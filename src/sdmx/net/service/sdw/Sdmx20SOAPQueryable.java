/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.net.service.sdw;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jdom.Document;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import sdmx.Registry;
import sdmx.Repository;
import sdmx.Queryable;
import sdmx.SdmxIO;
import sdmx.common.TextOperatorType;
import sdmx.commonreferences.CodeReference;
import sdmx.commonreferences.CodelistReference;
import sdmx.commonreferences.ConceptReference;
import sdmx.commonreferences.ConceptSchemeReference;
import sdmx.commonreferences.DataStructureRef;
import sdmx.commonreferences.DataStructureReference;
import sdmx.commonreferences.DataflowReference;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemReference;
import sdmx.commonreferences.ItemSchemeReference;
import sdmx.commonreferences.ItemSchemeReferenceBase;
import sdmx.commonreferences.NestedNCNameID;
import sdmx.commonreferences.VersionQuery;
import sdmx.exception.ParseException;
import sdmx.exception.QueryableException;
import sdmx.message.BaseHeaderType;
import sdmx.message.DataMessage;
import sdmx.message.DataQueryMessage;
import sdmx.message.DataStructureQueryMessage;
import sdmx.message.HeaderTimeType;
import sdmx.message.PartyType;
import sdmx.message.QueryMessage;
import sdmx.message.SenderType;
import sdmx.message.StructureType;
import sdmx.net.LocalRegistry;
import sdmx.query.base.QueryIDType;
import sdmx.query.base.QueryNestedIDType;
import sdmx.query.data.DataQueryType;
import sdmx.query.datastructure.DataStructureWhereType;
import sdmx.querykey.Query;
import sdmx.structure.DataflowsType;
import sdmx.structure.StructuresType;
import sdmx.structure.base.ItemSchemeType;
import sdmx.structure.base.ItemType;
import sdmx.structure.codelist.CodeType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.dataflow.DataflowType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.util.QueryStringUtils;
import sdmx.version.common.ParseDataCallbackHandler;
import sdmx.version.common.ParseParams;
import sdmx.version.common.SOAPStrippingInputStream;
import sdmx.version.twopointone.writer.Sdmx21StructureWriter;
import sdmx.version.twopointzero.QueryToSdmx20Query;
import sdmx.xml.DateTime;

/**
 *
 * @author James
 */
/**
 * This file is part of SdmxSax.
 *
 * SdmxSax is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * SdmxSax is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * SdmxSax. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright James Gardner 2014
 */
public class Sdmx20SOAPQueryable implements Registry, Repository, Queryable {

    private String soapNamespace = "http://ec.europa.eu/eurostat/sri/service/2.0";
    private String mediaType = "application/soap+xml;charset=UTF-8";

    private String serviceURL = "http://data.un.org/ws/NSIStdV20Service.asmx";
    private LocalRegistry local = new LocalRegistry();
    List<DataflowType> dataflowList = null;

    private String agencyId = "UIS";

    public Sdmx20SOAPQueryable(String agency, String serviceURL) {
        this.serviceURL = serviceURL;
        this.agencyId = agency;
    }

    public List<DataflowType> listDataflows() {
        if (dataflowList != null) {
            return dataflowList;
        }
        dataflowList = new ArrayList<DataflowType>();
        StructureType st = null;
        String s = QueryToSdmx20Query.toGetDataStructureListQuery(this.agencyId, soapNamespace);
        if (SdmxIO.isDumpQuery()) {
            System.out.println(s);
        }
        byte[] b = s.getBytes();
        InputStream in = new ByteArrayInputStream(b);
        try {
            st = SdmxIO.parseStructure(query("GetDataStructureDefinitionResult", in, b.length));
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20SOAPQueryable.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(Sdmx20SOAPQueryable.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        if (st == null) {
            dataflowList = null;
            return Collections.EMPTY_LIST;
        }
        Iterator<DataStructureType> it = st.getStructures().getDataStructures().getDataStructures().iterator();
        while (it.hasNext()) {
            DataStructureType ds = it.next();
            DataflowType flow = new DataflowType();
            flow.setAgencyID(ds.getAgencyID());
            flow.setId(ds.getId());
            flow.setVersion(ds.getVersion());
            flow.setNames(ds.getNames());
            flow.setDescriptions(ds.getDescriptions());
            flow.setStructure(ds.asReference());
            flow.setAnnotations(ds.getAnnotations());
            dataflowList.add(flow);
        }
        return dataflowList;
    }

    public String getAgencyId() {
        return agencyId;
    }

    /**
     * @param agencyId the agencyId to set
     */
    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * @return the serviceURL
     */
    public String getServiceURL() {
        return serviceURL;
    }

    /**
     * @param serviceURL the serviceURL to set
     */
    public void setServiceURL(String serviceURL) {
        this.serviceURL = serviceURL;
    }

    public Reader query2(String action, InputStream in, int length) {
        HttpClient client = new DefaultHttpClient();
        try {
            HttpPost req = new HttpPost(getServiceURL());
            req.setHeader("Content-Type", mediaType);
            //req.setHeader("Accept","application/xml");
            HttpEntity entity = new InputStreamEntity(in, length);
            req.setEntity(entity);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = client.execute(req, responseHandler);
            int fromIndex = responseBody.indexOf(action, 0);
            fromIndex = (responseBody.indexOf(">", fromIndex + action.length())) + 1;
            int toIndex = responseBody.lastIndexOf("</" + action);
            responseBody = responseBody.substring(fromIndex, toIndex);
            Reader reader = new StringReader(responseBody);
            if (SdmxIO.isSaveXml()) {
                String name = System.currentTimeMillis() + ".xml";
                FileOutputStream file = new FileOutputStream(name + ".xml");
                IOUtils.copy(reader, file);
                FileInputStream in2 = new FileInputStream(name + ".xml");
                reader = new InputStreamReader(in2);
            }
            return reader;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Reader query(String action, InputStream in, int length) {
        HttpClient client = new DefaultHttpClient();
        try {
            HttpPost req = new HttpPost(getServiceURL());
            req.setHeader("Content-Type", mediaType);
            //req.setHeader("Accept","application/xml");
            HttpEntity entity = new InputStreamEntity(in, length);
            req.setEntity(entity);
            HttpResponse response = client.execute(req);
            InputStream socket = response.getEntity().getContent();
            if (SdmxIO.isSaveXml()) {
                String name = System.currentTimeMillis() + ".xml";
                FileOutputStream file = new FileOutputStream(name);
                IOUtils.copy(socket, file);
                socket = new FileInputStream(name);
            }
            if (response.getStatusLine().getStatusCode() == 200) {
                SOAPStrippingInputStream stripper = new SOAPStrippingInputStream(socket, "<" + action + ">", "</" + action + ">");
                InputStreamReader isr = new InputStreamReader(stripper);
                return isr;
            } else {
                System.out.println("Response=" + response.getStatusLine().getStatusCode());
                System.out.println(Arrays.toString(response.getAllHeaders()));
                IOUtils.copy(socket, System.out);
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * @return the soapNamespace
     */
    public String getSoapNamespace() {
        return soapNamespace;
    }

    /**
     * @param soapNamespace the soapNamespace to set
     */
    public void setSoapNamespace(String soapNamespace) {
        this.soapNamespace = soapNamespace;
    }

    /**
     * @return the mediaType
     */
    public String getMediaType() {
        return mediaType;
    }

    /**
     * @param mediaType the mediaType to set
     */
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Registry getRegistry() {
        return this;
    }

    public BaseHeaderType getBaseHeader() {
        BaseHeaderType header = new BaseHeaderType();
        header.setId("none");
        header.setTest(false);
        SenderType sender = new SenderType();
        sender.setId(new IDType("Sdmx-Sax"));
        header.setSender(sender);
        PartyType receiver = new PartyType();
        receiver.setId(new IDType(agencyId));
        header.setReceivers(Collections.singletonList(receiver));
        HeaderTimeType htt = new HeaderTimeType();
        htt.setDate(DateTime.now());
        header.setPrepared(htt);
        return header;
    }

    @Override
    public void load(StructureType struct) {
        local.load(struct);
    }

    @Override
    public void unload(StructureType struct) {
        local.unload(struct);
    }

    @Override
    public void clear() {
        local.clear();
    }

    @Override
    public DataStructureType find(DataStructureReference ref) {
        DataStructureType dst = local.find(ref);
        if (dst == null) {
            String s = QueryToSdmx20Query.toGetDataStructureQuery(ref.getMaintainableParentId().toString(), ref.getAgencyId().toString(), soapNamespace);
            if (SdmxIO.isDumpQuery()) {
                System.out.println(s);
            }
            byte[] b = s.getBytes();
            InputStream in = new ByteArrayInputStream(b);
            try {
                local.load(SdmxIO.parseStructure(query("GetDataStructureDefinitionResult", in, b.length)));
            } catch (IOException ex) {
                Logger.getLogger(Sdmx20SOAPQueryable.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            } catch (ParseException ex) {
                Logger.getLogger(Sdmx20SOAPQueryable.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
            return local.find(ref);
        }
        return dst;
    }

    @Override
    public DataflowType find(DataflowReference ref) {
        if (local.find(ref) != null) {
            return local.find(ref);
        }
        for (DataflowType df2 : listDataflows()) {
            if (df2.identifiesMe(ref.getAgencyId(), ref.getMaintainableParentId(), ref.getVersion())) {
                return df2;
            }
        }
        return local.find(ref);
    }

    @Override
    public CodeType find(CodeReference ref) {
        return local.find(ref);
    }

    @Override
    public CodelistType find(CodelistReference ref) {
        return local.find(ref);
    }

    @Override
    public ConceptType find(ConceptReference ref) {
        return local.find(ref);
    }

    @Override
    public ConceptSchemeType find(ConceptSchemeReference ref) {
        return local.find(ref);
    }

    @Override
    public Repository getRepository() {
        return this;
    }

    @Override
    public ItemType find(ItemReference ref) {
        ConceptType concept = find(ConceptReference.create(ref.getAgencyId(), ref.getMaintainableParentId(), ref.getVersion(), ref.getId()));
        if (concept != null) {
            return concept;
        }
        CodeType code = find(CodeReference.create(ref.getAgencyId(), ref.getMaintainableParentId(), ref.getVersion(), ref.getId()));
        return code;

    }

    @Override
    public ItemSchemeType find(ItemSchemeReferenceBase ref) {
        ConceptSchemeType concept = find(ConceptSchemeReference.create(ref.getAgencyId(), ref.getMaintainableParentId(), ref.getVersion()));
        if (concept != null) {
            return concept;
        }
        CodelistType code = find(CodelistReference.create(ref.getAgencyId(), ref.getMaintainableParentId(), ref.getVersion()));
        return code;
    }

    @Override
    public void save(OutputStream out) throws IOException {
        StructureType st = new StructureType();
        st.setStructures(new StructuresType());
        st.getStructures().setDataflows(new DataflowsType());
        if (dataflowList == null) {
            listDataflows();
        }
        for (DataflowType df : listDataflows()) {
            if (df != null) {
                st.getStructures().getDataflows().getDataflows().add(df);
            }
        }
        local.load(st);
        local.save(out);
    }

    public void merge() {
    }

    @Override
    public List<DataStructureType> search(DataStructureReference ref) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<DataflowType> search(DataflowReference ref) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<CodeType> search(CodeReference ref) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<CodelistType> search(CodelistReference ref) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<ItemType> search(ItemReference ref) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<ItemSchemeType> search(ItemSchemeReferenceBase ref) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<ConceptType> search(ConceptReference ref) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<ConceptSchemeType> search(ConceptSchemeReference ref) {
        return Collections.EMPTY_LIST;
    }

    public List<StructureType> getCache() {
        return this.local.getCache();
    }

    @Override
    public DataMessage query(Query query) throws ParseException, IOException {
        String s = QueryToSdmx20Query.toGetDataQuery(query, soapNamespace);
        if (SdmxIO.isDumpQuery()) {
            System.out.println(s);
        }
        byte[] b = s.getBytes();
        InputStream in = new ByteArrayInputStream(b);
        try {
            return SdmxIO.parseData(query("GetCompactDataResult", in, b.length));
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20SOAPQueryable.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(Sdmx20SOAPQueryable.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void query(Query query, ParseDataCallbackHandler handler) throws ParseException, IOException {
        String s = QueryToSdmx20Query.toGetDataQuery(query, soapNamespace);
        if (SdmxIO.isDumpQuery()) {
            System.out.println(s);
        }
        byte[] b = s.getBytes();
        InputStream in = new ByteArrayInputStream(b);
        try {
            SdmxIO.parseDataStream(handler, query("GetCompactDataResult", in, b.length));
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20SOAPQueryable.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(Sdmx20SOAPQueryable.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.net.service.nsi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import sdmx.structure.base.ItemSchemeType;
import sdmx.structure.base.ItemType;
import sdmx.structure.codelist.CodeType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.dataflow.DataflowType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.version.common.SOAPStrippingInputStream;
import sdmx.version.twopointone.writer.Sdmx21StructureWriter;
import sdmx.version.twopointzero.Sdmx20QueryWriter;
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
public class Sdmx20NSIQueryable implements Registry,Repository,Queryable {

    private String soapNamespace = "http://ec.europa.eu/eurostat/sri/service/2.0";
    private String mediaType = "application/soap+xml;charset=UTF-8";

    private String serviceURL = "http://data.un.org/ws/NSIStdV20Service.asmx";
    private LocalRegistry local = new LocalRegistry();
    List<DataflowType> dataflowList = null;

    private String agencyId = "UIS";

    public Sdmx20NSIQueryable(String agency, String serviceURL) {
        this.serviceURL = serviceURL;
        this.agencyId = agency;
    }

    public List<DataflowType> listDataflows() {
        if (dataflowList != null) {
            return dataflowList;
        }
        dataflowList = new ArrayList<DataflowType>();
        DataStructureQueryMessage qm = new DataStructureQueryMessage();
        qm.setHeader(getBaseHeader());
        StructureType st = queryDataflows(qm);
        if (st == null) {
            dataflowList = null;
            return Collections.EMPTY_LIST;
        }
        dataflowList = st.getStructures().getDataflows().getDataflows();
        return dataflowList;
    }

    public StructureType queryDataflows(DataStructureQueryMessage message) {
        message.setHeader(getBaseHeader());
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document doc = Sdmx20QueryWriter.toListDataflows(message);
            String soapStart = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:sdmx=\"" + soapNamespace + "\">\n"
                    //+ "   <soap:Header/>\n"
                    + "   <soap:Body>\n"
                    + "      <sdmx:QueryStructure>\n"
                    + "         <sdmx:Query>";
            baos.write(soapStart.getBytes());
            Format format = Format.getCompactFormat();
            format.setOmitEncoding(true);
            format.setOmitDeclaration(true);
            XMLOutputter output = new XMLOutputter(format);
            output.output(doc, baos);
            String soapEnd = "</sdmx:Query>\n"
                    + "      </sdmx:QueryStructure>\n"
                    + "   </soap:Body>\n"
                    + "</soap:Envelope>";
            baos.write(soapEnd.getBytes());
            // Create a response handler
            byte[] bytes = baos.toByteArray();
            if (SdmxIO.isDumpQuery()) {
                try {
                    String name = "query-" + System.currentTimeMillis() + ".xml";
                    FileOutputStream fos = new FileOutputStream(name);
                    fos.write(bytes);
                    fos.close();
                } catch (IOException io) {
                }
            }
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            StructureType st = SdmxIO.parseStructure(query("QueryStructureResult", bais, bytes.length));
            if (SdmxIO.isSaveXml() && st != null) {
                String name = System.currentTimeMillis() + "-21.xml";
                FileOutputStream file = new FileOutputStream(name);
                Sdmx21StructureWriter.write(st, file);
            }
            return st;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    
    public StructureType query(DataStructureQueryMessage message) {
        message.setHeader(getBaseHeader());
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document doc = Sdmx20QueryWriter.toQueryDataStructure(message);
            String soapStart = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:sdmx=\"" + soapNamespace + "\">\n"
                    //+ "   <soap:Header/>\n"
                    + "   <soap:Body>\n"
                    + "      <sdmx:QueryStructure>\n"
                    + "         <sdmx:Query>";
            baos.write(soapStart.getBytes());
            Format format = Format.getCompactFormat();
            format.setOmitEncoding(true);
            format.setOmitDeclaration(true);
            XMLOutputter output = new XMLOutputter(format);
            output.output(doc, baos);
            String soapEnd = "</sdmx:Query>\n"
                    + "      </sdmx:QueryStructure>\n"
                    + "   </soap:Body>\n"
                    + "</soap:Envelope>";
            baos.write(soapEnd.getBytes());
            // Create a response handler
            byte[] bytes = baos.toByteArray();
            if (SdmxIO.isDumpQuery()) {
                try {
                    String name = "query-" + System.currentTimeMillis() + ".xml";
                    FileOutputStream fos = new FileOutputStream(name);
                    fos.write(bytes);
                    fos.close();
                } catch (IOException io) {
                }
            }
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            StructureType st = SdmxIO.parseStructure(query2("QueryStructureResult", bais, bytes.length));
            if (SdmxIO.isSaveXml() && st != null) {
                String name = System.currentTimeMillis() + "-21.xml";
                FileOutputStream file = new FileOutputStream(name);
                Sdmx21StructureWriter.write(st, file);
            }
            return st;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public DataMessage query(DataQueryMessage message) {
        message.setHeader(getBaseHeader());
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document doc = Sdmx20QueryWriter.toNSIDocument(message);
            String soapStart = "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n"
                    + "  <soap12:Body>\n"
                    + "    <GetCompactData xmlns=\"" + soapNamespace + "\">\n"
                    + "      <Query>";
            baos.write(soapStart.getBytes());
            Format format = Format.getCompactFormat();
            format.setOmitEncoding(true);
            format.setOmitDeclaration(true);
            XMLOutputter output = new XMLOutputter(format);
            output.output(doc, baos);
            String soapEnd = "</Query>\n"
                    + "    </GetCompactData>\n"
                    + "  </soap12:Body>\n"
                    + "</soap12:Envelope>";
            baos.write(soapEnd.getBytes());
            // Create a response handler
            byte[] bytes = baos.toByteArray();
            if (SdmxIO.isDumpQuery()) {
                try {
                    String name = "query-" + System.currentTimeMillis() + ".xml";
                    FileOutputStream fos = new FileOutputStream(name);
                    fos.write(bytes);
                    fos.close();
                } catch (IOException io) {
                }
            }
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            return SdmxIO.parseData(query("GetCompactDataResult", bais, bytes.length), false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
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
            DataStructureQueryMessage queryMessage = new DataStructureQueryMessage();
            DataStructureWhereType where = new DataStructureWhereType();
            where.setAgencyId(new QueryNestedIDType(ref.getAgencyId().toString(), TextOperatorType.EQUAL));
            List<QueryIDType> ids = new ArrayList<QueryIDType>();
            ids.add(new QueryIDType(ref.getMaintainableParentId().toString(), TextOperatorType.EQUAL));
            where.setId(ids);
            if (ref.getVersion() != null) {
                VersionQuery vqt = new VersionQuery(ref.getVersion().toString());
                where.setVersion(vqt);
            } else {
                where.setVersion(VersionQuery.ALL);
            }
            queryMessage.setDataStructureWhereType(where);
            local.load(query(queryMessage));
            return local.find(ref);
        }
        return dst;
    }

    @Override
    public DataflowType find(DataflowReference ref) {
        for(DataflowType df2:listDataflows()) {
            if( df2.identifiesMe(ref.getAgencyId(), ref.getMaintainableParentId(), ref.getVersion())){
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
        if( concept!=null) return concept;
        CodeType code = find(CodeReference.create(ref.getAgencyId(),ref.getMaintainableParentId(), ref.getVersion(), ref.getId()));
        return code;
        
    }

    @Override
    public ItemSchemeType find(ItemSchemeReference ref) {
        ConceptSchemeType concept = find(ConceptSchemeReference.create(ref.getAgencyId(), ref.getMaintainableParentId(), ref.getVersion()));
        if( concept!=null) return concept;
        CodelistType code = find(CodelistReference.create(ref.getAgencyId(),ref.getMaintainableParentId(), ref.getVersion()));
        return code;
    }
}

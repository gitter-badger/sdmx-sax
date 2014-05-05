/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointzero;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
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
import sdmx.SdmxIO;
import sdmx.commonreferences.ConceptReferenceType;
import sdmx.commonreferences.DataStructureRefType;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemSchemeReferenceBaseType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.VersionType;
import sdmx.message.BaseHeaderType;
import sdmx.message.DataMessage;
import sdmx.message.DataQueryMessage;
import sdmx.message.DataStructureQueryMessage;
import sdmx.message.HeaderTimeType;
import sdmx.message.PartyType;
import sdmx.message.QueryMessage;
import sdmx.message.SenderType;
import sdmx.message.StructureType;
import sdmx.query.data.DataQueryType;
import sdmx.query.datastructure.DataStructureWhereType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.version.common.Queryable;
import sdmx.version.common.QueryableException;
import sdmx.version.common.SOAPStrippingInputStream;
import sdmx.xml.DateTime;

/**
 *
 * @author James
 */
public class Sdmx20SOAPQueryable implements Queryable {

    private String soapNamespace = "http://stats.oecd.org/OECDStatWS/SDMX/";
    private String mediaType = "application/soap+xml;charset=UTF-8";

    private String agencyId = "";
    private String serviceURL = "";
    private Registry registry = null;
    List<DataStructureReferenceType> dataSetList = null;

    public Sdmx20SOAPQueryable(String agencyId, String serviceURL) {
        this.agencyId = agencyId;
        this.serviceURL = serviceURL;
    }

    public List<DataStructureReferenceType> listDataSets() throws QueryableException {
        try {
            if (dataSetList != null) {
                return dataSetList;
            }
            dataSetList = new ArrayList<DataStructureReferenceType>();
            DataStructureQueryMessage qm = new DataStructureQueryMessage();
            qm.setHeader(getBaseHeader());
            DataStructureWhereType dsw = new DataStructureWhereType();
            qm.setDataStructureWhereType(dsw);
            StructureType st = query(qm);
            Iterator<DataStructureType> it = st.getStructures().getDataStructures().getDataStructures().iterator();
            while (it.hasNext()) {
                DataStructureType ds = it.next();
                DataStructureRefType ref = new DataStructureRefType(ds.getAgencyID(), ds.getId(), ds.getVersion());
                DataStructureReferenceType reference = new DataStructureReferenceType(ref, null);
                dataSetList.add(reference);
            }
            return dataSetList;
        } catch (Exception ex) {
            dataSetList=null;
            throw new QueryableException("Error");
        }
    }

    @Override
    public StructureType query(DataStructureQueryMessage message) throws QueryableException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document doc = Sdmx20QueryWriter.toDocument(message);
            String soapStart = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:sdmx=\"" + soapNamespace + "\">\n"
                    + "   <soap:Header/>\n"
                    + "   <soap:Body>\n"
                    + "      <sdmx:GetDataStructureDefinition>\n"
                    + "         <sdmx:QueryMessage>";
            baos.write(soapStart.getBytes());
            Format format = Format.getCompactFormat();
            format.setOmitEncoding(true);
            format.setOmitDeclaration(true);
            XMLOutputter output = new XMLOutputter(format);
            output.output(doc, baos);
            String soapEnd = "</sdmx:QueryMessage>\n"
                    + "      </sdmx:GetDataStructureDefinition>\n"
                    + "   </soap:Body>\n"
                    + "</soap:Envelope>";
            baos.write(soapEnd.getBytes());
            // Create a response handler
            byte[] bytes = baos.toByteArray();
            //System.out.println(new String(bytes));
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            return SdmxIO.parseStructure(query("GetDataStructureDefinitionResult", bais, bytes.length));
        } catch (Exception ex) {
            throw new QueryableException("Error");
        }
    }

    public DataMessage query(DataQueryMessage message) throws QueryableException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document doc = Sdmx20QueryWriter.toDocument(message);
            String soapStart = "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n"
                    + "  <soap12:Body>\n"
                    + "    <GetCompactData xmlns=\"" + soapNamespace + "\">\n"
                    + "      <QueryMessage>";
            baos.write(soapStart.getBytes());
            Format format = Format.getCompactFormat();
            format.setOmitEncoding(true);
            format.setOmitDeclaration(true);
            XMLOutputter output = new XMLOutputter(format);
            output.output(doc, baos);
            String soapEnd = "</QueryMessage>\n"
                    + "    </GetCompactData>\n"
                    + "  </soap12:Body>\n"
                    + "</soap12:Envelope>";
            baos.write(soapEnd.getBytes());
            // Create a response handler
            byte[] bytes = baos.toByteArray();
            //System.out.println(new String(bytes));
            //System.out.println("---------------------------------");
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            return SdmxIO.parseData(query("GetCompactDataResult", bais, bytes.length), false);
        } catch (Exception ex) {
            throw new QueryableException("Error");
        }
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
            System.out.println("--------RESPONSE BODY--------");
            System.out.println(responseBody);
            System.out.println("--------RESPONSE BODY--------");
            int fromIndex = responseBody.indexOf(action, 0);
            fromIndex = (responseBody.indexOf(">", fromIndex + action.length())) + 1;
            int toIndex = responseBody.lastIndexOf("</" + action);
            responseBody = responseBody.substring(fromIndex, toIndex);
            //System.out.println("--------AFTER STRIP--------");
            //System.out.println(responseBody);
            //System.out.println("--------AFTER STRIP--------");
            StringReader reader = new StringReader(responseBody);
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
            if (response.getStatusLine().getStatusCode() == 200) {
                SOAPStrippingInputStream stripper = new SOAPStrippingInputStream(response.getEntity().getContent(), "<" + action + ">", "</" + action + ">");
                InputStreamReader isr = new InputStreamReader(stripper);
                return isr;
            } else {
                System.out.println("Response=" + response.getStatusLine().getStatusCode());
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

    @Override
    public Registry getRegistry() {
        return registry;
    }

    @Override
    public void setRegistry(Registry r) {
        registry = r;
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
}

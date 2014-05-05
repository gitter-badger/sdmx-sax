/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.registry;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
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
import sdmx.common.TextOperatorType;
import sdmx.commonreferences.ConceptReferenceType;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemSchemeReferenceBaseType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.VersionQueryType;
import sdmx.commonreferences.VersionType;
import sdmx.message.BaseHeaderType;
import sdmx.message.DataStructureQueryMessage;
import sdmx.message.HeaderTimeType;
import sdmx.message.PartyType;
import sdmx.message.QueryMessage;
import sdmx.message.SenderType;
import sdmx.message.StructureType;
import sdmx.query.base.QueryIDType;
import sdmx.query.base.QueryNestedIDType;
import sdmx.query.datastructure.DataStructureWhereType;
import sdmx.structure.StructuresType;
import sdmx.structure.base.IdentifiableType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.version.common.Queryable;
import sdmx.version.common.QueryableException;
import sdmx.version.twopointone.Sdmx21StructureReaderTools;
import sdmx.version.twopointzero.Sdmx20QueryWriter;
import sdmx.xml.DateTime;
import sdmx.xml.anyURI;

/**
 *
 * @author James
 */
public class QueryableServiceRegistry implements Registry {
    Registry local = LocalRegistry.getDefaultWorkspace();
    Queryable queryable = null;
    public QueryableServiceRegistry(Queryable queryable) {
        this.queryable=queryable;
    }
    public void load(StructureType struct) {
        local.load(struct);
    }
    public void unload(StructureType struct) {
        local.unload(struct);
    }
    public DataStructureType findDataStructure(NestedNCNameIDType agency, IDType id, VersionType version) {
        DataStructureType dst = local.findDataStructure(agency, id, version);
        if (dst == null) {
            try {
                DataStructureQueryMessage queryMessage = new DataStructureQueryMessage();
                DataStructureWhereType where = new DataStructureWhereType();
                where.setAgencyId(new QueryNestedIDType(agency.getString(), TextOperatorType.EQUAL));
                List<QueryIDType> ids = new ArrayList<QueryIDType>();
                ids.add(new QueryIDType(id.toString(), TextOperatorType.EQUAL));
                where.setId(ids);
                if( version!=null ) {
                   VersionQueryType vqt = new VersionQueryType(version.getString());
                   where.setVersion(vqt);
                }else {
                   where.setVersion(VersionQueryType.ALL);
                }
                queryMessage.setDataStructureWhereType(where);
                queryMessage.setHeader(getBaseHeader());
                local.load(queryable.query(queryMessage));
                return local.findDataStructure(agency, id, version);
            } catch (QueryableException ex) {
                Logger.getLogger(QueryableServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Error");
            }
        }
        return null;
    }
    public ConceptSchemeType findConceptScheme(NestedNCNameIDType agencyID, ConceptReferenceType conceptRef) {
        ConceptSchemeType dst = local.findConceptScheme(agencyID, conceptRef);
        return dst;
    }
    public CodelistType findCodelist(ItemSchemeReferenceBaseType enumeration) {
        CodelistType dst = local.findCodelist(enumeration);
        return dst;
    }
    public CodelistType findCodelistById(IDType id) {
        return local.findCodelistById(id);
    }
    public CodelistType findCodelist(NestedNCNameIDType codelistAgency, IDType codelist, VersionType codelistVersion) {
        CodelistType dst = local.findCodelist(codelistAgency, codelist, codelistVersion);
        return dst;
    }
    public CodelistType findCodelist(String codelistAgency, String codelist, String codelistVersion) {
        return findCodelist(new NestedNCNameIDType(codelistAgency), new IDType(codelist), new VersionType(codelistVersion));
    }
    public ConceptSchemeType findConceptScheme(NestedNCNameIDType csa, IDType csi) {
        ConceptSchemeType dst = local.findConceptScheme(csa, csi);
        return dst;
    }
    public ConceptSchemeType findConceptSchemeById(IDType id) {
        return local.findConceptSchemeById(id);
    }
    public ConceptType findConcept(NestedNCNameIDType agency, IDType id) {
        return local.findConcept(agency, id);
    }
    public ConceptType findConcept(IDType id) {
        return local.findConcept(id);
    }
    @Override
    public DataStructureType findDataStructure(NestedNCNameIDType agency, IDType id) {
        return findDataStructure(agency, id,null);
    }
    @Override
    public CodelistType findCodelist(NestedNCNameIDType codelistAgency, IDType codelist) {
        return local.findCodelist(codelistAgency,codelist);
    }
    @Override
    public CodelistType findCodelist(String codelistAgency, String codelist) {
        return local.findCodelist(codelistAgency,codelist);
    }

    public List<DataStructureReferenceType> listDataStructures(){
        try {
            return queryable.listDataSets();
        } catch (QueryableException ex) {
            Logger.getLogger(QueryableServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Error");
        }
    }
    public Queryable getQueryable(){ return queryable; }
    
    public BaseHeaderType getBaseHeader() {
        BaseHeaderType header = new BaseHeaderType();
        header.setId("none");
        header.setTest(false);
        SenderType sender = new SenderType();
        sender.setId(new IDType("Sdmx-Sax"));
        header.setSender(sender);
        PartyType receiver = new PartyType();
        receiver.setId(new IDType(queryable.getAgencyId()));
        header.setReceivers(Collections.singletonList(receiver));
        HeaderTimeType htt = new HeaderTimeType();
        htt.setDate(DateTime.now());
        header.setPrepared(htt);
        return header;
    }
}

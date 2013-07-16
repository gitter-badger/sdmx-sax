/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.workspace;

import javax.ws.rs.core.MediaType;
import com.sun.security.ntlm.Client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sdmx.commonreferences.ConceptReferenceType;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemSchemeReferenceBaseType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.VersionType;
import sdmx.data.ValueTypeResolver;
import sdmx.message.DataMessage;
import sdmx.message.StructureType;
import sdmx.structure.StructuresType;
import sdmx.structure.base.IdentifiableType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.version.common.SdmxIO;
import sdmx.xml.anyURI;

/**
 *
 * @author James
 */
public class RESTServiceRegistry implements Registry {

    public static void main(String args[]) {
        RESTServiceRegistry registry = new RESTServiceRegistry("FAO", "http://www.fao.org/figis/sdmx");
        System.out.println("DataStructure=" + registry.findDataStructure(new NestedNCNameIDType("FAO"), new IDType("CAPTURE_DATASTRUCTURE"), new VersionType("0.1")));
    }
    String agency = "";
    String serviceURL = "";
    Registry local = new LocalRegistry();

    public RESTServiceRegistry(String agency, String service) {
        this.serviceURL = service;
        this.agency = agency;
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
                StructureType st = retrieve(serviceURL + "/registry/datastructure/" + agency.getString() + "/" + id.getString() + "/" + version.getString());
                return local.findDataStructure(agency, id, version);
            } catch (MalformedURLException ex) {
                Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dst;
    }

    public ConceptSchemeType findConceptScheme(NestedNCNameIDType agencyID, ConceptReferenceType conceptRef) {
        ConceptSchemeType dst = local.findConceptScheme(agencyID, conceptRef);
        if (dst == null) {
            try {
                retrieve(serviceURL + "/registry/conceptscheme/" + agencyID.getString() + "/" + conceptRef.getRef().getMaintainableParentId() + "/" + conceptRef.getRef().getMaintainableParentVersion());
                return local.findConceptScheme(agencyID, conceptRef);
            } catch (MalformedURLException ex) {
                Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dst;
    }

    public CodelistType findCodelist(ItemSchemeReferenceBaseType enumeration) {
        CodelistType dst = local.findCodelist(enumeration);
        if (dst == null) {
            try {
                retrieve(serviceURL + "/registry/codelist/" + enumeration.getRef().getAgencyId() + "/" + enumeration.getRef().getId() + "/" + enumeration.getRef().getVersion());
                return local.findCodelist(enumeration);
            } catch (MalformedURLException ex) {
                Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dst;
    }

    public CodelistType findCodelistById(IDType id) {
        return local.findCodelistById(id);
    }

    public CodelistType findCodelist(NestedNCNameIDType codelistAgency, IDType codelist, VersionType codelistVersion) {
        CodelistType dst = local.findCodelist(codelistAgency, codelist, codelistVersion);
        if (dst == null) {
            try {
                retrieve(serviceURL + "/registry/codelist/" + codelistAgency.getString() + "/" + codelist.getString() + "/" + codelistVersion.getString());
                return local.findCodelist(codelistAgency, codelist, codelistVersion);
            } catch (MalformedURLException ex) {
                Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dst;
    }

    public CodelistType findCodelist(String codelistAgency, String codelist, String codelistVersion) {
        return findCodelist(new NestedNCNameIDType(codelistAgency), new IDType(codelist), new VersionType(codelistVersion));
    }

    public ConceptSchemeType findConceptScheme(NestedNCNameIDType csa, IDType csi) {
        ConceptSchemeType dst = local.findConceptScheme(csa, csi);
        if (dst == null) {
            try {
                retrieve(serviceURL + "/registry/conceptscheme/" + csa.getString() + "/" + csi.getString() + "/latest");
                return local.findConceptScheme(csa, csi);
            } catch (MalformedURLException ex) {
                Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dst;
    }

    public ConceptSchemeType findConceptSchemeById(IDType id) {
        System.out.println("Last ditch effort to find ConceptScheme:"+id.getString());
        return local.findConceptSchemeById(id);
    }

    public ConceptType findConcept(NestedNCNameIDType agency, IDType id) {
        return local.findConcept(agency, id);
    }

    public ConceptType findConcept(IDType id) {
        System.out.println("Last ditch effort to find Concept:"+id.getString());
        return local.findConcept(id);
    }

    private StructureType retrieve(String urlString) throws MalformedURLException, IOException {
        System.out.println("Retrieve:" + urlString);
        URL url = new URL(urlString);
        HttpURLConnection conn =
                (HttpURLConnection) url.openConnection();
        if (conn.getResponseCode() != 200) {
            throw new IOException(conn.getResponseMessage());
        }
        InputStream in = conn.getInputStream();
        StructureType st = SdmxIO.parseStructure(this, in);
        return st;
    }

    @Override
    public CodelistType findCodelist(NestedNCNameIDType codelistAgency, IDType codelist) {
        CodelistType dst = local.findCodelist(codelistAgency, codelist);
        if (dst == null) {
            try {
                retrieve(serviceURL + "/registry/codelist/" + codelistAgency.getString() + "/" + codelist.getString() + "/latest");
                return local.findCodelist(codelistAgency, codelist);
            } catch (MalformedURLException ex) {
                Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dst;
    }

    @Override
    public CodelistType findCodelist(String codelistAgency, String codelist) {
        return findCodelist(new NestedNCNameIDType(codelistAgency),new IDType(codelist));
    }

    @Override
    public DataStructureType findDataStructure(NestedNCNameIDType agency, IDType id) {
        DataStructureType dst = local.findDataStructure(agency, id);
        if (dst == null) {
            try {
                StructureType st = retrieve(serviceURL + "/registry/datastructure/" + agency.getString() + "/" + id.getString() + "/latest");
                return local.findDataStructure(agency, id);
            } catch (MalformedURLException ex) {
                Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dst;
    }

    @Override
    public List<DataStructureReferenceType> listDataSets() {
        return Collections.EMPTY_LIST;
    }
}

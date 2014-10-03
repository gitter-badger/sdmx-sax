/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.registry;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import sdmx.Registry;
import sdmx.SdmxIO;
import sdmx.common.Description;
import sdmx.common.Name;
import sdmx.commonreferences.ConceptReferenceType;
import sdmx.commonreferences.DataStructureRefType;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemSchemeReferenceBaseType;
import sdmx.commonreferences.NestedIDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.StructureRefType;
import sdmx.commonreferences.StructureReferenceType;
import sdmx.commonreferences.VersionType;
import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.commonreferences.types.StructureTypeCodelistType;
import sdmx.exception.ParseException;
import sdmx.message.DataMessage;
import sdmx.message.DataQueryMessage;
import sdmx.message.DataStructureQueryMessage;
import sdmx.message.StructureType;
import sdmx.structure.base.MaintainableType;
import sdmx.structure.codelist.CodeType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.dataflow.DataflowType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structure.datastructure.DimensionType;
import sdmx.version.common.SOAPStrippingInputStream;
import sdmx.version.twopointone.writer.Sdmx21StructureWriter;

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
public class ILORESTServiceRegistry implements Registry {

    public static void main(String args[]) {
        SdmxIO.setStrictRegex(false);
        ILORESTServiceRegistry registry = new ILORESTServiceRegistry("ILO", "http://www.ilo.org/ilostat/sdmx/ws/rest");
        registry.listDataflows();

    }
    private String agency = "";
    private String serviceURL = "";
    Registry local = new LocalRegistry();

    private List<DataflowType> dataflowList = null;

    CodelistType classifications = null;
    HashMap<String, CodelistType> indicators = new HashMap<String, CodelistType>();

    public ILORESTServiceRegistry(String agency, String service) {
        this.serviceURL = service;
        this.agency = agency;
        SdmxIO.setStrictRegex(false);
    }

    public void load(StructureType struct) {
        System.out.println("ILO Load:"+struct);
        local.load(struct);
    }

    public void unload(StructureType struct) {
        local.unload(struct);
    }
   /*
      This function ignores the version argument!!!
      ILO stat does not use version numbers.. simply take the latest
    */
    public DataStructureType findDataStructure(NestedNCNameIDType agency, IDType id, VersionType version) {
        DataStructureType dst = local.findDataStructure(agency, id);
        if (dst == null) {
            try {
                StructureType st = retrieve(getServiceURL() + "/datastructure/" + agency.getString() + "/" + id.getString() + "/latest");
                DataStructureType dst2 = st.findDataStructure(agency, id);
                load(st);
                return local.findDataStructure(agency, id);
            } catch (MalformedURLException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            } catch (ParseException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        return dst;
    }

    public ConceptSchemeType findConceptScheme(NestedNCNameIDType agencyID, ConceptReferenceType conceptRef) {
        ConceptSchemeType dst = local.findConceptScheme(agencyID, conceptRef);
        if (dst == null) {
            try {
                StructureType st = retrieve(getServiceURL() + "/conceptscheme/" + agencyID.getString() + "/" + conceptRef.getMaintainableParentId() + "/" + conceptRef.getVersion());
                load(st);
                return local.findConceptScheme(agencyID, conceptRef);
            } catch (MalformedURLException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dst;
    }

    public CodelistType findCodelist(ItemSchemeReferenceBaseType enumeration) {
        CodelistType dst = local.findCodelist(enumeration);
        if (dst == null) {
            try {
                StructureType st = retrieve(getServiceURL() + "/codelist/" + enumeration.getAgencyId() + "/" + enumeration.getMaintainableParentId() + "/" + enumeration.getMaintainedParentVersion());
                load(st);
                return local.findCodelist(enumeration);
            } catch (MalformedURLException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
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
                StructureType st = retrieve(getServiceURL() + "/codelist/" + codelistAgency.getString() + "/" + codelist.getString() + "/" + codelistVersion.getString());
                load(st);
                return local.findCodelist(codelistAgency, codelist, codelistVersion);
            } catch (MalformedURLException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
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
                StructureType st = retrieve(getServiceURL() + "/conceptscheme/" + csa.getString() + "/" + csi.getString() + "/latest");
                System.out.println("Loaded CSA/CSI struc:" + st.findConceptScheme(csa, csi));
                load(st);
                return local.findConceptScheme(csa, csi);
            } catch (MalformedURLException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dst;
    }

    public ConceptSchemeType findConceptSchemeById(IDType id) {
        System.out.println("Last ditch effort to find ConceptScheme:" + id.getString());
        return local.findConceptSchemeById(id);
    }

    public ConceptType findConcept(NestedNCNameIDType agency, IDType id) {
        return local.findConcept(agency, id);
    }

    public ConceptType findConcept(IDType id) {
        System.out.println("Last ditch effort to find Concept:" + id.getString());
        return local.findConcept(id);
    }

    private StructureType retrieve(String urlString) throws MalformedURLException, IOException, ParseException {
        System.out.println("Retrieve:" + urlString);
        URL url = new URL(urlString);
        HttpURLConnection conn
                = (HttpURLConnection) url.openConnection();
        if (conn.getResponseCode() != 200) {
            throw new IOException(conn.getResponseMessage());
        }
        InputStream in = conn.getInputStream();
        if (SdmxIO.isSaveXml()) {
            String name = System.currentTimeMillis() + ".xml";
            FileOutputStream file = new FileOutputStream(name);
            IOUtils.copy(in, file);
            in = new FileInputStream(name);
        }
        //FileOutputStream temp = new FileOutputStream("temp.xml");
        //org.apache.commons.io.IOUtils.copy(in, temp);
        //temp.close();
        //in.close();
        //in = new FileInputStream("temp.xml");
        System.out.println("Parsing!");
        StructureType st = SdmxIO.parseStructure(this, in);
        if (st == null) {
            System.out.println("St is null!");
        } else {
            if (SdmxIO.isSaveXml()) {
                String name = System.currentTimeMillis() + "-21.xml";
                FileOutputStream file = new FileOutputStream(name);
                Sdmx21StructureWriter.write(st, file);
            }
        }
        return st;
    }

    private DataMessage query(String urlString) throws MalformedURLException, IOException, ParseException {
        System.out.println("Query:" + urlString);
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(urlString);
        get.addHeader("Accept", "application/vnd.sdmx.structurespecificdata+xml;version=2.1");
        get.addHeader("User-Agent", "Sdmx-Sax");
        HttpResponse response = client.execute(get);
        /*
         URL url = new URL(urlString);
         HttpURLConnection conn
         = (HttpURLConnection) url.openConnection();
         //if (conn.getResponseCode() != 200) {
         //    return null;
         //}
         conn.setDoInput(true);
         conn.setDoOutput(false);
         conn.addRequestProperty("Accept", "application/vnd.sdmx.structurespecificdata+xml;version=2.1");
         conn.addRequestProperty("User-Agent", "Sdmx-Sax");
         conn.connect();
         InputStream in = conn.getInputStream();
         */
        InputStream in = response.getEntity().getContent();
        if (SdmxIO.isSaveXml()) {
            String name = System.currentTimeMillis() + ".xml";
            FileOutputStream file = new FileOutputStream(name);
            IOUtils.copy(in, file);
            in = new FileInputStream(name);
        }
        System.out.println("Parsing!");
        DataMessage msg = SdmxIO.parseData(in);
        if (msg == null) {
            System.out.println("Data is null!");
        }
        return msg;
    }
    /*
     This function retrieves and uses the local registry 
     instead of this when we call SdmxIO.parse(registry,in)
     this means that if the sdmx service sends sdmx 2.0 data structures
     the codelists dont have to be loaded.
     */

    private StructureType retrieve2(String urlString) throws MalformedURLException, IOException, ParseException {
        System.out.println("Retrieve:" + urlString);
        URL url = new URL(urlString);
        HttpURLConnection conn
                = (HttpURLConnection) url.openConnection();
        if (conn.getResponseCode() != 200) {
            throw new IOException(conn.getResponseMessage());
        }
        InputStream in = conn.getInputStream();
        //FileOutputStream temp = new FileOutputStream("temp.xml");
        //org.apache.commons.io.IOUtils.copy(in, temp);
        //temp.close();
        //in.close();
        //in = new FileInputStream("temp.xml");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
        }
        System.out.println("Parsing!");
        StructureType st = SdmxIO.parseStructure(local, in);
        if (st == null) {
            System.out.println("St is null!");
        }
        return st;
    }

    @Override
    public CodelistType findCodelist(NestedNCNameIDType codelistAgency, IDType codelist) {
        CodelistType dst = local.findCodelist(codelistAgency, codelist);
        if (dst == null) {
            try {
                StructureType st = retrieve(getServiceURL() + "/codelist/" + codelistAgency.getString() + "/" + codelist.getString() + "/latest");
                load(st);
                return local.findCodelist(codelistAgency, codelist);
            } catch (MalformedURLException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dst;
    }

    @Override
    public CodelistType findCodelist(String codelistAgency, String codelist) {
        return findCodelist(new NestedNCNameIDType(codelistAgency), new IDType(codelist));
    }

    @Override
    public DataStructureType findDataStructure(NestedNCNameIDType agency, IDType id) {
        System.out.println("Find DataStructure!!!");
        DataStructureType dst = local.findDataStructure(agency, id);
        if (dst == null) {
            try {
                System.out.println("Find DataStructure2!!!");
                StructureType st = retrieve(getServiceURL() + "/registry/datastructure/" + agency.getString() + "/" + id.getString() + "/latest");
                load(st);
                DataStructureType dst2 = st.findDataStructure(agency, id);
                System.out.println("Dst="+dst2);
                return local.findDataStructure(agency, id);
            } catch (MalformedURLException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        return dst;
    }
    /*
     public List<DataStructureReferenceType> listDataStructures() {
     if (dataSetList != null) {
     return dataSetList;
     }
     dataSetList = new ArrayList<DataStructureReferenceType>();
     try {
     StructureType st = retrieve2(serviceURL + "/datastructure/"+this.agency+"/all/all/");
     Iterator<DataStructureType> it = st.getStructures().getDataStructures().getDataStructures().iterator();
     while (it.hasNext()) {
     DataStructureType ds = it.next();
     DataStructureRefType ref = new DataStructureRefType(ds.getAgencyID(), ds.getId(), ds.getVersion());
     DataStructureReferenceType reference = new DataStructureReferenceType(ref, null);
     dataSetList.add(reference);
     }
     } catch (MalformedURLException ex) {
     Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
     dataSetList = null;
     } catch (IOException ex) {
     Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
     dataSetList = null;
            
     } catch (ParseException ex) {
     Logger.getLogger(Sdmx20RESTQueryable.class.getName()).log(Level.SEVERE, null, ex);
     }
     return dataSetList;
     }
     */

    @Override
    public StructureType query(DataStructureQueryMessage message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataMessage query(DataQueryMessage message) {
        IDType flowid = message.getQuery().getDataWhere().getAnd().get(0).getDataflow().get(0).getMaintainableParentId();
        NestedNCNameIDType agency = new NestedNCNameIDType(this.getAgencyId());
        DataStructureType dst = null;
        for (int i = 0; i < dataflowList.size(); i++) {
            if (dataflowList.get(i).getId().equals(flowid)) {
                dst = findDataStructure(dataflowList.get(i).getStructure().getAgencyId(), dataflowList.get(i).getStructure().getMaintainableParentId(), dataflowList.get(i).getStructure().getMaintainedParentVersion());
            }
        }
        DataStructureType structure = dst;
        StringBuilder q = new StringBuilder();
        for (int i = 0; i < structure.getDataStructureComponents().getDimensionList().size(); i++) {
            DimensionType dim = structure.getDataStructureComponents().getDimensionList().getDimension(i);
            String concept = dim.getConceptIdentity().getId().toString();
            List<String> params = message.getQuery().getDataWhere().getAnd().get(0).getDimensionParameters(concept);
            if (params.size() > 0) {
                for (int j = 0; j < params.size(); j++) {
                    q.append(params.get(j));
                    if (j < params.size() - 1) {
                        q.append("+");
                    }
                }
            }
            if (i < structure.getDataStructureComponents().getDimensionList().size() - 1) {
                q.append(".");
            }
        }
        String startTime = message.getQuery().getDataWhere().getAnd().get(0).getTimeDimensionValue().get(0).getStart().toString();
        String endTime = message.getQuery().getDataWhere().getAnd().get(0).getTimeDimensionValue().get(0).getEnd().toString();
        DataMessage msg = null;
        try {
            msg = query(getServiceURL() + "/data/"+this.agency+"," + flowid + "/" + q.toString() + "?startPeriod=" + startTime + "&endPeriod=" + endTime);
        } catch (IOException ex) {
            Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }

    @Override
    public List<DataflowType> listDataflows() {
        if (dataflowList != null) {
            return dataflowList;
        }
        this.classifications = findCodelist(new NestedNCNameIDType(agency), new IDType("CL_COLLECTION"));
        for (int i = 0; i < classifications.size(); i++) {
            CodeType code = classifications.getCode(i);
            String cod = code.getId().toString();
            CodelistType ind = findCodelist(agency, "CL_INDICATOR_"+cod);
            if (ind != null) {
                indicators.put(cod, ind);
            }else {
                System.out.println("Ind Is Null:"+cod);
            }
        }
        dataflowList = new ArrayList<DataflowType>();
        for (int i = 0; i < classifications.size(); i++) {
            CodeType coll = classifications.getCode(i);
            String con = coll.getId().toString();
            CodelistType indic = indicators.get(con);
            if (indic != null) {
                for (int j = 0; j < indic.size(); j++) {
                    CodeType indicator = indic.getCode(j);
                    DataflowType dataflow = new DataflowType();
                    dataflow.setAgencyID(classifications.getAgencyID());
                    String indicid = indicator.getId().toString();
                    dataflow.setId(new IDType("DF_"+con + "_ALL_" + indicid));
                    dataflow.setVersion(null);
                    DataStructureRefType ref = new DataStructureRefType(classifications.getAgencyID(), new IDType(con + "_ALL_" + indicid), VersionType.ONE);
                    DataStructureReferenceType reference = new DataStructureReferenceType(ref, null);
                    dataflow.setStructure(reference);
                    List<Name> names = new ArrayList<Name>();
                    Name name = new Name("en", coll.findName("en").toString()+" - "+indicator.findName("en").toString());
                    names.add(name);
                    dataflow.setNames(names);
                    dataflowList.add(dataflow);
                }
            }
        }
        return dataflowList;
    }

    @Override
    public void reset() {
        local.reset();
    }

    @Override
    public MaintainableType resolve(StructureReferenceType ref) {
        return RegistryUtil.resolve(this, ref);
    }

    @Override
    public DataflowType findDataflow(NestedNCNameIDType agency, IDType id, VersionType vers) {
        DataflowType dst = local.findDataflow(agency, id, vers);
        if (dst == null) {
            try {
                StructureType st = retrieve(getServiceURL() + "/registry/dataflow/" + agency.getString() + "/" + id.getString() + "/" + vers != null ? vers.toString() : "latest");
                load(st);
                return local.findDataflow(agency, id, vers);
            } catch (MalformedURLException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ILORESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        return dst;
    }

    /**
     * @return the agency
     */
    public String getAgencyId() {
        return agency;
    }

    /**
     * @param agency the agency to set
     */
    public void setAgencyId(String agency) {
        this.agency = agency;
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

}

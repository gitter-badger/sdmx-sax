/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.net.service;

import sdmx.net.*;
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
import sdmx.Repository;
import sdmx.Queryable;
import sdmx.SdmxIO;
import sdmx.commonreferences.CodeReference;
import sdmx.commonreferences.CodelistReference;
import sdmx.commonreferences.ConceptReference;
import sdmx.commonreferences.ConceptSchemeReference;
import sdmx.commonreferences.DataStructureReference;
import sdmx.commonreferences.DataflowReference;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemSchemeReferenceBase;
import sdmx.commonreferences.NestedID;
import sdmx.commonreferences.NestedNCNameID;
import sdmx.commonreferences.StructureReference;
import sdmx.commonreferences.Version;
import sdmx.exception.ParseException;
import sdmx.message.DataMessage;
import sdmx.message.DataQueryMessage;
import sdmx.message.DataStructureQueryMessage;
import sdmx.message.StructureType;
import sdmx.net.LocalRegistry;
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
public class RESTQueryable implements Queryable, Registry, Repository {

    public static void main(String args[]) {
        RESTQueryable registry = new RESTQueryable("ESTAT", "http://www.ec.europa.eu/eurostat/SDMX/diss-web/rest");
        List<DataflowType> dfs = registry.listDataflows();
        for (int i = 0; i < dfs.size(); i++) {
            System.out.println(dfs.get(i).getName());
        }
    }
    private String agency = "";
    private String serviceURL = "";
    Registry local = new LocalRegistry();

    private List<DataflowType> dataflowList = null;

    public RESTQueryable(String agency, String service) {
        this.serviceURL = service;
        this.agency = agency;
    }

    public Registry getRegistry() {
        return this;
    }

    public Repository getRepository() {
        return this;
    }

    public void load(StructureType struct) {
        local.load(struct);
    }

    public void unload(StructureType struct) {
        local.unload(struct);
    }

    private StructureType retrieve(String urlString) throws MalformedURLException, IOException, ParseException {
        Logger.getLogger("sdmx").log(Level.INFO, "Rest Queryable Retrieve:" + urlString);
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
        Logger.getLogger("sdmx").log(Level.INFO, "Rest Queryable Query:" + urlString);
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
    /*
     private StructureType retrieve(String urlString) throws MalformedURLException, IOException, ParseException {
     Logger.getLogger("sdmx").log(Level.INFO, "Rest Queryable Retrieve:" + urlString);
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
     }*/

    @Override
    public DataMessage query(DataQueryMessage message) {
        Logger.getLogger("sdmx").log(Level.INFO, "Rest Queryable Query: DataQueryMessage" + message);
        IDType flowid = message.getQuery().getDataWhere().getAnd().get(0).getDataflow().get(0).getMaintainableParentId();
        NestedNCNameID agency = new NestedNCNameID(this.getAgencyId());
        DataStructureType dst = null;
        for (int i = 0; i < dataflowList.size(); i++) {
            if (dataflowList.get(i).getId().equals(flowid)) {
                DataStructureReference ref = DataStructureReference.create(dataflowList.get(i).getStructure().getAgencyId(), dataflowList.get(i).getStructure().getMaintainableParentId(), dataflowList.get(i).getStructure().getMaintainedParentVersion());
                dst = find(ref);
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
            msg = query(getServiceURL() + "/data/" + flowid + "/" + q.toString() + "?startPeriod=" + startTime + "&endPeriod=" + endTime);
        } catch (IOException ex) {
            Logger.getLogger("sdmx").log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger("sdmx").log(Level.SEVERE, null, ex);
        }
        return msg;
    }

    @Override
    public List<DataflowType> listDataflows() {
        Logger.getLogger("sdmx").log(Level.FINE, "Rest Queryable listDataflows():");
        if (dataflowList != null) {
            return dataflowList;
        }
        dataflowList = new ArrayList<DataflowType>();
        try {
            StructureType st = retrieve(getServiceURL() + "/dataflow/" + this.getAgencyId() + "/all/latest");
            dataflowList = st.getStructures().getDataflows().getDataflows();
        } catch (MalformedURLException ex) {
            Logger.getLogger("sdmx").log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger("sdmx").log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger("sdmx").log(Level.SEVERE, null, ex);
        }
        return dataflowList;
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

    @Override
    public void clear() {
        local.clear();
    }

    @Override
    public DataStructureType find(DataStructureReference ref) {
        Logger.getLogger("sdmx").log(Level.FINE, "RESTQueryable find(DataStructureReference:"+ref.getAgencyId()+":"+ref.getMaintainableParentId()+":"+ref.getVersion());
        DataStructureType dst = local.find(ref);
        if (dst == null) {
            try {
                StructureType st = retrieve(getServiceURL() + "/datastructure/" + ref.getAgencyId().toString() + "/" + ref.getMaintainableParentId().toString() + "/" + ref.getVersion().toString());
                load(st);
                return local.find(ref);
            } catch (MalformedURLException ex) {
                Logger.getLogger("sdmx").log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger("sdmx").log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger("sdmx").log(Level.SEVERE, null, ex);
            }
        }
        return dst;
    }

    @Override
    public DataflowType find(DataflowReference ref) {
        Logger.getLogger("sdmx").log(Level.FINE, "RESTQueryable find(DataflowReference:"+ref.getAgencyId()+":"+ref.getMaintainableParentId()+":"+ref.getVersion());
        DataflowType dft = local.find(ref);
        if (dft == null) {
            try {
                StructureType st = retrieve(getServiceURL() + "/dataflow/" + ref.getAgencyId().toString() + "/" + ref.getMaintainableParentId().toString() + "/" + ref.getVersion() != null ? ref.getVersion().toString() : "latest");
                load(st);
                return local.find(ref);
            } catch (MalformedURLException ex) {
                Logger.getLogger("sdmx").log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger("sdmx").log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger("sdmx").log(Level.SEVERE, null, ex);
            }
        }
        return dft;
    }

    @Override
    public CodeType find(CodeReference ref) {
        Logger.getLogger("sdmx").log(Level.FINE, "RESTQueryable find(CodeReference:"+ref.getAgencyId()+":"+ref.getMaintainableParentId()+":"+ref.getVersion());
        CodeType dst = local.find(ref);
        if (dst == null) {
            try {
                StructureType st = retrieve(getServiceURL() + "/codelist/" + ref.getAgencyId().toString() + "/" + ref.getMaintainableParentId().toString() + ref.getVersion() != null ? "/" + ref.getVersion().toString() : "/latest");
                load(st);
                return local.find(ref);
            } catch (MalformedURLException ex) {
                Logger.getLogger("sdmx").log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger("sdmx").log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger("sdmx").log(Level.SEVERE, null, ex);
            }
        }
        return dst;

    }

    @Override
    public CodelistType find(CodelistReference ref) {
        Logger.getLogger("sdmx").log(Level.FINE, "RESTQueryable find(CodelistReference:"+ref.getAgencyId()+":"+ref.getMaintainableParentId()+":"+ref.getVersion());
        CodelistType dst = local.find(ref);
        if (dst == null) {
            try {
                StructureType st = retrieve(getServiceURL() + "/codelist/" + ref.getAgencyId().toString() + "/" + ref.getMaintainableParentId().toString() + ref.getVersion() != null ? "/" + ref.getVersion().toString() : "/latest");
                load(st);
                return local.find(ref);
            } catch (MalformedURLException ex) {
                Logger.getLogger("sdmx").log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger("sdmx").log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger("sdmx").log(Level.SEVERE, null, ex);
            }
        }
        return dst;
    }

    @Override
    public ConceptType find(ConceptReference ref) {
        ConceptSchemeReference ref2 = ConceptSchemeReference.create(ref.getAgencyId(),ref.getMaintainableParentId(),ref.getVersion());
        ConceptSchemeType cs = find(ref2);
        return cs.findConcept(ref.getId());
    }

    @Override
    public ConceptSchemeType find(ConceptSchemeReference ref) {
        Logger.getLogger("sdmx").log(Level.FINE, "RESTQueryable find(ConceptSchemeReference:"+ref.getAgencyId()+":"+ref.getMaintainableParentId()+":"+ref.getVersion());
        ConceptSchemeType dst = local.find(ref);
        if (dst == null) {
            try {
                StructureType st = retrieve(getServiceURL() + "/conceptscheme/" + ref.getAgencyId().toString() + "/" + ref.getMaintainableParentId().toString() + "/" + ref.getVersion().toString());
                load(st);
                return local.find(ref);
            } catch (MalformedURLException ex) {
                Logger.getLogger("sdmx").log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger("sdmx").log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger("sdmx").log(Level.SEVERE, null, ex);
            }
        }
        return dst;
    }

}

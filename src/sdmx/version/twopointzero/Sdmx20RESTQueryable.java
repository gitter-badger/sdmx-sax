/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointzero;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sdmx.Registry;
import sdmx.SdmxIO;
import sdmx.commonreferences.DataStructureRefType;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.exception.ParseException;
import sdmx.exception.QueryableException;
import sdmx.message.BaseHeaderType;
import sdmx.message.DataMessage;
import sdmx.message.DataQueryMessage;
import sdmx.message.DataStructure;
import sdmx.message.DataStructureQueryMessage;
import sdmx.message.StructureType;
import sdmx.query.datastructure.DataStructureWhereType;
import sdmx.registry.LocalRegistry;
import sdmx.registry.RESTServiceRegistry;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structure.datastructure.DimensionType;
import sdmx.version.common.Queryable;

/**
 *
 * @author James
 */
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *   SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public class Sdmx20RESTQueryable implements Queryable {

    private String agencyId = "";
    private String serviceURL = "";
    // Temporary Registry
    Registry registry = null;
    List<DataStructureReferenceType> dataSetList = null;

    public Sdmx20RESTQueryable(String agencyId, String serviceURL) {
        this.agencyId = agencyId;
        this.serviceURL = serviceURL;
    }

    public String getAgencyId() {
        return agencyId;
    }

    @Override
    public StructureType query(DataStructureQueryMessage message) {
        DataStructureWhereType where = message.getDataStructureWhereType();
        try {
            StructureType st = retrieveStructure(serviceURL + "/datastructure/" + message.getDataStructureWhereType().getAgencyId().getString() + "/" + message.getDataStructureWhereType().getId().get(0).toString() + "/" + message.getDataStructureWhereType().getVersion().getString());
            return st;
        } catch (MalformedURLException ex) {
            Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Sdmx20RESTQueryable.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Returning null Structure File");
        return null;
    }
    public DataMessage query(DataQueryMessage message) {
        IDType structid = message.getQuery().getDataWhere().getDataSetId().get(0);
        NestedNCNameIDType agency = new NestedNCNameIDType(agencyId);
        DataStructureType structure = registry.findDataStructure(agency, structid);
        StringBuilder q = new StringBuilder();
        for(int i=0;i<structure.getDataStructureComponents().getDimensionList().size();i++) {
            DimensionType dim = structure.getDataStructureComponents().getDimensionList().getDimension(i);
            String concept = dim.getConceptIdentity().getRef().getId().toString();
            List<String> params = message.getQuery().getDataWhere().getDimensionParameters(concept);
            if( params.size()>0) {
                for(int j=0;j<params.size();j++) {
                    q.append(params.get(j));
                    if( j<params.size()-1)q.append("+");
                }
            }
            if(i<structure.getDataStructureComponents().getDimensionList().size()-1)q.append(".");
        }
        
        return null;
    }

    private StructureType retrieveStructure(String urlString) throws MalformedURLException, IOException, ParseException {
        System.out.println("REST Queryable Retrieve:" + urlString);
        URL url = new URL(urlString);
        HttpURLConnection conn
                = (HttpURLConnection) url.openConnection();
        if (conn.getResponseCode() != 200) {
            throw new IOException(conn.getResponseMessage());
        }
        InputStream in = conn.getInputStream();
        StructureType st = SdmxIO.parseStructure(registry, in);
        if( st == null ) {
            System.out.println("Retrieve fetched a null Structure");
        }
        return st;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getServiceURL() {
        return serviceURL;
    }

    public void setServiceURL(String serviceURL) {
        this.serviceURL = serviceURL;
    }

    @Override
    public List<DataStructureReferenceType> listDataSets() {
        if (dataSetList != null) {
            return dataSetList;
        }
        dataSetList = new ArrayList<DataStructureReferenceType>();
        try {
            StructureType st = retrieveStructure(serviceURL + "/datastructure/"+agencyId+"/all/all/");
            registry.load(st);
            Iterator<DataStructureType> it = st.getStructures().getDataStructures().getDataStructures().iterator();
            while (it.hasNext()) {
                DataStructureType ds = it.next();
                DataStructureRefType ref = new DataStructureRefType(ds.getAgencyID(), ds.getId(), ds.getVersion());
                DataStructureReferenceType reference = new DataStructureReferenceType(ref, null);
                dataSetList.add(reference);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Sdmx20SOAPQueryable.class.getName()).log(Level.SEVERE, null, ex);
            dataSetList = null;
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20SOAPQueryable.class.getName()).log(Level.SEVERE, null, ex);
            dataSetList = null;
        } catch (ParseException ex) {
            Logger.getLogger(Sdmx20RESTQueryable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataSetList;
    }
    public Registry getRegistry() {
        return registry;
    }
    public void setRegistry(Registry r) {
        registry=r;
    }
}

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
import sdmx.exception.ParseException;
import sdmx.message.BaseHeaderType;
import sdmx.message.DataMessage;
import sdmx.message.DataQueryMessage;
import sdmx.message.DataStructureQueryMessage;
import sdmx.message.StructureType;
import sdmx.query.datastructure.DataStructureWhereType;
import sdmx.registry.LocalRegistry;
import sdmx.registry.QueryableServiceRegistry;
import sdmx.registry.RESTServiceRegistry;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.version.common.Queryable;
import sdmx.exception.QueryableException;

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
    Registry registry = new QueryableServiceRegistry(this);
    List<DataStructureReferenceType> dataSetList = null;

    public Sdmx20RESTQueryable(String agencyId, String serviceURL) {
        this.agencyId = agencyId;
        this.serviceURL = serviceURL;
    }

    @Override
    public String getAgencyId() {
        return agencyId;
    }

    @Override
    public StructureType query(DataStructureQueryMessage message) throws QueryableException {
        DataStructureWhereType where = message.getDataStructureWhereType();
        System.out.println("DSW="+message.getDataStructureWhereType().getVersion().toString());
        try {
            StructureType st = retrieve(serviceURL + "/datastructure/" + message.getDataStructureWhereType().getAgencyId().getString() + "/" + message.getDataStructureWhereType().getId().get(0).toString() + "/" + message.getDataStructureWhereType().getVersion().getString());
            return st;
        } catch (MalformedURLException ex) {
            Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(Sdmx20RESTQueryable.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        System.out.println("Returning null Structure File");
        return null;
    }
    @Override
    public DataMessage query(DataQueryMessage message) throws QueryableException {
        return null;
    }

    private StructureType retrieve(String urlString) throws MalformedURLException, IOException, ParseException {
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

    @Override
    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    @Override
    public String getServiceURL() {
        return serviceURL;
    }

    @Override
    public void setServiceURL(String serviceURL) {
        this.serviceURL = serviceURL;
    }

    @Override
    public List<DataStructureReferenceType> listDataSets() throws QueryableException {
        if (dataSetList != null) {
            return dataSetList;
        }
        dataSetList = new ArrayList<DataStructureReferenceType>();
        try {
            StructureType st = retrieve(serviceURL + "/datastructure/"+agencyId+"/all/all/");
            Iterator<DataStructureType> it = st.getStructures().getDataStructures().getDataStructures().iterator();
            while (it.hasNext()) {
                DataStructureType ds = it.next();
                System.out.println("vers="+ds.getVersion());
                DataStructureRefType ref = new DataStructureRefType(ds.getAgencyID(), ds.getId(), ds.getVersion());
                DataStructureReferenceType reference = new DataStructureReferenceType(ref, null);
                dataSetList.add(reference);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Sdmx20SOAPQueryable.class.getName()).log(Level.SEVERE, null, ex);
            dataSetList = null;
            throw new QueryableException("Malformed URL Exception");
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20SOAPQueryable.class.getName()).log(Level.SEVERE, null, ex);
            dataSetList = null;
            throw new QueryableException("Network Error");
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

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
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.message.BaseHeaderType;
import sdmx.message.DataStructureQueryMessage;
import sdmx.message.StructureType;
import sdmx.version.common.Queryable;
import sdmx.version.common.SdmxIO;
import sdmx.workspace.RESTServiceRegistry;
import sdmx.workspace.Registry;

/**
 *
 * @author James
 */
public class Sdmx20RESTQueryable implements Queryable {
    private String agencyId = "";
    private String serviceURL = "";
    Registry registry = null;
    public Sdmx20RESTQueryable(Registry registry,String agencyId,String serviceURL) {
        this.registry=registry;
        this.agencyId=agencyId;
        this.serviceURL=serviceURL;
    }    

    @Override
    public String getAgencyId() {
        return agencyId;
    }

    @Override
    public StructureType getDataStructure(DataStructureQueryMessage message) throws MalformedURLException, IOException {
            try {
                StructureType st = retrieve(serviceURL + "/registry/datastructure/" + message.getDataStructureWhereType().getAgencyId().getString() + "/" + message.getDataStructureWhereType().getId().toString() + "/" + message.getDataStructureWhereType().getVersion().toString());
                return st;
            } catch (MalformedURLException ex) {
                Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RESTServiceRegistry.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
    }
    
    private StructureType retrieve(String urlString) throws MalformedURLException, IOException {
        System.out.println("REST Queryable Retrieve:" + urlString);
        URL url = new URL(urlString);
        HttpURLConnection conn =
                (HttpURLConnection) url.openConnection();
        if (conn.getResponseCode() != 200) {
            throw new IOException(conn.getResponseMessage());
        }
        InputStream in = conn.getInputStream();
        StructureType st = SdmxIO.parseStructure(registry, in);
        return st;
    }

    @Override
    public void setAgencyId(String agencyId) {
        this.agencyId=agencyId;
    }

    @Override
    public String getServiceURL() {
        return serviceURL;
    }

    @Override
    public void setServiceURL(String serviceURL) {
        this.serviceURL=serviceURL;
    }

    @Override
    public Registry getRegistry() {
        return registry;
    }

    @Override
    public void setRegistry(Registry registry) {
        this.registry=registry;
    }

    @Override
    public List<DataStructureReferenceType> listDataSets(BaseHeaderType header) {
        return Collections.EMPTY_LIST;
    }
    
}

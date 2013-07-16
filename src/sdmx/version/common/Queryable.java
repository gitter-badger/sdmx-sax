/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.common;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.message.BaseHeaderType;
import sdmx.message.DataStructureQueryMessage;
import sdmx.message.StructureType;
import sdmx.workspace.Registry;

/**
 *
 * @author James
 */
public interface Queryable {

    public String getAgencyId();

    public StructureType getDataStructure(DataStructureQueryMessage message) throws MalformedURLException, IOException;

    public List<DataStructureReferenceType> listDataSets(BaseHeaderType header);
    

    public void setAgencyId(String agencyId);

    /**
     * @return the serviceURL
     */
    public String getServiceURL();

    /**
     * @param serviceURL the serviceURL to set
     */
    public void setServiceURL(String serviceURL);

    /**
     * @return the registry
     */
    public Registry getRegistry();

    /**
     * @param registry the registry to set
     */
    public void setRegistry(Registry registry);
    public String getSoapNamespace();
    public void setSoapNamespace(String s);
}

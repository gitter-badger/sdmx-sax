/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.common;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import sdmx.Registry;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.message.BaseHeaderType;
import sdmx.message.DataMessage;
import sdmx.message.DataQueryMessage;
import sdmx.message.DataStructureQueryMessage;
import sdmx.message.StructureType;

/**
 *
 * @author James
 */
public interface Queryable {

    public String getAgencyId();

    public StructureType query(DataStructureQueryMessage message) throws QueryableException;
    public DataMessage query(DataQueryMessage message) throws QueryableException;
    public List<DataStructureReferenceType> listDataSets() throws QueryableException;

    public void setAgencyId(String agencyId);

    /**
     * @return the serviceURL
     */
    public String getServiceURL();

    /**
     * @param serviceURL the serviceURL to set
     */
    public void setServiceURL(String serviceURL);
    public Registry getRegistry();
    public void setRegistry(Registry r);
}

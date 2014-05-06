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

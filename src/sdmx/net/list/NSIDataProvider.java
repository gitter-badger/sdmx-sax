/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *  SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
package sdmx.net.list;

import java.net.MalformedURLException;
import java.net.URL;
import sdmx.Queryable;
import sdmx.net.service.nsi.Sdmx20NSIQueryable;

/**
 *
 * @author James
 */
public class NSIDataProvider extends DataProvider {

    private String agencyId = null;
    private URL serviceURL = null;
    private String soapNamespace = null;

    public NSIDataProvider(int indx,String agency, String serviceURL, String soapNamespace,String attribution,String htmlAttribution) throws MalformedURLException {
        super(indx,attribution,htmlAttribution);
        this.agencyId = agency;
        this.serviceURL = new URL(serviceURL);
        this.soapNamespace = soapNamespace;
    }

    @Override
    public Queryable getQueryable() {
        Sdmx20NSIQueryable q = new Sdmx20NSIQueryable(agencyId, serviceURL.toString());
        q.setSoapNamespace(soapNamespace);
        return q;
    }
    
    public String getAgencyId() {
        return agencyId;
    }
    public int getType() { return DataProvider.TYPE_NSI; }
    public String getServiceURL() { return this.serviceURL.toString(); }
    @Override
    public String getOptions() { return soapNamespace; }
}

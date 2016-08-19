/*
    This file is part of sdmx-sax.

    sdmx-sax is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    sdmx-sax is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with sdmx-sax.  If not, see <http://www.gnu.org/licenses/>.
    Copyright (C) 2015 James Gardner
*/
package sdmx.net;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import sdmx.net.list.DataProvider;
import sdmx.net.list.ILODataProvider;
import sdmx.net.list.KnoemaDataProvider;
import sdmx.net.list.NSIDataProvider;
//import sdmx.net.list.NSIDataProvider;
import sdmx.net.list.NomisDataProvider;
//import sdmx.net.list.ONSDataProvider;
import sdmx.net.list.OpenSDMXDataProvider;
import sdmx.net.list.RESTDataProvider;
import sdmx.net.list.SDWDataProvider;

/**
 *
 * @author James
 */
public class ServiceList {
    
    public static DataProvider getDataProvider(int type, String agency,String serviceURL,String options,String attribution,String htmlAttribution) throws MalformedURLException {
        for(DataProvider dp:DataProvider.getList()){
            if( dp.getType() == type && agency.equals(dp.getAgencyId()) && dp.getServiceURL().equals(serviceURL)) {
                return dp;
            }
        }
        switch(type) {
            case DataProvider.TYPE_ILO:return new ILODataProvider(-1,agency, serviceURL,attribution,htmlAttribution);
            case DataProvider.TYPE_KNOEMA:return new KnoemaDataProvider(-1,agency, serviceURL,attribution,htmlAttribution);
            case DataProvider.TYPE_NSI:return new NSIDataProvider(-1,agency, serviceURL,options,attribution,htmlAttribution);
            case DataProvider.TYPE_SDW:return new SDWDataProvider(-1,agency, serviceURL,options,attribution,htmlAttribution);
            case DataProvider.TYPE_REST:return new RESTDataProvider(-1,agency, serviceURL,attribution,htmlAttribution);
            case DataProvider.TYPE_OPENSDMX:return new OpenSDMXDataProvider(-1,agency, serviceURL,attribution,htmlAttribution);
            case DataProvider.TYPE_NOMIS:return new NomisDataProvider(-1,agency, serviceURL,options,attribution,htmlAttribution);
            //case DataProvider.TYPE_ONS:return new ONSDataProvider(-1,agency, serviceURL,options,attribution,htmlAttribution);
        }
        return null;
    }
    public static List<DataProvider> listDataProviders() {
        return DataProvider.getList();
    }
}

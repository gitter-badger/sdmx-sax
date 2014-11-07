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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sdmx.Registry;
import sdmx.Queryable;

/**
 *
 * @author James
 */
public class DataProvider {
    public static final int TYPE_SDW = 0;
    public static final int TYPE_NSI = 1;
    public static final int TYPE_REST = 2;
    public static final int TYPE_OPENSDMX = 3;
    public static final int TYPE_ILO = 4;
    public static final int TYPE_KNOEMA = 5;
    
    
    private static final List<DataProvider> LIST = new ArrayList<DataProvider>();
    static{
        try {
            LIST.add(new SDWDataProvider(0,"ABS","http://stat.abs.gov.au/sdmxws/sdmx.asmx","http://stats.oecd.org/OECDStatWS/SDMX/"));
            LIST.add(new SDWDataProvider(1,"I","http://dati.istat.it/SDMXWS/sdmx.asmx","http://stats.oecd.org/OECDStatWS/SDMX/"));
            LIST.add(new SDWDataProvider(2,"OECD","http://stats.oecd.org/SDMXWS/sdmx.asmx","http://stats.oecd.org/OECDStatWS/SDMX/"));
            LIST.add(new SDWDataProvider(3,"IMF","http://sdmxws.imf.org/IMFStatWS_SDMX2/sdmx.asmx","http://stats.imf.org/DotStatWS/SDMX/"));
            LIST.add(new RESTDataProvider(4,"ESTAT","http://www.ec.europa.eu/eurostat/SDMX/diss-web/rest"));
            LIST.add(new RESTDataProvider(5,"ECB","http://a-sdw-wsrest.ecb.europa.eu/service"));
            LIST.add(new NSIDataProvider(6,"UIS","http://data.un.org/ws/NSIStdV20Service.asmx","http://ec.europa.eu/eurostat/sri/service/2.0"));
            LIST.add(new NSIDataProvider(7,"INEGI","http://www.snieg.mx/opendata/NSIStdV20Service.asmx","http://ec.europa.eu/eurostat/sri/service/2.0"));
            LIST.add(new OpenSDMXDataProvider(8,"FAO","http://data.fao.org/sdmx"));
            LIST.add(new ILODataProvider(9,"ILO","http://www.ilo.org/ilostat/sdmx/ws/rest"));
            LIST.add(new KnoemaDataProvider(10,"Knoema","http://knoema.com/api/1.0/sdmx"));
            LIST.add(new KnoemaDataProvider(11,"AfDB","http://opendataforafrica.org/api/1.0/sdmx"));
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private int index = -1;
    public DataProvider(int indx) {
        this.index=indx;
    }
    public int getIndex() {
        return index;
    }
    public static List<DataProvider>  getList() { return LIST; }
    public Queryable getQueryable() {
        return null;
    }
    
    public String getAgencyId() { return ""; }
    public String toString() { return getAgencyId(); }
    public int getType() { return -1; }
    public String getServiceURL() { return ""; }
    public String getOptions() { return ""; }

}

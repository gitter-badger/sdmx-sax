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
            LIST.add(new SDWDataProvider(1,"ABS","http://stat.abs.gov.au/sdmxws/sdmx.asmx","http://stats.oecd.org/OECDStatWS/SDMX/",                    "Based on Australian Bureau of Statistics data","Based on Australian Bureau of Statistics data"));
            LIST.add(new SDWDataProvider(2,"I","http://dati.istat.it/SDMXWS/sdmx.asmx","http://stats.oecd.org/OECDStatWS/SDMX/",                        "Based on Italian National Institute of Statistics data","Based on Italian National Institute of Statistics data"));
            LIST.add(new SDWDataProvider(3,"OECD","http://stats.oecd.org/SDMXWS/sdmx.asmx","http://stats.oecd.org/OECDStatWS/SDMX/",                    "Based on OECD.Stat data","Based on OECD.Stat data"));
            LIST.add(new SDWDataProvider(4,"IMF","http://sdmxws.imf.org/SDMX/sdmx.asmx","http://stats.imf.org/DotStatWS/SDMX/",              "Based on International Monetary Fund data","Based on International Monetary Fund data"));
            LIST.add(new RESTDataProvider(5,"ESTAT","http://www.ec.europa.eu/eurostat/SDMX/diss-web/rest",                                              "Based on Eurostat data","Based on Eurostat data"));
            LIST.add(new RESTDataProvider(6,"ECB","http://a-sdw-wsrest.ecb.europa.eu/service",                                                          "Based on European Central Bank data","Based on European Central Bank data"));
            LIST.add(new NSIDataProvider(7,"UIS","http://data.un.org/ws/NSIStdV20Service.asmx","http://ec.europa.eu/eurostat/sri/service/2.0",          "Based on UNESCO Institute for Statistics data","Based on UNESCO Institute for Statistics data"));
            LIST.add(new NSIDataProvider(8,"INEGI","http://www.snieg.mx/opendata/NSIStdV20Service.asmx","http://ec.europa.eu/eurostat/sri/service/2.0", "Based on Instituto Nacional de Estadística y Geografía data","Based on Instituto Nacional de Estadística y Geografía data"));
            LIST.add(new OpenSDMXDataProvider(9,"FAO","http://data.fao.org/sdmx",                                                                       "Based on Food and Agriculture Organisation of the United Nations data","Based on Food and Agriculture Organisation of the United Nations data"));
            LIST.add(new ILODataProvider(10,"ILO","http://www.ilo.org/ilostat/sdmx/ws/rest",                                                             "Based on International Labour Organisation data","Based on International Labour Organisation data"));
            LIST.add(new KnoemaDataProvider(11,"Knoema","http://knoema.com/api/1.0/sdmx",                                                               "Based on data provided by Knoema(various sources)","Based on data provided by Knoema(various sources)"));
            LIST.add(new KnoemaDataProvider(12,"AfDB","http://opendataforafrica.org/api/1.0/sdmx",                                                      "Based on African Development Bank Group data(www.opendataforafrica.org)","Based on African Development Bank Group data(www.opendataforafrica.org)"));
            LIST.add(new SDWDataProvider(13,"NBB","http://stat.nbb.be/sdmxws/sdmx.asmx","http://stats.oecd.org/OECDStatWS/SDMX/",              "Based on National Bank of Belgium data","Based on National Bank of Belgium data"));
            LIST.add(new SDWDataProvider(14,"UKDS","https://stats.ukdataservice.ac.uk/sdmxws/sdmx.asmx","http://stats.oecd.org/OECDStatWS/SDMX/",              "Based on United Kingdom Data Service data","Based on United Kingdom Data Service data"));
            
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private int index = -1;
    private String attribution = "";
    private String htmlAttribution = "";
    public DataProvider(int indx,String attribution,String htmlAttribution) {
        this.index=indx;
        this.attribution=attribution;
        this.htmlAttribution=htmlAttribution;
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

    /**
     * @return the attribution
     */
    public String getAttribution() {
        return attribution;
    }

    /**
     * @return the htmlAttribution
     */
    public String getHtmlAttribution() {
        return htmlAttribution;
    }

    /**
     * @param htmlAttribution the htmlAttribution to set
     */
    public void setHtmlAttribution(String htmlAttribution) {
        this.htmlAttribution = htmlAttribution;
    }

}

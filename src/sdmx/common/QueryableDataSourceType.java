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
package sdmx.common;

/**
 *	<xs:complexType name="QueryableDataSourceType">
		<xs:annotation>
			<xs:documentation>QueryableDataSourceType describes a data source which is accepts an standard SDMX Query message and responds appropriately.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="DataURL" type="xs:anyURI">
				<xs:annotation>
					<xs:documentation>DataURL contains the URL of the data source.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="WSDLURL" type="xs:anyURI" minOccurs="0">
				<xs:annotation>
					<xs:documentation>WSDLURL provides the location of a WSDL instance on the internet which describes the queryable data source.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="WADLURL" type="xs:anyURI" minOccurs="0">
				<xs:annotation>
					<xs:documentation>WADLURL provides the location of a WADL instance on the internet which describes the REST protocol of the queryable data source.</xs:documentation>
				</xs:annotation>
			</xs:element>
		</xs:sequence>
		<xs:attribute name="isRESTDatasource" type="xs:boolean" use="required">
			<xs:annotation>
				<xs:documentation>The isRESTDatasource attribute indicates, if true, that the queryable data source is accessible via the REST protocol.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
		<xs:attribute name="isWebServiceDatasource" type="xs:boolean" use="required">
			<xs:annotation>
				<xs:documentation>The isWebServiceDatasource attribute indicates, if true, that the queryable data source is accessible via Web Services protocols.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
	</xs:complexType>
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
public class QueryableDataSourceType {
       private String dataURL = null;
       private String wsdlURL = null;
       private String wadlURL = null;
       private boolean isRestDatasource = false;
       private boolean isWebServiceDatasource = false;

       public QueryableDataSourceType(String data,String wsdl,String wadl,boolean rest, boolean web){
           this.dataURL=data;
           this.wsdlURL=wsdl;
           this.wadlURL=wadl;
           this.isRestDatasource=rest;
           this.isWebServiceDatasource=web;
       }


    /**
     * @return the dataURL
     */
    public String getDataURL() {
        return dataURL;
    }

    /**
     * @param dataURL the dataURL to set
     */
    public void setDataURL(String dataURL) {
        this.dataURL = dataURL;
    }

    /**
     * @return the wsdlURL
     */
    public String getWsdlURL() {
        return wsdlURL;
    }

    /**
     * @param wsdlURL the wsdlURL to set
     */
    public void setWsdlURL(String wsdlURL) {
        this.wsdlURL = wsdlURL;
    }

    /**
     * @return the wadlURL
     */
    public String getWadlURL() {
        return wadlURL;
    }

    /**
     * @param wadlURL the wadlURL to set
     */
    public void setWadlURL(String wadlURL) {
        this.wadlURL = wadlURL;
    }

    /**
     * @return the isRestDatasource
     */
    public boolean isIsRestDatasource() {
        return isRestDatasource;
    }

    /**
     * @param isRestDatasource the isRestDatasource to set
     */
    public void setIsRestDatasource(boolean isRestDatasource) {
        this.isRestDatasource = isRestDatasource;
    }

    /**
     * @return the isWebServiceDatasource
     */
    public boolean isIsWebServiceDatasource() {
        return isWebServiceDatasource;
    }

    /**
     * @param isWebServiceDatasource the isWebServiceDatasource to set
     */
    public void setIsWebServiceDatasource(boolean isWebServiceDatasource) {
        this.isWebServiceDatasource = isWebServiceDatasource;
    }
}

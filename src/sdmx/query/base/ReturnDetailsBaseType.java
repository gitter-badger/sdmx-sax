/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

/**
 *	<xs:complexType name="ReturnDetailsBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>ReturnDetailsBaseType is an abstract type that forms the basis for any query return details.</xs:documentation>
		</xs:annotation>
		<xs:attribute name="defaultLimit" type="xs:integer" use="optional">
			<xs:annotation>
				<xs:documentation>The defaultLimit attribute is the suggested maximum response size in kilobytes.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
		<xs:attribute name="detail" type="xs:string" use="optional">
			<xs:annotation>
				<xs:documentation>>The detail attribute is used to indicate how much of the matched object should be returned.</xs:documentation>
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
public class ReturnDetailsBaseType {
    private Integer defaultLimit=null;
    private String detail=null;

    /**
     * @return the defaultLimit
     */
    public Integer getDefaultLimit() {
        return defaultLimit;
    }

    /**
     * @param defaultLimit the defaultLimit to set
     */
    public void setDefaultLimit(Integer defaultLimit) {
        this.defaultLimit = defaultLimit;
    }

    /**
     * @return the detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail the detail to set
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
}

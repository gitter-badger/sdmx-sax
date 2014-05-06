/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import sdmx.commonreferences.CodelistReferenceType;

/**
 *	<xs:complexType name="CodeValueType">
		<xs:annotation>
			<xs:documentation>CodeValueType is used to query for data or reference metadata where a component which uses the referenced codelist as its representation enumeration has the value provided. Note that this is only applicable when the value is a coded value, which is to say that it does not apply to a codelist which is specified as the representation or an identifiable object target in a metadata target.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="Codelist" type="common:CodelistReferenceType">
				<xs:annotation>
					<xs:documentation>Codelist references the codelist for which the coded value is being sought.</xs:documentation>
				</xs:annotation>
			</xs:element>
		</xs:sequence>
		<xs:attribute name="value" type="xs:string" use="required">
			<xs:annotation>
				<xs:documentation>The value attribute indicates the coded value that is to be queried for.</xs:documentation>
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
public class CodeValueType {
    private CodelistReferenceType codelist = null;
    private String value = null;

    /**
     * @return the codelist
     */
    public CodelistReferenceType getCodelist() {
        return codelist;
    }

    /**
     * @param codelist the codelist to set
     */
    public void setCodelist(CodelistReferenceType codelist) {
        this.codelist = codelist;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
    
}

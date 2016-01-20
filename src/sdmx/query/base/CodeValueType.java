/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import sdmx.commonreferences.CodelistReference;

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
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
 */
public class CodeValueType {
    private CodelistReference codelist = null;
    private String value = null;

    /**
     * @return the codelist
     */
    public CodelistReference getCodelist() {
        return codelist;
    }

    /**
     * @param codelist the codelist to set
     */
    public void setCodelist(CodelistReference codelist) {
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

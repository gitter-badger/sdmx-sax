/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import sdmx.commonreferences.ItemSchemeReferenceBaseType;

/**
 *	<xs:complexType name="RepresentationType" abstract="true">
		<xs:annotation>
			<xs:documentation>RepresentationType is an abstract type that defines a representation. Because the type of item schemes that are allowed as the an enumeration vary based on the object in which this is defined, this type is abstract to force that the enumeration reference be restricted to the proper type of item scheme reference.</xs:documentation>
		</xs:annotation>
		<xs:choice>
			<xs:element name="TextFormat" type="TextFormatType">
				<xs:annotation>
					<xs:documentation>TextFormat describes an uncoded textual format.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:sequence>
				<xs:element name="Enumeration" type="common:ItemSchemeReferenceBaseType">
					<xs:annotation>
						<xs:documentation>Enumeration references an item scheme that enumerates the allowable values for this representation.</xs:documentation>
					</xs:annotation>
				</xs:element>
				<xs:element name="EnumerationFormat" type="CodededTextFormatType" minOccurs="0">
					<xs:annotation>
						<xs:documentation>EnumerationFormat describes the facets of the item scheme enumeration. This is for the most part, informational.</xs:documentation>
					</xs:annotation>
				</xs:element>
			</xs:sequence>
		</xs:choice>
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
public class RepresentationType {
   
    private TextFormatType textFormat = null;
    private ItemSchemeReferenceBaseType enumeration = null;
    private CodededTextFormatType enumerationFormat = null;

    /**
     * @return the textFormat
     */
    public TextFormatType getTextFormat() {
        return textFormat;
    }

    /**
     * @param textFormat the textFormat to set
     */
    public void setTextFormat(TextFormatType textFormat) {
        this.textFormat = textFormat;
    }

    /**
     * @return the enumeration
     */
    public ItemSchemeReferenceBaseType getEnumeration() {
        return enumeration;
    }

    /**
     * @param enumeration the enumeration to set
     */
    public void setEnumeration(ItemSchemeReferenceBaseType enumeration) {
        this.enumeration = enumeration;
    }

    /**
     * @return the enumerationForma
     */
    public CodededTextFormatType getEnumerationFormat() {
        return enumerationFormat;
    }

    /**
     * @param enumerationForma the enumerationForma to set
     */
    public void setEnumerationFormat(CodededTextFormatType enumerationForma) {
        this.enumerationFormat = enumerationForma;
    }

}

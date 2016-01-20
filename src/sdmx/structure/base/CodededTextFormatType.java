/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import sdmx.xml.positiveInteger;

/**
 *	<xs:complexType name="CodededTextFormatType">
		<xs:annotation>
			<xs:documentation>CodededTextFormatType is a restricted version of the SimpleComponentTextFormatType that only allows factets and text types applicable to codes. Although the time facets permit any value, an actual code identifier does not support the necessary characters for time. Therefore these facets should not contain time in their values.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="SimpleComponentTextFormatType">
				<xs:attribute name="textType" type="CodeDataType" use="optional"/>
				<xs:attribute name="isSequence" type="xs:boolean" use="optional"/>
				<xs:attribute name="interval" type="xs:integer" use="optional"/>
				<xs:attribute name="startValue" type="xs:integer" use="optional"/>
				<xs:attribute name="endValue" type="xs:integer" use="optional"/>
				<xs:attribute name="timeInterval" type="xs:duration" use="optional"/>
				<xs:attribute name="startTime" type="common:StandardTimePeriodType" use="optional"/>
				<xs:attribute name="endTime" type="common:StandardTimePeriodType" use="optional"/>
				<xs:attribute name="minLength" type="xs:positiveInteger" use="optional"/>
				<xs:attribute name="maxLength" type="xs:positiveInteger" use="optional"/>
				<xs:attribute name="minValue" type="xs:integer" use="optional"/>
				<xs:attribute name="maxValue" type="xs:integer" use="optional"/>
				<xs:attribute name="decimals" type="xs:positiveInteger" use="prohibited"/>
				<xs:attribute name="pattern" type="xs:string" use="optional"/>
			</xs:restriction>
		</xs:complexContent>
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
public class CodededTextFormatType extends SimpleComponentTextFormatType {

    CodeDataType textType = null;
    
    /**
     * @return the decimals
     */
    public positiveInteger getDecimals() {
        throw new RuntimeException("Decimals is prohibited field in CodededTextFormatType");
    }

    /**
     * @param decimals the decimals to set
     */
    public void setDecimals(positiveInteger decimals) {
        throw new RuntimeException("Decimals is prohibited field in CodededTextFormatType");
    }
    
}

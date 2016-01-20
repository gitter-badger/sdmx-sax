/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import sdmx.common.SimpleDataType;

/**
 *	<xs:complexType name="SimpleComponentTextFormatType">
		<xs:annotation>
			<xs:documentation>SimpleComponentTextFormatType is a restricted version of the BasicComponentTextFormatType that does not allow for multi-lingual values.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="BasicComponentTextFormatType">
				<xs:attribute name="textType" type="common:SimpleDataType" use="optional" default="String"/>
				<xs:attribute name="isMultiLingual" type="xs:boolean" use="prohibited"/>
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
public class SimpleComponentTextFormatType extends BasicComponentTextFormatType {
    private SimpleDataType textType = null;

    private Boolean isMultiLingual = false;// prohibited field

    /**
     * @return the textType
     */
    public SimpleDataType getTextType() {
        return textType;
    }

    /**
     * @param textType the textType to set
     */
    public void setTextType(SimpleDataType textType) {
        this.textType = textType;
    }

    /**
     * @return the isMultiLingual
     */
    @Override
    public Boolean isMultiLingual() {
        return Boolean.FALSE;
    }

    /**
     * @param isMultiLingual the isMultiLingual to set
     */
    public void setMultiLingual(Boolean isMultiLingual) {
        this.isMultiLingual = isMultiLingual;
    }
}

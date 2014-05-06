/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import sdmx.common.BasicComponentDataType;
import sdmx.common.DataType;

/**
 *	<xs:complexType name="BasicComponentTextFormatType">
		<xs:annotation>
			<xs:documentation>BasicComponentTextFormatType is a restricted version of the TextFormatType that restricts the text type to the representations allowed for all components except for target objects.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="TextFormatType">
				<xs:attribute name="textType" type="common:BasicComponentDataType" use="optional" default="String"/>
			</xs:restriction>
		</xs:complexContent>
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
public class BasicComponentTextFormatType extends TextFormatType {
    private BasicComponentDataType textType =null;

    /**
     * @return the textType
     */
    @Override
    public BasicComponentDataType getTextType() {
        return textType;
    }

    /**
     * @param textType the textType to set
     */
    public void setTextType(BasicComponentDataType textType) {
        this.textType = textType;
    }
    /**
     * @param textType the textType to set
     */
    public void setTextType(DataType textType) {
        this.textType = (BasicComponentDataType)textType;
    }
}

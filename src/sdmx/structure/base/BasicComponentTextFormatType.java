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

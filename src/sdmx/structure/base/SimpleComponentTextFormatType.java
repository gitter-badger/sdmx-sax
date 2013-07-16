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

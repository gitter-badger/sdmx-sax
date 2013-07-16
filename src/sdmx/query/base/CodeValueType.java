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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.List;

/**
 *	<xs:complexType name="DataKeyValueType">
		<xs:annotation>
			<xs:documentation>DataKeyValueType is a type for providing a dimension value for the purpose of defining a distinct data key. Only a single value can be provided for the dimension.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="DinstinctKeyValueType">
				<xs:sequence>
					<xs:element name="Value" type="SimpleKeyValueType"/>
				</xs:sequence>
				<xs:attribute name="id" type="SingleNCNameIDType" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class DataKeyValueType extends DistinctKeyValueType {
    private SimpleKeyValueType value = null;
    private SingleNCNameIDType id = null;
    public DataKeyValueType(SimpleKeyValueType v,SingleNCNameIDType id) {
        super(v,id);
        this.value=v;
        this.id=id;
    }

}

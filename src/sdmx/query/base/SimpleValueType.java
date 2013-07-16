/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import sdmx.common.SimpleOperatorType;
import sdmx.xml.XMLString;

/**
 *	<xs:complexType name="SimpleValueType">
		<xs:annotation>
			<xs:documentation>SimpleValueType describes the structure of a simple value query. A value is provided as the content in string format.</xs:documentation>
		</xs:annotation>
		<xs:simpleContent>
			<xs:extension base="xs:string">
				<xs:attribute name="operator" type="common:SimpleOperatorType" default="equal">
					<xs:annotation>
						<xs:documentation>The operator attribute indicates the operator to apply to the string value query. The options are equal and notEqual.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:extension>
		</xs:simpleContent>
	</xs:complexType>

 * @author James
 */
public class SimpleValueType extends XMLString {
    private SimpleOperatorType operator = SimpleOperatorType.EQUAL;
    public SimpleValueType(String s, SimpleOperatorType operator) {
        super(s);
        this.operator=operator;
    }

    /**
     * @return the operator
     */
    public SimpleOperatorType getOperator() {
        return operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(SimpleOperatorType operator) {
        this.operator = operator;
    }
}

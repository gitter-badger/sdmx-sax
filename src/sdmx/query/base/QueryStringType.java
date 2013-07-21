/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import sdmx.common.TextOperatorType;
import sdmx.xml.XMLString;

/**
 *	<xs:complexType name="QueryStringType">
		<xs:annotation>
			<xs:documentation>QueryStringType defines the structure of a string query.</xs:documentation>
		</xs:annotation>
		<xs:simpleContent>
			<xs:extension base="xs:string">
				<xs:attribute name="operator" type="common:TextOperatorType" default="equal">
					<xs:annotation>
						<xs:documentation>The operator attribute indicates how the supplied value should be applied to the objects being searched in order to constitute a match. For example, a value of "EqualTo" means the value of the field being search should exactly match the value supplied. See the defining type for further details.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:extension>
		</xs:simpleContent>	
	</xs:complexType>

 * @author James
 */
public class QueryStringType extends XMLString {
    private TextOperatorType operator = TextOperatorType.EQUAL;
    public QueryStringType(String s, TextOperatorType operator) {
    super(s);
    this.operator=operator;
    }

    /**
     * @return the operator
     */
    public TextOperatorType getOperator() {
        return operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(TextOperatorType operator) {
        this.operator = operator;
    }
    
    
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import sdmx.common.TextOperatorType;
import sdmx.commonreferences.NestedIDType;

/**
 *	<xs:complexType name="QueryNestedIDType">
		<xs:annotation>
			<xs:documentation>QueryNestedIDType defines the structure of a query for a nested identifier.</xs:documentation>
		</xs:annotation>
		<xs:simpleContent>
			<xs:extension base="common:NestedIDType">
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
public class QueryNestedIDType extends NestedIDType {
    private TextOperatorType operator = TextOperatorType.EQUAL;
    public QueryNestedIDType(String s,TextOperatorType operator) {
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

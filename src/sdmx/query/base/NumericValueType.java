/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import sdmx.common.OrderedOperatorType;

/**
 *	<xs:complexType name="NumericValueType">
		<xs:annotation>
			<xs:documentation>NumericValueType describes the structure of a numeric query. A value is provided as the content in decimal format.</xs:documentation>
		</xs:annotation>
		<xs:simpleContent>
			<xs:extension base="xs:decimal">
				<xs:attribute name="operator" type="common:OrderedOperatorType" default="equal">
					<xs:annotation>
						<xs:documentation>The operator attribute indicates the operator to apply to the numeric value query, such as equal to or greater than.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:extension>
		</xs:simpleContent>
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
public class NumericValueType {
    private double value = 0.0d;
    private OrderedOperatorType operator = OrderedOperatorType.EQUAL;
    public NumericValueType(double value,OrderedOperatorType operator) {
        this.value=value;
        this.operator=operator;
    }

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * @return the operator
     */
    public OrderedOperatorType getOperator() {
        return operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(OrderedOperatorType operator) {
        this.operator = operator;
    }
}

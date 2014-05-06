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

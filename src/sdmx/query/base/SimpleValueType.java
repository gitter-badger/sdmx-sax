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
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
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

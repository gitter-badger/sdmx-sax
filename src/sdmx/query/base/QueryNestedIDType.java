/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import sdmx.common.TextOperatorType;
import sdmx.commonreferences.NestedID;

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
public class QueryNestedIDType extends NestedID {
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

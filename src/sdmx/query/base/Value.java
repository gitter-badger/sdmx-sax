/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import sdmx.common.SimpleOperatorType;

/**
 *	<xs:element name="Value" type="SimpleValueType">
		<xs:annotation>
			<xs:documentation>Value is used to query for the value of a component. This should be used for concepts or components based on a simple value (e.g. a code or a simple string). This should be used when a simple equal/not equal operator is all that is necessary for matching the sought value.</xs:documentation>
		</xs:annotation>
	</xs:element>
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
public class Value extends SimpleValueType {
    public Value(String s, SimpleOperatorType operator){
        super(s,operator);
    }
}

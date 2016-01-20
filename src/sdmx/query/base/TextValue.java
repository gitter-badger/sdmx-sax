/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import sdmx.common.TextOperatorType;

/**
 *	<xs:element name="TextValue" type="QueryTextType">
		<xs:annotation>
			<xs:documentation>TextValue is used to query for the value of a concept or component based on textual parameters. The text value can be language specific (where  parallel multi-lingual values are available) and is qualified with an operator indicating how the supplied text should be matched against the sought components. If only a simple equality check is necessary, regardless of language, the Value element can be used.</xs:documentation>
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
public class TextValue extends QueryTextType {
     public TextValue(String lang,String val, TextOperatorType operator) {
         super(lang,val,operator);
     }
}

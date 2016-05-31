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

public class TextValue extends QueryTextType {
     public TextValue(String lang,String val, TextOperatorType operator) {
         super(lang,val,operator);
     }
}

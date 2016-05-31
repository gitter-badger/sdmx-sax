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

public class Value extends SimpleValueType {
    public Value(String s, SimpleOperatorType operator){
        super(s,operator);
    }
}

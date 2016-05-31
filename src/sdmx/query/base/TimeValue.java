/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import sdmx.common.TimeOperatorType;

/**
 *	<xs:element name="TimeValue" type="TimePeriodValueType">
		<xs:annotation>
			<xs:documentation>TimeValue is used to query for the value of a concept or component based on time parameters. This is typically used when the value needs to be treated explicitly as a time, for example when searching for data after a particular point in time. If only a simple equality check is necessary, the Value element can be used.</xs:documentation>
		</xs:annotation>
	</xs:element>
 * @author James
 */

public class TimeValue extends TimePeriodValueType {
    public TimeValue(String s) {
        super(s,TimeOperatorType.EQUAL);
    }
    public TimeValue(String s, TimeOperatorType operator) {
        super(s,operator);
    }
}

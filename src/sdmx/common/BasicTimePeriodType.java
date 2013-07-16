/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import sdmx.xml.DateTime;

/**
 *	<xs:simpleType name="BasicTimePeriodType">
		<xs:annotation>
			<xs:documentation>BasicTimePeriodType contains the basic dates and calendar periods. It is a combination of the Gregorian time periods and the date time type..</xs:documentation>
		</xs:annotation>
		<xs:union memberTypes="GregorianTimePeriodType xs:dateTime"/>
	</xs:simpleType>	
 * @author James
 */
public class BasicTimePeriodType {
}

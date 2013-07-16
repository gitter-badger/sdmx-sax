/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

/**
 *	<xs:simpleType name="StandardTimePeriodType">
		<xs:annotation>
			<xs:documentation>StandardTimePeriodType defines the set of standard time periods in SDMX. This includes the reporting time periods and the basic date type (i.e. the calendar time periods and the dateTime format).</xs:documentation>
		</xs:annotation>
		<xs:union memberTypes="BasicTimePeriodType ReportingTimePeriodType"/>
	</xs:simpleType>	
 * @author James
 */
public class StandardTimePeriodType {
}

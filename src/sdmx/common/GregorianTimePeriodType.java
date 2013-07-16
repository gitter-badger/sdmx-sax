/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import sdmx.xml.DateType;
import sdmx.xml.gYear;
import sdmx.xml.gYearMonth;

/**
 *	<xs:simpleType name="GregorianTimePeriodType">
		<xs:annotation>
			<xs:documentation>GregorianTimePeriodType defines the set of standard calendar periods in SDMX.</xs:documentation>
		</xs:annotation>
		<xs:union memberTypes="xs:gYear xs:gYearMonth xs:date"/>
	</xs:simpleType>	
 * @author James
 */
public class GregorianTimePeriodType {

}

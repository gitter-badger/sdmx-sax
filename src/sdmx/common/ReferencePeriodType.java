/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import sdmx.xml.DateTime;

/**
 *	<xs:complexType name="ReferencePeriodType">
		<xs:annotation>
			<xs:documentation>Specifies the inclusive start and end times.</xs:documentation>
		</xs:annotation>
		<xs:attribute name="startTime" type="xs:dateTime" use="required">
			<xs:annotation>
				<xs:documentation>The startTime attributes contains the inclusive start date for the reference period.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
		<xs:attribute name="endTime" type="xs:dateTime" use="required">
			<xs:annotation>
				<xs:documentation>The endTime attributes contains the inclusive end date for the reference period.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
	</xs:complexType>
 * @author James
 */
public class ReferencePeriodType {
    private DateTime startTime = null;
    private DateTime endTime = null;
    public ReferencePeriodType(DateTime start,DateTime end) {
        startTime =start;
        endTime=end;
    }

    /**
     * @return the startTime
     */
    public DateTime getStartTime() {
        return startTime;
    }

    /**
     * @return the endTime
     */
    public DateTime getEndTime() {
        return endTime;
    }

}

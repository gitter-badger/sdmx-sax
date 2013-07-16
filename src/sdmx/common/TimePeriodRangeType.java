/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

/**
 *	<xs:complexType name="TimePeriodRangeType">
		<xs:annotation>
			<xs:documentation>TimePeriodRangeType defines a time period, and indicates whether it is inclusive in a range.</xs:documentation>
		</xs:annotation>
		<xs:simpleContent>
			<xs:extension base="ObservationalTimePeriodType">
				<xs:attribute name="isInclusive" type="xs:boolean" default="true">
					<xs:annotation>
						<xs:documentation>The isInclusive attribute, when true, indicates that the time period specified is included in the range.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:extension>
		</xs:simpleContent>
	</xs:complexType>
 * @author James
 */
public class TimePeriodRangeType extends ObservationalTimePeriodType {

    private boolean isInclusive = true;
    
    public TimePeriodRangeType(String s) {
        super(s);
        this.isInclusive=true;
    }
    public TimePeriodRangeType(String s,boolean inc) {
        super(s);
        this.isInclusive=inc;
    }
}

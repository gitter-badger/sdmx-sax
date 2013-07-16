/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.constraint;

import sdmx.common.ReferencePeriodType;

/**
 *	<xs:complexType name="ContentConstraintType">
		<xs:annotation>
			<xs:documentation>ContentConstraintType describes the details of a content constraint by defining the content regions, key sets, or release information for the constraint attachment objects. Note that if the constraint is for a data provider, then only release calendar information is relevant, as there is no reliable way of determining which key family is being used to frame constraints in terms of cube regions or key sets.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="ContentConstraintBaseType">
				<xs:sequence>
					<xs:element name="ReleaseCalendar" type="ReleaseCalendarType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>ReleaseCalendar defines dates on which the constrained data is to be made available.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:element name="ReferencePeriod" type="common:ReferencePeriodType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>ReferencePeriod is used to report start date and end date constraints.</xs:documentation>
						</xs:annotation>
					</xs:element>
				</xs:sequence>
				<xs:attribute name="type" type="common:ContentConstraintTypeCodeType" use="optional" default="Actual">
					<xs:annotation>
						<xs:documentation>The type attribute indicates whether this constraint states what data is actually present for the constraint attachment, or if it defines what content is allowed. The default value is "Actual", meaning the data actually present for the constraint attachment.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:extension>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class ContentConstraintType extends ContentConstraintBaseType {
     private ReleaseCalendarType releaseCalendar=null;
     private ReferencePeriodType releasePeriod= null;

    /**
     * @return the releaseCalendar
     */
    public ReleaseCalendarType getReleaseCalendar() {
        return releaseCalendar;
    }

    /**
     * @param releaseCalendar the releaseCalendar to set
     */
    public void setReleaseCalendar(ReleaseCalendarType releaseCalendar) {
        this.releaseCalendar = releaseCalendar;
    }

    /**
     * @return the releasePeriod
     */
    public ReferencePeriodType getReleasePeriod() {
        return releasePeriod;
    }

    /**
     * @param releasePeriod the releasePeriod to set
     */
    public void setReleasePeriod(ReferencePeriodType releasePeriod) {
        this.releasePeriod = releasePeriod;
    }
     
}

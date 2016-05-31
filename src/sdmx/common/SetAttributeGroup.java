/*
    This file is part of sdmx-sax.

    sdmx-sax is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    sdmx-sax is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with sdmx-sax.  If not, see <http://www.gnu.org/licenses/>.
    Copyright (C) 2015 James Gardner
*/
package sdmx.common;

import sdmx.xml.DateTime;
import sdmx.xml.IDRef;
import sdmx.xml.gYear;

/**
 *	<xs:attributeGroup name="SetAttributeGroup">
<xs:annotation>
<xs:documentation>The SetAttributeGroup defines a common set of attributes for use in data and reference metadata sets.</xs:documentation>
</xs:annotation>
<xs:attribute name="structureRef" type="xs:IDREF" use="required">
<xs:annotation>
<xs:documentation>The structureRef contains a reference to a structural specification in the header of a data or reference metadata message. The structural specification details which structure the data or reference metadata conforms to, as well as providing additional information such as how the data is structure (e.g. which dimension occurs at the observation level for a data set).</xs:documentation>
</xs:annotation>
</xs:attribute>
<xs:attribute name="setID" type="IDType" use="optional">
<xs:annotation>
<xs:documentation>The setID provides an identification of the data or metadata set.</xs:documentation>
</xs:annotation>
</xs:attribute>
<xs:attribute name="action" type="ActionType" use="optional">
<xs:annotation>
<xs:documentation>The action attribute indicates whether the file is appending, replacing, or deleting.</xs:documentation>
</xs:annotation>
</xs:attribute>
<xs:attribute name="reportingBeginDate" type="BasicTimePeriodType" use="optional">
<xs:annotation>
<xs:documentation>The reportingBeginDate indicates the inclusive start time of the data reported in the data or metadata set.</xs:documentation>
</xs:annotation>
</xs:attribute>
<xs:attribute name="reportingEndDate" type="BasicTimePeriodType" use="optional">
<xs:annotation>
<xs:documentation>The reportingEndDate indicates the inclusive end time of the data reported in the data or metadata set.</xs:documentation>
</xs:annotation>
</xs:attribute>
<xs:attribute name="validFromDate" type="xs:dateTime" use="optional">
<xs:annotation>
<xs:documentation>The validFromDate indicates the inclusive start time indicating the validity of the information in the data or metadata set.</xs:documentation>
</xs:annotation>
</xs:attribute>
<xs:attribute name="validToDate" type="xs:dateTime" use="optional">
<xs:annotation>
<xs:documentation>The validToDate indicates the inclusive end time indicating the validity of the information in the data or metadata set.</xs:documentation>
</xs:annotation>
</xs:attribute>
<xs:attribute name="publicationYear" type="xs:gYear" use="optional">
<xs:annotation>
<xs:documentation>The publicationYear holds the ISO 8601 four-digit year.</xs:documentation>
</xs:annotation>
</xs:attribute>
<xs:attribute name="publicationPeriod" type="ObservationalTimePeriodType" use="optional">
<xs:annotation>
<xs:documentation>The publicationPeriod specifies the period of publication of the data or metadata in terms of whatever provisioning agreements might be in force (i.e., "Q1 2005" if that is the time of publication for a data set published on a quarterly basis).</xs:documentation>
</xs:annotation>
</xs:attribute>
</xs:attributeGroup>
 * @author James
 */
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *   SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public class SetAttributeGroup {

    private IDRef structureRef = null;
    private ActionType action = null;
    private BasicTimePeriodType reportingBeginDate = null;
    private BasicTimePeriodType reportingEndDate = null;
    private DateTime validFromDate = null;
    private DateTime validToDate = null;
    gYear publicationYear=null;
    ObservationalTimePeriodType publicationPeriod=null;

    public SetAttributeGroup(IDRef ref) {
        this.structureRef = ref;
    }

    /**
     * @return the structureRef
     */
    public IDRef getStructureRef() {
        return structureRef;
    }

    /**
     * @param structureRef the structureRef to set
     */
    public void setStructureRef(IDRef structureRef) {
        this.structureRef = structureRef;
    }

    /**
     * @return the action
     */
    public ActionType getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(ActionType action) {
        this.action = action;
    }

    /**
     * @return the reportingBeginDate
     */
    public BasicTimePeriodType getReportingBeginDate() {
        return reportingBeginDate;
    }

    /**
     * @param reportingBeginDate the reportingBeginDate to set
     */
    public void setReportingBeginDate(BasicTimePeriodType reportingBeginDate) {
        this.reportingBeginDate = reportingBeginDate;
    }

    /**
     * @return the reportingEndDate
     */
    public BasicTimePeriodType getReportingEndDate() {
        return reportingEndDate;
    }

    /**
     * @param reportingEndDate the reportingEndDate to set
     */
    public void setReportingEndDate(BasicTimePeriodType reportingEndDate) {
        this.reportingEndDate = reportingEndDate;
    }

    /**
     * @return the validFromDate
     */
    public DateTime getValidFromDate() {
        return validFromDate;
    }

    /**
     * @param validFromDate the validFromDate to set
     */
    public void setValidFromDate(DateTime validFromDate) {
        this.validFromDate = validFromDate;
    }

    /**
     * @return the validToDate
     */
    public DateTime getValidToDate() {
        return validToDate;
    }

    /**
     * @param validToDate the validToDate to set
     */
    public void setValidToDate(DateTime validToDate) {
        this.validToDate = validToDate;
    }
}

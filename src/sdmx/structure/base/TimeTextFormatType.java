/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import sdmx.common.StandardTimePeriodType;
import sdmx.common.TimeDataType;
import sdmx.xml.duration;
import sdmx.xml.positiveInteger;

/**
 *	<xs:complexType name="TimeTextFormatType">
		<xs:annotation>
			<xs:documentation>TimeTextFormat is a restricted version of the SimpleComponentTextFormatType that only allows time based format and specifies a default ObservationalTimePeriod representation and facets of a start and end time.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="SimpleComponentTextFormatType">
				<xs:attribute name="textType" type="common:TimeDataType" default="ObservationalTimePeriod"/>
				<xs:attribute name="startTime" type="common:StandardTimePeriodType" use="optional"/>
				<xs:attribute name="endTime" type="common:StandardTimePeriodType" use="optional"/>
				<xs:attribute name="isSequence" type="xs:boolean" use="prohibited"/>
				<xs:attribute name="interval" type="xs:decimal" use="prohibited"/>
				<xs:attribute name="startValue" type="xs:decimal" use="prohibited"/>
				<xs:attribute name="endValue" type="xs:decimal" use="prohibited"/>
				<xs:attribute name="timeInterval" type="xs:duration" use="prohibited"/>
				<xs:attribute name="minLength" type="xs:positiveInteger" use="prohibited"/>
				<xs:attribute name="maxLength" type="xs:positiveInteger" use="prohibited"/>
				<xs:attribute name="minValue" type="xs:decimal" use="prohibited"/>
				<xs:attribute name="maxValue" type="xs:decimal" use="prohibited"/>
				<xs:attribute name="decimals" type="xs:positiveInteger" use="prohibited"/>
				<xs:attribute name="pattern" type="xs:string" use="prohibited"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */

public class TimeTextFormatType {
    private TimeDataType textFormat = null;

    /**
     * @return the textFormat
     */
    public TimeDataType getTextFormat() {
        return textFormat;
    }

    /**
     * @param textFormat the textFormat to set
     */
    public void setTextFormat(TimeDataType textFormat) {
        this.textFormat = textFormat;
    }

    /**
     * @return the isSequence
     */
    public Boolean isSequence() {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @param isSequence the isSequence to set
     */
    public void setSequence(Boolean isSequence) {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @return the interval
     */
    public Double getInterval() {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @param interval the interval to set
     */
    public void setInterval(Double interval) {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @return the startValue
     */
    public Double getStartValue() {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @param startValue the startValue to set
     */
    public void setStartValue(Double startValue) {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @return the endValue
     */
    public Double getEndValue() {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @param endValue the endValue to set
     */
    public void setEndValue(Double endValue) {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @return the timeInterval
     */
    public duration getTimeInterval() {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @param timeInterval the timeInterval to set
     */
    public void setTimeInterval(duration timeInterval) {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @return the minLength
     */
    public positiveInteger getMinLength() {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @param minLength the minLength to set
     */
    public void setMinLength(positiveInteger minLength) {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @return the maxLength
     */
    public positiveInteger getMaxLength() {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @param maxLength the maxLength to set
     */
    public void setMaxLength(positiveInteger maxLength) {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @return the minValue
     */
    public Double getMinValue() {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @param minValue the minValue to set
     */
    public void setMinValue(Double minValue) {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @return the maxValue
     */
    public Double getMaxValue() {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @param maxValue the maxValue to set
     */
    public void setMaxValue(Double maxValue) {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @return the decimals
     */
    public positiveInteger getDecimals() {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @param decimals the decimals to set
     */
    public void setDecimals(positiveInteger decimals) {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @return the pattern
     */
    public String getPattern() {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @param pattern the pattern to set
     */
    public void setPattern(String pattern) {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @return the isMultiLingual
     */
    public Boolean isMultiLingual() {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }

    /**
     * @param isMultiLingual the isMultiLingual to set
     */
    public void setMultiLingual(Boolean isMultiLingual) {
        throw new RuntimeException("Prohibited field in TimeTextFormatType");
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import sdmx.common.DataType;
import sdmx.common.SimpleDataType;
import sdmx.common.StandardTimePeriodType;
import sdmx.xml.duration;
import sdmx.xml.positiveInteger;

/**
 *	<xs:complexType name="NonFacetedTextFormatType">
		<xs:annotation>
			<xs:documentation>NonFacetedTextFormatType is a restricted version of the SimpleComponentTextFormatType that does not allow for any facets.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="SimpleComponentTextFormatType">
				<xs:attribute name="textType" type="common:SimpleDataType" use="optional"/>
				<xs:attribute name="isSequence" type="xs:boolean" use="prohibited"/>
				<xs:attribute name="interval" type="xs:decimal" use="prohibited"/>
				<xs:attribute name="startValue" type="xs:decimal" use="prohibited"/>
				<xs:attribute name="endValue" type="xs:decimal" use="prohibited"/>
				<xs:attribute name="timeInterval" type="xs:duration" use="prohibited"/>
				<xs:attribute name="startTime" type="common:BasicTimePeriodType" use="prohibited"/>
				<xs:attribute name="endTime" type="common:BasicTimePeriodType" use="prohibited"/>
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
public class NonFacetedTextFormatType {
    private SimpleDataType textType = null;

    /**
     * @return the textType
     */
    public SimpleDataType getTextType() {
        return textType;
    }

    /**
     * @param textType the textType to set
     */
    public void setTextType(SimpleDataType textType) {
        this.textType = textType;
    }

    /**
     * @return the isSequence
     */
    public Boolean isSequence() {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @param isSequence the isSequence to set
     */
    public void setSequence(Boolean isSequence) {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @return the interval
     */
    public Double getInterval() {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @param interval the interval to set
     */
    public void setInterval(Double interval) {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @return the startValue
     */
    public Double getStartValue() {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @param startValue the startValue to set
     */
    public void setStartValue(Double startValue) {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @return the endValue
     */
    public Double getEndValue() {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @param endValue the endValue to set
     */
    public void setEndValue(Double endValue) {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @return the timeInterval
     */
    public duration getTimeInterval() {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @param timeInterval the timeInterval to set
     */
    public void setTimeInterval(duration timeInterval) {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @return the startTime
     */
    public StandardTimePeriodType getStartTime() {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(StandardTimePeriodType startTime) {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @return the endTime
     */
    public StandardTimePeriodType getEndTime() {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(StandardTimePeriodType endTime) {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @return the minLength
     */
    public positiveInteger getMinLength() {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @param minLength the minLength to set
     */
    public void setMinLength(positiveInteger minLength) {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @return the maxLength
     */
    public positiveInteger getMaxLength() {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @param maxLength the maxLength to set
     */
    public void setMaxLength(positiveInteger maxLength) {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @return the minValue
     */
    public Double getMinValue() {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @param minValue the minValue to set
     */
    public void setMinValue(Double minValue) {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @return the maxValue
     */
    public Double getMaxValue() {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @param maxValue the maxValue to set
     */
    public void setMaxValue(Double maxValue) {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @return the decimals
     */
    public positiveInteger getDecimals() {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @param decimals the decimals to set
     */
    public void setDecimals(positiveInteger decimals) {
       throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @return the pattern
     */
    public String getPattern() {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @param pattern the pattern to set
     */
    public void setPattern(String pattern) {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @return the isMultiLingual
     */
    public Boolean isMultiLingual() {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }

    /**
     * @param isMultiLingual the isMultiLingual to set
     */
    public void setMultiLingual(Boolean isMultiLingual) {
        throw new RuntimeException("Prohibited field in NonFacetedTextFormatType");
    }
}

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

/**
 *	<xs:simpleType name="TimeDataType">
		<xs:annotation>
			<xs:documentation>TimeDataType restricts SimpleDataType to specify the allowable data types for representing a time value.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="SimpleDataType">
			<xs:enumeration value="ObservationalTimePeriod"/>
			<xs:enumeration value="StandardTimePeriod"/>
			<xs:enumeration value="BasicTimePeriod"/>
			<xs:enumeration value="GregorianTimePeriod"/>
			<xs:enumeration value="GregorianYear"/>
			<xs:enumeration value="GregorianYearMonth"/>
			<xs:enumeration value="GregorianDay"/>
			<xs:enumeration value="ReportingTimePeriod"/>
			<xs:enumeration value="ReportingYear"/>
			<xs:enumeration value="ReportingSemester"/>
			<xs:enumeration value="ReportingTrimester"/>
			<xs:enumeration value="ReportingQuarter"/>
			<xs:enumeration value="ReportingMonth"/>
			<xs:enumeration value="ReportingWeek"/>
			<xs:enumeration value="ReportingDay"/>
			<xs:enumeration value="DateTime"/>
			<xs:enumeration value="TimeRange"/>
		</xs:restriction>
	</xs:simpleType>	
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
public class TimeDataType {
public static final String OBSERVATIONAL_TIME_PERIOD_TEXT = "ObservationalTimePeriod";
			public static final String STANDARD_TIME_PERIOD_TEXT = "StandardTimePeriod";
			public static final String BASIC_TIME_PERIOD_TEXT = "BasicTimePeriod";
			public static final String GREGORIAN_TIME_PERIOD_TEXT = "GregorianTimePeriod";
			public static final String GREGORIAN_YEAR_TEXT = "GregorianYear";
			public static final String GREGORIAN_YEAR_MONTH_TEXT = "GregorianYearMonth";
			public static final String GREGORIAN_DAY_TEXT = "GregorianDay";
			public static final String REPORTING_TIME_PERIOD_TEXT = "ReportingTimePeriod";
			public static final String REPORTING_YEAR_TEXT = "ReportingYear";
			public static final String REPORTING_SEMESTER_TEXT = "ReportingSemester";
			public static final String REPORTING_TRIMESTER_TEXT = "ReportingTrimester";
			public static final String REPORTING_QUARTER_TEXT = "ReportingQuarter";
			public static final String REPORTING_MONTH_TEXT = "ReportingMonth";
			public static final String REPORTING_WEEK_TEXT = "ReportingWeek";
			public static final String REPORTING_DAY_TEXT = "ReportingDay";
			public static final String DATETIME_TEXT = "DateTime";
			public static final String TIME_RANGE_TEXT = "TimeRange";
}

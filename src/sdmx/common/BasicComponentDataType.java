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

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;
import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:simpleType name="BasicComponentDataType">
		<xs:annotation>
			<xs:documentation>BasicComponentDataType provides an enumerated list of the types of characters allowed in the textType attribute for all non-target object components.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="DataType">
			<xs:enumeration value="String"/>
			<xs:enumeration value="Alpha"/>
			<xs:enumeration value="AlphaNumeric"/>
			<xs:enumeration value="Numeric"/>
			<xs:enumeration value="BigInteger"/>
			<xs:enumeration value="Integer"/>
			<xs:enumeration value="Long"/>
			<xs:enumeration value="Short"/>
			<xs:enumeration value="Decimal"/>
			<xs:enumeration value="Float"/>
			<xs:enumeration value="Double"/>
			<xs:enumeration value="Boolean"/>
			<xs:enumeration value="URI"/>
			<xs:enumeration value="Count"/>
			<xs:enumeration value="InclusiveValueRange"/>
			<xs:enumeration value="ExclusiveValueRange"/>
			<xs:enumeration value="Incremental"/>
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
			<xs:enumeration value="Month"/>
			<xs:enumeration value="MonthDay"/>
			<xs:enumeration value="Day"/>
			<xs:enumeration value="Time"/>
			<xs:enumeration value="Duration"/>
			<xs:enumeration value="XHTML"/>
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
 
 *  SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public class BasicComponentDataType extends DataType {
    
    public static final List<BasicComponentDataType> ENUM = new ArrayList<BasicComponentDataType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    
    public static final String STRING_TEXT = addString("String");
    public static final String ALPHA_TEXT = addString("Alpha");
    public static final String ALPHANUMERIC_TEXT = addString("AlphaNumeric");
    public static final String NUMERIC_TEXT = addString("Numeric");
    public static final String BIGINTEGER_TEXT = addString("BigInteger");
    public static final String INTEGER_TEXT = addString("Integer");
    public static final String LONG_TEXT = addString("Long");
    public static final String SHORT_TEXT = addString("Short");
    public static final String DECIMAL_TEXT = addString("Decimal");
    public static final String FLOAT_TEXT = addString("Float");
    public static final String DOUBLE_TEXT = addString("Double");
    public static final String BOOLEAN_TEXT = addString("Boolean");
    public static final String URI_TEXT = addString("URI");
    public static final String COUNT_TEXT = addString("Count");
    public static final String INCLUSIVE_VALUE_RANGE_TEXT = addString("InclusiveValueRange");
    public static final String EXCLUSIVE_VALUE_RANGE_TEXT = addString("ExclusiveValueRange");
    public static final String INCREMENTAL_TEXT = addString("Incremental");
    public static final String OBSERVATIONAL_TIME_PERIOD_TEXT = addString("ObservationalTimePeriod");
    public static final String STANDARD_TIME_PERIOD_TEXT = addString("StandardTimePeriod");
    public static final String BASIC_TIME_PERIOD_TEXT = addString("BasicTimePeriod");
    public static final String GREGORIAN_TIME_PERIOD_TEXT = addString("GregorianTimePeriod");
    public static final String GREGORIAN_YEAR_TEXT = addString("GregorianYear");
    public static final String GREGORIAN_YEAR_MONTH_TEXT = addString("GregorianYearMonth");
    public static final String GREGORIAN_DAY_TEXT = addString("GregorianDay");
    public static final String REPORTING_TIME_PERIOD_TEXT = addString("ReportingTimePeriod");
    public static final String REPORTING_YEAR_TEXT = addString("ReportingYear");
    public static final String REPORTING_SEMESTER_TEXT = addString("ReportingSemester");
    public static final String REPORTING_TRIMESTER_TEXT = addString("ReportingTrimester");
    public static final String REPORTING_QUARTER_TEXT = addString("ReportingQuarter");
    public static final String REPORTING_MONTH_TEXT = addString("ReportingMonth");
    public static final String REPORTING_WEEK_TEXT = addString("ReportingWeek");
    public static final String REPORTING_DAY_TEXT = addString("ReportingDay");
    public static final String DATETIME_TEXT = addString("DateTime");
    public static final String TIME_RANGE_TEXT = addString("TimeRange");
    public static final String MONTH_TEXT = addString("Month");
    public static final String MONTHDAY_TEXT = addString("MonthDay");
    public static final String DAY_TEXT = addString("Day");
    public static final String TIME_TEXT = addString("Time");
    public static final String DURATION_TEXT = addString("Duration");
    public static final String XHTML_TEXT = addString("XHTML");

    public static final BasicComponentDataType STRING = add(STRING_TEXT);
    public static final BasicComponentDataType ALPHA = add(ALPHA_TEXT);
    public static final BasicComponentDataType ALPHANUMERIC = add(ALPHANUMERIC_TEXT);
    public static final BasicComponentDataType NUMERIC = add(NUMERIC_TEXT);
    public static final BasicComponentDataType BIGINTEGER = add(BIGINTEGER_TEXT);
    public static final BasicComponentDataType INTEGER = add(INTEGER_TEXT);
    public static final BasicComponentDataType LONG = add(LONG_TEXT);
    public static final BasicComponentDataType SHORT = add(SHORT_TEXT);
    public static final BasicComponentDataType DECIMAL = add(DECIMAL_TEXT);
    public static final BasicComponentDataType FLOAT = add(FLOAT_TEXT);
    public static final BasicComponentDataType DOUBLE = add(DOUBLE_TEXT);
    public static final BasicComponentDataType BOOLEAN = add(BOOLEAN_TEXT);
    public static final BasicComponentDataType URI = add(URI_TEXT);
    public static final BasicComponentDataType COUNT = add(COUNT_TEXT);
    public static final BasicComponentDataType INCLUSIVE_VALUE_RANGE = add(INCLUSIVE_VALUE_RANGE_TEXT);
    public static final BasicComponentDataType EXCLUSIVE_VALUE_RANGE = add(EXCLUSIVE_VALUE_RANGE_TEXT);
    public static final BasicComponentDataType INCREMENTAL = add(INCREMENTAL_TEXT);
    public static final BasicComponentDataType OBSERVATIONAL_TIME_PERIOD = add(OBSERVATIONAL_TIME_PERIOD_TEXT);
    public static final BasicComponentDataType STANDARD_TIME_PERIOD = add(STANDARD_TIME_PERIOD_TEXT);
    public static final BasicComponentDataType BASIC_TIME_PERIOD = add(BASIC_TIME_PERIOD_TEXT);
    public static final BasicComponentDataType GREGORIAN_TIME_PERIOD = add(GREGORIAN_TIME_PERIOD_TEXT);
    public static final BasicComponentDataType GREGORIAN_YEAR = add(GREGORIAN_YEAR_TEXT);
    public static final BasicComponentDataType GREGORIAN_YEAR_MONTH = add(GREGORIAN_YEAR_MONTH_TEXT);
    public static final BasicComponentDataType GREGORIAN_DAY = add(GREGORIAN_DAY_TEXT);
    public static final BasicComponentDataType REPORTING_TIME_PERIOD = add(REPORTING_TIME_PERIOD_TEXT);
    public static final BasicComponentDataType REPORTING_YEAR = add(REPORTING_YEAR_TEXT);
    public static final BasicComponentDataType REPORTING_SEMESTER = add(REPORTING_SEMESTER_TEXT);
    public static final BasicComponentDataType REPORTING_TRIMESTER = add(REPORTING_TRIMESTER_TEXT);
    public static final BasicComponentDataType REPORTING_QUARTER = add(REPORTING_QUARTER_TEXT);
    public static final BasicComponentDataType REPORTING_MONTH = add(REPORTING_MONTH_TEXT);
    public static final BasicComponentDataType REPORTING_WEEK = add(REPORTING_WEEK_TEXT);
    public static final BasicComponentDataType REPORTING_DAY = add(REPORTING_DAY_TEXT);
    public static final BasicComponentDataType DATETIME = add(DATETIME_TEXT);
    public static final BasicComponentDataType TIME_RANGE = add(TIME_RANGE_TEXT);
    public static final BasicComponentDataType MONTH = add(MONTH_TEXT);
    public static final BasicComponentDataType MONTHDAY = add(MONTHDAY_TEXT);
    public static final BasicComponentDataType DAY = add(DAY_TEXT);
    public static final BasicComponentDataType TIME = add(TIME_TEXT);
    public static final BasicComponentDataType DURATION = add(DURATION_TEXT);
    public static final BasicComponentDataType XHTML = add(XHTML_TEXT);

// Utility
    private static BasicComponentDataType add(String s) {
        BasicComponentDataType b = new BasicComponentDataType(s);
        ENUM.add(b);
        return b;
    }

    private static String addString(String s) {
        STRING_ENUM.add(s);
        return s;
    }

    public static BasicComponentDataType fromString(String s) {
        for (int i = 0; i < ENUM.size(); i++) {
            if (ENUM.get(i).toString().equals(s)) {
                return ENUM.get(i);
            }
        }
        return null;
    }

    public static BasicComponentDataType fromStringWithException(String s) throws TypeValueNotFoundException {
        for (int i = 0; i < ENUM.size(); i++) {
            if (ENUM.get(i).toString().equals(s)) {
                return ENUM.get(i);
            }
        }
        throw new TypeValueNotFoundException("Value:" + s + " not found in BasicComponentDataType enumeration!");
    }

    public BasicComponentDataType(String s) {
        super(s);
        if (!STRING_ENUM.contains(s)) {
            throw new IllegalArgumentException(s + " is not a valid BasicComponentDataType");
        }
    }

}

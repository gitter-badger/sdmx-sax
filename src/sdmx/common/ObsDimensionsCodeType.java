/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import sdmx.xml.XMLString;

/**
 *	<xs:simpleType name="ObsDimensionsCodeType">
		<xs:annotation>
			<xs:documentation>ObsDimensionsCodeType is an enumeration containing the values "TimeDimension" and "AllDimensions"</xs:documentation>
		</xs:annotation>
		<xs:restriction base="xs:string">
			<xs:enumeration value="AllDimensions">
				<xs:annotation>
					<xs:documentation>AllDimensions notes that the cross sectional format shall be flat; that is all dimensions should be contained at the observation level.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
			<xs:enumeration value="TIME_PERIOD">
				<xs:annotation>
					<xs:documentation>TIME_PERIOD refers to the fixed identifier for the time dimension.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
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
public class ObsDimensionsCodeType extends XMLString {
      public static final String ALL_DIMENSIONS_TEXT = "AllDimensions";
      public static final String TIME_PERIOD_TEXT = "TIME_PERIOD";
      public static final ObsDimensionsCodeType ALL_DIMENSIONS = new ObsDimensionsCodeType(ALL_DIMENSIONS_TEXT);
      public static final ObsDimensionsCodeType TIME_PERIOD = new ObsDimensionsCodeType(TIME_PERIOD_TEXT);

      private ObsDimensionsCodeType(String s) {
         super(s);
      }
      public static ObsDimensionsCodeType fromString(String s) {
          if( ALL_DIMENSIONS_TEXT.equals(s) ) return ALL_DIMENSIONS;
          if( TIME_PERIOD_TEXT.equals(s)) return TIME_PERIOD;
          throw new RuntimeException(s+" is not an ObsDimensionsCodeType");
      }
}

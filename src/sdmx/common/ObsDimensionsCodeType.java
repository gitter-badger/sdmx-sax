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

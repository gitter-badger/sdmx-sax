/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import sdmx.commonreferences.NCNameIDType;

/**
 *	<xs:simpleType name="ObservationDimensionType">
		<xs:annotation>
			<xs:documentation>ObservationDimensionType allows for the dimension at the observation level to be specified by either providing the dimension identifier or using the explicit value "AllDimensions".</xs:documentation>
		</xs:annotation>
		<xs:union memberTypes="NCNameIDType ObsDimensionsCodeType"/>
	</xs:simpleType>
 * @author James
 */
public class ObservationDimensionType extends NCNameIDType {
    ObsDimensionsCodeType code;
    public ObservationDimensionType(String s) {
        super(s);
        code = ObsDimensionsCodeType.fromString(s);
    }
    public String toString() { return code.toString(); }
}

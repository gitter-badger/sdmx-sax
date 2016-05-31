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

import sdmx.commonreferences.NCNameID;

/**
 *	<xs:simpleType name="ObservationDimensionType">
		<xs:annotation>
			<xs:documentation>ObservationDimensionType allows for the dimension at the observation level to be specified by either providing the dimension identifier or using the explicit value "AllDimensions".</xs:documentation>
		</xs:annotation>
		<xs:union memberTypes="NCNameIDType ObsDimensionsCodeType"/>
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
public class ObservationDimensionType extends NCNameID {
    ObsDimensionsCodeType code;
    public ObservationDimensionType(String s) {
        super(s);
        if( ObsDimensionsCodeType.ALL_DIMENSIONS_TEXT.equals(s)){
           code = ObsDimensionsCodeType.fromString(s);
        } else if( ObsDimensionsCodeType.TIME_PERIOD_TEXT.equals(s)) {
           code = ObsDimensionsCodeType.fromString(s);
        }
    }
    public String toString() { return code!=null?code.toString():super.toString(); }
}

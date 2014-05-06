/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.footer;

import static sdmx.footer.SeverityCodeType.CODE_WARNING;

/**
 *	<xs:simpleType name="SeverityCodeType">
		<xs:restriction base="xs:string">
			<xs:enumeration value="Error">
				<xs:annotation>
					<xs:documentation>Error indicates the status message coresponds to an error.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
			<xs:enumeration value="Warning">
				<xs:annotation>
					<xs:documentation>Warning indicates that the status message corresponds to a warning.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
			<xs:enumeration value="Information">
				<xs:annotation>
					<xs:documentation>Information indicates that the status message corresponds to an informational message.</xs:documentation>
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
public class SeverityCodeType extends sdmx.xml.XMLString {
    public static final String CODE_ERROR ="Error";
    public static final String CODE_WARNING ="Warning";
    public static final String CODE_INFORMATION ="Information";
    public static final SeverityCodeType ERROR = new SeverityCodeType(CODE_ERROR);
    public static final SeverityCodeType WARNING = new SeverityCodeType(CODE_WARNING);
    public static final SeverityCodeType INFORMATION = new SeverityCodeType(CODE_INFORMATION);

    private SeverityCodeType(String str) {
        super(str);
    }
    public SeverityCodeType fromString(String s) {
        if( CODE_ERROR.equals(s) ) return ERROR;
        if( CODE_WARNING.equals(s) ) return WARNING;
        if( CODE_INFORMATION.equals(s)) return INFORMATION;
        throw new RuntimeException(s+" is not a Serverity CodeType");
    }
}
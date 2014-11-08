/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import java.util.regex.Pattern;
import sdmx.xml.RegexXMLString;

/**
 * <xs:simpleType name="NestedIDType">
 * <xs:annotation>
 * <xs:documentation>NestedIDType is the least restrictive form of an identifier
 * used throughout all SDMX-ML messages. It allows for a hierarchical
 * identifier, with each portion separated by the '.' character. For the
 * identifier portions, valid characters include A-Z, a-z, @, 0-9, _, -,
 * $.</xs:documentation>
 * </xs:annotation>
 * <xs:restriction base="xs:string">
 * <xs:pattern value="[A-z0-9_@$\-]+(\.[A-z0-9_@$\-]+)*"/>
 * </xs:restriction>
 * </xs:simpleType>
 *
 * @author James
 */
/**
 * This file is part of SdmxSax.
 *
 * SdmxSax is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * SdmxSax is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * SdmxSax. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright James Gardner 2014
 */
public class NestedID extends RegexXMLString {

    public static final String PATTERN = "[A-z0-9_@$\\-]+(\\.[A-z0-9_@$\\-]+)*";
    public static final Pattern REGEX_PATTERN = Pattern.compile(PATTERN);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN};

    public NestedID(String s) {
        super(s);
    }
    @Override
    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }

    public boolean equals(NestedID id) {
        if( id == null ) return false;
        return super.getString().equals(id.getString());
    }

    public boolean equals(String id) {
        return super.getString().equals(id);
    }

    public boolean equals(IDType id) {
        //System.out.println("left="+this.getString()+" right="+id.getString());
        return super.getString().equals(id.getString());
    }

    public IDType asID() {
        return new IDType(super.getString());
    }
}

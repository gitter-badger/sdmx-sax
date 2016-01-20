/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;

/**
 *	<xs:simpleType name="MaintainableReturnDetailType">
		<xs:annotation>
			<xs:documentation>MaintainableReturnDetailType contains a sub set of the enumerations defined in the ReturnDetailType. Enumerations relating specifically to item schemes are not included</xs:documentation>
		</xs:annotation>
		<xs:restriction base="StructureReturnDetailType">
			<xs:enumeration value="Stub"/>
			<xs:enumeration value="CompleteStub"/>
			<xs:enumeration value="Full"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
 */
public class MaintainableReturnDetailType {

    public static final List<MaintainableReturnDetailType> ENUM = new ArrayList<MaintainableReturnDetailType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    public static final String STUB_TEXT = addString("Stub");
    public static final String COMPLETESTUB_TEXT = addString("CompleteStub");
    public static final String FULL_TEXT = addString("Full");
    public static final MaintainableReturnDetailType STUB = add("Stub");
    public static final MaintainableReturnDetailType COMPLETESTUB = add("CompleteStub");
    public static final MaintainableReturnDetailType FULL = add("Full");
    // Utility

    private static MaintainableReturnDetailType add(String s) {
        MaintainableReturnDetailType b = new MaintainableReturnDetailType(s);
        ENUM.add(b);
        return b;
    }

    private static String addString(String s) {
        STRING_ENUM.add(s);
        return s;
    }

    public static MaintainableReturnDetailType fromString(String s) {
        for (int i = 0; i < ENUM.size(); i++) {
            if (ENUM.get(i).target.equals(s)) {
                return ENUM.get(i);
            }
        }
        return null;
    }

    public static MaintainableReturnDetailType fromStringWithException(String s) throws TypeValueNotFoundException {
        for (int i = 0; i < ENUM.size(); i++) {
            if (ENUM.get(i).target.equals(s)) {
                return ENUM.get(i);
            }
        }
        throw new TypeValueNotFoundException("Value:" + s + " not found in DataType enumeration!");
    }
// Instance
    private String target = null;

    public MaintainableReturnDetailType(String s) {
        if (!STRING_ENUM.contains(s)) {
            throw new IllegalArgumentException(s + " is not a valid ObjectTypeCodelistType");
        }
        this.target = s;

    }

    public String toString() {
        return target;
    }
}

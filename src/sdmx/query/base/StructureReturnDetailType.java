/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;

/**
 *	<xs:simpleType name="StructureReturnDetailType">
		<xs:annotation>
			<xs:documentation>StructureReturnDetailType contains a set of enumerations that indicate how much detail should be returned for an object.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="xs:string">
			<xs:enumeration value="Stub">
				<xs:annotation>
					<xs:documentation>Only the identification information and name should be returned.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
			<xs:enumeration value="CompleteStub">
				<xs:annotation>
					<xs:documentation>Identification information, name, description, and annotations should be returned.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
			<xs:enumeration value="Full">
				<xs:annotation>
					<xs:documentation>The entire detail of the object should be returned.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
			<xs:enumeration value="MatchedItems">
				<xs:annotation>
					<xs:documentation>For an item scheme, only the items matching the item where parameters will be returned. In the case that items are hierarchical, the entire hierarchy leading to the matched item will have to be returned.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
			<xs:enumeration value="CascadedMatchedItems">
				<xs:annotation>
					<xs:documentation>For an item scheme, only the items matching the item where parameters, and their hierarchical child items will be returned. In the case that items are hierarchical, the entire hierarchy leading to the matched item will have to be returned.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
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
public class StructureReturnDetailType {

    public static final List<StructureReturnDetailType> ENUM = new ArrayList<StructureReturnDetailType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    public static final String STUB_TEXT = addString("Stub");
    public static final String COMPLETESTUB_TEXT = addString("CompleteStub");
    public static final String FULL_TEXT = addString("Full");
    public static final String MATCHED_ITEMS_TEXT = addString("MatchedItems");
    public static final String CASCADED_MATCHED_ITEMS_TEXT = addString("CascadedMatchedItems");
    public static final StructureReturnDetailType STUB = add("Stub");
    public static final StructureReturnDetailType COMPLETESTUB = add("CompleteStub");
    public static final StructureReturnDetailType FULL = add("Full");
    public static final StructureReturnDetailType MATCHED_ITEMS = add("MatchedItems");
    public static final StructureReturnDetailType CASCADED_MATCHED_ITEMS = add("CascadedMatchedItems");
    // Utility

    private static StructureReturnDetailType add(String s) {
        StructureReturnDetailType b = new StructureReturnDetailType(s);
        ENUM.add(b);
        return b;
    }

    private static String addString(String s) {
        STRING_ENUM.add(s);
        return s;
    }

    public static StructureReturnDetailType fromString(String s) {
        for (int i = 0; i < ENUM.size(); i++) {
            if (ENUM.get(i).target.equals(s)) {
                return ENUM.get(i);
            }
        }
        return null;
    }

    public static StructureReturnDetailType fromStringWithException(String s) throws TypeValueNotFoundException {
        for (int i = 0; i < ENUM.size(); i++) {
            if (ENUM.get(i).target.equals(s)) {
                return ENUM.get(i);
            }
        }
        throw new TypeValueNotFoundException("Value:" + s + " not found in DataType enumeration!");
    }
// Instance
    private String target = null;

    public StructureReturnDetailType(String s) {
        if (!STRING_ENUM.contains(s)) {
            throw new IllegalArgumentException(s + " is not a valid ObjectTypeCodelistType");
        }
        this.target = s;

    }

    public String toString() {
        return target;
    }    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;

/**
 *	<xs:simpleType name="TextSearchOperatorType">
		<xs:annotation>
			<xs:documentation>TextSearchOperatorType provides an enumeration of text search operators.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="xs:string">
			<xs:enumeration value="contains">
				<xs:annotation>
					<xs:documentation>The text being searched must contain the supplied text.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
			<xs:enumeration value="startsWith">
				<xs:annotation>
					<xs:documentation>The text being searched must start with the supplied text.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
			<xs:enumeration value="endsWith">
				<xs:annotation>
					<xs:documentation>The text being searched must end with the supplied text.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
			<xs:enumeration value="doesNotContain">
				<xs:annotation>
					<xs:documentation>The text being searched cannot contain the supplied text.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
			<xs:enumeration value="doesNotStartWith">
				<xs:annotation>
					<xs:documentation>The text being searched cannot start with the supplied text.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
			<xs:enumeration value="doesNotEndWith">
				<xs:annotation>
					<xs:documentation>The text being searched cannot end with the supplied text.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class TextSearchOperatorType {
    public static final String CONTAINS_TEXT = "contains";
    public static final String STARTS_WITH_TEXT = "startsWith";
    public static final String ENDS_WITH_TEXT = "endsWith";
    public static final String DOES_NOT_CONTAIN_TEXT = "doesNotContain";
    public static final String DOES_NOT_START_WITH_TEXT = "doesNotStartWith";
    public static final String DOES_NOT_END_WITH_TEXT = "doesNotEndWith";

    public static final List<TextSearchOperatorType> ENUM = new ArrayList<TextSearchOperatorType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();

    
    public static final TextSearchOperatorType CONTAINS = add("contains");
    public static final TextSearchOperatorType STARTS_WITH = add("startsWith");
    public static final TextSearchOperatorType ENDS_WITH = add("endsWith");
    public static final TextSearchOperatorType DOES_NOT_CONTAIN = add("doesNotContain");
    public static final TextSearchOperatorType DOES_NOT_START_WITH = add("doesNotStartWith");
    public static final TextSearchOperatorType DOES_NOT_END_WITH = add("doesNotEndWith");
    
// Utility
    private static TextSearchOperatorType add(String s) {
        TextSearchOperatorType b = new TextSearchOperatorType(s);
        ENUM.add(b);
        return b;
    }

    private static String addString(String s) {
        STRING_ENUM.add(s);
        return s;
    }

    public static TextSearchOperatorType fromString(String s) {
        for (int i = 0; i < ENUM.size(); i++) {
            if (ENUM.get(i).target.equals(s)) {
                return ENUM.get(i);
            }
        }
        return null;
    }

    /**
     *
     * @param s
     * @return
     * @throws TypeValueNotFoundException
     */
    public static TextSearchOperatorType fromStringWithException(String s) throws TypeValueNotFoundException {
        for (int i = 0; i < ENUM.size(); i++) {
            if (ENUM.get(i).target.equals(s)) {
                return ENUM.get(i);
            }
        }
        throw new TypeValueNotFoundException("Value:" + s + " not found in SimpleDataType enumeration!");
    }
// Instance
    private String target = null;

    public TextSearchOperatorType(String s) {
        if (!STRING_ENUM.contains(s)) {
            throw new IllegalArgumentException(s + " is not a valid TextSearchOperatorType");
        }
        this.target = s;
    }

    public String toString() {
        return target;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

/**
 *	<xs:simpleType name="UnboundedCodeType">
		<xs:annotation>
			<xs:documentation>UnboundedCodeType provides single textual value of "unbounded", for use in OccurentType.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="xs:string">
			<xs:enumeration value="unbounded">
				<xs:annotation>
					<xs:documentation>Object has no upper limit on occurrences.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
		</xs:restriction>
	</xs:simpleType>

 * @author James
 */
public class UnboundedCodeType {
      public static final String text = "unbounded";
}

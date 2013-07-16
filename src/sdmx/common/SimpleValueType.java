/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import sdmx.common.choice.ComponentValueSetTypeChoice;
import sdmx.common.choice.CubeRegionKeyTypeChoice;
import sdmx.xml.XMLString;

/**
 *	<xs:complexType name="SimpleValueType">
		<xs:annotation>
			<xs:documentation>SimpleValueType contains a simple value for a component, and if that value is from a code list, the ability to indicate that child codes in a simple hierarchy are part of the value set of the component for the region.</xs:documentation>
		</xs:annotation>
		<xs:simpleContent>
			<xs:extension base="xs:string">
				<xs:attribute name="cascadeValues" type="xs:boolean" use="optional" default="false">
					<xs:annotation>
						<xs:documentation>The cascadeValues attribute, if true, indicates that if the value is taken from a code all child codes in a simple hierarchy are understood be included in the region.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:extension>
		</xs:simpleContent>
	</xs:complexType>
 * @author James
 */
public class SimpleValueType extends XMLString implements ComponentValueSetTypeChoice,CubeRegionKeyTypeChoice {
    String val = null;
    boolean cascadeValues = false;
    public SimpleValueType(String s,boolean casc) {
        super(s);
        this.cascadeValues=casc;
    }

}

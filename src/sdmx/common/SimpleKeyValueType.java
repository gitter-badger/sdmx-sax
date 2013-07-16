/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import sdmx.common.choice.DistinctKeyValueTypeChoice;
import sdmx.common.choice.MetadataKeyValueTypeChoice;
import sdmx.common.choice.MetadataTargetRegionKeyTypeChoice;

/**
 *	<xs:complexType name="SimpleKeyValueType">
		<xs:annotation>
			<xs:documentation>SimpleKeyValueType derives from the SimpleValueType, but does not allow for the cascading of value in the hierarchy, as keys are meant to describe a distinct full or partial key.</xs:documentation>
		</xs:annotation>
		<xs:simpleContent>
			<xs:restriction base="SimpleValueType">
				<xs:attribute name="cascadeValues" type="xs:boolean" use="prohibited"/>
			</xs:restriction>
		</xs:simpleContent>
	</xs:complexType>
 * @author James
 */
public class SimpleKeyValueType extends SimpleValueType implements DistinctKeyValueTypeChoice,MetadataKeyValueTypeChoice {
    public SimpleKeyValueType(String s) {
        super(s,false);
    }
}

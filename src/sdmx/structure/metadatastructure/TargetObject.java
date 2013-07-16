/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

import sdmx.structure.base.ComponentType;

/**
 *	<xs:complexType name="TargetObject" abstract="true">
		<xs:annotation>
			<xs:documentation>TargetObject is an abstract base type from which all target objects of a metadata target are derived. It is based on a component. Implementations of this will refined the local representation so that the allowed values accurately reflect the representation of the target object reference.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="ComponentType"/>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class TargetObject extends ComponentType {
    
}

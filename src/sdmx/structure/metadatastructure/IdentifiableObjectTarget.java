/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

/**
 *	<xs:element name="IdentifiableObjectTarget" type="IdentifiableObjectTargetType" substitutionGroup="Component">
		<xs:annotation>
			<xs:documentation>IdentifiableObjectTarget is target object which references an Identifiable object as defined in the SDMX Information Model. The reference must be complete (i.e. a URN or a complete set of reference fields). For an item object, it is possible to define a local representation of an item scheme from which the item must be referenced.</xs:documentation>
		</xs:annotation>
	</xs:element>

 * @author James
 */
public class IdentifiableObjectTarget extends IdentifiableObjectTargetType {
    
}

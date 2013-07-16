/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

/**
 *	<xs:element name="KeyDescriptorValuesTarget" type="KeyDescriptorValuesTargetType" substitutionGroup="Component">
		<xs:annotation>
			<xs:documentation>KeyDescriptorValuesTarget is target object which references a data key for the purpose of attach reference metadata to portions of data. A data key is a set of dimension references and values for those dimension. This component on its own is not of much use, as the data key only has local references to the dimensions. Therefore it is typical that this is used in combination with some sort of reference to the data (either a data set reference or a reference to the underlying structure, structure usage, or provision agreement of the data.</xs:documentation>
		</xs:annotation>
	</xs:element>
 * @author James
 */
public class KeyDescriptorValuesTarget extends KeyDescriptorValuesTargetType {
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

/**
 *	<xs:element name="MetadataAttribute" type="MetadataAttributeType" substitutionGroup="Component">
		<xs:annotation>
			<xs:documentation>MetadataAttribute defines the a metadata attribute, which is the value of an attribute, such as the instance of a coded or uncoded attribute in a metadata structure definition.</xs:documentation>
		</xs:annotation>
		<xs:unique name="MetadataAttribute_Unique_MetadataAttribute">
			<xs:selector xpath="structure:MetadataAttribute"/>
			<xs:field xpath="@id"/>
		</xs:unique>
	</xs:element>

 * @author James
 */

public class MetadataAttribute extends MetadataAttributeType {
    
}

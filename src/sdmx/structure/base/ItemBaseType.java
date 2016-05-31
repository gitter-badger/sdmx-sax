/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

/**
 *	<xs:complexType name="ItemBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>ItemBaseType is an abstract base type that forms the basis for the ItemType. It requires that at least an id be supplied for an item.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="NameableType">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
					<xs:element ref="common:Name" maxOccurs="unbounded"/>
					<xs:element ref="common:Description" minOccurs="0" maxOccurs="unbounded"/>
				</xs:sequence>
				<xs:attribute name="id" type="common:IDType" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */

public abstract class ItemBaseType extends NameableType {
/*
 * Annotations, Name, Description Field all inherited from superclasses
 */    
}

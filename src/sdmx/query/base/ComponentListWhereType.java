/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import java.util.List;

/**
 *	<xs:complexType name="ComponentListWhereType" abstract="true">
		<xs:annotation>
			<xs:documentation>ComponentListWhereType is an abstract base type that serves as the basis for a query for a component list within a structure query. A list of component where children are provided to query for the list's child components. The conditions within a component list query are implied to be in an and-query. If an id and a child component where condition are supplied, then both conditions will have to met in order for the component list query to return true. If, for instance, a query based on names in multiple languages is required, then multiple instances of the element utilizing this type should be used within an or-query container.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="IdentifiableWhereType">
				<xs:sequence minOccurs="0" maxOccurs="unbounded">
					<xs:element ref="ComponentWhere"/>
				</xs:sequence>
			</xs:extension>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class ComponentListWhereType extends IdentifiableWhereType {
    List<ComponentWhereType> components = null;
    
}

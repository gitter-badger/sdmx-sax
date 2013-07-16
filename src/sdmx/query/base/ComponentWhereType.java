/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import sdmx.commonreferences.ConceptReferenceType;
import sdmx.commonreferences.ItemSchemeReferenceBaseType;

/**
 *	<xs:complexType name="ComponentWhereType" abstract="true">
		<xs:annotation>
			<xs:documentation>ComponentWhereType is an abstract base type that serves as the basis for a query for a component within a component list where or a structure query. A concept identity and a local representation condition are available to seek a component that utilizes a particular concept or representation scheme. The conditions within a component query are implied to be in an and-query. If an id and a concept identity condition are supplied, then both conditions will have to met in order for the component query to return true. If, for instance, a query based on names in multiple languages is required, then multiple instances of the element utilizing this type should be used within an or-query container.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="IdentifiableWhereType">
				<xs:sequence>
					<xs:element name="ConceptIdentity" type="common:ConceptReferenceType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>ConceptIdentity is used to query for a structure component based on the concept from which it takes its semantic.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:element name="Enumeration" type="common:ItemSchemeReferenceBaseType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>Enumeration is used to query for a structure component based on the item scheme that is used as the enumeration for its representation. This enumeration may be explicit defined by the component (i.e. its local representation), or inherited from the concept from which the component takes its semantic (i.e. the concept core representation).</xs:documentation>
						</xs:annotation>
					</xs:element>
				</xs:sequence>
			</xs:extension>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class ComponentWhereType extends IdentifiableWhereType {
    private ConceptReferenceType conceptIdentity = null;
    private ItemSchemeReferenceBaseType enumeration = null;

    /**
     * @return the conceptIdentity
     */
    public ConceptReferenceType getConceptIdentity() {
        return conceptIdentity;
    }

    /**
     * @param conceptIdentity the conceptIdentity to set
     */
    public void setConceptIdentity(ConceptReferenceType conceptIdentity) {
        this.conceptIdentity = conceptIdentity;
    }

    /**
     * @return the enumeration
     */
    public ItemSchemeReferenceBaseType getEnumeration() {
        return enumeration;
    }

    /**
     * @param enumeration the enumeration to set
     */
    public void setEnumeration(ItemSchemeReferenceBaseType enumeration) {
        this.enumeration = enumeration;
    }
}

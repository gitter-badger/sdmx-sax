/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import java.util.List;
import sdmx.commonreferences.ConceptReference;
import sdmx.commonreferences.ItemSchemeReferenceBase;

/**
 *	<xs:complexType name="StructureWhereType" abstract="true">
		<xs:annotation>
			<xs:documentation>StructureWhereType is an abstract base type that serves as the basis for a query for a structure object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="MaintainableWhereType">
				<xs:sequence>
					<xs:element name="UsedConcept" type="common:ConceptReferenceType" minOccurs="0" maxOccurs="unbounded">
						<xs:annotation>
							<xs:documentation>UsedConcept is used to query for a structure that uses the referenced concept as the basis of one of its components.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:element name="UsedRepresentation" type="common:ItemSchemeReferenceBaseType" minOccurs="0" maxOccurs="unbounded">
						<xs:annotation>
							<xs:documentation>UsedRepresentation is used to query for a structure that uses the referenced item scheme for the representation of one of its components.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:sequence minOccurs="0" maxOccurs="unbounded">
						<xs:element ref="ComponentListWhere"/>
					</xs:sequence>
					<xs:sequence minOccurs="0" maxOccurs="unbounded">
						<xs:element ref="ComponentWhere"/>
					</xs:sequence>
				</xs:sequence>
			</xs:extension>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */

public class StructureWhereType extends MaintainableWhereType {
    private ConceptReference usedConcept = null;
    private ItemSchemeReferenceBase useRepresentation = null;
    private List<ComponentListWhereType> componentLists = null;
    private List<ComponentWhereType> components = null;

    /**
     * @return the usedConcept
     */
    public ConceptReference getUsedConcept() {
        return usedConcept;
    }

    /**
     * @param usedConcept the usedConcept to set
     */
    public void setUsedConcept(ConceptReference usedConcept) {
        this.usedConcept = usedConcept;
    }

    /**
     * @return the useRepresentation
     */
    public ItemSchemeReferenceBase getUseRepresentation() {
        return useRepresentation;
    }

    /**
     * @param useRepresentation the useRepresentation to set
     */
    public void setUseRepresentation(ItemSchemeReferenceBase useRepresentation) {
        this.useRepresentation = useRepresentation;
    }

    /**
     * @return the componentLists
     */
    public List<ComponentListWhereType> getComponentLists() {
        return componentLists;
    }

    /**
     * @param componentLists the componentLists to set
     */
    public void setComponentLists(List<ComponentListWhereType> componentLists) {
        this.componentLists = componentLists;
    }

    /**
     * @return the components
     */
    public List<ComponentWhereType> getComponents() {
        return components;
    }

    /**
     * @param components the components to set
     */
    public void setComponents(List<ComponentWhereType> components) {
        this.components = components;
    }
}

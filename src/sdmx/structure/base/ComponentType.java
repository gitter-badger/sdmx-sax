/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import sdmx.commonreferences.ConceptReferenceType;

/**
 *	<xs:complexType name="ComponentType" abstract="true">
		<xs:annotation>
			<xs:documentation>ComponentType is an abstract base type for all components. It contains information pertaining to a component, including an optional reference to a concept, an optional role played by the concept, an optional text format description, and an optional local representation.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="ComponentBaseType">
				<xs:sequence>
					<xs:element name="ConceptIdentity" type="common:ConceptReferenceType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>ConceptIdentity allows for the referencing of a concept in a concept scheme. The component takes its semantic from this concept, and if an id is not specified, it takes its identification as well. If a representation (LocalRepresentation) is not supplied, then the representation of the component is also inherited from the concept. Note that in the case of the component representation being inherited from the concept, the allowable representations for the component still apply. Therefore, if a component references a concept with a core representation that is not allowed for the concept, that representation must be locally overridden. For components which can specify a concept role, it is implied that the concept which is referenced also identifies a role for the component.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:element name="LocalRepresentation" type="RepresentationType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>LocalRepresentation references item schemes that may be used to create the representation of a component. The type of this must be refined such that a concrete item scheme reference is used.</xs:documentation>
						</xs:annotation>
					</xs:element>
				</xs:sequence>
			</xs:extension>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class ComponentType extends ComponentBaseType {
    private ConceptReferenceType conceptIdentity = null;
    private RepresentationType localRepresentation = null;

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
     * @return the localRepresentation
     */
    public RepresentationType getLocalRepresentation() {
        return localRepresentation;
    }

    /**
     * @param localRepresentation the localRepresentation to set
     */
    public void setLocalRepresentation(RepresentationType localRepresentation) {
        this.localRepresentation = localRepresentation;
    }
    
}

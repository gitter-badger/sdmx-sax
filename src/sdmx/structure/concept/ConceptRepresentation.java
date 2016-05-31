/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.concept;

import sdmx.structure.base.BasicComponentTextFormatType;
import sdmx.structure.base.RepresentationType;

/**
 *	<xs:complexType name="ConceptRepresentation">
		<xs:annotation>
			<xs:documentation>ConceptRepresentation defines the core representation that are allowed for a concept. The text format allowed for a concept is that which is allowed for any non-target object component.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="RepresentationType">
				<xs:choice>
					<xs:element name="TextFormat" type="BasicComponentTextFormatType"/>
					<xs:sequence>
						<xs:element name="Enumeration" type="common:CodelistReferenceType">
							<xs:annotation>
								<xs:documentation>Enumeration references a codelist which enumerates the possible values that can be used as the representation of this concept.</xs:documentation>
							</xs:annotation>
						</xs:element>
						<xs:element name="EnumerationFormat" type="CodededTextFormatType" minOccurs="0"/>
					</xs:sequence>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */


public class ConceptRepresentation extends RepresentationType {
    BasicComponentTextFormatType textFormat = null;
    
}

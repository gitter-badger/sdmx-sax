/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.concept;

import java.util.ArrayList;
import java.util.List;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.LocalConceptReference;
import sdmx.commonreferences.NCNameID;
import sdmx.structure.base.ItemType;
import sdmx.structure.codelist.CodeType;

/**
 *	<xs:complexType name="ConceptBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>ConceptBaseType is an abstract base type the forms the basis of the ConceptType by requiring a name and id, and restricting the content of the id.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemType">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
					<xs:element ref="common:Name" maxOccurs="unbounded"/>
					<xs:element ref="common:Description" minOccurs="0" maxOccurs="unbounded"/>
					<xs:choice minOccurs="0">
						<xs:element name="Parent" type="common:LocalConceptReferenceType">
							<xs:annotation>
								<xs:documentation>Parent captures the semantic relationships between concepts which occur within a single concept scheme. This identifies the concept of which the current concept is a qualification (in the ISO 11179 sense) or subclass.</xs:documentation>
							</xs:annotation>
						</xs:element>
					</xs:choice>					
				</xs:sequence>
				<xs:attribute name="id" type="common:NCNameIDType" use="required">
					<xs:annotation>
						<xs:documentation>The id attribute holds the identification of the concept. The type of this id is restricted to the common:NCNNameIDType. This is necessary, since concept id may be used to create XML elements and attributes in data and metadata structure specific schemas and therefore must be compliant with the NCName type in XML Schema (see common:NCNameIDType for further details).</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
 */
public class ConceptBaseType extends ItemType {
    LocalConceptReference parent = null;
    public ConceptBaseType() {
    }
    public ConceptType getConcept(int i) {
        return (ConceptType)super.getItem(i);
    }
    public void setConcept(int i, ConceptType ct) {
        super.setItem(i,ct);
    }
    public void setConcepts(List<ConceptType> cons) {
        List<ItemType> items = new ArrayList<ItemType>();
        items.addAll(cons);
        super.setItems(items);        
    }
    public void addConcept(ConceptType cat) {
        super.addItem(cat);
    }
    public ConceptType findConcept(String id) {
        return findConcept(new IDType(id));
    }
    public ConceptType findConcept(IDType id) {
        return (ConceptType)super.findItem(id);
    }
}

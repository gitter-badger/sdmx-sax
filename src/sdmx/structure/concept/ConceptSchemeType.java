/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.concept;

import java.util.ArrayList;
import java.util.List;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedID;
import sdmx.structure.base.ItemSchemeType;
import sdmx.structure.base.ItemType;
import sdmx.structure.codelist.CodeType;

/**
 *	<xs:complexType name="ConceptSchemeType">
		<xs:annotation>
			<xs:documentation>onceptSchemeType describes the structure of a concept scheme. A concept scheme is the descriptive information for an arrangement or division of concepts into groups based on characteristics, which the objects have in common. It contains a collection of concept definitions, that may be arranged in simple hierarchies.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemSchemeType">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
					<xs:element ref="common:Name" maxOccurs="unbounded"/>
					<xs:element ref="common:Description" minOccurs="0" maxOccurs="unbounded"/>
					<xs:sequence minOccurs="0" maxOccurs="unbounded">
						<xs:element ref="Concept"/>
					</xs:sequence>
				</xs:sequence>
				<xs:attribute name="id" type="common:NCNameIDType" use="required">
					<xs:annotation>
						<xs:documentation>The id attribute holds the identification of the concept scheme. The type of this id is restricted to the common:NCNNameIDType. This is necessary, since the concept scheme may be used to create simple types in data and metadata structure specific schemas and therefore must be compliant with the NCName type in XML Schema (see common:NCNameIDType for further details).</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *   SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public class ConceptSchemeType extends ItemSchemeType {
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
    public void dump() {
        
    }
    public ConceptType findConcept(String id) {
        return findConcept(new IDType(id));
    }
    public ConceptType findConcept(IDType id) {
        //System.out.println("CS:"+getId().getString());
        //System.out.println("CT:"+super.findItem(id));
        return (ConceptType)super.findItem(id);
    }
    public ConceptType findConcept(NestedID id) {
        return (ConceptType)super.findItem(id);
    }
    public void addConcept(ConceptType cat) {
        super.addItem(cat);
    }

    public void merge(ConceptSchemeType m) {
        for(ItemType it:m.getItems()){
            addItem(it);
        }
    }
}

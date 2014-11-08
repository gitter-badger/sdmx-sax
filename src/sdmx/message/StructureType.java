/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.message;

import java.util.List;
import sdmx.Registry;
import sdmx.commonreferences.CodeReference;
import sdmx.commonreferences.CodelistReference;
import sdmx.commonreferences.ConceptReference;
import sdmx.commonreferences.ConceptSchemeReference;
import sdmx.commonreferences.DataStructureReference;
import sdmx.commonreferences.DataflowReference;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemReference;
import sdmx.commonreferences.ItemSchemeReference;
import sdmx.commonreferences.ItemSchemeReferenceBase;
import sdmx.commonreferences.NestedID;
import sdmx.commonreferences.NestedNCNameID;
import sdmx.commonreferences.StructureReference;
import sdmx.commonreferences.Version;
import sdmx.structure.StructuresType;
import sdmx.structure.base.ItemSchemeType;
import sdmx.structure.base.ItemType;
import sdmx.structure.base.MaintainableType;
import sdmx.structure.codelist.CodeType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.dataflow.DataflowType;
import sdmx.structure.datastructure.DataStructureType;

/**
 * *	<xs:complexType name="StructureType">
		<xs:annotation>
			<xs:documentation>StructureType defines the contents of a structure message. The payload is optional since this message may be returned from a web service with only information in the footer.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MessageType">
				<xs:sequence>
					<xs:element name="Header" type="StructureHeaderType"/>
					<xs:element name="Structures" type="structure:StructuresType" minOccurs="0"/>
					<xs:element ref="footer:Footer" minOccurs="0"/>
				</xs:sequence>
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
public class StructureType extends MessageType implements Registry {
    private StructuresType structures = null;
    public StructureType(){
    }
    public StructureType(StructuresType structures){
        this.structures=structures;
    }

    /**
     * @return the structures
     */
    public StructuresType getStructures() {
        return structures;
    }

    @Override
    public void clear() {
    }

    @Override
    public DataStructureType find(DataStructureReference ref) {
        return structures.find(ref);
    }

    @Override
    public DataflowType find(DataflowReference ref) {
        return structures.find(ref);
    }

    @Override
    public CodeType find(CodeReference ref) {
        return structures.find(ref);
    }

    @Override
    public CodelistType find(CodelistReference ref) {
        return structures.find(ref);
    }

    @Override
    public ConceptType find(ConceptReference ref) {
        return structures.find(ref);
    }

    @Override
    public ConceptSchemeType find(ConceptSchemeReference ref) {
        return structures.find(ref);
    }

    @Override
    public void load(StructureType struct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unload(StructureType struct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DataflowType> listDataflows() {
        return structures.listDataflows();
    }

    public void setStructures(StructuresType struct) {
        this.structures=struct;
    }

    @Override
    public ItemType find(ItemReference ref) {
        return this.structures.find(ref);
    }

    @Override
    public ItemSchemeType find(ItemSchemeReference ref) {
        return this.structures.find(ref);
    }

}

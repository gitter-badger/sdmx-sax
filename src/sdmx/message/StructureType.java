/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.message;

import java.util.List;
import sdmx.Registry;
import sdmx.commonreferences.ConceptReferenceType;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemSchemeReferenceBaseType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.StructureReferenceType;
import sdmx.commonreferences.VersionType;
import sdmx.registry.RegistryUtil;
import sdmx.structure.StructuresType;
import sdmx.structure.base.MaintainableType;
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

    /**
     * @param structures the structures to set
     */
    public void setStructures(StructuresType structures) {
        this.structures = structures;
    }

    @Override
    public void load(StructureType struct) {
        structures.load(struct);
    }

    @Override
    public void unload(StructureType struct) {
        structures.unload(struct);
    }

    @Override
    public DataStructureType findDataStructure(NestedNCNameIDType agency, IDType id, VersionType version) {
        return structures.findDataStructure(agency, id, version);
    }

    @Override
    public DataStructureType findDataStructure(NestedNCNameIDType agency, IDType id) {
        return structures.findDataStructure(agency, id);
    }

    @Override
    public ConceptSchemeType findConceptScheme(NestedNCNameIDType agencyID, ConceptReferenceType conceptRef) {
        return structures.findConceptScheme(agencyID, conceptRef);
    }

    @Override
    public CodelistType findCodelist(ItemSchemeReferenceBaseType enumeration) {
        return structures.findCodelist(enumeration);
    }

    @Override
    public CodelistType findCodelistById(IDType id) {
        return structures.findCodelistById(id);
    }

    @Override
    public CodelistType findCodelist(NestedNCNameIDType codelistAgency, IDType codelist, VersionType codelistVersion) {
        return structures.findCodelist(codelistAgency, codelist, codelistVersion);
    }

    @Override
    public CodelistType findCodelist(NestedNCNameIDType codelistAgency, IDType codelist) {
        return structures.findCodelist(codelistAgency, codelist);
    }

    @Override
    public CodelistType findCodelist(String codelistAgency, String codelist, String codelistVersion) {
        return structures.findCodelist(codelistAgency, codelist, codelistVersion);
    }

    @Override
    public CodelistType findCodelist(String codelistAgency, String codelist) {
        return structures.findCodelist(codelistAgency, codelist);
    }

    @Override
    public ConceptSchemeType findConceptScheme(NestedNCNameIDType csa, IDType csi) {
        return structures.findConceptScheme(csa, csi);
    }

    @Override
    public ConceptSchemeType findConceptSchemeById(IDType id) {
        return structures.findConceptSchemeById(id);
    }

    @Override
    public ConceptType findConcept(NestedNCNameIDType agency, IDType id) {
        return structures.findConcept(agency, id);
    }

    @Override
    public ConceptType findConcept(IDType id) {
        return structures.findConcept(id);
    }

    @Override
    public StructureType query(DataStructureQueryMessage message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataMessage query(DataQueryMessage message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DataflowType> listDataflows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reset() {
        
    }

    @Override
    public MaintainableType resolve(StructureReferenceType ref) {
        return RegistryUtil.resolve(this, ref);
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx;

import java.util.ArrayList;
import java.util.List;
import sdmx.commonreferences.ConceptReferenceType;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemSchemeReferenceBaseType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.StructureReferenceType;
import sdmx.commonreferences.VersionType;
import sdmx.message.DataStructure;
import sdmx.message.StructureType;
import sdmx.structure.StructuresType;
import sdmx.structure.base.IdentifiableType;
import sdmx.structure.base.MaintainableType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.dataflow.DataflowType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.version.common.Queryable;
import sdmx.version.twopointone.Sdmx21StructureReaderTools;
import sdmx.xml.anyURI;
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *  SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public interface Registry extends Queryable {
    public void load(StructureType struct);
    public void unload(StructureType struct);
//    public IdentifiableType findIdentifiable(String agency, String id, String version);
    public DataStructureType findDataStructure(NestedNCNameIDType agency,IDType id,VersionType version);
    public DataStructureType findDataStructure(NestedNCNameIDType agency,IDType id);
    public ConceptSchemeType findConceptScheme(NestedNCNameIDType agencyID, ConceptReferenceType conceptRef);
    public CodelistType findCodelist(ItemSchemeReferenceBaseType enumeration);
    public CodelistType findCodelistById(IDType id);
    public CodelistType findCodelist(NestedNCNameIDType codelistAgency, IDType codelist, VersionType codelistVersion);
    public CodelistType findCodelist(NestedNCNameIDType codelistAgency, IDType codelist);
    public CodelistType findCodelist(String codelistAgency, String codelist, String codelistVersion);
    public CodelistType findCodelist(String codelistAgency, String codelist);
    public ConceptSchemeType findConceptScheme(NestedNCNameIDType csa, IDType csi);
    public ConceptSchemeType findConceptSchemeById(IDType id);
    public ConceptType findConcept(NestedNCNameIDType agency, IDType id);
    public ConceptType findConcept(IDType id);
    public List<DataflowType> listDataflows();
    public MaintainableType resolve(StructureReferenceType ref);
    public void reset();
}
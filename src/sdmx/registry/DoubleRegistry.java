/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.registry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sdmx.Registry;
import sdmx.common.TextOperatorType;
import sdmx.commonreferences.ConceptReferenceType;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemSchemeReferenceBaseType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.StructureReferenceType;
import sdmx.commonreferences.VersionQueryType;
import sdmx.commonreferences.VersionType;
import sdmx.exception.QueryableException;
import sdmx.message.BaseHeaderType;
import sdmx.message.DataMessage;
import sdmx.message.DataQueryMessage;
import sdmx.message.DataStructureQueryMessage;
import sdmx.message.HeaderTimeType;
import sdmx.message.PartyType;
import sdmx.message.SenderType;
import sdmx.message.StructureType;
import sdmx.query.base.QueryIDType;
import sdmx.query.base.QueryNestedIDType;
import sdmx.query.datastructure.DataStructureWhereType;
import sdmx.structure.base.MaintainableType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.dataflow.DataflowType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.version.common.Queryable;
import sdmx.xml.DateTime;

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
public class DoubleRegistry implements Registry {
    Registry left = LocalRegistry.getDefaultWorkspace();
    Registry right = LocalRegistry.getDefaultWorkspace();
    public DoubleRegistry(Registry left, Registry right) {
        this.left = left;
        this.right=right;
    }
    public void load(StructureType struct) {
        left.load(struct);
    }
    public void unload(StructureType struct) {
        left.unload(struct);
    }
    public DataStructureType findDataStructure(NestedNCNameIDType agency, IDType id, VersionType version) {
        DataStructureType dst = left.findDataStructure(agency, id, version);
        if( dst == null ) dst = right.findDataStructure(agency, id, version);
        return dst;
    }
    public ConceptSchemeType findConceptScheme(NestedNCNameIDType agencyID, ConceptReferenceType conceptRef) {
        ConceptSchemeType dst = left.findConceptScheme(agencyID, conceptRef);
        if( dst == null ) dst = right.findConceptScheme(agencyID, conceptRef);
        return dst;
    }
    public CodelistType findCodelist(ItemSchemeReferenceBaseType enumeration) {
        CodelistType dst = left.findCodelist(enumeration);
        if( dst == null ) dst = right.findCodelist(enumeration);
        return dst;
    }
    public CodelistType findCodelistById(IDType id) {
        CodelistType dst = left.findCodelistById(id);
        if( dst == null ) dst = right.findCodelistById(id);
        return dst;
    }
    public CodelistType findCodelist(NestedNCNameIDType codelistAgency, IDType codelist, VersionType codelistVersion) {
        CodelistType dst = left.findCodelist(codelistAgency, codelist, codelistVersion);
        if( dst == null ) dst =right.findCodelist(codelistAgency, codelist, codelistVersion);
        return dst;
    }
    public CodelistType findCodelist(String codelistAgency, String codelist, String codelistVersion) {
        CodelistType dst = left.findCodelist(codelistAgency, codelist, codelistVersion);
        if(dst == null ) dst = right.findCodelist(codelistAgency, codelist, codelistVersion);
        return dst;
    }
    public ConceptSchemeType findConceptScheme(NestedNCNameIDType csa, IDType csi) {
        ConceptSchemeType dst = left.findConceptScheme(csa, csi);
        if( dst == null ) dst = right.findConceptScheme(csa, csi);
        return dst;
    }
    public ConceptSchemeType findConceptSchemeById(IDType id) {
        ConceptSchemeType cs = left.findConceptSchemeById(id);
        if( cs == null ) cs = right.findConceptSchemeById(id);
        return cs;
    }
    public ConceptType findConcept(NestedNCNameIDType agency, IDType id) {
        ConceptType ct = left.findConcept(agency, id);
        if( ct == null ) ct = right.findConcept(agency, id);
        return ct;
    }
    public ConceptType findConcept(IDType id) {
        ConceptType ct = left.findConcept(id);
        if( ct == null ) ct = right.findConcept(id);
        return ct;
    }
    @Override
    public DataStructureType findDataStructure(NestedNCNameIDType agency, IDType id) {
        DataStructureType ds = left.findDataStructure(agency, id);
        if( ds == null ) ds = right.findDataStructure(agency, id);
        return ds;
    }
    @Override
    public CodelistType findCodelist(NestedNCNameIDType codelistAgency, IDType codelist) {
        CodelistType ct = left.findCodelist(codelistAgency, codelist);
        if( ct == null ) ct = right.findCodelist(codelistAgency, codelist);
        return ct;
    }
    @Override
    public CodelistType findCodelist(String codelistAgency, String codelist) {
        CodelistType ct = left.findCodelist(codelistAgency, codelist);
        if( ct == null ) ct = right.findCodelist(codelistAgency, codelist);
        return ct;
    }

    public List<DataStructureReferenceType> listDataStructures(){
        return Collections.EMPTY_LIST;
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
       left.reset();
       right.reset();
    }

    @Override
    public MaintainableType resolve(StructureReferenceType ref) {
        return RegistryUtil.resolve(this, ref);
    }

}

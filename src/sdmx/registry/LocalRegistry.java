/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.registry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sdmx.Registry;
import sdmx.commonreferences.ConceptReferenceType;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemSchemeReferenceBaseType;
import sdmx.commonreferences.NestedIDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.StructureReferenceType;
import sdmx.commonreferences.VersionType;
import sdmx.message.DataMessage;
import sdmx.message.DataQueryMessage;
import sdmx.message.DataStructure;
import sdmx.message.DataStructureQueryMessage;
import sdmx.message.StructureType;
import sdmx.structure.ConceptsType;
import sdmx.structure.StructuresType;
import sdmx.structure.base.IdentifiableType;
import sdmx.structure.base.MaintainableType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.dataflow.DataflowType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.version.twopointone.Sdmx21StructureReaderTools;
import sdmx.xml.anyURI;

/**
 *
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
public class LocalRegistry implements Registry {

    public static void main(String args[]) {
    }
    /*
     * This contains all structures loaded by the workspace
     */

    List<StructureType> structures = new ArrayList<StructureType>();

    /*
     * The static default workspace
     */
    private static final LocalRegistry def = new LocalRegistry();

    public static LocalRegistry getDefaultWorkspace() {
        return def;
    }

    public void load(StructureType struct) {
        //System.out.println("Local Load=" + struct);
        if (struct != null) {
            structures.add(struct);
        } else {
            throw new RuntimeException("Can't load null structure");
        }
    }

    public void unload(StructureType struct) {
        structures.remove(struct);
    }

    public IdentifiableType findIdentifiable(String agency, String id, String version) {
        NestedNCNameIDType ag = Sdmx21StructureReaderTools.toNestedNCNameIDType(agency);
        IDType idt = Sdmx21StructureReaderTools.toIDType(id);
        VersionType vers = Sdmx21StructureReaderTools.toVersionType(version);
        for (int i = 0; i < structures.size(); i++) {
            IdentifiableType it = findInStructure(structures.get(i), ag, idt, vers);
            if (it != null) {
                return it;
            }
        }
        return null;
    }

    private IdentifiableType findInStructure(StructureType doc, NestedNCNameIDType ag, IDType idt, VersionType vers) {
        StructuresType structs = doc.getStructures();
        IdentifiableType found = structs.getCategorisations().findCategorisation(ag, idt, vers);
        if (found != null) {
            return found;
        }
        found = structs.getCategorySchemes().findCategoryScheme(ag, idt, vers);
        if (found != null) {
            return found;
        }
        found = structs.getCodelists().findCodelist(ag, idt, vers);
        if (found != null) {
            return found;
        }
        found = structs.getDataStructures().findDataStructure(ag, idt, vers);
        if (found != null) {
            return found;
        }
        found = structs.getDataflows().findDataflow(ag, idt, vers);
        if (found != null) {
            return found;
        }
        found = structs.getMetadataStructures().findMetadataStructure(ag, idt, vers);
        if (found != null) {
            return found;
        }
        return null;
    }

    public DataStructureType findDataStructure(NestedNCNameIDType agency, IDType id, VersionType version) {
        DataStructureType found = null;
        //System.out.println("findDS");
        for (int i = 0; i < structures.size(); i++) {
            //System.out.println("Looking for DS");
            if (structures.get(i).getStructures().getDataStructures() != null) {
                //System.out.println("Got a Structure with a DataStructure");
                found = structures.get(i).findDataStructure(agency, id, version);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }

    public void loadStructure(anyURI uri) {
    }

    public ConceptSchemeType findConceptScheme(NestedNCNameIDType agencyID, ConceptReferenceType conceptRef) {
        ConceptSchemeType cs = null;
        for (int i = 0; i < structures.size(); i++) {
            cs = structures.get(i).findConceptScheme(agencyID, conceptRef);
            if (cs != null&&(cs.isExternalReference()==null||!cs.isExternalReference())) {
                return cs;
            }
        }
        return null;
    }

    public CodelistType findCodelist(ItemSchemeReferenceBaseType enumeration) {
        for (int i = 0; i < structures.size(); i++) {
            CodelistType cs = structures.get(i).findCodelist(enumeration);
            if (cs != null&&(cs.isExternalReference()==null||!cs.isExternalReference())) {
                return cs;
            }
        }
        return null;
    }

    public CodelistType findCodelistById(IDType id) {
        for (int i = 0; i < structures.size(); i++) {
            CodelistType cl = structures.get(i).findCodelistById(id);
            if (cl != null) {
                return cl;
            }
        }
        return null;
    }

    public CodelistType findCodelist(NestedNCNameIDType codelistAgency, IDType codelist, VersionType codelistVersion) {
        return findCodelist(codelistAgency.getString(), codelist.getString(), codelistVersion == null ? null : codelistVersion.getString());
    }

    public CodelistType findCodelist(String codelistAgency, String codelist, String codelistVersion) {
        for (int i = 0; i < structures.size(); i++) {
            CodelistType cl = structures.get(i).findCodelist(codelistAgency, codelist, codelistVersion);
            if (cl != null&&(cl.isExternalReference()==null||!cl.isExternalReference())) {
                return cl;
            }
        }
        return null;
    }

    public ConceptSchemeType findConceptScheme(NestedNCNameIDType csa, IDType csi) {
        for (int i = 0; i < structures.size(); i++) {
            ConceptSchemeType cs = structures.get(i).findConceptScheme(csa, csi);
            if (cs != null&&(cs.isExternalReference()==null||!cs.isExternalReference())) {
                return cs;
            }
        }
        return null;
    }

    public ConceptSchemeType findConceptSchemeById(IDType id) {
        for (int i = 0; i < structures.size(); i++) {
            ConceptSchemeType cs = structures.get(i).findConceptSchemeById(id);
            if (cs != null&&(cs.isExternalReference()==null&&!cs.isExternalReference())) {
                return cs;
            }
        }
        return null;
    }

    public ConceptType findConcept(NestedNCNameIDType agency, IDType id) {
        ConceptSchemeType cs = findConceptScheme(agency, id);
        if (cs == null) {
            // This is for ABS Data Structures -> the OBS_VALUE
            // has an agency of 'OECD' and this agency can't be inferred from the
            // keyfamily agency, or sender agency.
            return findConcept(id.asID());
        }
        return cs.findConcept(id);
    }

    public ConceptType findConcept(IDType id) {
        ConceptType ct = null;
        for (int i = 0; i < structures.size(); i++) {
            ct = structures.get(i).findConcept(id);
            if (ct != null) {
                return ct;
            }
        }
        return ct;
    }

    @Override
    public CodelistType findCodelist(NestedNCNameIDType codelistAgency, IDType codelist) {
        for (int i = 0; i < structures.size(); i++) {
            CodelistType cl = structures.get(i).findCodelist(codelistAgency, codelist);
            if (cl != null&&(cl.isExternalReference()==null||!cl.isExternalReference())) {
                return cl;
            }
        }
        return null;
    }

    @Override
    public CodelistType findCodelist(String codelistAgency, String codelist) {
        return findCodelist(new NestedNCNameIDType(codelistAgency), new IDType(codelist));
    }

    public DataStructureType findDataStructure(NestedNCNameIDType agency, IDType id) {
        DataStructureType found = null;
        for (int i = 0; i < structures.size(); i++) {
            found = structures.get(i).findDataStructure(agency, id);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    public List<DataflowType> listDataflows() {
        List<DataflowType> result = new ArrayList<DataflowType>();
        for(int i=0;i<structures.size();i++) {
            result.addAll(structures.get(i).listDataflows());
        }
        return result;
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
    public void reset() {
        structures.clear();
    }

    @Override
    public MaintainableType resolve(StructureReferenceType ref) {
        return RegistryUtil.resolve(this, ref);
    }

    @Override
    public DataflowType findDataflow(NestedNCNameIDType agency, IDType id, VersionType vers) {
        DataflowType df = null;
        for(int i=0;i<structures.size();i++) {
            df = structures.get(i).findDataflow(agency, id, vers);
            if( df!=null ) return df;
        }
        return null;
    }
}

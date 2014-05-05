/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.registry;

import sdmx.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sdmx.commonreferences.ConceptReferenceType;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemSchemeReferenceBaseType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.VersionType;
import sdmx.message.DataStructure;
import sdmx.message.StructureType;
import sdmx.structure.ConceptsType;
import sdmx.structure.StructuresType;
import sdmx.structure.base.IdentifiableType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.version.twopointone.Sdmx21StructureReaderTools;
import sdmx.xml.anyURI;

/**
 *
 * @author James
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
        System.out.println("Local Load=" + struct);
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
        for (int i = 0; i < structures.size(); i++) {
            if (structures.get(i).getStructures().getDataStructures() != null) {
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
            if (cs != null) {
                return cs;
            }
        }
        return null;
    }

    public CodelistType findCodelist(ItemSchemeReferenceBaseType enumeration) {
        for (int i = 0; i < structures.size(); i++) {
            CodelistType cs = structures.get(i).findCodelist(enumeration);
            if (cs != null) {
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
            if (cl != null) {
                return cl;
            }
        }
        return null;
    }

    public ConceptSchemeType findConceptScheme(NestedNCNameIDType csa, IDType csi) {
        for (int i = 0; i < structures.size(); i++) {
            ConceptSchemeType cs = structures.get(i).findConceptScheme(csa, csi);
            if (cs != null) {
                return cs;
            }
        }
        return null;
    }

    public ConceptSchemeType findConceptSchemeById(IDType id) {
        for (int i = 0; i < structures.size(); i++) {
            ConceptSchemeType cs = structures.get(i).findConceptSchemeById(id);
            if (cs != null) {
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
            cs = findConceptSchemeById(id);
            return cs.findConcept(id);
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
            if (cl != null) {
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

    public List<DataStructureReferenceType> listDataStructures() {
        List<DataStructureReferenceType> result = new ArrayList<DataStructureReferenceType>();
        for(int i=0;i<structures.size();i++) {
            result.addAll(structures.get(i).listDataStructures());
        }
        return result;
    }
}

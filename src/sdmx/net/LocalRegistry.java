/*
    This file is part of sdmx-sax.

    sdmx-sax is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    sdmx-sax is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with sdmx-sax.  If not, see <http://www.gnu.org/licenses/>.
    Copyright (C) 2015 James Gardner
*/
package sdmx.net;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import sdmx.message.DataMessage;
import sdmx.message.DataQueryMessage;
import sdmx.message.DataStructure;
import sdmx.message.DataStructureQueryMessage;
import sdmx.message.StructureType;
import sdmx.structure.ConceptsType;
import sdmx.structure.DataflowsType;
import sdmx.structure.StructuresType;
import sdmx.structure.base.IdentifiableType;
import sdmx.structure.base.ItemSchemeType;
import sdmx.structure.base.ItemType;
import sdmx.structure.base.MaintainableType;
import sdmx.structure.codelist.CodeType;
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
 * This file is part of SdmxSax.
 *
 * SdmxSax is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * SdmxSax is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * SdmxSax. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright James Gardner 2014
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
        if (struct != null && !structures.contains(struct)) {
            if (this == def) {
                System.out.println("Default Registry Loading Structure");
            }
            structures.add(struct);
        } else if (struct == null) {
            throw new RuntimeException("Can't load null structure");
        }
    }

    public void unload(StructureType struct) {
        structures.remove(struct);
    }

    public List<DataflowType> listDataflows() {
        List<DataflowType> result = new ArrayList<DataflowType>();
        for (int i = 0; i < structures.size(); i++) {
            result.addAll(structures.get(i).listDataflows());
        }
        return result;
    }

    @Override
    public void clear() {
        structures.clear();
    }

    @Override
    public DataStructureType find(DataStructureReference ref) {
        Logger.getLogger("sdmx").log(Level.FINE, "LocalRegistry.find(DataStructureReference-" + ref.getAgencyId() + ":" + ref.getMaintainableParentId() + ":" + ref.getVersion() + ")");
        DataStructureType found = null;
        for (int i = 0; i < structures.size(); i++) {
            if (structures.get(i).getStructures().getDataStructures() != null) {
                found = structures.get(i).getStructures().getDataStructures().find(ref);
                if (found != null) {
                    return found;
                }
            }
        }
        return found;
    }

    @Override
    public DataflowType find(DataflowReference ref) {
        Logger.getLogger("sdmx").log(Level.FINE, "LocalRegistry.find(DataflowReference-" + ref.getAgencyId() + ":" + ref.getMaintainableParentId() + ":" + ref.getVersion() + ")");
        DataflowType df = null;
        for (int i = 0; i < structures.size(); i++) {
            df = structures.get(i).find(ref);
            if (df != null) {
                return df;
            }
        }
        for (DataflowType df2 : listDataflows()) {
            if (df2.identifiesMe(ref.getAgencyId(), ref.getMaintainableParentId(), ref.getVersion())) {
                return df2;
            }
        }
        return null;
    }

    @Override
    public CodeType find(CodeReference ref) {
        Logger.getLogger("sdmx").log(Level.FINE, "LocalRegistry.find(CodeReference-" + ref.getAgencyId() + ":" + ref.getMaintainableParentId() + ":" + ref.getVersion() + ")");
        for (int i = 0; i < structures.size(); i++) {
            CodeType cl = structures.get(i).find(ref);
            if (cl != null) {
                return cl;
            }
        }
        return null;
    }

    @Override
    public CodelistType find(CodelistReference ref) {
        Logger.getLogger("sdmx").log(Level.FINE, "LocalRegistry.find(CodelistReference-" + ref.getAgencyId() + ":" + ref.getMaintainableParentId() + ":" + ref.getVersion() + ")");
        for (int i = 0; i < structures.size(); i++) {
            CodelistType cl = structures.get(i).find(ref);
            if (cl != null && (cl.isExternalReference() == null || !cl.isExternalReference())) {
                return cl;
            }
        }
        return null;
    }

    @Override
    public ConceptType find(ConceptReference ref) {
        Logger.getLogger("sdmx").log(Level.FINE, "LocalRegistry.find(ConceptReference-" + ref.getAgencyId() + ":" + ref.getMaintainableParentId() + ":" + ref.getVersion() + ")");
        for (int i = 0; i < structures.size(); i++) {
            ConceptType cl = structures.get(i).find(ref);
            if (cl != null) {
                return cl;
            }
        }
        return null;
    }

    @Override
    public ConceptSchemeType find(ConceptSchemeReference ref) {
        Logger.getLogger("sdmx").log(Level.FINE, "LocalRegistry.find(ConceptSchemeReference-" + ref.getAgencyId() + ":" + ref.getMaintainableParentId() + ":" + ref.getVersion() + ")");
        for (int i = 0; i < structures.size(); i++) {
            ConceptSchemeType cl = structures.get(i).find(ref);
            if (cl != null) {
                Logger.getLogger("sdmx").log(Level.FINE, "LocalRegistry.find(ConceptSchemeReference-found ConceptScheme");
                return cl;
            }
        }
        Logger.getLogger("sdmx").log(Level.FINE, "LocalRegistry.find(ConceptSchemeReference-returning null");
        return null;
    }

    @Override
    public ItemType find(ItemReference ref) {
        ConceptType concept = find(ConceptReference.create(ref.getAgencyId(), ref.getMaintainableParentId(), ref.getVersion(), ref.getId()));
        if (concept != null) {
            return concept;
        }
        CodeType code = find(CodeReference.create(ref.getAgencyId(), ref.getMaintainableParentId(), ref.getVersion(), ref.getId()));
        return code;

    }

    @Override
    public ItemSchemeType find(ItemSchemeReferenceBase ref) {
        ConceptSchemeType concept = find(ConceptSchemeReference.create(ref.getAgencyId(), ref.getMaintainableParentId(), ref.getVersion()));
        if (concept != null) {
            return concept;
        }
        CodelistType code = find(CodelistReference.create(ref.getAgencyId(), ref.getMaintainableParentId(), ref.getVersion()));
        return code;
    }

    @Override
    public void save(OutputStream out) throws IOException {
        if (structures.size() == 0) {
            return;
        }
        StructureType struct = this.structures.get(0);
        for (int i = 1; i < structures.size(); i++) {
            struct.merge(structures.get(i));
        }
        structures.clear();
        structures.add(struct);
        struct.save(out);
        out.flush();
        out.close();
    }

    public void merge() {
        if (structures.size() == 0) {
            return;
        }
        StructureType struct = this.structures.get(0);
        for (int i = 1; i < structures.size(); i++) {
            struct.merge(structures.get(i));
        }
        structures.clear();
        structures.add(struct);
    }

    @Override
    public List<DataStructureType> search(DataStructureReference ref) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<DataflowType> search(DataflowReference ref) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<CodeType> search(CodeReference ref) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<CodelistType> search(CodelistReference ref) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<ItemType> search(ItemReference ref) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<ItemSchemeType> search(ItemSchemeReferenceBase ref) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<ConceptType> search(ConceptReference ref) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<ConceptSchemeType> search(ConceptSchemeReference ref) {
        return Collections.EMPTY_LIST;
    }
    public List<StructureType> getCache(){
        return this.structures;
    }
}

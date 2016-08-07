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
import sdmx.common.TextOperatorType;
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
import sdmx.commonreferences.VersionQuery;
import sdmx.commonreferences.Version;
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
import sdmx.structure.base.ItemSchemeType;
import sdmx.structure.base.ItemType;
import sdmx.structure.base.MaintainableType;
import sdmx.structure.codelist.CodeType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.dataflow.DataflowType;
import sdmx.structure.datastructure.DataStructureType;
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
        Logger.getLogger("sdmx").fine("DoubleRegistry:left="+left.getClass());
        Logger.getLogger("sdmx").fine("DoubleRegistry:right="+right.getClass());
    }
    public void load(StructureType struct) {
        left.load(struct);
    }
    public void unload(StructureType struct) {
        left.unload(struct);
    }
    @Override
    public List<DataflowType> listDataflows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        left.clear();
        right.clear();
    }

    @Override
    public DataStructureType find(DataStructureReference ref) {
        Logger.getLogger("sdmx").log(Level.FINE,"DoubleRegistry:find(DataStructureReference-"+ref.toString());
        DataStructureType dst = left.find(ref);
        if( dst==null ) {
            return right.find(ref);
        }
        return dst;
    }

    @Override
    public DataflowType find(DataflowReference ref) {
        Logger.getLogger("sdmx").log(Level.FINE,"DoubleRegistry:find(DataflowReference-"+ref.toString());
        DataflowType dst = left.find(ref);
        if( dst==null ) {
            return right.find(ref);
        }
        return dst;
    }

    @Override
    public CodeType find(CodeReference ref) {
        Logger.getLogger("sdmx").log(Level.FINE,"DoubleRegistry:find(CodeReference-"+ref.toString());
        CodeType dst = left.find(ref);
        if( dst==null ) {
            return right.find(ref);
        }
        return dst;
    }

    @Override
    public CodelistType find(CodelistReference ref) {
        Logger.getLogger("sdmx").log(Level.FINE,"DoubleRegistry:find(CodelistReference-"+ref.toString());
        CodelistType dst = left.find(ref);
        if( dst==null ) {
            return right.find(ref);
        }
        return dst;
    }

    @Override
    public ConceptType find(ConceptReference ref) {
        Logger.getLogger("sdmx").log(Level.FINE,"DoubleRegistry:find(ConceptReference-"+ref.toString());
        ConceptType dst = left.find(ref);
        if( dst==null ) {
            return right.find(ref);
        }
        return dst;
    }

    @Override
    public ConceptSchemeType find(ConceptSchemeReference ref) {
        Logger.getLogger("sdmx").log(Level.FINE,"DoubleRegistry:find(ConceptSchemeReference-"+ref.toString());
        ConceptSchemeType dst = left.find(ref);
        if( dst==null ) {
            return right.find(ref);
        }
        return dst;
    }
    @Override
    public ItemType find(ItemReference ref) {
        ConceptType concept = find(ConceptReference.create(ref.getAgencyId(), ref.getMaintainableParentId(), ref.getVersion(), ref.getId()));
        if( concept!=null) return concept;
        CodeType code = find(CodeReference.create(ref.getAgencyId(),ref.getMaintainableParentId(), ref.getVersion(), ref.getId()));
        return code;
        
    }

    @Override
    public ItemSchemeType find(ItemSchemeReferenceBase ref) {
        ConceptSchemeType concept = find(ConceptSchemeReference.create(ref.getAgencyId(), ref.getMaintainableParentId(), ref.getVersion()));
        if( concept!=null) return concept;
        CodelistType code = find(CodelistReference.create(ref.getAgencyId(),ref.getMaintainableParentId(), ref.getVersion()));
        return code;
    }

    @Override
    public void save(OutputStream out) throws IOException {
        left.save(out);
    }
    public void merge(){}
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
        List<StructureType> result = new ArrayList<StructureType>();
        result.addAll(left.getCache());
        result.addAll(right.getCache());
        return result;
    }
}

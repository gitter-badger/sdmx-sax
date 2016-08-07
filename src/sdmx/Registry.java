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
package sdmx;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import sdmx.commonreferences.CategorySchemeReference;
import sdmx.commonreferences.CodeReference;
import sdmx.commonreferences.CodelistReference;
import sdmx.commonreferences.ComponentReference;
import sdmx.commonreferences.ConceptReference;
import sdmx.commonreferences.ConceptSchemeReference;
import sdmx.commonreferences.ConstraintReference;
import sdmx.commonreferences.ConstraintTargetReference;
import sdmx.commonreferences.DataStructureReference;
import sdmx.commonreferences.DataflowReference;
import sdmx.commonreferences.DimensionReference;
import sdmx.commonreferences.HierarchicalCodelistReference;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemReference;
import sdmx.commonreferences.ItemSchemeReference;
import sdmx.commonreferences.ItemSchemeReferenceBase;
import sdmx.commonreferences.NestedNCNameID;
import sdmx.commonreferences.StructureReference;
import sdmx.commonreferences.Version;
import sdmx.message.StructureType;
import sdmx.structure.HierarchicalCodelist;
import sdmx.structure.base.ComponentType;
import sdmx.structure.base.ItemSchemeType;
import sdmx.structure.base.ItemType;
import sdmx.structure.base.MaintainableType;
import sdmx.structure.category.CategorySchemeType;
import sdmx.structure.codelist.CodeType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.constraint.ConstraintType;
import sdmx.structure.dataflow.DataflowType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structure.datastructure.DimensionType;

/**
 *
 * @author James
 */
public interface Registry {
    public void load(StructureType struct);
    public void unload(StructureType struct);
    public void clear();
    public List<DataflowType> listDataflows();
    public DataStructureType find(DataStructureReference ref);
    public DataflowType find(DataflowReference ref);
    public CodeType find(CodeReference ref);
    public CodelistType find(CodelistReference ref);
    public ItemType find(ItemReference ref);
    public ItemSchemeType find(ItemSchemeReferenceBase ref);
    public ConceptType find(ConceptReference ref);
    public ConceptSchemeType find(ConceptSchemeReference ref);
    
    public List<DataStructureType> search(DataStructureReference ref);
    public List<DataflowType> search(DataflowReference ref);
    public List<CodeType> search(CodeReference ref);
    public List<CodelistType> search(CodelistReference ref);
    public List<ItemType> search(ItemReference ref);
    public List<ItemSchemeType> search(ItemSchemeReferenceBase ref);
    public List<ConceptType> search(ConceptReference ref);
    public List<ConceptSchemeType> search(ConceptSchemeReference ref);
    
    public void save(OutputStream out)throws IOException;
    public List<StructureType> getCache();
}

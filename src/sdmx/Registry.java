/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx;

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
import sdmx.commonreferences.ItemSchemeReferenceBase;
import sdmx.commonreferences.NestedNCNameID;
import sdmx.commonreferences.StructureReference;
import sdmx.commonreferences.Version;
import sdmx.message.StructureType;
import sdmx.structure.HierarchicalCodelist;
import sdmx.structure.base.ComponentType;
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
    public ConceptType find(ConceptReference ref);
    public ConceptSchemeType find(ConceptSchemeReference ref);
}

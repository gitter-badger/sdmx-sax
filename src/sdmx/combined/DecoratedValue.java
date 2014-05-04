/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.combined;

import sdmx.Registry;
import sdmx.structure.codelist.CodeType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.datastructure.DataStructureType;

/**
 *
 * @author James
 */
public class DecoratedValue {

    private String concept = null;
    private String value = null;
    private Registry registry = null;
    private DataStructureType structure = null;

    public DecoratedValue(String concept, String value, Registry registry,DataStructureType struct) {
        this.concept=concept;
        this.value=value;
        this.registry=registry;
        this.structure=struct;
    }
    public boolean isCoded() {
        return structure.getDataStructureComponents().findDimension(concept).getLocalRepresentation().getEnumeration()!=null;
    }
    public CodeType getCode() {
        return ValueTypeResolver.resolveCode(registry, structure, concept, value);
    }
    public CodelistType getCodelist() {
        return ValueTypeResolver.getPossibleCodes(registry, structure, value);
    }
}

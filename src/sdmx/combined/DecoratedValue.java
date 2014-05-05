/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.combined;

import java.util.Locale;
import sdmx.Registry;
import sdmx.common.Description;
import sdmx.common.Name;
import sdmx.structure.base.Component;
import sdmx.structure.base.RepresentationType;
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
        Component comp = structure.getDataStructureComponents().findDimension(concept);
        if( comp == null ) return false;
        RepresentationType localRep = comp.getLocalRepresentation();
        if( localRep == null ) return false;
        return structure.getDataStructureComponents().findDimension(concept).getLocalRepresentation().getEnumeration()!=null;
    }
    public CodeType getCode() {
        return ValueTypeResolver.resolveCode(registry, structure, concept, value);
    }
    public CodelistType getCodelist() {
        return ValueTypeResolver.getPossibleCodes(registry, structure, value);
    }
    public String toString() {
        Locale loc = Locale.getDefault();
        if( isCoded() ) {
            CodeType code = getCode();
            if( code == null ) {
                throw new RuntimeException("Null Code");
            }
            Name name = code.findName(loc.getLanguage());
            Description desc = code.findDescription(loc.getLanguage());
            if( name != null ) return name.getText();
            if( desc!=null ) return desc.getText();
            else return code.getId().toString();
        }
        return value;
    }
}

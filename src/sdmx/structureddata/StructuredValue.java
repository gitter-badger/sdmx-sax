/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structureddata;

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
public class StructuredValue {

    private String concept = null;
    private String value = null;
    private Registry registry = null;
    private DataStructureType structure = null;

    public StructuredValue(String concept, String value, Registry registry,DataStructureType struct) {
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
                return value;
            }
            Description desc = code.findDescription(loc.getLanguage());
            if( desc == null ) {
                Name name = code.findName(loc.getLanguage());
                if( name == null ) return code.getId().toString();
                return name.getText();
            }
            return desc.getText();
        }
        return value;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structureddata;

import java.util.ArrayList;
import java.util.Locale;
import sdmx.Registry;
import sdmx.common.Description;
import sdmx.common.Name;
import sdmx.structure.base.Component;
import sdmx.structure.base.ComponentUtil;
import sdmx.structure.base.ItemSchemeType;
import sdmx.structure.base.ItemType;
import sdmx.structure.base.RepresentationType;
import sdmx.structure.codelist.CodeType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.datastructure.DataStructureType;

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
public class StructuredValue {

    private String concept = null;
    private String value = null;
    private Registry registry = null;
    private DataStructureType structure = null;

    public StructuredValue(String concept, String value, Registry registry, DataStructureType struct) {
        //if (concept.equals("FREQ")) {
        //    System.out.println("Concept=" + concept);
        //    System.out.println("Value=" + value);
        //}
        this.concept = concept;
        this.value = value;
        this.registry = registry;
        this.structure = struct;
    }

    public boolean isCoded() {
        Component comp = structure.getDataStructureComponents().findDimension(concept);
        if ("type".equals(concept)) {
            comp = structure.getDataStructureComponents().getDimensionList().getMeasureDimension();
        }
        if (comp == null) {
            System.out.println("Comp is NUll!"+concept);
            return false;
        }
        RepresentationType localRep = ComponentUtil.getRepresentation(registry,comp);
        return true;
    }

    public ItemType getCode() {
        //System.out.println("Concept:"+ concept+" Value:" + value);
        if( "OBS_VALUE".equals(this.concept)||this.getConcept().getId().equals(structure.getDataStructureComponents().getMeasureList().getPrimaryMeasure().getId().toString())){
            ItemType itm = new CodeType();
            ArrayList<Name> names = new ArrayList<Name>();
            Name name = new Name(null,this.value);
            names.add(name);
            itm.setNames(names);
            return itm;
        }
        
        
        //Locale loc = Locale.getDefault();
        //ItemType item = ValueTypeResolver.resolveCode(registry, structure, concept, value);
        //System.out.println("Item=" + item.toString());
        //System.out.println("Item=" + item.findName(loc.getLanguage()));
        return ValueTypeResolver.resolveCode(registry, structure, concept, getValue());
    }

    public ItemSchemeType getCodelist() {
        return ValueTypeResolver.getPossibleCodes(registry, structure, concept);
    }

    public String toString() {
        Locale loc = Locale.getDefault();
        //if (concept.equals("FREQ")) {
        //    ItemType code2 = getCode();
        //    System.out.println("FREQ Code=" + code2);
        //}
        if (isCoded()) {
            ItemType code = getCode();
            if (code == null) {
                return getValue();
            }
            Description desc = code.findDescription(loc.getLanguage());
            if (desc == null) {
                Name name = code.findName(loc.getLanguage());
                if (name == null) {
                    return code.getId().toString();
                }
                return name.getText();
            }
            return desc.getText();
        }
        return getValue();
    }

    /**
     * @return the concept
     */
    public ConceptType getConcept() {
        return registry.find(structure.getDataStructureComponents().findDimension(concept).getConceptIdentity());
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }
}

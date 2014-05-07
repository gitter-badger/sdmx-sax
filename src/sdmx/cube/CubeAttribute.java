/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.cube;

import java.util.Locale;
import sdmx.common.DataType;
import sdmx.common.Description;
import sdmx.common.Name;
import sdmx.structure.base.Component;
import sdmx.structure.codelist.CodeType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptType;

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
public class CubeAttribute {

    private Component component = null;
    private ConceptType concept = null;
    private CodelistType codelist = null;

    private String value = null;

    public String getName() {
        Locale loc = Locale.getDefault();
        Name name = getConcept().findName(loc.getLanguage());
        if (name != null) {
            return name.getText();
        } else {
            return getComponent().getId().toString();
        }
    }

    public String getDescription() {
        Locale loc = Locale.getDefault();
        Description desc = getConcept().findDescription(loc.getLanguage());
        if (desc != null) {
            return desc.getText();
        } else {
            return "";
        }
    }

    public String getValueString() {
        if (codelist != null) {
            CodeType ct = codelist.findCode(getValue());
            Locale loc = Locale.getDefault();
            Name name = ct.findName(loc.getLanguage());
            if (name != null) {
                return name.getText();
            } else {
                return ct.getId().toString();
            }
        } else {
            if (getComponent().getLocalRepresentation().getTextFormat().getTextType() == DataType.DECIMAL) {
                return getValue();
            }
            if (getComponent().getLocalRepresentation().getTextFormat().getTextType() == DataType.INTEGER) {
                return getValue();
            }
        }
        return "";
    }

    /**
     * @return the concept
     */
    public ConceptType getConcept() {
        return concept;
    }

    /**
     * @param concept the concept to set
     */
    public void setConcept(ConceptType concept) {
        this.concept = concept;
    }

    /**
     * @return the codelist
     */
    public CodelistType getCodelist() {
        return codelist;
    }

    /**
     * @param codelist the codelist to set
     */
    public void setCodelist(CodelistType codelist) {
        this.codelist = codelist;
    }

    /**
     * @return the component
     */
    public Component getComponent() {
        return component;
    }

    /**
     * @param component the component to set
     */
    public void setComponent(Component component) {
        this.component = component;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }


}

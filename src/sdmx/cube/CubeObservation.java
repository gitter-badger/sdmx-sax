/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.cube;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import sdmx.structure.base.Component;
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
public class CubeObservation {
    HashMap<String,CubeAttribute> map = new HashMap<>();
    
    private String concept = null;
    private String cross = null;
    private String observationConcept = null;
    private String value = null;
    
    public CubeObservation(String concept,String cross,String observationConcept,String value){
        this.concept=concept;
        this.cross=cross;
        this.observationConcept=observationConcept;
        this.value=value;
    }
   
    public CubeAttribute getAttribute(String id) {
        return map.get(id);
    }

    public void putAttribute(CubeAttribute sub) {
        map.put(sub.getValue(),sub);
    }

    public Collection<CubeAttribute> listAttributes() {
        return map.values();
    }
    public Set<String> listAttributeNames() {
        return map.keySet();
    }

    /**
     * @return the concept
     */
    public String getCrossSection() {
        return cross;
    }

    /**
     * @param concept the concept to set
     */
    public void setCross(String concept) {
        this.cross = concept;
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

    /**
     * @return the concept
     */
    public String getConcept() {
        return concept;
    }

    /**
     * @param concept the concept to set
     */
    public void setConcept(String concept) {
        this.concept = concept;
    }

    /**
     * @return the observationConcept
     */
    public String getObservationConcept() {
        return observationConcept;
    }

    /**
     * @param observationConcept the observationConcept to set
     */
    public void setObservationConcept(String observationConcept) {
        this.observationConcept = observationConcept;
    }
}

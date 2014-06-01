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
public class TimeCubeDimension extends CubeDimension {

    HashMap<String,CubeObservation> map = new HashMap<String,CubeObservation>();
    
    public TimeCubeDimension(String concept, String value) {
        super(concept,value);
    }

    public Collection<CubeObservation> listObservations() {
        return map.values();
    }

    public void putObservation(CubeObservation sub) {
        map.put(sub.getValue(),sub);
    }

    public CubeObservation getObservation(String id) {
        return map.get(id);
    }

    public Set<String> listObservationValues() {
        return map.keySet();
    }

    @Override
    public CubeDimension getSubDimension(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putSubDimension(CubeDimension sub) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<CubeDimension> listSubDimensions() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public Set<String> listDimensionValues() {
        return Collections.EMPTY_SET;
    }
}

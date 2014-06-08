/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.cube;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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
public class ListCubeDimension extends CubeDimension {

    List<CubeDimension> list = new LinkedList<CubeDimension>();
    
    public ListCubeDimension(String concept,String value){
        super(concept,value);
    }
    
    @Override
    public CubeDimension getSubDimension(String id) {
        Iterator<CubeDimension> it = list.iterator();
        while(it.hasNext()){
            CubeDimension cd = it.next();
            if( cd.getValue().equals(id))return cd;
        }
        return null;
    }

    @Override
    public void putSubDimension(CubeDimension sub) {
        CubeDimension old = getSubDimension(sub.getValue());
        if( old!=null ) list.remove(old);
        list.add(sub);
        setSubDimension(sub.getConcept());
    }

    @Override
    public Collection<CubeDimension> listSubDimensions() {
        return list;
    }
    @Override
    public Set<String> listDimensionValues() {
        Set set = new TreeSet();
        for(int i=0;i<list.size();i++) {
            set.add(list.get(i).getValue());
        }
        return set;
    }
    public void dump() {
        System.out.println("Dim:"+getConcept()+":"+getValue());
        System.out.println("SubDims");
        Iterator<CubeDimension> it = this.listSubDimensions().iterator();
        while(it.hasNext()) {
            it.next().dump();
        }
        System.out.println("End Dim:"+getConcept()+":"+getValue());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structureddata;

import java.util.Locale;
import sdmx.Registry;
import sdmx.common.Name;
import sdmx.commonreferences.ConceptReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedIDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.VersionType;
import sdmx.data.DataSet;
import sdmx.structure.base.Component;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
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
public class StructuredDataSet {

    private DataSet dataSet = null;
    private Registry registry = null;
    private DataStructureType structure = null;

    public StructuredDataSet(DataSet ds, Registry reg, DataStructureType struct) {
        this.dataSet = ds;
        this.registry = reg;
        this.structure = struct;
    }

    public StructuredValue getDecoratedValue(int row, int column) {
        return new StructuredValue(dataSet.getColumnName(column), dataSet.getValue(row, column), registry, structure);
    }

    public String getColumnName(int i) {
        String conceptString = dataSet.getColumnName(i);
        //System.out.println("ds="+structure);
        Component c = structure.getDataStructureComponents().findDimension(conceptString);
        // * Fixed in DataStructureComponentsType.findDimension
        //if( "TIME_PERIOD".equals(conceptString)&&c == null ) {
        //    // TIME_PERIOD in Data, Something else in Structure
        //   c = structure.getDataStructureComponents().getTimeDimension();
        //}
        if( c == null ) {
            System.out.println("Component is null conceptRef:"+conceptString);
            return conceptString;
        }
        ConceptReferenceType conceptRef = c.getConceptIdentity();
        ConceptType concept = null;
        if (conceptRef != null) {
            ConceptSchemeType con = registry.findConceptScheme(conceptRef.getRef().getAgencyId(), conceptRef.getRef().getMaintainableParentId());
            if (con == null) {
                System.out.println("Cant find concept:" + conceptRef.getRef().getMaintainableParentId());
            }
            concept = con.findConcept(c.getConceptIdentity().getRef().getId());
            Locale loc = Locale.getDefault();
            Name name = concept==null?null:concept.findName(loc.getLanguage());
            if (name == null) {
                throw new RuntimeException("No Name for Concept!");
            }
            return name.getText();
        } else {
            throw new RuntimeException("Can't find Concept:" + conceptString);
        }
    }
    public int size() { 
        return dataSet.size();
    }
    public int getColumnCount() {
        return dataSet.getColumnSize();
    }
}

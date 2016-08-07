/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structureddata;

import java.util.Locale;
import sdmx.Registry;
import sdmx.common.Name;
import sdmx.commonreferences.ConceptReference;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedID;
import sdmx.commonreferences.NestedNCNameID;
import sdmx.commonreferences.Version;
import sdmx.data.DataSet;
import sdmx.structure.base.Component;
import sdmx.structure.concept.ConceptSchemeType;
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
public class StructuredDataSet {

    private DataSet dataSet = null;
    private Registry registry = null;
    private DataStructureType structure = null;

    public StructuredDataSet(DataSet ds, Registry reg, DataStructureType struct) {
        this.dataSet = ds;
        this.registry = reg;
        this.structure = struct;
    }

    public StructuredValue getStructuredValue(int row, int column) {
        return new StructuredValue(getDataSet().getColumnName(column), getDataSet().getValue(row, column), registry, getStructure());
    }
    public int getColumnIndex(String id) {
        return getDataSet().getColumnIndex(id);
    }

    public String getColumnName(int i) {
        String conceptString = getDataSet().getColumnName(i);
        //System.out.println("Concept="+conceptString);
        //System.out.println("ds="+getStructure());
        Component c = getStructure().getDataStructureComponents().findDimension(conceptString);
        if (c == null && conceptString.equals("type")) {
            c = getStructure().getDataStructureComponents().getDimensionList().getMeasureDimension();
        }
        //System.out.println("Concept="+conceptString+": component="+c);
        // * Fixed in DataStructureComponentsType.findDimension
        //if( "TIME_PERIOD".equals(conceptString)&&c == null ) {
        //    // TIME_PERIOD in Data, Something else in Structure
        //   c = structure.getDataStructureComponents().getTimeDimension();
        //}
        if (c == null) {
            System.out.println("Component is null conceptRef:" + conceptString);
            return conceptString;
        }
        ConceptReference conceptRef = c.getConceptIdentity();
        ConceptType concept = null;
        if (conceptRef != null) {
            concept = registry.find(conceptRef);
            Locale loc = Locale.getDefault();
            Name name = concept == null ? null : concept.findName(loc.getLanguage());
            if (name == null) {
                throw new RuntimeException("No Name for Concept"+conceptRef.toString());
            }
            return name.getText();
        } else {
            throw new RuntimeException("Can't find Concept:" + conceptString);
        }
    }

    public int size() {
        return getDataSet().size();
    }

    public int getColumnCount() {
        return getDataSet().getColumnSize();
    }

    /**
     * @return the dataSet
     */
    public DataSet getDataSet() {
        return dataSet;
    }

    /**
     * @return the structure
     */
    public DataStructureType getStructure() {
        return structure;
    }
}

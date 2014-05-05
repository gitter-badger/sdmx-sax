/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.combined;

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
 *
 * @author James
 */
public class DecoratedDataSet {

    private DataSet dataSet = null;
    private Registry registry = null;
    private DataStructureType structure = null;

    public DecoratedDataSet(DataSet ds, Registry reg, DataStructureType struct) {
        this.dataSet = ds;
        this.registry = reg;
        this.structure = struct;
    }

    public DecoratedValue getDecoratedValue(int row, int column) {
        return new DecoratedValue(dataSet.getColumnName(column), dataSet.getValue(row, column), registry, structure);
    }

    public String getColumnName(int i) {
        String conceptString = dataSet.getColumnName(i);
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
            Name name = concept.findName(loc.getLanguage());
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.util;

import sdmx.Registry;
import sdmx.common.ObservationDimensionType;
import sdmx.commonreferences.DataStructureReference;
import sdmx.message.DataMessage;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structure.datastructure.DimensionType;

/**
 *
 * @author James
 */
public class PostParseUtilities {
    // Sdmx 2.0 files frequently don't have Structure References to the Data Structure
    public static void setStructureReference(DataMessage data, DataStructureReference ref) {
        data.setDataStructure(ref, null);
    }
    // Sdmx 2.0 files don't have a dimension at observation
    public static void setDimensionAtObservation(DataMessage data,Registry reg, DataStructureReference ref) {
        DataStructureType struct = reg.find(ref);
        for(DimensionType d:struct.getDataStructureComponents().getDimensionList().getDimensions()){
            if( data.getDataSets().get(0).getColumnMapper().isAttachedToObservation(d.getId().toString())){
                data.getHeader().getStructures().get(0).setDimensionAtObservation(new ObservationDimensionType(d.getId().toString()));
            }
        }
        if( data.getDataSets().get(0).getColumnMapper().isAttachedToObservation(struct.getDataStructureComponents().getDimensionList().getTimeDimension().getId().toString())){
            data.getHeader().getStructures().get(0).setDimensionAtObservation(new ObservationDimensionType(struct.getDataStructureComponents().getDimensionList().getTimeDimension().getId().toString()));
        }
    }
}

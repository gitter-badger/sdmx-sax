/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.data;

import org.sdmx.resources.sdmxml.schemas.v21.query.ObservationActionCodeType;
import sdmx.common.DataStructureRequestType;

/**
 *
 * @author James
 */

public class DataReturnDetailsType extends DataReturnDetailsBaseType {
    private Integer firstNObservations = null;
    private Integer lastNObservations = null;
    private DataStructureRequestType structure = null;
    private ObservationActionCodeType observationAction = null;

    /**
     * @return the firstNObservations
     */
    public Integer getFirstNObservations() {
        return firstNObservations;
    }

    /**
     * @param firstNObservations the firstNObservations to set
     */
    public void setFirstNObservations(Integer firstNObservations) {
        this.firstNObservations = firstNObservations;
    }

    /**
     * @return the lastNObservations
     */
    public Integer getLastNObservations() {
        return lastNObservations;
    }

    /**
     * @param lastNObservations the lastNObservations to set
     */
    public void setLastNObservations(Integer lastNObservations) {
        this.lastNObservations = lastNObservations;
    }

    /**
     * @return the structure
     */
    public DataStructureRequestType getStructure() {
        return structure;
    }

    /**
     * @param structure the structure to set
     */
    public void setStructure(DataStructureRequestType structure) {
        this.structure = structure;
    }

    /**
     * @return the observationAction
     */
    public ObservationActionCodeType getObservationAction() {
        return observationAction;
    }

    /**
     * @param observationAction the observationAction to set
     */
    public void setObservationAction(ObservationActionCodeType observationAction) {
        this.observationAction = observationAction;
    }
}

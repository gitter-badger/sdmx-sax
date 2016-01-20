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
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
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

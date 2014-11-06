/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.datastructure;

import sdmx.commonreferences.ConceptReference;
import sdmx.query.base.AnnotationWhereType;
import sdmx.query.base.ComponentWhereType;

/**
 *
 * @author James
 */
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
public class TimeDimensionWhereType extends ComponentWhereType {
    private AnnotationWhereType annotationWhere = null;

    /**
     * @return the annotationWhere
     */
    public AnnotationWhereType getAnnotationWhere() {
        return annotationWhere;
    }

    /**
     * @param annotationWhere the annotationWhere to set
     */
    public void setAnnotationWhere(AnnotationWhereType annotationWhere) {
        this.annotationWhere = annotationWhere;
    }

   
}

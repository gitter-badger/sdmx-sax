/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.datastructure;

import sdmx.commonreferences.ConceptReferenceType;
import sdmx.query.base.AnnotationWhereType;
import sdmx.query.base.ComponentWhereType;

/**
 *
 * @author James
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

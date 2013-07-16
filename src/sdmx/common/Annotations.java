/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.common;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author James
 */
public class Annotations extends AnnotationsType {
     public Annotations(List<AnnotationType> annots) {
         super(annots);
     }

    public Annotations() {
        super(new ArrayList<AnnotationType>());
    }
}

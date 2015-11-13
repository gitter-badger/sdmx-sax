/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import sdmx.Registry;
import sdmx.structure.concept.ConceptType;

/**
 *
 * @author James
 */
public class ComponentUtil {
    public static RepresentationType getRepresentation(Registry reg,Component c){
        RepresentationType rep = c.getLocalRepresentation();
        if( rep==null ) {
            ConceptType concept = reg.find(c.getConceptIdentity());
            return concept.getCoreRepresentation();
        }
        return c.getLocalRepresentation();
    }
    public static RepresentationType getLocalRepresentation(Component c) {
        if( c == null ) return null;
        return c.getLocalRepresentation();
    }
}

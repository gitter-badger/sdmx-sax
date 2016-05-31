/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.datastructure;

import sdmx.Registry;
import sdmx.commonreferences.ConceptReference;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemSchemeReference;
import sdmx.commonreferences.ItemSchemeReferenceBase;
import sdmx.commonreferences.Version;
import sdmx.structure.concept.ConceptType;

/**
 *
 * @author James
 */

public class MeasureDimensionType extends BaseDimensionType {
      public ConceptType findConcept(Registry reg, IDType id) {
          ItemSchemeReferenceBase ref1 = this.getLocalRepresentation().getEnumeration();
          ConceptReference ref2 = ConceptReference.create(ref1.getAgencyId(), ref1.getMaintainableParentId(), ref1.getVersion(), id);
          return reg.find(ref2);
      }
      public ConceptType findConcept(Registry reg, String id) {
          ItemSchemeReferenceBase ref1 = this.getLocalRepresentation().getEnumeration();
          ConceptReference ref2 = ConceptReference.create(ref1.getAgencyId(), ref1.getMaintainableParentId(), ref1.getVersion(), new IDType(id));
          return reg.find(ref2);
      }
}

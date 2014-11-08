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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sdmx.commonreferences.ConceptReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedIDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.VersionType;
import sdmx.structure.categorisation.CategorisationType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.xml.anyURI;

/**
 * <xs:complexType name="ConceptsType">
 * <xs:annotation>
 * <xs:documentation>ConceptsType describes the structure of the concepts
 * container. It contains one or more stand-alone concept or concept scheme,
 * which can be explicitly detailed or referenced from an external structure
 * document or registry service. This container may contain a mix of both
 * stand-alone concepts and concept schemes.</xs:documentation>
 * </xs:annotation>
 * <xs:sequence>
 * <xs:element name="ConceptScheme" type="ConceptSchemeType" minOccurs="0"
 * maxOccurs="unbounded">
 * <xs:annotation>
 * <xs:documentation>ConceptScheme provides the details of a concept scheme,
 * which is the descriptive information for an arrangement or division of
 * concepts into groups based on characteristics, which the objects have in
 * common. It contains a collection of concept definitions, that may be arranged
 * in simple hierarchies.</xs:documentation>
 * </xs:annotation>
 * <xs:unique name="ConceptScheme_UniqueConcept">
 * <xs:selector xpath="structure:Concept"/>
 * <xs:field xpath="@id"/>
 * </xs:unique>
 * </xs:element>
 * </xs:sequence>
 * </xs:complexType>
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
public class ConceptsType {

    List<ConceptSchemeType> conceptSchemes = new ArrayList<ConceptSchemeType>();

    /**
     * @return the categorisations
     */
    public List<ConceptSchemeType> getConceptSchemes() {
        return conceptSchemes;
    }

    /**
     * @param categorisations the categorisations to set
     */
    public void setConceptSchemes(List<ConceptSchemeType> cons) {
        this.conceptSchemes = cons;
    }

    public ConceptSchemeType findConceptScheme(String agency, String id, String vers) {
        IDType findid = new IDType(id);
        NestedNCNameIDType ag = new NestedNCNameIDType(agency);
        VersionType ver = new VersionType(vers);
        return findConceptScheme(ag, findid, ver);
    }

    public ConceptSchemeType findConceptScheme(NestedNCNameIDType agency2, NestedIDType findid, VersionType ver) {
        for (int i = 0; i < conceptSchemes.size(); i++) {
            if (conceptSchemes.get(i).identifiesMe(agency2, findid, ver)) {
                return conceptSchemes.get(i);
            }
        }
        return null;
    }

    public void dump() {
        for (int i = 0; i < conceptSchemes.size(); i++) {
            conceptSchemes.get(i).dump();
        }
    }
    /*
     * This method is used in sdmx 2.0 parsing to find a concept with the correct ID..
     * this is because the Dimension in the KeyFamily does not contain a complete reference
     * only an ID.. we lookup the Concept by it's ID, when we find a match, we can make a 
     * ConceptReference out of it with it's AgencyID and Version.
     */

    public ConceptSchemeType findConceptSchemeById(NestedIDType id) {
        ConceptSchemeType cs = null;
        for (int i = 0; i < conceptSchemes.size(); i++) {
            if (conceptSchemes.get(i).identifiesMe(id)) {
                if (cs == null) {
                    cs = conceptSchemes.get(i);
                } else {
                    int j = cs.getVersion().compareTo(conceptSchemes.get(i).getVersion());
                    switch (j) {
                        case -1: // Less
                            break;
                        case 0:  // Equal
                            break;
                        case 1:
                            // Our found conceptscheme has a greater version number.
                            cs = conceptSchemes.get(i);
                            break;
                    }
                }
            }
        }
        return cs;
    }

    public ConceptSchemeType findConceptSchemeByUrn(anyURI urn) {
        ConceptSchemeType cs = null;
        for (int i = 0; i < conceptSchemes.size(); i++) {
            if (conceptSchemes.get(i).identifiesMe(urn)) {
                if (cs == null) {
                    cs = conceptSchemes.get(i);
                }
            }
        }
        return cs;
    }

    public ConceptSchemeType findConceptScheme(NestedNCNameIDType agency, ConceptReferenceType ref) {
        //System.out.println("Looking for Ref:"+agency.toString()+":"+ref.getMaintainableParentId().toString()+":"+ref.getVersion());
        //ConceptSchemeType cs = findConceptScheme(agency, ref.getMaintainableParentId());
        //System.out.println("cs="+cs);
        return findConceptScheme(agency, ref.getMaintainableParentId(), ref.getVersion());
    }

    public ConceptType findConcept(NestedNCNameIDType agency, ConceptReferenceType ref) {
        ConceptSchemeType cs = findConceptScheme(agency, ref);
        return cs.findConcept(ref.getId());
    }
    public ConceptType findConcept(IDType id) {
        for(int i=0;i<conceptSchemes.size();i++) {
            ConceptType ct = conceptSchemes.get(i).findConcept(id);
            if( ct!=null) return ct;
        }
        return null;
    }

    public ConceptSchemeType findConceptScheme(NestedNCNameIDType mainAgencyId, NestedIDType id) {
        for (int i = 0; i < conceptSchemes.size(); i++) {
            if (conceptSchemes.get(i).getAgencyID().equals(mainAgencyId) && conceptSchemes.get(i).getId().equals(id)) {
                return conceptSchemes.get(i);
            }
        }
        return null;
    }
}

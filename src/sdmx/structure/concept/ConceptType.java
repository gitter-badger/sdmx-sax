/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.concept;

import sdmx.commonreferences.NCNameIDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.VersionType;
import sdmx.structure.base.ItemType;

/**
 *	<xs:complexType name="ConceptType">
		<xs:annotation>
			<xs:documentation>ConceptType describes the details of a concept. A concept is defined as a unit of knowledge created by a unique combination of characteristics. If a concept does not specify a TextFormat or a core representation, then the representation of the concept is assumed to be represented by any set of valid characters (corresponding to the xs:string datatype of W3C XML Schema).</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="ConceptBaseType">
				<xs:sequence>
					<xs:element name="CoreRepresentation" type="ConceptRepresentation" minOccurs="0">
						<xs:annotation>
							<xs:documentation></xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:element name="ISOConceptReference" type="ISOConceptReferenceType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>Provides a reference to an ISO 11179 concept.</xs:documentation>
						</xs:annotation>					
					</xs:element>
				</xs:sequence>
			</xs:extension>
		</xs:complexContent>
	</xs:complexType>

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
public class ConceptType extends ConceptBaseType {
    
    private ConceptRepresentation coreRep = null;
    private ISOConceptReferenceType isoConceptRef = null;
    
    private NestedNCNameIDType agencyID;
    
    private VersionType version = VersionType.ONE;
    
    
    
    public ConceptType() {
    }

    /**
     * @return the coreRep
     */
    public ConceptRepresentation getCoreRepresentation() {
        return coreRep;
    }

    /**
     * @param coreRep the coreRep to set
     */
    public void setCoreRepresentation(ConceptRepresentation coreRep) {
        this.coreRep = coreRep;
    }

    /**
     * @return the isoConceptRef
     */
    public ISOConceptReferenceType getIsoConceptRef() {
        return isoConceptRef;
    }

    /**
     * @param isoConceptRef the isoConceptRef to set
     */
    public void setIsoConceptRef(ISOConceptReferenceType isoConceptRef) {
        this.isoConceptRef = isoConceptRef;
    }
    /**
     * @return the agencyID
     */
    public NestedNCNameIDType getAgencyID() {
        return agencyID;
    }

    /**
     * @param agencyID the agencyID to set
     */
    public void setAgencyID(NestedNCNameIDType agencyId) {
        this.agencyID = agencyId;
    }
    /**
     * @return the version
     */
    public VersionType getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(VersionType version) {
        this.version = version;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import java.lang.ref.Reference;
import sdmx.common.Annotations;
import sdmx.common.ExternalReferenceAttributeGroup;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedIDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.RefBaseType;
import sdmx.commonreferences.ReferenceType;
import sdmx.commonreferences.VersionType;

/**
 * <xs:complexType name="MaintainableType" abstract="true">
 * <xs:annotation>
 * <xs:documentation>MaintainableType is an abstract base type for all
 * maintainable objects.</xs:documentation>
 * </xs:annotation>
 * <xs:complexContent>
 * <xs:extension base="MaintainableBaseType">
 * <xs:attribute name="agencyID" type="common:NestedNCNameIDType"
 * use="required">
 * <xs:annotation>
 * <xs:documentation>The agencyID must be provided, and identifies the
 * maintenance agency of the object.</xs:documentation>
 * </xs:annotation>
 * </xs:attribute>
 * <xs:attribute name="isFinal" type="xs:boolean" use="optional"
 * default="false">
 * <xs:annotation>
 * <xs:documentation>The isFinal attribute indicates whether the object is
 * unchangeable without versioning. If the value is true, the object must be
 * versioned upon change. If the final attribute is not supplied, then the
 * object is assumed not to be final. Note that all production objects must be
 * final.</xs:documentation>
 * </xs:annotation>
 * </xs:attribute>
 * <xs:attribute name="isExternalReference" type="xs:boolean" use="optional"
 * default="false">
 * <xs:annotation>
 * <xs:documentation>The isExternalReference attribute, if true, indicates that
 * the actual object is not defined the corresponding element, rather its full
 * details are defined elsewhere - indicated by either the registryURL, the
 * repositoryURL, or the structureURL. The purpose of this is so that each
 * structure message does not have to redefine object that are already defined
 * elsewhere. If the isExternalReference attribute is not set, then it is
 * assumed to be false, and the object should contain the full definition of its
 * contents. If more than one of the registryURL, the repositoryURL, and the
 * structureURL are supplied, then the application processing the object can
 * choose the method it finds best suited to retrieve the details of the
 * object.</xs:documentation>
 * </xs:annotation>
 * </xs:attribute>
 * <xs:attributeGroup ref="common:ExternalReferenceAttributeGroup"/>
 * </xs:extension>
 * </xs:complexContent>
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
public class MaintainableType extends MaintainableBaseType {

    private NestedNCNameIDType agencyID=null;
    private Boolean isFinal = null;
    private Boolean isExternalReference = null;
    private ExternalReferenceAttributeGroup externalReferences = null;

    /**
     * @return the agencyID
     */
    public NestedNCNameIDType getAgencyID() {
        return agencyID;
    }

    /**
     * @param agencyID the agencyID to set
     */
    public void setAgencyID(NestedNCNameIDType agencyID) {
        this.agencyID = agencyID;
    }

    /**
     * @return the isFinal
     */
    public Boolean isFinal() {
        return isFinal;
    }

    /**
     * @param isFinal the isFinal to set
     */
    public void setFinal(Boolean isFinal) {
        this.isFinal = isFinal;
    }

    /**
     * @return the isExternalReference
     */
    public Boolean isExternalReference() {
        return isExternalReference;
    }

    /**
     * @param isExternalReference the isExternalReference to set
     */
    public void setExternalReference(Boolean isExternalReference) {
        this.isExternalReference = isExternalReference;
    }

    /**
     * @return the externalReferences
     */
    public ExternalReferenceAttributeGroup getExternalReferences() {
        return externalReferences;
    }

    /**
     * @param externalReferences the externalReferences to set
     */
    public void setExternalReferences(ExternalReferenceAttributeGroup externalReferences) {
        this.externalReferences = externalReferences;
    }

    public boolean identifiesMe(String agency2, String id2, String vers2) {
        return identifiesMe(new NestedNCNameIDType(agency2), new IDType(id2), new VersionType(vers2));
    }

    public boolean identifiesMe(NestedNCNameIDType agency2, NestedIDType id2, VersionType vers2) {
        //System.out.println("Left=" + this.agencyID + "." + this.getId() + "." + this.getVersion());
        //System.out.println("Right=" + agency2 + "." + id2 + "." + vers2);
        if (vers2 == null||this.getVersion()==null) {
            if (this.agencyID.equals(agency2) && this.getId().equals(id2)) {
                return true;
            } else {
                //System.out.println("Doesn't Match!!");
                return false;
            }
        } else {
            if (this.agencyID.equals(agency2) && this.getId().equals(id2) && this.getVersion().equals(vers2)) {
                return true;
            } else {
                //System.out.println("Doesn't Match!!");
                return false;
            }
        }
    }

    public boolean identifiesMe(NestedNCNameIDType agency2, NestedIDType id2) {
        //System.out.println("Left=" + this.agencyID + "." + this.getId() + "." + this.getVersion());
        //System.out.println("Right=" + agency2 + "." + id2 + "." + vers2);
        if (this.agencyID.equals(agency2) && this.getId().equals(id2)) {
            return true;
        } else {
            //System.out.println("Doesn't Match!!");
            return false;
        }
    }
    public ReferenceType asReference() {
        RefBaseType ref = new RefBaseType(agencyID,getId(),getVersion(),null,null,null,false,null,null);
        ReferenceType reference = new ReferenceType(ref,getUri());
        return reference;
    }
}

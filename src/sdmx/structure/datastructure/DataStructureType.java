/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.datastructure;

import sdmx.commonreferences.DataStructureRefType;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.structure.base.Component;
import sdmx.structure.base.StructureType;
import sdmx.structure.dataflow.DataflowType;

/**
 * <xs:complexType name="DataStructureType">
 * <xs:annotation>
 * <xs:documentation>DataStructureType describes the structure of a data
 * structure definition. A data structure definition is defined as a collection
 * of metadata concepts, their structure and usage when used to collect or
 * disseminate data.</xs:documentation>
 * </xs:annotation>
 * <xs:complexContent>
 * <xs:restriction base="StructureType">
 * <xs:sequence>
 * <xs:element ref="common:Annotations" minOccurs="0"/>
 * <xs:element ref="common:Name" maxOccurs="unbounded"/>
 * <xs:element ref="common:Description" minOccurs="0" maxOccurs="unbounded"/>
 * <xs:sequence minOccurs="0">
 * <xs:element ref="DataStructureComponents"/>
 * </xs:sequence>
 * </xs:sequence>
 * </xs:restriction>
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
public class DataStructureType extends StructureType {

    private DataStructureComponents components = null;

    /**
     * @return the components
     */
    public DataStructureComponents getDataStructureComponents() {
        return components;
    }

    /**
     * @param components the components to set
     */
    public void setDataStructureComponents(DataStructureComponents components) {
        this.components = components;
    }

    public void dump() {
        System.out.println("*** Data Structure ***");
        System.out.println("Dimensions");
        for (DimensionType dim : components.getDimensionList().getDimensions()) {
            System.out.print(dim.getConceptIdentity().getRef().getId());
            if (dim.getLocalRepresentation().getEnumeration() != null) {
                System.out.print(" Codelist:" + dim.getLocalRepresentation().getEnumeration().getRef().getAgencyId() + ":" + dim.getLocalRepresentation().getEnumeration().getRef().getId() + ":" + dim.getLocalRepresentation().getEnumeration().getRef().getVersion());
            }
            if (dim.getConceptIdentity()!=null ) {
                System.out.print(" Concept Identity:" + dim.getConceptIdentity().getRef().getAgencyId()+":"+dim.getConceptIdentity().getRef().getId()+":"+dim.getConceptIdentity().getRef().getVersion());
            }else {
                System.out.println("***** NULL CONCEPT IDENTITY ******");
            }
            if (dim.getLocalRepresentation()!=null&&dim.getLocalRepresentation().getTextFormat() != null) {
                System.out.print(" Text Format:" + dim.getLocalRepresentation().getTextFormat().getTextType());
            }
            System.out.println();
        }
        System.out.println("Attributes");
        for (AttributeType dim : components.getAttributeList().getAttributes()) {
            System.out.print(dim.getConceptIdentity().getRef().getId());
            if (dim.getLocalRepresentation()!=null&&dim.getLocalRepresentation().getEnumeration() != null) {
                System.out.print(" Codelist:" + dim.getLocalRepresentation().getEnumeration().getRef().getAgencyId() + ":" + dim.getLocalRepresentation().getEnumeration().getRef().getId() + ":" + dim.getLocalRepresentation().getEnumeration().getRef().getVersion());
            }
            if (dim.getConceptIdentity()!=null ) {
                System.out.print(" Concept Identity:" + dim.getConceptIdentity().getRef().getAgencyId()+":"+dim.getConceptIdentity().getRef().getId()+":"+dim.getConceptIdentity().getRef().getVersion());
            }else {
                System.out.println("***** NULL CONCEPT IDENTITY ******");
            }
            if (dim.getLocalRepresentation()!=null&&dim.getLocalRepresentation().getTextFormat() != null) {
                System.out.print(" Text Format:" + dim.getLocalRepresentation().getTextFormat().getTextType());
            }
            System.out.println();
        }
        System.out.println("Measures");
        for (MeasureDimensionType dim : components.getMeasureList().getMeasures()) {
            System.out.print(dim.getConceptIdentity().getRef().getId());
            if (dim.getLocalRepresentation()!=null&&dim.getLocalRepresentation().getEnumeration() != null) {
                System.out.print(" Codelist:" + dim.getLocalRepresentation().getEnumeration().getRef().getAgencyId() + ":" + dim.getLocalRepresentation().getEnumeration().getRef().getId() + ":" + dim.getLocalRepresentation().getEnumeration().getRef().getVersion());
            }
            if (dim.getConceptIdentity()!=null ) {
                System.out.print(" Concept Identity:" + dim.getConceptIdentity().getRef().getAgencyId()+":"+dim.getConceptIdentity().getRef().getId()+":"+dim.getConceptIdentity().getRef().getVersion());
            }else {
                System.out.println("***** NULL CONCEPT IDENTITY ******");
            }
            if (dim.getLocalRepresentation()!=null&&dim.getLocalRepresentation().getTextFormat() != null) {
                System.out.print(" Text Format:" + dim.getLocalRepresentation().getTextFormat().getTextType());
            }
            System.out.println();
        }
        System.out.println("Time");
        TimeDimensionType dim = components.getDimensionList().getTimeDimension();
        if (dim != null) {
            System.out.print(dim.getConceptIdentity().getRef().getId());
            if (dim.getLocalRepresentation()!=null&&dim.getLocalRepresentation().getEnumeration() != null) {
                System.out.print(" Codelist:" + dim.getLocalRepresentation().getEnumeration().getRef().getAgencyId() + ":" + dim.getLocalRepresentation().getEnumeration().getRef().getId() + ":" + dim.getLocalRepresentation().getEnumeration().getRef().getVersion());
            }
            if (dim.getConceptIdentity()!=null ) {
                System.out.print(" Concept Identity:" + dim.getConceptIdentity().getRef().getAgencyId()+":"+dim.getConceptIdentity().getRef().getId()+":"+dim.getConceptIdentity().getRef().getVersion());
            }else {
                System.out.println("***** NULL CONCEPT IDENTITY ******");
            }
            if (dim.getLocalRepresentation()!=null&&dim.getLocalRepresentation().getTextFormat() != null) {
                System.out.print(" Text Format:" + dim.getLocalRepresentation().getTextFormat().getTextType());
            }
            System.out.println();
        }
        PrimaryMeasure dim2 = components.getMeasureList().getPrimaryMeasure();
        if (dim2 != null) {
            System.out.print(dim2.getConceptIdentity().getRef().getId());
            if (dim2.getLocalRepresentation()!=null&&dim2.getLocalRepresentation().getEnumeration() != null) {
                System.out.print(" Codelist:" + dim2.getLocalRepresentation().getEnumeration().getRef().getAgencyId() + ":" + dim2.getLocalRepresentation().getEnumeration().getRef().getId() + ":" + dim2.getLocalRepresentation().getEnumeration().getRef().getVersion());
            }
            if (dim2.getConceptIdentity()!=null ) {
                System.out.print(" Concept Identity:" + dim2.getConceptIdentity().getRef().getAgencyId()+":"+dim2.getConceptIdentity().getRef().getId()+":"+dim2.getConceptIdentity().getRef().getVersion());
            }else {
                System.out.println("***** NULL CONCEPT IDENTITY ******");
            }
            if (dim2.getLocalRepresentation()!=null&&dim2.getLocalRepresentation().getTextFormat() != null) {
                System.out.print(" Text Format:" + dim2.getLocalRepresentation().getTextFormat().getTextType());
            }
            System.out.println();
        }
    }
    public Component findComponent(String col) {
        return findComponent(new IDType(col));
    }
    public Component findComponent(IDType col) {
        for (DimensionType dim : components.getDimensionList().getDimensions()) {
            if( dim.identifiesMe(col))return dim;
        }
        for (AttributeType dim : components.getAttributeList().getAttributes()) {
            if( dim.identifiesMe(col))return dim;
        }
        //System.out.println("Measure3="+components.getMeasureList().getMeasures().size());
        for (MeasureDimensionType dim : components.getMeasureList().getMeasures()) {
            //System.out.println("Dim="+dim.getId()+":concept="+col);
            if( dim.identifiesMe(col))return dim;
        }
        TimeDimensionType dim = components.getDimensionList().getTimeDimension();
        if( dim.identifiesMe(col))return dim;
        PrimaryMeasure dim2 = components.getMeasureList().getPrimaryMeasure();
        if( dim2.identifiesMe(col))return dim2;
        return null;
    }
    public DataStructureReferenceType asReference() {
        DataStructureRefType ref = new DataStructureRefType(getAgencyID(),getId(),getVersion());
        DataStructureReferenceType reference = new DataStructureReferenceType(ref,getUri());
        return reference;
    }
    public DataflowType asDataflow() {
        DataflowType dataFlow = new DataflowType();
        dataFlow.setNames(getNames());
        dataFlow.setDescriptions(getDescriptions());
        dataFlow.setStructure(asReference());
        dataFlow.setAnnotations(getAnnotations());
        dataFlow.setAgencyID(getAgencyID());
        dataFlow.setId(getId());
        dataFlow.setVersion(getVersion());
        return dataFlow;
    }
}


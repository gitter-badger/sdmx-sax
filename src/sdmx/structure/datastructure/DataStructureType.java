/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.datastructure;

import sdmx.commonreferences.IDType;
import sdmx.structure.base.Component;
import sdmx.structure.base.StructureType;

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
            if (dim.getLocalRepresentation()!=null&&dim.getLocalRepresentation().getTextFormat() != null) {
                System.out.print(" Text Format:" + dim.getLocalRepresentation().getTextFormat().getTextType());
            }
            System.out.println();
        }
        System.out.println("Time");
        TimeDimensionType dim = components.getTimeDimension();
        if (dim != null) {
            System.out.print(dim.getConceptIdentity().getRef().getId());
            if (dim.getLocalRepresentation()!=null&&dim.getLocalRepresentation().getEnumeration() != null) {
                System.out.print(" Codelist:" + dim.getLocalRepresentation().getEnumeration().getRef().getAgencyId() + ":" + dim.getLocalRepresentation().getEnumeration().getRef().getId() + ":" + dim.getLocalRepresentation().getEnumeration().getRef().getVersion());
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
            if (dim2.getLocalRepresentation()!=null&&dim2.getLocalRepresentation().getTextFormat() != null) {
                System.out.print(" Text Format:" + dim2.getLocalRepresentation().getTextFormat().getTextType());
            }
            System.out.println();
        }
    }
    public Component findComponent(IDType col) {
        for (DimensionType dim : components.getDimensionList().getDimensions()) {
            if( dim.identifiesMe(col))return dim;
        }
        for (AttributeType dim : components.getAttributeList().getAttributes()) {
            if( dim.identifiesMe(col))return dim;
        }
        for (MeasureDimensionType dim : components.getMeasureList().getMeasures()) {
            if( dim.identifiesMe(col))return dim;
        }
        TimeDimensionType dim = components.getTimeDimension();
        if( dim.identifiesMe(col))return dim;
        PrimaryMeasure dim2 = components.getMeasureList().getPrimaryMeasure();
        if( dim2.identifiesMe(col))return dim2;
        return null;
    }
}

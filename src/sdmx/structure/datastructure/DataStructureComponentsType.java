/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.datastructure;

import sdmx.structure.base.Component;
import sdmx.structure.concept.ConceptType;

/**
 *	<xs:complexType name="DataStructureComponentsType">
		<xs:annotation>
			<xs:documentation>DataStructureComponentsType describes the structure of the grouping to the sets of metadata concepts that have a defined structural role in the data structure definition. At a minimum at least one dimension and a primary measure must be defined.</xs:documentation>
		</xs:annotation>		
		<xs:complexContent>	
			<xs:extension base="DataStructureComponentsBaseType">
				<xs:sequence>
					<xs:element ref="DimensionList"/>
					<xs:element ref="Group" minOccurs="0" maxOccurs="unbounded"/>
					<xs:element ref="AttributeList" minOccurs="0"/>
					<xs:element ref="MeasureList"/>
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
public class DataStructureComponentsType extends DataStructureComponentsBaseType {
     private DimensionListType dimensionList=null;    
     private Group group=null;
     private AttributeListType attributeList = null;
     private MeasureListType measureList = null;
     

    /**
     * @return the dimensionList
     */
    public DimensionListType getDimensionList() {
        return dimensionList;
    }

    /**
     * @param dimensionList the dimensionList to set
     */
    public void setDimensionList(DimensionListType dimensionList) {
        this.dimensionList = dimensionList;
    }

    /**
     * @return the group
     */
    public Group getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * @return the attributeList
     */
    public AttributeListType getAttributeList() {
        return attributeList;
    }

    /**
     * @param attributeList the attributeList to set
     */
    public void setAttributeList(AttributeListType attributeList) {
        this.attributeList = attributeList;
    }

    /**
     * @return the measureList
     */
    public MeasureListType getMeasureList() {
        return measureList;
    }

    /**
     * @param measureList the measureList to set
     */
    public void setMeasureList(MeasureListType measureList) {
        this.measureList = measureList;
    }


    public Component findDimension(String name) {
        for(int i=0;i<dimensionList.size();i++) {
            //System.out.println("Dim="+dimensionList);
            //System.out.println("Dim2="+dimensionList.getDimension(i));
            //System.out.println("Dim3="+dimensionList.getDimension(i).getLocalRepresentation().getEnumeration().getRef().getId());
            //System.out.println("Dim4="+dimensionList.getDimension(i).getConceptIdentity().getRef());
            //System.out.println("Dim5="+dimensionList.getDimension(i).getConceptIdentity().getRef().getId());
            if( dimensionList.getDimension(i).getConceptIdentity().getRef().getId().equals(name))return dimensionList.getDimension(i);
        }
        for(int i=0;i<attributeList.size();i++) {
            if( attributeList.getAttribute(i).getConceptIdentity().getRef().getId().equals(name))return attributeList.getAttribute(i);
        }
        for(int i=0;i<measureList.size();i++) {
            if( measureList.getMeasure(i).getConceptIdentity().getRef().getId().equals(name))return measureList.getMeasure(i);
        }
        if( dimensionList.getTimeDimension()!=null&& dimensionList.getTimeDimension().getConceptIdentity().getRef().getId().equals(name))return dimensionList.getTimeDimension();
        if( measureList.getPrimaryMeasure()!=null&&measureList.getPrimaryMeasure().getConceptIdentity().getRef().getId().equals(name))return measureList.getPrimaryMeasure();
        // These are the 2 hard coded values in the Sdmx Specification
        if( "TIME_PERIOD".equals(name)) {
            return dimensionList.getTimeDimension();
        }
        if( "OBS_VALUE".equals(name) ) {
            return measureList.getPrimaryMeasure();
        }
//        System.out.println("Can't Find:"+name);
        return null;
    }
    public int size() {
        return dimensionList.size()+attributeList.size()+measureList.size()+((dimensionList.getTimeDimension()!=null)?1:0)+(measureList.getPrimaryMeasure()!=null?1:0);
    }
}

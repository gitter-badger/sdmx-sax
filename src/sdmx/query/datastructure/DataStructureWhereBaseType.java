/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.datastructure;

import sdmx.common.TimeRangeValueType;
import sdmx.commonreferences.ConceptReferenceType;
import sdmx.commonreferences.DataStructureEnumerationSchemeReferenceType;
import sdmx.commonreferences.VersionQueryType;
import sdmx.commonreferences.types.MaintainableTypeCodelistType;
import sdmx.query.base.AnnotationWhereType;
import sdmx.query.base.QueryIDType;
import sdmx.query.base.QueryNestedIDType;
import sdmx.query.base.QueryTextType;
import sdmx.query.base.StructureWhereType;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="DataStructureWhereBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>DataStructureWhereBaseType is an abstract base type that forms the basis of the DataStructureWhereType.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureWhereType">
				<xs:sequence>
					<xs:element name="Annotation" type="AnnotationWhereType" minOccurs="0"/>
					<xs:element name="URN" type="xs:anyURI" minOccurs="0"/>
					<xs:element name="ID" type="QueryIDType" minOccurs="0"/>
					<xs:element name="Name" type="QueryTextType" minOccurs="0"/>
					<xs:element name="Description" type="QueryTextType" minOccurs="0"/>
					<xs:element name="Version" type="common:VersionQueryType" minOccurs="0"/>
					<xs:element name="VersionTo" type="common:TimeRangeValueType" minOccurs="0"/>
					<xs:element name="VersionFrom" type="common:TimeRangeValueType" minOccurs="0"/>
					<xs:element name="VersionActive" type="xs:boolean" minOccurs="0"/>
					<xs:element name="AgencyID" type="QueryNestedIDType" minOccurs="0"/>
					<xs:element name="UsedConcept" type="common:ConceptReferenceType" minOccurs="0" maxOccurs="unbounded"/>
					<xs:element name="UsedRepresentation" type="common:DataStructureEnumerationSchemeReferenceType" minOccurs="0" maxOccurs="unbounded"/>
					<xs:sequence minOccurs="0" maxOccurs="unbounded">
						<xs:element ref="GroupWhere"/>
					</xs:sequence>
				</xs:sequence>
				<xs:attribute name="type" type="common:MaintainableTypeCodelistType" use="optional" fixed="DataStructure"/>
			</xs:restriction>
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
public class DataStructureWhereBaseType extends StructureWhereType {
    public DataStructureWhereBaseType() {
        super.setType(MaintainableTypeCodelistType.DATASTRUCTURE);
    }
}

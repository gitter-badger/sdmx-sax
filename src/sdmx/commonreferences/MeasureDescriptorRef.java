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
package sdmx.commonreferences;

import sdmx.commonreferences.types.ComponentListTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *<xs:complexType name="MeasureDescriptorRefType">
		<xs:annotation>
			<xs:documentation>MeasureDescriptorRefType contains a reference to the measure descriptor within a data structure definition.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentListRefBaseType">
				<xs:attribute name="id" type="IDType" use="required" fixed="MEASURE_DESCRIPTOR"/>
				<xs:attribute name="class" type="ComponentListTypeCodelistType" use="optional" fixed="MeasureDescriptor"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="datastructure"/>
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
 
 *  SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */

public class MeasureDescriptorRef extends ComponentListRefBase {
    public MeasureDescriptorRef(IDType id){
        super(null,null,null,id,ComponentListTypeCodelistType.MEASUREDESCRIPTOR,StructurePackageTypeCodelistType.DATASTRUCTURE);
    }
}

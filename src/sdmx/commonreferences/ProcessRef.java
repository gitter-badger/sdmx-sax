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

import sdmx.commonreferences.types.MaintainableTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *
 * <xs:complexType name="ProcessRefType">
		<xs:annotation>
			<xs:documentation>ProcessRefType contains a set of reference fields for a process.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableRefBaseType">
				<xs:attribute name="class" type="MaintainableTypeCodelistType" use="optional" fixed="Process"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="process"/>
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

public class ProcessRef extends MaintainableRefBase {
    public ProcessRef(){
        super(null,null,null,MaintainableTypeCodelistType.PROCESS,PackageTypeCodelistType.PROCESS);
    }
    
}

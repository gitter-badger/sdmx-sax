/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="ProcessStepRefType">
		<xs:annotation>
			<xs:documentation>ProcessStepRefType provides for a reference to a process step through its id. Support for referencing nested process steps is provided through a nested identifier.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ChildObjectRefBaseType">
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional" fixed="ProcessStep"/>
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

public class ProcessStepRef extends ChildObjectRefBase {
    public ProcessStepRef(){
        super(null,null,null,null,ObjectTypeCodelistType.PROCESSSTEP,PackageTypeCodelistType.PROCESS);
    }
    
}

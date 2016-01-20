/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.datastructure;

import java.util.List;
import sdmx.structure.base.ComponentList;
import sdmx.structure.base.GroupingType;

/**
 *	<xs:complexType name="DataStructureComponentsBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>DataStructureComponentsBaseType is an abstract base type the serves as the basis for the DataStructureComponentsType. This type is necessary to allow for valid substitutions of component lists.</xs:documentation>
		</xs:annotation>		
		<xs:complexContent>	
			<xs:restriction base="GroupingType">
			</xs:restriction>
		</xs:complexContent>	
	</xs:complexType>
 * @author James
 */
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
 */
public class DataStructureComponentsBaseType extends GroupingType {
/*
    @Override
    public List<ComponentList> getComponents() {
        return null;
    }

    @Override
    public void setComponents(List<ComponentList> components) {
        return;
    }
  */  
}

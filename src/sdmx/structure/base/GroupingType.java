/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import java.util.ArrayList;
import java.util.List;

/**
 *	<xs:complexType name="GroupingType" abstract="true">
		<xs:annotation>
			<xs:documentation>GroupType is an abstract base type for specific structure groupings. It contains a collection of component lists. Concrete instances of this should restrict to specific concrete component lists.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:sequence minOccurs="0" maxOccurs="unbounded">
				<xs:element ref="ComponentList"/>
			</xs:sequence>
		</xs:sequence>
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
public abstract class GroupingType {
    /**
     * @return the components
     */
    public abstract List<ComponentList> getComponents();

    /**
     * @param components the components to set
     */
    public abstract void setComponents(List<ComponentList> components);
}

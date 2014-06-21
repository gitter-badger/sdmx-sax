/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import java.util.ArrayList;
import java.util.List;

/**
 *	<xs:complexType name="ComponentListType" abstract="true">
		<xs:annotation>
			<xs:documentation>ComponentListType is an abstract base type for all component lists. It contains a collection of components. Concrete types should restrict this to specific concrete components.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="IdentifiableType">
				<xs:sequence>
					<xs:sequence minOccurs="0" maxOccurs="unbounded">
						<xs:element ref="Component"/>
					</xs:sequence>
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
public class ComponentListType extends IdentifiableType {
    private List<Component> components = new ArrayList<Component>();

    /**
     * @return the components
     */
    public List<Component> getComponents() {
        return components;
    }
    public int size() { return components.size(); }
}

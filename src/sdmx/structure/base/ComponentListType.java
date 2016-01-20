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

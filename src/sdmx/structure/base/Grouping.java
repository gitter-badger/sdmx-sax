/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import java.util.List;

/**
 *	<xs:element name="Grouping" type="GroupingType" abstract="true">
		<xs:annotation>
			<xs:documentation>Grouping is an abstract element that serves as a substitution head for all structure groupings. Groupings contain a collection of component lists for a structure. Concrete instances of this must use a concrete instance of GroupingType.</xs:documentation>
		</xs:annotation>
	</xs:element>
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
public class Grouping extends GroupingType {

    @Override
    public List<ComponentList> getComponents() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setComponents(List<ComponentList> components) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

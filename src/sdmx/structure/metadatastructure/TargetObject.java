/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

import sdmx.structure.base.ComponentType;

/**
 *	<xs:complexType name="TargetObject" abstract="true">
		<xs:annotation>
			<xs:documentation>TargetObject is an abstract base type from which all target objects of a metadata target are derived. It is based on a component. Implementations of this will refined the local representation so that the allowed values accurately reflect the representation of the target object reference.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="ComponentType"/>
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
public class TargetObject extends ComponentType {
    
}

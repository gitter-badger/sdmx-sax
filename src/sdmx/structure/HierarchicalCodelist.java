/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure;

/**
 *	<xs:complexType name="HierarchicalCodelistsType">
		<xs:annotation>
			<xs:documentation>HierarchicalCodelistsType describes the structure of the hierarchical code lists container. It contains one or more hierarchical code list, which can be explicitly detailed or referenced from an external structure document or registry service.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="HierarchicalCodelist" type="HierarchicalCodelistType" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>HierarchicalCodelist provides the details of a hierarchical code list, which is defined as an organised collection of codes that may participate in many parent/child relationships with other codes in the list, as defined by one or more hierarchy of the list.</xs:documentation>
				</xs:annotation>
				<xs:unique name="HierarchicalCodelist_UniqueHierarchy">
					<xs:selector xpath="structure:Hierarchy"/>
					<xs:field xpath="@id"/>
				</xs:unique>	
				<xs:unique name="HierarchicalCodelist_UniqueCodelistAlias">
					<xs:selector xpath="structure:IncludedCodelistReference"/>
					<xs:field xpath="@alias"/>
				</xs:unique>
			</xs:element>
		</xs:sequence>
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
public class HierarchicalCodelist {
    
}

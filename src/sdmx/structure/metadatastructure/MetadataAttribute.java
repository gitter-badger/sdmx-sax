/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

/**
 *	<xs:element name="MetadataAttribute" type="MetadataAttributeType" substitutionGroup="Component">
		<xs:annotation>
			<xs:documentation>MetadataAttribute defines the a metadata attribute, which is the value of an attribute, such as the instance of a coded or uncoded attribute in a metadata structure definition.</xs:documentation>
		</xs:annotation>
		<xs:unique name="MetadataAttribute_Unique_MetadataAttribute">
			<xs:selector xpath="structure:MetadataAttribute"/>
			<xs:field xpath="@id"/>
		</xs:unique>
	</xs:element>

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
public class MetadataAttribute extends MetadataAttributeType {
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import java.util.List;

/**
 *	<xs:complexType name="AnnotableWhereType" abstract="true">
		<xs:annotation>
			<xs:documentation>AnnotableWhereType is an abstract base type for querying an annotable artefact.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="Annotation" type="AnnotationWhereType" minOccurs="0">
				<xs:annotation>
					<xs:documentation>Annotation is a parameter for matching the details of an annotatable object's annotations. It allows for querying based on the details of an annotation.</xs:documentation>
				</xs:annotation>
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
public class AnnotableWhereType {
    List<AnnotationWhereType> query = null;
    
}

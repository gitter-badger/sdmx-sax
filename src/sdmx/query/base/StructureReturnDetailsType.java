/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

/**
 *	<xs:complexType name="StructureReturnDetailsType">
		<xs:annotation>
			<xs:documentation>StructureReturnDetailsType defines the structure of the return details for any structural metadata query.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="StructureReturnDetailsBaseType">
				<xs:sequence>
					<xs:element name="References" type="ReferencesType">
						<xs:annotation>
							<xs:documentation>References is used to communicate how objects that reference or are referenced by the object(s) being queried should be returned.</xs:documentation>
						</xs:annotation>
					</xs:element>
				</xs:sequence>
				<xs:attribute name="returnMatchedArtefact" type="xs:boolean" default="true">
					<xs:annotation>
						<xs:documentation>The returnMatchedArtefact attribute indicates whether the object(s) match by the query should be returned. If this is set to false, only the reference objects from the match object(s) will be returned.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
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
public class StructureReturnDetailsType extends StructureReturnDetailsBaseType {
    private Boolean returnMatchedArtefact = null;

    /**
     * @return the returnMatchedArtefact
     */
    public Boolean getReturnMatchedArtefact() {
        return returnMatchedArtefact;
    }

    /**
     * @param returnMatchedArtefact the returnMatchedArtefact to set
     */
    public void setReturnMatchedArtefact(Boolean returnMatchedArtefact) {
        this.returnMatchedArtefact = returnMatchedArtefact;
    }
}

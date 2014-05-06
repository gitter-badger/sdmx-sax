/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;
/**
 *	<xs:complexType name="MaintainableReturnDetailsType">
		<xs:annotation>
			<xs:documentation>MaintainableReturnDetailsType defines the structure for the return details of a non-item scheme maintainable object. It eliminates the detail options that are specific to searching an item scheme</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureReturnDetailsType">
				<xs:sequence>
					<xs:element name="References" type="ReferencesType"/>
				</xs:sequence>
				<xs:attribute name="detail" type="MaintainableReturnDetailType" default="Full"/>
				<xs:attribute name="returnMatchedArtefact" type="xs:boolean" default="true"/>
			</xs:restriction>
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
public class MaintainableReturnDetailsType extends StructureReturnDetailsType {
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

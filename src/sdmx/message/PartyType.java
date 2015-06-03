/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.message;

import java.util.List;
import sdmx.common.Name;
import sdmx.commonreferences.IDType;
import sdmx.structure.base.NameableType;

/**
 *	<xs:complexType name="PartyType">
		<xs:annotation>
			<xs:documentation>PartyType defines the information which is sent about various parties such as senders and receivers of messages.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element ref="common:Name" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>Name is a human-readable name of the party.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="Contact" type="ContactType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>Contact provides contact information for the party in regard to the transmission of the message.</xs:documentation>
				</xs:annotation>
			</xs:element>
		</xs:sequence>
		<xs:attribute name="id" type="common:IDType" use="required">
			<xs:annotation>
				<xs:documentation>The id attribute holds the identification of the party.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
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
public class PartyType extends NameableType {
    private List<Name> names;
    private List<ContactType> contacts;
    private IDType id;
    public PartyType(){
        super();
    
    }

    /**
     * @return the name
     */
    public List<Name> getNames() {
        return names;
    }

    /**
     * @param name the name to set
     */
    public void setNames(List<Name> name) {
        this.names = name;
    }

    /**
     * @return the contact
     */
    public List<ContactType> getContacts() {
        return contacts;
    }

    /**
     * @param contact the contact to set
     */
    public void setContacts(List<ContactType> contact) {
        this.contacts = contact;
    }

    /**
     * @return the id
     */
    public IDType getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(IDType id) {
        this.id = id;
    }
}

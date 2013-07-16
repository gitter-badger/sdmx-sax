/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.message;

import java.util.List;
import sdmx.common.Name;
import sdmx.commonreferences.IDType;

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
public class PartyType {
    private List<Name> names;
    private List<ContactType> contacts;
    private IDType id;
    public PartyType(){}

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

/*
    This file is part of sdmx-sax.

    sdmx-sax is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    sdmx-sax is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with sdmx-sax.  If not, see <http://www.gnu.org/licenses/>.
    Copyright (C) 2015 James Gardner
*/
package sdmx.message;

import java.util.List;
import sdmx.common.Name;
import sdmx.common.TextType;
import sdmx.xml.anyURI;

/**
 *<xs:complexType name="ContactType">
		<xs:annotation>
			<xs:documentation>ContactType provides defines the contact information about a party.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element ref="common:Name" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>Name contains a human-readable name for the contact.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="Department" type="common:TextType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>Department is designation of the organisational structure by a linguistic expression, within which the contact person works.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="Role" type="common:TextType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>Role is the responsibility of the contact person with respect to the object for which this person is the contact.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:choice minOccurs="0" maxOccurs="unbounded">
				<xs:element name="Telephone" type="xs:string">
					<xs:annotation>
						<xs:documentation>Telephone holds the telephone number for the contact person.</xs:documentation>
					</xs:annotation>
				</xs:element>
				<xs:element name="Fax" type="xs:string">
					<xs:annotation>
						<xs:documentation>Fax holds the fax number for the contact person.</xs:documentation>
					</xs:annotation>
				</xs:element>
				<xs:element name="X400" type="xs:string">
					<xs:annotation>
						<xs:documentation>X400 holds the X.400 address for the contact person.</xs:documentation>
					</xs:annotation>
				</xs:element>
				<xs:element name="URI" type="xs:anyURI">
					<xs:annotation>
						<xs:documentation>URI holds an information URL for the contact person.</xs:documentation>
					</xs:annotation>
				</xs:element>
				<xs:element name="Email" type="xs:string">
					<xs:annotation>
						<xs:documentation>Email holds the email address for the contact person.</xs:documentation>
					</xs:annotation>
				</xs:element>
			</xs:choice>
		</xs:sequence>
	</xs:complexType>
 * @author James
 */

public class ContactType {
			private List<Name> names;
			private List<TextType> departments;
			private List<TextType> roles;

                        private List<String> telephones;
                        private List<String> faxes;
                        private List<String> x400s;
			private List<anyURI> uris;
                        private List<String> emails;

    /**
     * @return the names
     */
    public List<Name> getNames() {
        return names;
    }

    /**
     * @param names the names to set
     */
    public void setNames(List<Name> names) {
        this.names = names;
    }

    /**
     * @return the departments
     */
    public List<TextType> getDepartments() {
        return departments;
    }

    /**
     * @param departments the departments to set
     */
    public void setDepartments(List<TextType> departments) {
        this.departments = departments;
    }

    /**
     * @return the roles
     */
    public List<TextType> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(List<TextType> roles) {
        this.roles = roles;
    }

    /**
     * @return the telephones
     */
    public List<String> getTelephones() {
        return telephones;
    }

    /**
     * @param telephones the telephones to set
     */
    public void setTelephones(List<String> telephones) {
        this.telephones = telephones;
    }

    /**
     * @return the faxes
     */
    public List<String> getFaxes() {
        return faxes;
    }

    /**
     * @param faxes the faxes to set
     */
    public void setFaxes(List<String> faxes) {
        this.faxes = faxes;
    }

    /**
     * @return the x400s
     */
    public List<String> getX400s() {
        return x400s;
    }

    /**
     * @param x400s the x400s to set
     */
    public void setX400s(List<String> x400s) {
        this.x400s = x400s;
    }

    /**
     * @return the uris
     */
    public List<anyURI> getUris() {
        return uris;
    }

    /**
     * @param uris the uris to set
     */
    public void setUris(List<anyURI> uris) {
        this.uris = uris;
    }

    /**
     * @return the emails
     */
    public List<String> getEmails() {
        return emails;
    }

    /**
     * @param emails the emails to set
     */
    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

}

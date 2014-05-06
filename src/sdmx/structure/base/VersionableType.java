/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import sdmx.commonreferences.VersionType;
import sdmx.xml.DateTime;

/**
 *	<xs:complexType name="VersionableType" abstract="true">
		<xs:annotation>
			<xs:documentation>VersionableType is an abstract base type for all versionable objects.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="NameableType">
				<xs:attribute name="version" type="common:VersionType" use="optional" default="1.0">
					<xs:annotation>
						<xs:documentation>This version attribute holds a version number in the format of #[.#]+ (see common:VersionType definition for details). If not supplied, the version number is defaulted to 1.0.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="validFrom" type="xs:dateTime" use="optional">
					<xs:annotation>
						<xs:documentation>The validFrom attribute provides the inclusive start date for providing supplemental validity information about the version.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="validTo" type="xs:dateTime" use="optional">
					<xs:annotation>
						<xs:documentation>The validTo attribute provides the inclusive end date for providing supplemental validity information about the version.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:extension>
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
public class VersionableType extends NameableType {
    public static void main(String args[]) {}
    private VersionType version = VersionType.ONE;
    private DateTime validFrom;
    private DateTime validTo;

    /**
     * @return the version
     */
    public VersionType getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(VersionType version) {
        this.version = version;
    }

    /**
     * @return the validFrom
     */
    public DateTime getValidFrom() {
        return validFrom;
    }

    /**
     * @param validFrom the validFrom to set
     */
    public void setValidFrom(DateTime validFrom) {
        this.validFrom = validFrom;
    }

    /**
     * @return the validTo
     */
    public DateTime getValidTo() {
        return validTo;
    }

    /**
     * @param validTo the validTo to set
     */
    public void setValidTo(DateTime validTo) {
        this.validTo = validTo;
    }
    
}

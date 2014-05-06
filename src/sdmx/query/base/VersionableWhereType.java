/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import sdmx.common.TimeRangeValueType;
import sdmx.commonreferences.VersionQueryType;

/**
 *	<xs:complexType name="VersionableWhereType" abstract="true">
		<xs:annotation>
			<xs:documentation>VersionableQueryType is an abstract base type that serves as the basis for any query for a versionable object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="NameableWhereType">
				<xs:sequence>
					<xs:element name="Version" type="common:VersionQueryType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>Version is used to match the version of the versioned object. The version can be specified as either an explicit version number, or a late bound query where the latest version of an object will be returned.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:element name="VersionTo" type="common:TimeRangeValueType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>VersionTo is used to specify a range which the start date of the validity period of version should fall within to create a successful match.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:element name="VersionFrom" type="common:TimeRangeValueType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>VersionFrom is used to specify a range which the end date of the validity period of version should fall within to create a successful match.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:element name="VersionActive" type="xs:boolean" minOccurs="0">
						<xs:annotation>
							<xs:documentation>VersionActive is used to request object with active or inactive versions, base on the version validity dates. A value of true indicates that only objects where the current date is within the validity period of the version will be matched.</xs:documentation>
						</xs:annotation>
					</xs:element>
				</xs:sequence>
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
public class VersionableWhereType extends NameableWhereType {
    private VersionQueryType version = null;
    private TimeRangeValueType versionTo = null;
    private TimeRangeValueType versionFrom = null;
    private Boolean versionActive = null;

    /**
     * @return the version
     */
    public VersionQueryType getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(VersionQueryType version) {
        this.version = version;
    }

    /**
     * @return the versionTo
     */
    public TimeRangeValueType getVersionTo() {
        return versionTo;
    }

    /**
     * @param versionTo the versionTo to set
     */
    public void setVersionTo(TimeRangeValueType versionTo) {
        this.versionTo = versionTo;
    }

    /**
     * @return the versionFrom
     */
    public TimeRangeValueType getVersionFrom() {
        return versionFrom;
    }

    /**
     * @param versionFrom the versionFrom to set
     */
    public void setVersionFrom(TimeRangeValueType versionFrom) {
        this.versionFrom = versionFrom;
    }

    /**
     * @return the versionActive
     */
    public Boolean getVersionActive() {
        return versionActive;
    }

    /**
     * @param versionActive the versionActive to set
     */
    public void setVersionActive(Boolean versionActive) {
        this.versionActive = versionActive;
    }
    
}

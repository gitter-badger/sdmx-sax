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
package sdmx.common;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *	<xs:attributeGroup name="ExternalReferenceAttributeGroup">
		<xs:attribute name="serviceURL" type="xs:anyURI" use="optional">
			<xs:annotation>
				<xs:documentation>The serviceURL attribute indicates the URL of an SDMX SOAP web service from which the details of the object can be retrieved. Note that this can be a registry or and SDMX structural metadata repository, as they both implement that same web service interface.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
		<xs:attribute name="structureURL" type="xs:anyURI" use="optional">
			<xs:annotation>
				<xs:documentation>The structureURL attribute indicates the URL of a SDMX-ML structure message (in the same version as the source document) in which the externally referenced object is contained. Note that this may be a URL of an SDMX RESTful web service which will return the referenced object.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
	</xs:attributeGroup>
 * @author James
 */
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *  SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public class ExternalReferenceAttributeGroup implements Serializable {
    private String serviceURL = null;
    private String structureURL = null;


    public ExternalReferenceAttributeGroup() {}
    public ExternalReferenceAttributeGroup(String service,String structure) {
        this.structureURL=structure;
    }

    /**
     * @return the serviceURL
     */
    public String getServiceURL() {
        return serviceURL;
    }

    /**
     * @param serviceURL the serviceURL to set
     */
    public void setServiceURL(String serviceURL) {
        this.serviceURL = serviceURL;
    }

    /**
     * @return the structureURL
     */
    public String getStructureURL() {
        return structureURL;
    }

    /**
     * @param structureURL the structureURL to set
     */
    public void setStructureURL(String structureURL) {
        this.structureURL = structureURL;
    }
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeUTF(serviceURL);
        oos.writeUTF(structureURL);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        this.serviceURL = ois.readUTF();
        this.structureURL = ois.readUTF();
    }
}

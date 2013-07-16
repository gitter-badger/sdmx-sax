/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

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
public class ExternalReferenceAttributeGroup {
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
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="ReferenceType" abstract="true">
		<xs:annotation>
			<xs:documentation>ReferenceType is an abstract base type. It is used as the basis for all references, to all for a top level generic object reference that can be substituted with an explicit reference to any object. Any reference can consist of a Ref (which contains all required reference fields separately) and/or a URN. These must result in the identification of the same object. Note that the Ref and URN elements are local and unqualified in order to allow for refinement of this structure outside of the namespace. This allows any reference to further refined by a different namespace. For example, a metadata structure definition specific metadata set might wish to restrict the URN to only allow for a value from an enumerated list. The general URN structure, for the purpose of mapping the reference fields is as follows: urn:sdmx:org.package-name.class-name=agency-id:(maintainable-parent-object-id[maintainable-parent-object-version].)?(container-object-id.)?object-id([object-version])?.</xs:documentation>
		</xs:annotation>
		<xs:choice>
			<xs:sequence>
				<xs:element name="Ref" type="RefBaseType" form="unqualified">
					<xs:annotation>
						<xs:documentation>Ref is used to provide a complete set of reference fields. Derived reference types will restrict the RefType so that the content of the Ref element requires exactly what is needed for a complete reference.</xs:documentation>
					</xs:annotation>
				</xs:element>
				<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0">
					<xs:annotation>
						<xs:documentation>URN is used to hold the URN of the referenced object. This must be the same URN that would be constructed from the individual fields in the Ref element.</xs:documentation>
					</xs:annotation>
				</xs:element>
			</xs:sequence>
			<xs:element name="URN" type="xs:anyURI" form="unqualified">
				<xs:annotation>
					<xs:documentation>URN is used to hold the URN of the referenced object.</xs:documentation>
				</xs:annotation>
			</xs:element>
		</xs:choice>
	</xs:complexType>	
 * @author James
 */
public class ReferenceType {
    private RefBaseType ref = null;
    private anyURI urn = null;
    public ReferenceType(RefBaseType ref, anyURI urn) {
        this.ref=ref;
        this.urn=urn;
    }
   public ReferenceType(anyURI urn) {
        this.ref=null;
        this.urn=urn;
    }

    /**
     * @return the ref
     */
    public RefBaseType getRef() {
        return ref;
    }

    /**
     * @param ref the ref to set
     */
    public void setRef(RefBaseType ref) {
        this.ref = ref;
    }

    /**
     * @return the urn
     */
    public anyURI getUrn() {
        return urn;
    }

    /**
     * @param urn the urn to set
     */
    public void setUrn(anyURI urn) {
        this.urn = urn;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.xml.anyURI;

/**
 * <xs:complexType name="ReferenceType" abstract="true">
 * <xs:annotation>
 * <xs:documentation>ReferenceType is an abstract base type. It is used as the
 * basis for all references, to all for a top level generic object reference
 * that can be substituted with an explicit reference to any object. Any
 * reference can consist of a Ref (which contains all required reference fields
 * separately) and/or a URN. These must result in the identification of the same
 * object. Note that the Ref and URN elements are local and unqualified in order
 * to allow for refinement of this structure outside of the namespace. This
 * allows any reference to further refined by a different namespace. For
 * example, a metadata structure definition specific metadata set might wish to
 * restrict the URN to only allow for a value from an enumerated list. The
 * general URN structure, for the purpose of mapping the reference fields is as
 * follows:
 * urn:sdmx:org.package-name.class-name=agency-id:(maintainable-parent-object-id[maintainable-parent-object-version].)?(container-object-id.)?object-id([object-version])?.</xs:documentation>
 * </xs:annotation>
 * <xs:choice>
 * <xs:sequence>
 * <xs:element name="Ref" type="RefBaseType" form="unqualified">
 * <xs:annotation>
 * <xs:documentation>Ref is used to provide a complete set of reference fields.
 * Derived reference types will restrict the RefType so that the content of the
 * Ref element requires exactly what is needed for a complete
 * reference.</xs:documentation>
 * </xs:annotation>
 * </xs:element>
 * <xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0">
 * <xs:annotation>
 * <xs:documentation>URN is used to hold the URN of the referenced object. This
 * must be the same URN that would be constructed from the individual fields in
 * the Ref element.</xs:documentation>
 * </xs:annotation>
 * </xs:element>
 * </xs:sequence>
 * <xs:element name="URN" type="xs:anyURI" form="unqualified">
 * <xs:annotation>
 * <xs:documentation>URN is used to hold the URN of the referenced
 * object.</xs:documentation>
 * </xs:annotation>
 * </xs:element>
 * </xs:choice>
 * </xs:complexType>
 *
 * @author James
 */
/**
 * This file is part of SdmxSax.
 *
 * SdmxSax is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * SdmxSax is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * SdmxSax. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright James Gardner 2014
 */
public class ReferenceType {

    private RefBaseType ref = null;
    private anyURI urn = null;

    private transient PackageTypeCodelistType pack = null;
    private transient ObjectTypeCodelistType clazz = null;
    private transient NestedNCNameIDType agency = null;
    private transient IDType maintainedParentId = null;
    private transient VersionType maintainedParentVersion = null;
    private transient VersionType version = null;
    private transient NestedIDType objectId = null;

    public ReferenceType(RefBaseType ref, anyURI urn) {
        this.ref = ref;
        this.urn = urn;
        if (this.ref != null) {
            //try {
                this.pack = ref.getPack();
                this.clazz = ref.getRefClass();
                this.agency = ref.getAgencyId();
                this.objectId = ref.getId();
                this.maintainedParentId = ref.getMaintainableParentId();
                this.maintainedParentVersion = ref.getMaintainableParentVersion();
                this.version = ref.getVersion();
                //produce();
            //} catch (URISyntaxException ex) {
            //    Logger.getLogger(ReferenceType.class.getName()).log(Level.SEVERE, null, ex);
            //}
        } else {
            parse();
        }
    }

    public ReferenceType(anyURI urn) {
        this.ref = null;
        this.urn = urn;
        parse();
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

    private void produce() throws URISyntaxException {
        StringBuffer sb = new StringBuffer();
        sb.append(URN_START);
        sb.append(".infomodel.");
        sb.append(getPack().toString());
        sb.append(".");
        sb.append(getClazz().toString());
        sb.append(":");
        if (getAgencyId() != null) {
            sb.append(getAgencyId().toString());
        }
        if (getId() != null) {
            sb.append(".");
            sb.append(getId().toString());
        }
        if (getVersion() != null) {
            sb.append("(" + getVersion().toString() + ")");
        }
        this.urn = new anyURI(sb.toString());
    }

    private static final String URN_START = "urn:sdmx:org.sdmx";

    public void parse() {
        String s = urn.getString();
        if (!s.startsWith(URN_START)) {
            System.out.println("Malformed SDMX URN:" + s);
            return;
        }
        int firstEquals = s.indexOf("=");
        String packageAndClass = s.substring(URN_START.length(), firstEquals);
        int firstDot = packageAndClass.lastIndexOf(".");
        String pack = packageAndClass.substring(packageAndClass.lastIndexOf(".", firstDot - 1) + 1, firstDot);
        this.pack = PackageTypeCodelistType.fromString(pack);
        String clazz = packageAndClass.substring(firstDot + 1, packageAndClass.length());
        this.clazz = ObjectTypeCodelistType.fromString(clazz);
        String ag = s.substring(firstEquals + 1, s.indexOf(":", firstEquals));
        this.agency = new NestedNCNameIDType(ag);
        int loc = s.indexOf(ag) + ag.length() + 1;
        String idAndVersion = s.substring(loc, s.length());
        String id = idAndVersion.substring(0, idAndVersion.indexOf("("));
        this.maintainedParentId = new IDType(id);
        String vers = idAndVersion.substring(idAndVersion.indexOf("(") + 1, idAndVersion.indexOf(")"));
        this.version = new VersionType(vers);
    }

    /**
     * @return the pack
     */
    public PackageTypeCodelistType getPack() {
        return pack;
    }

    /**
     * @return the clazz
     */
    public ObjectTypeCodelistType getRefClass() {
        return clazz;
    }

    /**
     * @return the clazz
     */
    public ObjectTypeCodelistType getClazz() {
        return clazz;
    }

    /**
     * @return the agency
     */
    public NestedNCNameIDType getAgencyId() {
        return agency;
    }

    /**
     * @return the maintainedObjectId
     */
    public IDType getMaintainableParentId() {
        return maintainedParentId;
    }

    /**
     * @return the maintainedObjectVersion
     */
    public VersionType getVersion() {
        return version;
    }

    /**
     * @return the objectId
     */
    public NestedIDType getId() {
        return objectId;
    }

    public IDType[] getContainedObjectIds() {
        return new IDType[]{};
    }

    /**
     * @return the maintainedParentVersion
     */
    public VersionType getMaintainedParentVersion() {
        return maintainedParentVersion;
    }

}

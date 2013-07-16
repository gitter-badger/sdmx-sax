/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:complexType name="RefBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>RefBaseType is an abstract base type the defines the basis for any set of complete reference fields. This should be refined by derived types so that only the necessary fields are available and required as necessary. This can be used for both full and local references (when some of the values are implied from another context). A local reference is indicated with the local attribute. The values in this type correspond directly to the components of the URN structure, and thus can be used to compose a URN when the local attribute value is false. As this is the case, any reference components which are not part of the URN structure should not be present in the derived types.</xs:documentation>
		</xs:annotation>
		<xs:attribute name="agencyID" type="NestedNCNameIDType" use="optional">
			<xs:annotation>
				<xs:documentation>The agencyID attribute identifies the maintenance agency for the object being referenced (agency-id in the URN structure). This is optional to allow for local references (where the other reference fields are inferred from another context), but all complete references will require this.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
		<xs:attribute name="maintainableParentID" type="IDType" use="optional">
			<xs:annotation>
				<xs:documentation>The maintainableParentID attribute identifies the maintainable object in which the referenced object is defined, if applicable (maintainable-parent-object-id in the URN structure). This is only used in references where the referenced object is not itself maintainable.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
		<xs:attribute name="maintainableParentVersion" type="VersionType" use="optional">
			<xs:annotation>
				<xs:documentation>The maintainableParentVersion attribute identifies the version of the maintainable object in which the referenced object is defined (maintainable-parent-object-version in the URN structure). This is only used in references where the referenced object is not itself maintainable. This should only be used when the maintainableParentID is present. If this is available, a default of 1.0 will always apply.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
		<xs:attribute name="containerID" type="NestedIDType" use="optional">
			<xs:annotation>
				<xs:documentation>The containerID attribute identifies the object within a maintainable object in which the referenced object is defined (container-object-id in the URN structure). This is only used in references where the referenced object is not contained directly within a maintainable object (e.g. a Component within a ComponentList, within a maintainable Structure). If the container has a fixed identifier, this attribute will not be present.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
		<xs:attribute name="id" type="NestedIDType" use="required">
			<xs:annotation>
				<xs:documentation>The id attribute identifies the object being referenced, and is therefore always required.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
		<xs:attribute name="version" type="VersionType" use="optional">
			<xs:annotation>
				<xs:documentation>The version attribute identifies the version of the object being reference, if applicable. If this is available, a default value of 1.0 will always apply.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
		<xs:attribute name="local" type="xs:boolean" use="optional">
			<xs:annotation>
				<xs:documentation>The local attribute indicates whether this set of reference fields is meant for local referencing, in which case some of the reference fields will be implied from another context. Concrete instances of this class will always fix this value to either true or false, depending on their intended usage. If the value is fixed to true, then the complete set of reference fields will be required and a URN can be fully composed from the values.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
		<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional">
			<xs:annotation>
				<xs:documentation>The class attribute indicates the class name of the object being referenced. This attribute allows any reference to be processed generically from this definition. References derived from this should fix the value of this attribute to indicate the type of object that is being referenced, or in the case that a reference which allows specific types of fields, the representation should be sub-setted to the appropriate values.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
		<xs:attribute name="package" type="PackageTypeCodelistType" use="optional">
			<xs:annotation>
				<xs:documentation>The package attribute indicates the package name for the object being referenced. This attribute allows any reference to be processed generically from this definition. References derived from this should fix the value of this attribute to indicate the type of object that is being referenced, or in the case that a reference which allows specific types of fields, the representation should be sub-setted to the appropriate values.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
	</xs:complexType>
 * @author James
 */
public class RefBaseType {
    private NestedNCNameIDType agencyId = null;
    private IDType maintainableParentId = null;
    private VersionType maintainableParentVersion = null;
    private NestedIDType containerId = null;
    private NestedIDType id = null;
    private VersionType version = null;
    private boolean local = false;
    private ObjectTypeCodelistType clazz = null;
    private PackageTypeCodelistType pack = null;

   public RefBaseType(NestedNCNameIDType agencyId,NestedIDType id, VersionType vers,IDType maintParent,VersionType mainVers,NestedIDType containId,boolean loc,ObjectTypeCodelistType obs,PackageTypeCodelistType pack) {
       this.agencyId=agencyId;
       this.maintainableParentId=maintParent;
       this.maintainableParentVersion=mainVers;
       this.containerId=containId;
       this.id=id;
       this.version=vers;
       this.local=local;
       this.clazz=obs;
       this.pack=pack;
   }

    public RefBaseType() {
    }

    /**
     * @return the agencyId
     */
    public NestedNCNameIDType getAgencyId() {
        return agencyId;
    }

    /**
     * @return the maintainableParentId
     */
    public IDType getMaintainableParentId() {
        return maintainableParentId;
    }

    /**
     * @return the maintainableParentVersion
     */
    public VersionType getMaintainableParentVersion() {
        return maintainableParentVersion;
    }

    /**
     * @return the containerId
     */
    public NestedIDType getContainerId() {
        return containerId;
    }

    /**
     * @return the id
     */
    public NestedIDType getId() {
        return id;
    }

    /**
     * @return the version
     */
    public VersionType getVersion() {
        return version;
    }

    /**
     * @return the local
     */
    public boolean isLocal() {
        return local;
    }

    /**
     * @return the clazz
     */
    public ObjectTypeCodelistType getRefClass() {
        return clazz;
    }

    /**
     * @return the pack
     */
    public PackageTypeCodelistType getPack() {
        return pack;
    }

    /**
     * @param agencyId the agencyId to set
     */
    public void setAgencyId(NestedNCNameIDType agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * @param maintainableParentId the maintainableParentId to set
     */
    public void setMaintainableParentId(IDType maintainableParentId) {
        this.maintainableParentId = maintainableParentId;
    }

    /**
     * @param maintainableParentVersion the maintainableParentVersion to set
     */
    public void setMaintainableParentVersion(VersionType maintainableParentVersion) {
        this.maintainableParentVersion = maintainableParentVersion;
    }

    /**
     * @param containerId the containerId to set
     */
    public void setContainerId(NestedIDType containerId) {
        this.containerId = containerId;
    }

    /**
     * @param id the id to set
     */
    public void setId(NestedIDType id) {
        this.id = id;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(VersionType version) {
        this.version = version;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(boolean local) {
        this.local = local;
    }


}

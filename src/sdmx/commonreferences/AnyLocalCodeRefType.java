/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.CodeTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="AnyLocalCodeRefType">
		<xs:annotation>
			<xs:documentation>AnyLocalCodeRefType provides a local reference to any code object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="RefBaseType">
				<xs:attribute name="agencyID" type="NestedNCNameIDType" use="prohibited"/>
				<xs:attribute name="maintainableParentID" type="IDType" use="prohibited"/>
				<xs:attribute name="maintainableParentVersion" type="VersionType" use="prohibited"/>
				<xs:attribute name="containerID" type="IDType" use="optional">
					<xs:annotation>
						<xs:documentation>The containerID attribute references the hierarchy which defines the hierarchical code in the case that this reference is for a hierarchical code.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="id" type="NestedIDType" use="required"/>
				<xs:attribute name="local" type="xs:boolean" use="optional" fixed="true"/>
				<xs:attribute name="class" type="CodeTypeCodelistType" use="optional"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="codelist"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class AnyLocalCodeRefType extends RefBaseType {
    public AnyLocalCodeRefType(IDType containerId,NestedIDType id,CodeTypeCodelistType cl){
        super(null,id,null,null,null,containerId,true,cl,PackageTypeCodelistType.CODELIST);
    }
}

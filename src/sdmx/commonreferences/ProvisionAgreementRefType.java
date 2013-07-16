/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.MaintainableTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="ProvisionAgreementRefType">
		<xs:annotation>
			<xs:documentation>ProvisionAgreementRefType contains a set of reference fields for a provision agreement.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableRefBaseType">
				<xs:attribute name="class" type="MaintainableTypeCodelistType" use="optional" fixed="ProvisionAgreement"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="registry"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class ProvisionAgreementRefType extends MaintainableRefBaseType {
    public ProvisionAgreementRefType(){
        super(null,null,null,MaintainableTypeCodelistType.PROVISIONAGREEMENT,PackageTypeCodelistType.REGISTRY);
    }
}

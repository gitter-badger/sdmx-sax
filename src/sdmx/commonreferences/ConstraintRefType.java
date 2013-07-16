/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ConstraintTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="ConstraintRefType" abstract="true">
		<xs:annotation>
			<xs:documentation>ConstraintRefType contains a set of reference fields for a constraint.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableRefBaseType">
				<xs:attribute name="class" type="ConstraintTypeCodelistType" use="optional"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="registry"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public abstract class ConstraintRefType extends MaintainableRefBaseType {
    public ConstraintRefType(ConstraintTypeCodelistType clazz){
        super(null, null, null, clazz, PackageTypeCodelistType.REGISTRY);
        
    }
    
}

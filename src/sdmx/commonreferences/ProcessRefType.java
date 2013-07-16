/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.MaintainableTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *
 * <xs:complexType name="ProcessRefType">
		<xs:annotation>
			<xs:documentation>ProcessRefType contains a set of reference fields for a process.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableRefBaseType">
				<xs:attribute name="class" type="MaintainableTypeCodelistType" use="optional" fixed="Process"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="process"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class ProcessRefType extends MaintainableRefBaseType {
    public ProcessRefType(){
        super(null,null,null,MaintainableTypeCodelistType.PROCESS,PackageTypeCodelistType.PROCESS);
    }
    
}

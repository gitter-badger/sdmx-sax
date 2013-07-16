/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="LocalProcessStepRefType">
		<xs:annotation>
			<xs:documentation>LocalProcessStepRefType contains a local reference to a process step object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalIdentifiableRefBaseType">
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional" fixed="ProcessStep"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="process"/>					
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalProcessStepRefType extends LocalIdentifiableRefBaseType {
    public LocalProcessStepRefType(){
        super(null,null,ObjectTypeCodelistType.PROCESSSTEP,PackageTypeCodelistType.PROCESS);
    }
    
}

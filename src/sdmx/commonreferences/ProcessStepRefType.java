/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="ProcessStepRefType">
		<xs:annotation>
			<xs:documentation>ProcessStepRefType provides for a reference to a process step through its id. Support for referencing nested process steps is provided through a nested identifier.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ChildObjectRefBaseType">
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional" fixed="ProcessStep"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="process"/>					
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
	
 * @author James
 */
public class ProcessStepRefType extends ChildObjectRefBaseType {
    public ProcessStepRefType(){
        super(null,null,null,null,ObjectTypeCodelistType.PROCESSSTEP,PackageTypeCodelistType.PROCESS);
    }
    
}

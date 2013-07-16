/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 * *
	<xs:complexType name="TransitionRefType">
		<xs:annotation>
			<xs:documentation>TransitionRefType provides for a reference to a transition definition in process step through its id.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ContainerChildObjectRefBaseType">
				<xs:attribute name="containerID" type="NestedIDType" use="required"/>
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional" fixed="Transition"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="process"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class TransitionRefType extends ContainerChildObjectRefBaseType {
    public TransitionRefType(NestedIDType containId){
        super(null,null,null,containId,null,ObjectTypeCodelistType.TRANSITION,PackageTypeCodelistType.PROCESS);
    }
    
}

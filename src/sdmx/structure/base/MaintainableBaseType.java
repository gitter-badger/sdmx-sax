/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import java.util.ArrayList;
import java.util.List;
import sdmx.common.Annotations;
import sdmx.common.Description;
import sdmx.common.Name;
import sdmx.commonreferences.IDType;

/**
 *	<xs:complexType name="MaintainableBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>MaintainableBaseType is an abstract type that only serves the purpose of forming the base for the actual MaintainableType. The purpose of this type is to restrict the VersionableType to require the id attribute.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="VersionableType">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
					<xs:element ref="common:Name" maxOccurs="unbounded"/>
					<xs:element ref="common:Description" minOccurs="0" maxOccurs="unbounded"/>
				</xs:sequence>
				<xs:attribute name="id" type="common:IDType" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public abstract class MaintainableBaseType extends VersionableType {

    
    
    
}

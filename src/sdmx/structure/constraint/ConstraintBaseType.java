/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.constraint;

import sdmx.structure.base.MaintainableType;

/**
 *	<xs:complexType name="ConstraintBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>ConstraintBaseType is an abstract base type that forms the basis of the main abstract ConstraintType. It requires that a name be provided.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableType">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
					<xs:element ref="common:Name" maxOccurs="unbounded"/>
					<xs:element ref="common:Description" minOccurs="0" maxOccurs="unbounded"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */

public class ConstraintBaseType extends MaintainableType {
    
}

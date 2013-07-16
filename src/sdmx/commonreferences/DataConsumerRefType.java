/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.OrganisationTypeCodelistType;

/**
 *	<xs:complexType name="DataConsumerRefType">
		<xs:annotation>
			<xs:documentation>DataConsumerRefType contains a set of reference fields for referencing a data consumer within a data consumer scheme.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="OrganisationRefBaseType">
				<xs:attribute name="class" type="OrganisationTypeCodelistType" use="optional" fixed="DataConsumer"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class DataConsumerRefType extends OrganisationRefBaseType {
    public DataConsumerRefType(OrganisationTypeCodelistType clazz) {
        super(null,null,null,null,clazz);
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.OrganisationTypeCodelistType;

/**
 *	<xs:complexType name="LocalDataConsumerRefType">
		<xs:annotation>
			<xs:documentation>LocalDataConsumerRefType references a data consumer locally where the reference to the data consumer scheme which defines it is provided elsewhere.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalOrganisationRefBaseType">
				<xs:attribute name="class" type="OrganisationTypeCodelistType" use="optional" fixed="DataConsumer"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalDataConsumerRefType extends LocalOrganisationRefBaseType {
    public LocalDataConsumerRefType(IDType id){
        super(id,OrganisationTypeCodelistType.DATACONSUMER);
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.OrganisationSchemeTypeCodelistType;

/**
 *	<xs:complexType name="DataConsumerSchemeRefType">
		<xs:annotation>
			<xs:documentation>DataConsumerSchemeRefType contains a set of reference fields for a data consumer scheme.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="OrganisationSchemeRefBaseType">
				<xs:attribute name="class" type="OrganisationSchemeTypeCodelistType" use="optional" fixed="DataConsumerScheme"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class DataConsumerSchemeRefType extends OrganisationSchemeRefBaseType {
    public DataConsumerSchemeRefType(IDType id){
        super(id,OrganisationSchemeTypeCodelistType.DATACONSUMERSCHEME);
    }
}

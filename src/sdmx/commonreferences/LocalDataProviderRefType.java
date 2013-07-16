/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.OrganisationTypeCodelistType;

/**
 *	<xs:complexType name="LocalDataProviderRefType">
		<xs:annotation>
			<xs:documentation>LocalDataProviderRefType references a data provider locally where the reference to the data provider scheme which defines it is provided elsewhere.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalOrganisationRefBaseType">
				<xs:attribute name="class" type="OrganisationTypeCodelistType" use="optional" fixed="DataProvider"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalDataProviderRefType extends LocalOrganisationRefBaseType{
    public LocalDataProviderRefType(IDType id){
        super(id,OrganisationTypeCodelistType.DATAPROVIDER);
    }
   
}

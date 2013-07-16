/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.OrganisationSchemeTypeCodelistType;

/**
 *	<xs:complexType name="DataProviderSchemeRefType">
		<xs:annotation>
			<xs:documentation>DataProviderSchemeRefType contains a set of reference fields for a data provider scheme.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="OrganisationSchemeRefBaseType">
				<xs:attribute name="class" type="OrganisationSchemeTypeCodelistType" use="optional" fixed="DataProviderScheme"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class DataProviderSchemeRefType extends OrganisationSchemeRefBaseType {
    public DataProviderSchemeRefType(IDType id){
        super(id,OrganisationSchemeTypeCodelistType.DATAPROVIDERSCHEME);
    }
    
    
}

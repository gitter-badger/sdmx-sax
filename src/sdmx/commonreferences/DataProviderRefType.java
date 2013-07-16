/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.OrganisationTypeCodelistType;

/**
 *	<xs:complexType name="DataProviderRefType">
		<xs:annotation>
			<xs:documentation>DataProviderRefType contains a set of reference fields for referencing a data provider within a data provider scheme.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="OrganisationRefBaseType">
				<xs:attribute name="class" type="OrganisationTypeCodelistType" use="optional" fixed="DataProvider"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class DataProviderRefType extends OrganisationRefBaseType {
    public DataProviderRefType(IDType id){
        super(null,id,null,null,OrganisationTypeCodelistType.DATAPROVIDER);
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

/**
 *	<xs:complexType name="StructuralMetadataQueryType" abstract="true">
		<xs:annotation>
			<xs:documentation>StructureWhereQueryType is an abstract base type that serves as the basis for any structural metadata query. Concrete instances of this type are implied to be an and-query. A structural object will be returned for any object where all of the conditions are met.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="ReturnDetails" type="StructureReturnDetailsType"/>
			<xs:element ref="StructuralMetadataWhere"/>
		</xs:sequence>
	</xs:complexType>

 * @author James
 */

public class StructuralMetadataQueryType {
    StructureReturnDetailsType returnDetails = null;
    StructuralMetadataWhere query = null;
}

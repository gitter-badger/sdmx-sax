/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

/**
 *	<xs:element name="StructuralMetadataWhere" type="MaintainableWhereType" abstract="true">
		<xs:annotation>
			<xs:documentation>StructuralMetadataWhere is an abstract substitution head that forms the basis of any structural metadata query's details. This contains the actual parameters to be matched. These parameters are implicitly joined by an "and" connector (i.e. each of the parameters must be matched in order to satisfy the query). If it is necessary to supply "or" conditions for a parameter, this should be done by supplying multiple queries.</xs:documentation>
		</xs:annotation>
	</xs:element>
 * @author James
 */

public class StructuralMetadataWhere extends MaintainableWhereType {
    
}

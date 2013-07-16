/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import org.sdmx.resources.sdmxml.schemas.v21.query.StructureReturnDetailType;

/**
 *	<xs:complexType name="StructureReturnDetailsBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>StructureReturnDetailsBaseType is an abstract base type which forms the basis of StructureReturnDetailsType.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ReturnDetailsBaseType">
				<xs:attribute name="detail" type="StructureReturnDetailType" default="Full">
					<xs:annotation>
						<xs:documentation>The detail attribute is used to indicate whether the response to the query should return the full details of matched objects, or just a subset of the information should be returned. A value of "Full" indicates that the full details of all matched objects should be returned. A value of "CompleteStub" indicates that the identification information, name, description, and annotations for the matched object should be returned. A value of "Stub" indicates that just the identification information and name should be returned for the matched objects. Note that this applies only to the object(s) matched by the query parameters. The References element has a separate field for indicating the level of detail returned for referenced objects.</xs:documentation>
					</xs:annotation>
				</xs:attribute>				
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class StructureReturnDetailsBaseType extends ReturnDetailsBaseType {
    private StructureReturnDetailType detail = null;
}

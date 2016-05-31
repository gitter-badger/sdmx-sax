/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

import java.util.List;
import sdmx.common.Annotations;
import sdmx.common.AnnotationsType;
import sdmx.commonreferences.IDType;
import sdmx.structure.base.ComponentListType;

/**
 *	<xs:complexType name="MetadataTargetBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>MetadataTargetBaseType is an abstract base type which forms the basis for the MetadataTargetType.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>	
			<xs:restriction base="ComponentListType">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
				</xs:sequence>
				<xs:attribute name="id" type="common:IDType" use="required"/>
			</xs:restriction>
		</xs:complexContent>		
	</xs:complexType>

 * @author James
 */

public class MetadataTargetBaseType extends ComponentListType {
   public MetadataTargetBaseType(Annotations annots, IDType id) {
       super();
       super.setAnnotations(annots);
       super.setId(id);
   }    
}

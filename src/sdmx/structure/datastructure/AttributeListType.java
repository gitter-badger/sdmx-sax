/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.datastructure;

import java.util.ArrayList;
import java.util.List;
import sdmx.common.Annotations;
import sdmx.commonreferences.IDType;
import sdmx.structure.base.Component;
import sdmx.structure.base.ComponentListType;
import sdmx.structure.datastructure.AttributeType;
import sdmx.structure.datastructure.AttributeBaseType;

/**
 *	<xs:complexType name="AttributeListBaseType" abstract="true">
		<xs:annotation>
				<xs:documentation>AttributeListBaseType is an abstract base type used as the basis for the AttributeListType.</xs:documentation>
		</xs:annotation>		
		<xs:complexContent>	
			<xs:restriction base="ComponentListType">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
				</xs:sequence>
				<xs:attribute name="id" type="common:IDType" use="optional" fixed="AttributeDescriptor">
					<xs:annotation>
						<xs:documentation>The id attribute is provided in this case for completeness. However, its value is fixed to AttributeDescriptor.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class AttributeListType extends AttributeListBaseType {
   
   public List<AttributeType> getAttributes() {
       List<AttributeType> list = new ArrayList<AttributeType>();
       for(int i=0;i<super.getComponents().size();i++) {
           list.add( getAttribute(i) );
       }
       return list;
   }
   
   public void setAttributes(List<AttributeType> at) {
       List<Component> list = new ArrayList<Component>();
       for(int i=0;i<at.size();i++) {
           list.add(at.get(i));
       }
       super.setComponents(list);
   }
   
   public AttributeType getAttribute(int i) {
       Component c = getComponent(i);
       AttributeBaseType at=(AttributeType)c;
       return (AttributeType) at;
   }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.List;

/**
 *	<xs:complexType name="CubeRegionType">
		<xs:annotation>
			<xs:documentation>CubeRegionType defines the structure of a data cube region. This is based on the abstract RegionType and simply refines the key and attribute values to conform with what is applicable for dimensions and attributes, respectively. See the documentation of the base type for more details on how a region is defined.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="RegionType">
				<xs:sequence>
					<xs:element name="KeyValue" type="CubeRegionKeyType" minOccurs="0" maxOccurs="unbounded"/>
					<xs:element name="Attribute" type="AttributeValueSetType" minOccurs="0" maxOccurs="unbounded"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class CubeRegionType extends RegionType {
        private List<CubeRegionKeyType> keyValues = null;
        private List<AttributeValueSetType> attributes = null;

        public CubeRegionType(List<CubeRegionKeyType> values,List<AttributeValueSetType> attrs){
            super(null,null);
            this.keyValues=values;
            this.attributes=attrs;
        }

}

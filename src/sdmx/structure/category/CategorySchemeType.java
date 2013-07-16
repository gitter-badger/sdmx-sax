/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.category;

import java.util.ArrayList;
import java.util.List;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NCNameIDType;
import sdmx.structure.base.ItemSchemeType;
import sdmx.structure.base.ItemType;

/**
 *	<xs:complexType name="CategorySchemeType">
		<xs:annotation>
			<xs:documentation>CategorySchemeType describes the structure of a category scheme. A category scheme is the descriptive information for an arrangement or division of categories into groups based on characteristics, which the objects have in common. This provides for a simple, leveled hierarchy or categories.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemSchemeType">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
					<xs:element ref="common:Name" maxOccurs="unbounded"/>
					<xs:element ref="common:Description" minOccurs="0" maxOccurs="unbounded"/>
					<xs:sequence minOccurs="0" maxOccurs="unbounded">
						<xs:element ref="Category"/>
					</xs:sequence>
				</xs:sequence>
				<xs:attribute name="id" type="common:NCNameIDType" use="required">
					<xs:annotation>
						<xs:documentation>The id attribute holds the identification of the category scheme. The type of this id is restricted to the common:NCNNameIDType. This is necessary, since the category scheme may be used to create simple types in data and metadata structure specific schemas and therefore must be compliant with the NCName type in XML Schema (see common:NCNameIDType for further details).</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class CategorySchemeType extends ItemSchemeType {
    public CategorySchemeType() {
        
    }
    public Category getCategory(int i){
        return (Category)super.getItem(i);
    }
    public void setCategory(int i,Category c){
        super.setItem(i,c);
    }
    public void setCategories(List<CategoryType> list) {
        List<ItemType> items = new ArrayList<ItemType>(list.size());
        items.addAll(list);
        super.setItems(items);
    }

    public CategoryType findCategory(String s) {
        return findCategory(new IDType(s));
    }
    public CategoryType findCategory(IDType id) {
        return (CategoryType)super.findItem(id);
    }
    
    public void dump() {

    }
}

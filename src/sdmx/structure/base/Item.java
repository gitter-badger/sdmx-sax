/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

/**
 *	<xs:element name="Item" type="ItemType" abstract="true">
		<xs:annotation>
			<xs:documentation>Item is an abstract element that serves as a substitution head for all items in an item scheme, including those items nested within other items. Concrete instances of this must use a concrete instance of ItemType.</xs:documentation>
		</xs:annotation>
	</xs:element>
 * @author James
 */
public class Item extends ItemType {
    
}

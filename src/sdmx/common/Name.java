/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

/**
 *	<xs:element name="Name" type="TextType">
		<xs:annotation>
			<xs:documentation>Name is a reusable element, used for providing a human-readable name for an object.</xs:documentation>
		</xs:annotation>
	</xs:element>
 * 
 * @author James
 */
public class Name extends TextType  {
    public Name(String lang,String name) {
        super(lang,name);
    }
}

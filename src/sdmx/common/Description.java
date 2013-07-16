/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

/**
 *	<xs:element name="Description" type="TextType">
		<xs:annotation>
			<xs:documentation>Description is a reusable element, used for providing a longer human-readable description of an object.</xs:documentation>
		</xs:annotation>
	</xs:element>
 * @author James
 */
public class Description extends TextType {
    public Description(String lang,String text){
        super(lang,text);
    }

}

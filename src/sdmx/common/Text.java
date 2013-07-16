/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

/**
	<xs:element name="Text" type="TextType">
		<xs:annotation>
			<xs:documentation>Text is a reusable element, used for providing a language specific text value for general purposes (i.e. not for a name or description).</xs:documentation>
		</xs:annotation>
	</xs:element>
 * @author James
 */
public class Text extends TextType {
    public Text(String lang,String text){
        super(lang,text);
    }

}

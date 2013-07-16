/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

/**
	<xs:element name="StructuredText" type="XHTMLType">
		<xs:annotation>
			<xs:documentation>StructuredText is a reusable element, used for providing a language specific text value structured as XHTML.</xs:documentation>
		</xs:annotation>
	</xs:element>
 * @author James
 */
public class StructuredText extends TextType {
    public StructuredText(String lang,String text){
        super(lang,text);
    }

}

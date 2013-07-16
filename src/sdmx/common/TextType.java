package sdmx.common;

/**
 *	<xs:complexType name="TextType">
		<xs:annotation>
			<xs:documentation>TextType provides for a set of language-specific alternates to be provided for any human-readable constructs in the instance.</xs:documentation>
		</xs:annotation>
		<xs:simpleContent>
			<xs:extension base="xs:string">
				<xs:attribute ref="xml:lang" default="en">
					<xs:annotation>
						<xs:documentation>The xml:lang attribute specifies a language code for the text. If not supplied, the default language is assumed to be English.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:extension>
		</xs:simpleContent>
	</xs:complexType>
 * 
 * @author James
 */
public class TextType {

    String lang = null;
    String text = null;

    public TextType(String lang1, String text1) {
        this.lang = lang1;
        this.text = text1;

    }

    public String getLang() {
        return lang;
    }

    public String getText() {
        return text;
    }
    public String toString() {
        return text;
    }
}

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
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *   SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
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

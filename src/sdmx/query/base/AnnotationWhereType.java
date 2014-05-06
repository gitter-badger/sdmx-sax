/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

/**
 *	<xs:complexType name="AnnotationWhereType">
		<xs:annotation>
			<xs:documentation>AnnotationWhereType defines the structure for querying the details of an annotation.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="Type" type="QueryStringType" minOccurs="0">
				<xs:annotation>
					<xs:documentation>Type is a parameter for matching the type field of an annotation.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="Title" type="QueryStringType" minOccurs="0">
				<xs:annotation>
					<xs:documentation>Title is a parameter for matching the title field of an annotation.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="Text" type="QueryTextType" minOccurs="0">
				<xs:annotation>
					<xs:documentation>Text is a parameter for matching the text field of an annotation.</xs:documentation>
				</xs:annotation>
			</xs:element>
		</xs:sequence>
	</xs:complexType>

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
public class AnnotationWhereType {
    private QueryStringType type = null;
    private QueryStringType title = null;
    private QueryStringType text = null;

    /**
     * @return the type
     */
    public QueryStringType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(QueryStringType type) {
        this.type = type;
    }

    /**
     * @return the title
     */
    public QueryStringType getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(QueryStringType title) {
        this.title = title;
    }

    /**
     * @return the text
     */
    public QueryStringType getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(QueryStringType text) {
        this.text = text;
    }
    
    
}

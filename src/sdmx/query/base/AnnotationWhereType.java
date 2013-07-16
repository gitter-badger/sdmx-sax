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

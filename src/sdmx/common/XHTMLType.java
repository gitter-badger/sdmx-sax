/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.common;

import java.util.ArrayList;
import java.util.List;

/**
<xs:complexType name="XHTMLType" mixed="true">
<xs:annotation>
<xs:documentation>XHTMLType allows for mixed content of text and XHTML tags. When using this type, one will have to provide a reference to the XHTML schema, since the processing of the tags within this type is strict, meaning that they are validated against the XHTML schema provided.</xs:documentation>
</xs:annotation>
<xs:sequence minOccurs="0" maxOccurs="unbounded">
<xs:any namespace="http://www.w3.org/1999/xhtml" processContents="strict"/>
</xs:sequence>
<xs:attribute ref="xml:lang" default="en"/>
</xs:complexType>
 * @author James
 */
public class XHTMLType {

    List<String> htmlBlocks = new ArrayList<String>();
    String lang = "en";

    public XHTMLType(List<String> htmlBlocks) {
        this.htmlBlocks = htmlBlocks;
        this.lang = "en";
    }

    public XHTMLType(List<String> htmlBlocks, String xmlLang) {
        this.htmlBlocks = htmlBlocks;
        this.lang = xmlLang;
    }

    public List<String> getHTMLBlocks() {
        return htmlBlocks;
    }

    public String getHTMLBlock(int i) {
        return htmlBlocks.get(i);
    }

    public int getSize() {
        return htmlBlocks.size();
    }
}

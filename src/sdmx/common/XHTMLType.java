/*
    This file is part of sdmx-sax.

    sdmx-sax is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    sdmx-sax is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with sdmx-sax.  If not, see <http://www.gnu.org/licenses/>.
    Copyright (C) 2015 James Gardner
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

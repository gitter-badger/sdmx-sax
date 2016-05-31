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
 *	<xs:complexType name="StatusMessageType">
		<xs:annotation>
			<xs:documentation>StatusMessageType describes the structure of an error or warning message. A message contains the text of the message, as well as an optional language indicator and an optional code.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="Text" type="TextType" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>Text contains the text of the message, in parallel language values.</xs:documentation>
				</xs:annotation>
			</xs:element>
		</xs:sequence>
		<xs:attribute name="code" type="xs:string" use="optional">
			<xs:annotation>
				<xs:documentation>The code attribute holds an optional code identifying the underlying error that generated the message. This should be used if parallel language descriptions of the error are supplied, to distinguish which of the multiple error messages are for the same underlying error.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
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
public class StatusMessageType {
    private List<TextType> texts = new ArrayList<TextType>();
    private String code = null;


    public StatusMessageType(List<TextType> text,String code) {
        this.texts=texts;
        this.code=code;
    }
    public StatusMessageType(){}

    /**
     * @return the texts
     */
    public List<TextType> getTexts() {
        return texts;
    }

    public TextType getText(int i){ return texts.get(i);}
    public int getTextSize()  { return texts.size(); }

    /**
     * @param texts the texts to set
     */
    public void setTexts(List<TextType> texts) {
        this.texts = texts;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.List;

/**
 *	<xs:complexType name="CodedStatusMessageType">
		<xs:annotation>
			<xs:documentation>CodedStatusMessageType describes the structure of an error or warning message which required a code.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StatusMessageType">
				<xs:sequence>
					<xs:element name="Text" type="TextType" maxOccurs="unbounded"/>
				</xs:sequence>
				<xs:attribute name="code" type="xs:string" use="required"/>
			</xs:restriction>
		</xs:complexContent>
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
 
 *  SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public class CodedStatusMessageType extends StatusMessageType {
    public CodedStatusMessageType(List<TextType> texts,String code) {
        super(texts,code);
    }
    public CodedStatusMessageType(){}
}

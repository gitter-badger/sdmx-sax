/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import sdmx.common.AnnotableType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedIDType;
import sdmx.commonreferences.RefBaseType;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="IdentifiableType" abstract="true">
		<xs:annotation>
			<xs:documentation>IdentifiableType is an abstract base type for all identifiable objects.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="common:AnnotableType">
				<xs:attribute name="id" type="common:IDType" use="optional">
					<xs:annotation>
						<xs:documentation>The id is the identifier for the object.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="urn" type="xs:anyURI" use="optional">
					<xs:annotation>
						<xs:documentation>The urn attribute holds a valid SDMX Registry URN (see SDMX Registry Specification for details).</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="uri" type="xs:anyURI" use="optional">
					<xs:annotation>
						<xs:documentation>The uri attribute holds a URI that contains a link to a resource with additional information about the object, such as a web page. This uri is not a SDMX message.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:extension>
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
public class IdentifiableType extends AnnotableType {
    private IDType id;
    private anyURI urn;
    private anyURI uri;

    /**
     * @return the id
     */
    public IDType getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(IDType id) {
        this.id = id;
    }

    /**
     * @return the urn
     */
    public anyURI getUrn() {
        return urn;
    }

    /**
     * @param urn the urn to set
     */
    public void setUrn(anyURI urn) {
        this.urn = urn;
    }

    /**
     * @return the uri
     */
    public anyURI getUri() {
        return uri;
    }

    /**
     * @param uri the uri to set
     */
    public void setUri(anyURI uri) {
        this.uri = uri;
    }
    public boolean identifiesMe(IDType id2){
        if( this.id==null) return false;
        return this.id.equals(id2);
    }
    public boolean identifiesMe(NestedIDType id2){
        if( this.id==null) return false;
        return this.id.equals(id2);
    }
    public boolean identifiesMe(anyURI uri2){
        if( this.uri!=null&&this.urn!=null)
        return this.uri.equals(uri2)||this.urn.equals(uri2);
        else if( this.uri!=null ){
            return this.uri.equals(uri2);
        }else if( this.urn!=null) {
            return this.urn.equals(uri2);
        }
        return false;
    }
}

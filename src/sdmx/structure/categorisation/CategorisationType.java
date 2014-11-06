/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.categorisation;

import java.util.Calendar;
import java.util.List;
import sdmx.common.Annotations;
import sdmx.common.AnnotationsType;
import sdmx.common.Description;
import sdmx.common.Name;
import sdmx.common.TextType;
import sdmx.commonreferences.CategoryReference;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedNCNameID;
import sdmx.commonreferences.ObjectReference;
import sdmx.commonreferences.Version;
import sdmx.structure.base.MaintainableType;
import sdmx.xml.DateTime;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="CategorisationType">
		<xs:annotation>
			<xs:documentation>CategorisationType is defines the structure for a categorisation. A source object is referenced via an object reference and the target category is referenced via the target category.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="MaintainableType">
				<xs:sequence minOccurs="0">
					<xs:element name="Source" type="common:ObjectReferenceType">
						<xs:annotation>
							<xs:documentation>Source is a reference to an object to be categorized.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:element name="Target" type="common:CategoryReferenceType">
						<xs:annotation>
							<xs:documentation>Target is reference to the category that the referenced object is to be mapped to.</xs:documentation>
						</xs:annotation>
					</xs:element>
				</xs:sequence>
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
public class CategorisationType extends MaintainableType {
    
    
    public CategorisationType() {
        
    }
    public CategorisationType(NestedNCNameID agencyId,Annotations annotations,List<Description> descriptions,IDType id,boolean isExternalReference,boolean isFinal,List<Name> nameArray,ObjectReference source,CategoryReference target,anyURI uri,anyURI urn,DateTime validFrom,DateTime validTo,Version version) {
        super.setAgencyID(agencyId);
        super.setAnnotations(annotations);
        super.setDescriptions(descriptions);
        super.setId(id);
        super.setExternalReference(isExternalReference);
        super.setFinal(isFinal);
        super.setNames(nameArray);
        setSource(source);
        setTarget(target);
        super.setUri(uri);
        super.setUrn(urn);
        super.setValidFrom(validFrom);
        super.setValidTo(validTo);
        super.setVersion(version);
    }
    
    private ObjectReference source = null;
    private CategoryReference target = null;

    /**
     * @return the source
     */
    public ObjectReference getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(ObjectReference source) {
        this.source = source;
    }

    /**
     * @return the target
     */
    public CategoryReference getTarget() {
        return target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(CategoryReference target) {
        this.target = target;
    }

    public void dump() {
        System.out.println("Categorisation");
        System.out.println("agency="+this.getAgencyID());
        System.out.println("id="+this.getId());
        System.out.println("vers="+this.getVersion());
    }
    
}

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
import sdmx.commonreferences.CategoryReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.ObjectReferenceType;
import sdmx.commonreferences.VersionType;
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
public class CategorisationType extends MaintainableType {
    
    
    public CategorisationType() {
        
    }
    public CategorisationType(NestedNCNameIDType agencyId,Annotations annotations,List<Description> descriptions,IDType id,boolean isExternalReference,boolean isFinal,List<Name> nameArray,ObjectReferenceType source,CategoryReferenceType target,anyURI uri,anyURI urn,DateTime validFrom,DateTime validTo,VersionType version) {
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
    
    private ObjectReferenceType source = null;
    private CategoryReferenceType target = null;

    /**
     * @return the source
     */
    public ObjectReferenceType getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(ObjectReferenceType source) {
        this.source = source;
    }

    /**
     * @return the target
     */
    public CategoryReferenceType getTarget() {
        return target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(CategoryReferenceType target) {
        this.target = target;
    }

    public void dump() {
        System.out.println("Categorisation");
        System.out.println("agency="+this.getAgencyID());
        System.out.println("id="+this.getId());
        System.out.println("vers="+this.getVersion());
    }
    
}

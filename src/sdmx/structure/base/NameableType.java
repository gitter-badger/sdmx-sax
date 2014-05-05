/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import java.util.List;
import sdmx.common.Description;
import sdmx.common.Name;

/**
 *	<xs:complexType name="NameableType" abstract="true">
		<xs:annotation>
			<xs:documentation>NameableType is an abstract base type for  all nameable objects.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="IdentifiableType">
				<xs:sequence>
					<xs:element ref="common:Name" maxOccurs="unbounded">
						<xs:annotation>
							<xs:documentation>Name provides for a human-readable name for the object. This may be provided in multiple, parallel language-equivalent forms.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:element ref="common:Description" minOccurs="0" maxOccurs="unbounded">
						<xs:annotation>
							<xs:documentation>Description provides for a longer human-readable description of the object. This may be provided in multiple, parallel language-equivalent forms.</xs:documentation>
						</xs:annotation>
					</xs:element>
				</xs:sequence>
			</xs:extension>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class NameableType extends IdentifiableType {
     private List<Name> names = null;
     private List<Description> descriptions = null;

    /**
     * @return the names
     */
    public List<Name> getNames() {
        return names;
    }

    /**
     * @param names the names to set
     */
    public void setNames(List<Name> names1) {
        this.names = names1;
    }

    /**
     * @return the descriptions
     */
    public List<Description> getDescriptions() {
        return descriptions;
    }

    /**
     * @param descriptions the descriptions to set
     */
    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }
    public Name findName(String lang) {
        if( names == null ) return null;
        Name def = null;
        for(int i=0;i<names.size();i++) {
            if( lang!=null&&lang.equals(names.get(i).getLang()))return names.get(i);
            if( names.get(i).getLang()==null)def=names.get(i);
        }
        if( !"en".equals(lang) ) return findName("en");
        return def;
    }
    public Description findDescription(String lang) {
        if( descriptions == null ) return null;
        Description def = null;
        for(int i=0;i<descriptions.size();i++) {
            if( lang!=null&&lang.equals(descriptions.get(i).getLang()))return descriptions.get(i);
            if( descriptions.get(i).getLang()==null)def=descriptions.get(i);
        }
        if( !"en".equals(lang) ) return findDescription("en");
        return def;
    }
}

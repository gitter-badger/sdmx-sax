/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure;

import sdmx.structure.categorisation.CategorisationType;
import java.util.ArrayList;
import java.util.List;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.VersionType;

/**
 *	<xs:complexType name="CategorisationsType">
		<xs:annotation>
			<xs:documentation>CategorisationsType describes the structure of the categorisations container. It contains one or more categorisation of a specific object type, which can be explicitly detailed or referenced from an external structure document or registry service. This container may contain categorisations for multiple types of structural objects.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="Categorisation" type="CategorisationType" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>Categorisation allows for the association of an identifiable object to a category, providing for the classifications of the reference identifiable object. This must either contain the full details of the categorisation, or provide a name and identification information and reference the full details from an external structure document or registry service.</xs:documentation>
				</xs:annotation>
			</xs:element>
		</xs:sequence>
	</xs:complexType>
 * @author James
 */
public class CategorisationsType {
    private List<CategorisationType> categorisations = new ArrayList<CategorisationType>();

    /**
     * @return the categorisations
     */
    public List<CategorisationType> getCategorisations() {
        return categorisations;
    }

    /**
     * @param categorisations the categorisations to set
     */
    public void setCategorisations(List<CategorisationType> categorisations) {
        this.categorisations = categorisations;
    }
    public CategorisationType findCategorisation(String agency,String id,String vers) {
        IDType findid = new IDType(id);
        NestedNCNameIDType ag = new NestedNCNameIDType(agency);
        VersionType ver = new VersionType(vers);
        return findCategorisation(ag,findid,ver);
    }
    public CategorisationType findCategorisation(NestedNCNameIDType agency2,IDType findid,VersionType ver) {
        for(int i=0;i<categorisations.size();i++) {
            if( categorisations.get(i).identifiesMe(agency2,findid,ver)) {
                return categorisations.get(i);
            }
        }
        return null;
    }
    public void dump() {
        for(int i=0;i<categorisations.size();i++) {
            categorisations.get(i).dump();
        }
    }
}

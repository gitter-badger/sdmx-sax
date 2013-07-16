/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure;

import sdmx.structure.codelist.CodelistType;
import java.util.ArrayList;
import java.util.List;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemSchemeReferenceBaseType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.RefBaseType;
import sdmx.commonreferences.VersionType;
import sdmx.structure.categorisation.CategorisationType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="CodelistsType">
		<xs:annotation>
			<xs:documentation>CodelistsType describes the structure of the code lists container. It contains one or more code list, which can be explicitly detailed or referenced from an external structure document or registry service.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="Codelist" type="CodelistType" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>Codelist provides the details of a code list, which is defined as a list from which some statistical concepts (coded concepts) take their values.</xs:documentation>
				</xs:annotation>
				<xs:unique name="Codelist_UniqueCode">
					<xs:selector xpath="structure:Code"/>
					<xs:field xpath="@id"/>
				</xs:unique>
			</xs:element>
		</xs:sequence>
	</xs:complexType>
 * @author James
 */
public class CodelistsType {
    private List<CodelistType> codelists = new ArrayList<CodelistType>();

    public CodelistsType(List<CodelistType> codelists) {
        this.codelists=codelists;
    }

    /**
     * @return the codelists
     */
    public List<CodelistType> getCodelists() {
        return codelists;
    }

    /**
     * @param codelists the codelists to set
     */
    public void setCodelists(List<CodelistType> codelists) {
        this.codelists = codelists;
    }
    public CodelistType findCodelist(String agency,String id,String vers) {
        IDType findid = new IDType(id);
        NestedNCNameIDType ag = new NestedNCNameIDType(agency);
        VersionType ver = vers==null?null:new VersionType(vers);
        return findCodelist(ag,findid,ver);
    }
    public CodelistType findCodelist(NestedNCNameIDType agency2,IDType findid,VersionType ver) {
        for(int i=0;i<codelists.size();i++) {
            CodelistType cl2 = codelists.get(i);
            if( codelists.get(i).identifiesMe(agency2,findid,ver)) {
                return codelists.get(i);
            }
        }
        return null;
    }
    public CodelistType findCodelist(NestedNCNameIDType agency2,IDType findid) {
        for(int i=0;i<codelists.size();i++) {
            if( codelists.get(i).identifiesMe(agency2,findid)) {
                return codelists.get(i);
            }
        }
        return null;
    }
    public CodelistType findCodelist(anyURI uri) {
        for(int i=0;i<codelists.size();i++) {
            if( codelists.get(i).identifiesMe(uri)) {
                return codelists.get(i);
            }
        }
        return null;
    }
    public void dump() {
    }
    /*
     * This method is used in sdmx 2.0 parsing to find a codelist with the correct ID..
     * this is because the Dimension in the KeyFamily does not contain a complete reference
     * only an ID.. we lookup the Codelist by it's ID, when we find a match, we can make a 
     * LocalItemSchemeReference out of it with it's AgencyID and Version.
     */
    public CodelistType findCodelistById(IDType id) {
        CodelistType cl = null;
        for(int i=0;i<codelists.size();i++) {
            if( codelists.get(i).identifiesMe(id)) {
                if( cl==null)cl = codelists.get(i);
                else {
                    int j=cl.getVersion().compareTo(codelists.get(i).getVersion());
                    switch(j){
                        case -1: // Less
                            break;
                        case 0:  // Equal
                            break;
                        case 1:
                            // Our found conceptscheme has a greater version number.
                            cl=codelists.get(i);
                            break;
                    }
                }
            }
        }
        return cl;
    }
    public CodelistType findCodelist(ItemSchemeReferenceBaseType ref) {
        if( ref.getRef()!=null) {
            return findCodelist(ref.getRef().getAgencyId(),new IDType(ref.getRef().getId().toString()), ref.getRef().getVersion());
        }else {
            return findCodelist(ref.getUrn());
        }
    }
}

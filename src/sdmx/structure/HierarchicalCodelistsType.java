/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure;

import java.util.ArrayList;
import java.util.List;

/**
 *	<xs:complexType name="HierarchicalCodelistsType">
		<xs:annotation>
			<xs:documentation>HierarchicalCodelistsType describes the structure of the hierarchical code lists container. It contains one or more hierarchical code list, which can be explicitly detailed or referenced from an external structure document or registry service.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="HierarchicalCodelist" type="HierarchicalCodelistType" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>HierarchicalCodelist provides the details of a hierarchical code list, which is defined as an organised collection of codes that may participate in many parent/child relationships with other codes in the list, as defined by one or more hierarchy of the list.</xs:documentation>
				</xs:annotation>
				<xs:unique name="HierarchicalCodelist_UniqueHierarchy">
					<xs:selector xpath="structure:Hierarchy"/>
					<xs:field xpath="@id"/>
				</xs:unique>	
				<xs:unique name="HierarchicalCodelist_UniqueCodelistAlias">
					<xs:selector xpath="structure:IncludedCodelistReference"/>
					<xs:field xpath="@alias"/>
				</xs:unique>
			</xs:element>
		</xs:sequence>
	</xs:complexType>
 * @author James
 */
public class HierarchicalCodelistsType {
    private List<HierarchicalCodelist> hierarchicalCodelists = new ArrayList<HierarchicalCodelist>();

    /**
     * @return the hierarchicalCodelists
     */
    public List<HierarchicalCodelist> getHierarchicalCodelists() {
        return hierarchicalCodelists;
    }

    /**
     * @param hierarchicalCodelists the hierarchicalCodelists to set
     */
    public void setHierarchicalCodelists(List<HierarchicalCodelist> hierarchicalCodelists) {
        this.hierarchicalCodelists = hierarchicalCodelists;
    }
}

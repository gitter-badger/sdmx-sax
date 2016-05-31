/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure;

import java.util.ArrayList;
import java.util.List;

/**
 *<xs:complexType name="ReportingTaxonomiesType">
		<xs:annotation>
			<xs:documentation>ReportingTaxonomiesType describes the structure of the reporting taxonomies container. It contains one or more reporting taxonomy, which can be explicitly detailed or referenced from an external structure document or registry service.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="ReportingTaxonomy" type="ReportingTaxonomyType" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>ReportingTaxonomy provides the details of a reporting taxonomy, which is a scheme which defines the composition structure of a data report where each component can be described by an independent data or metadata flow definition.</xs:documentation>
				</xs:annotation>
				<xs:unique name="ReportingTaxonomy_UniqueReportingCategory">
					<xs:selector xpath="structure:ReportingCategory"/>
					<xs:field xpath="@id"/>
				</xs:unique>
			</xs:element>
		</xs:sequence>
	</xs:complexType>
 * @author James
 */

public class ReportingTaxonomiesType {
    private List<ReportingTaxonomy> reportingTaxonomies = new ArrayList<ReportingTaxonomy>();

    /**
     * @return the reportingTaxonomies
     */
    public List<ReportingTaxonomy> getReportingTaxonomies() {
        return reportingTaxonomies;
    }

    /**
     * @param reportingTaxonomies the reportingTaxonomies to set
     */
    public void setReportingTaxonomies(List<ReportingTaxonomy> reportingTaxonomies) {
        this.reportingTaxonomies = reportingTaxonomies;
    }
}

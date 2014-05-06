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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import sdmx.commonreferences.types.MaintainableTypeCodelistType;

/**
 *	<xs:complexType name="MaintainableWhereType" abstract="true">
		<xs:annotation>
			<xs:documentation>MaintainableQueryType is an abstract base type that serves as the basis for any query for a maintainable object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="VersionableWhereType">
				<xs:sequence>
					<xs:element name="AgencyID" type="QueryNestedIDType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>AgencyID is used to match the agency id of the maintained object.</xs:documentation>
						</xs:annotation>
					</xs:element>
				</xs:sequence>
				<xs:attribute name="type" type="common:MaintainableTypeCodelistType" use="optional">
					<xs:annotation>
						<xs:documentation>The type attribute optionally defines the type of object being queried. For queries for distinct types of objects, a fixed value should be specified in the derived queries. For queries that serve to query for like types of objects, this should be required.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:extension>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */

public class MaintainableWhereType extends VersionableWhereType {
    private QueryNestedIDType agencyId = null;
    private MaintainableTypeCodelistType type = null;

    /**
     * @return the agencyId
     */
    public QueryNestedIDType getAgencyId() {
        return agencyId;
    }

    /**
     * @param agencyId the agencyId to set
     */
    public void setAgencyId(QueryNestedIDType agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * @return the type
     */
    public MaintainableTypeCodelistType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(MaintainableTypeCodelistType type) {
        this.type = type;
    }
}

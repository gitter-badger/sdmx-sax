/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

/**
 *	<xs:complexType name="StructureReturnDetailsType">
		<xs:annotation>
			<xs:documentation>StructureReturnDetailsType defines the structure of the return details for any structural metadata query.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="StructureReturnDetailsBaseType">
				<xs:sequence>
					<xs:element name="References" type="ReferencesType">
						<xs:annotation>
							<xs:documentation>References is used to communicate how objects that reference or are referenced by the object(s) being queried should be returned.</xs:documentation>
						</xs:annotation>
					</xs:element>
				</xs:sequence>
				<xs:attribute name="returnMatchedArtefact" type="xs:boolean" default="true">
					<xs:annotation>
						<xs:documentation>The returnMatchedArtefact attribute indicates whether the object(s) match by the query should be returned. If this is set to false, only the reference objects from the match object(s) will be returned.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:extension>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */

public class StructureReturnDetailsType extends StructureReturnDetailsBaseType {
    private Boolean returnMatchedArtefact = null;

    /**
     * @return the returnMatchedArtefact
     */
    public Boolean getReturnMatchedArtefact() {
        return returnMatchedArtefact;
    }

    /**
     * @param returnMatchedArtefact the returnMatchedArtefact to set
     */
    public void setReturnMatchedArtefact(Boolean returnMatchedArtefact) {
        this.returnMatchedArtefact = returnMatchedArtefact;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;
/**
 *	<xs:complexType name="MaintainableReturnDetailsType">
		<xs:annotation>
			<xs:documentation>MaintainableReturnDetailsType defines the structure for the return details of a non-item scheme maintainable object. It eliminates the detail options that are specific to searching an item scheme</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureReturnDetailsType">
				<xs:sequence>
					<xs:element name="References" type="ReferencesType"/>
				</xs:sequence>
				<xs:attribute name="detail" type="MaintainableReturnDetailType" default="Full"/>
				<xs:attribute name="returnMatchedArtefact" type="xs:boolean" default="true"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class MaintainableReturnDetailsType extends StructureReturnDetailsType {
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

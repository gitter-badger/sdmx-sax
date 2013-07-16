/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.message;

import sdmx.structure.StructuresType;

/**
 * *	<xs:complexType name="StructureType">
		<xs:annotation>
			<xs:documentation>StructureType defines the contents of a structure message. The payload is optional since this message may be returned from a web service with only information in the footer.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MessageType">
				<xs:sequence>
					<xs:element name="Header" type="StructureHeaderType"/>
					<xs:element name="Structures" type="structure:StructuresType" minOccurs="0"/>
					<xs:element ref="footer:Footer" minOccurs="0"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class StructureType extends MessageType {
    private StructuresType structures = null;
    public StructureType(){
    }
    public StructureType(StructuresType structures){
        this.structures=structures;
    }

    /**
     * @return the structures
     */
    public StructuresType getStructures() {
        return structures;
    }

    /**
     * @param structures the structures to set
     */
    public void setStructures(StructuresType structures) {
        this.structures = structures;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import java.util.ArrayList;
import java.util.List;

/**
 *	<xs:complexType name="StructureType" abstract="true">
		<xs:annotation>
			<xs:documentation>StructureType is an abstract base type for all structure objects. Concrete instances of this should restrict to a concrete grouping.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="MaintainableType">
				<xs:sequence>
					<xs:sequence minOccurs="0">
						<xs:element ref="Grouping"/>
					</xs:sequence>
				</xs:sequence>
			</xs:extension>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */

public class StructureType extends MaintainableType {
    List<Grouping> groups = new ArrayList<Grouping>();
}

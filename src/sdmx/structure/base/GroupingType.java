/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import java.util.ArrayList;
import java.util.List;

/**
 *	<xs:complexType name="GroupingType" abstract="true">
		<xs:annotation>
			<xs:documentation>GroupType is an abstract base type for specific structure groupings. It contains a collection of component lists. Concrete instances of this should restrict to specific concrete component lists.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:sequence minOccurs="0" maxOccurs="unbounded">
				<xs:element ref="ComponentList"/>
			</xs:sequence>
		</xs:sequence>
	</xs:complexType>
 * @author James
 */

public abstract class GroupingType {

}

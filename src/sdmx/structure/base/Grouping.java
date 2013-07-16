/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import java.util.List;

/**
 *	<xs:element name="Grouping" type="GroupingType" abstract="true">
		<xs:annotation>
			<xs:documentation>Grouping is an abstract element that serves as a substitution head for all structure groupings. Groupings contain a collection of component lists for a structure. Concrete instances of this must use a concrete instance of GroupingType.</xs:documentation>
		</xs:annotation>
	</xs:element>
 * @author James
 */
public class Grouping extends GroupingType {

    @Override
    public List<ComponentList> getComponents() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setComponents(List<ComponentList> components) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import java.util.ArrayList;
import java.util.List;

/**
 *	<xs:complexType name="ComponentListType" abstract="true">
		<xs:annotation>
			<xs:documentation>ComponentListType is an abstract base type for all component lists. It contains a collection of components. Concrete types should restrict this to specific concrete components.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="IdentifiableType">
				<xs:sequence>
					<xs:sequence minOccurs="0" maxOccurs="unbounded">
						<xs:element ref="Component"/>
					</xs:sequence>
				</xs:sequence>
			</xs:extension>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ComponentListType extends IdentifiableType {
    private List<Component> components = new ArrayList<Component>();

    /**
     * @return the components
     */
    public List<Component> getComponents() {
        return components;
    }

    /**
     * @param components the components to set
     */
    public void setComponents(List<Component> components) {
        this.components = components;
    }
    public Component getComponent(int i) {
        return components.get(i);
    }
    public void setComponent(int i,Component c) {
        components.set(i, c);
    }
    public int size() { return components.size(); }
}

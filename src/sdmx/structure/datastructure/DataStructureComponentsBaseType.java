/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.datastructure;

import java.util.List;
import sdmx.structure.base.ComponentList;
import sdmx.structure.base.GroupingType;

/**
 *	<xs:complexType name="DataStructureComponentsBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>DataStructureComponentsBaseType is an abstract base type the serves as the basis for the DataStructureComponentsType. This type is necessary to allow for valid substitutions of component lists.</xs:documentation>
		</xs:annotation>		
		<xs:complexContent>	
			<xs:restriction base="GroupingType">
			</xs:restriction>
		</xs:complexContent>	
	</xs:complexType>
 * @author James
 */
public class DataStructureComponentsBaseType extends GroupingType {

    @Override
    public List<ComponentList> getComponents() {
        return null;
    }

    @Override
    public void setComponents(List<ComponentList> components) {
        return;
    }
    
}

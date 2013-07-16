/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.common;

import sdmx.commonreferences.NestedNCNameIDType;
import java.util.ArrayList;
import java.util.List;
import sdmx.common.choice.ComponentValueSetTypeChoice;

/**
 *	<xs:complexType name="ComponentValueSetType" abstract="true">
<xs:annotation>
<xs:documentation>ComponentValueSetType is an abstract base type which is used to provide a set of value for a referenced component. Implementations of this type will be based on a particular component type and refine the allowed values to reflect the types of values that are possible for that type of component.</xs:documentation>
</xs:annotation>
<xs:choice minOccurs="0">
<xs:element name="Value" type="SimpleValueType" maxOccurs="unbounded">
<xs:annotation>
<xs:documentation>Value provides a simple value for the component, such as a coded, numeric, or simple text value. This type of component value is applicable for dimensions and attributes.</xs:documentation>
</xs:annotation>
</xs:element>
<xs:element name="DataSet" type="SetReferenceType" maxOccurs="unbounded">
<xs:annotation>
<xs:documentation>DataSet provides a reference to a data set and is used to state a value for the data set target component in a metadata target.</xs:documentation>
</xs:annotation>
</xs:element>
<xs:element name="DataKey" type="DataKeyType" maxOccurs="unbounded">
<xs:annotation>
<xs:documentation>DataKey provides a set of dimension references and value, which form a full or partial data key. This is used to state a value for the key descriptor values target component in a metadata target.</xs:documentation>
</xs:annotation>
</xs:element>
<xs:element name="Object" type="ObjectReferenceType" maxOccurs="unbounded">
<xs:annotation>
<xs:documentation>Object provides a reference to an Identifiable object in the SDMX Information Model. This is used to state a value for an identifiable target component in a metadata target.</xs:documentation>
</xs:annotation>
</xs:element>
<xs:element name="TimeRange" type="TimeRangeValueType">
<xs:annotation>
<xs:documentation>TimeValue provides a value for a component which has a time representation. This is repeatable to allow for a range to be specified, although a single value can also be provided. An operator is available on this to indicate whether the specified value indicates an exact value or the beginning/end of a range (inclusive or exclusive).</xs:documentation>
</xs:annotation>
</xs:element>
</xs:choice>
<xs:attribute name="id" type="NestedNCNameIDType" use="required">
<xs:annotation>
<xs:documentation>The id attribute provides the identifier for the component for which values are being provided. This base type allows for a nested identifier to be provided, for the purpose of referencing a nested component (i.e. a metadata attribute). However, specific implementations will restrict this representation to only allow single level identifiers where appropriate.</xs:documentation>
</xs:annotation>
</xs:attribute>
<xs:attribute name="include" type="xs:boolean" use="optional" default="true">
<xs:annotation>
<xs:documentation>The include attribute indicates whether the values provided for the referenced component are to be included are excluded from the region in which they are defined.</xs:documentation>
</xs:annotation>
</xs:attribute>
</xs:complexType>	
 * @author James
 */
public class ComponentValueSetType {


    ComponentValueSetTypeChoice choice = null;

    private NestedNCNameIDType id=null;// Required
    private boolean include = true;

    public ComponentValueSetType(ComponentValueSetTypeChoice value,NestedNCNameIDType id) {
        this.choice=value;
        this.id=id;
    }
}

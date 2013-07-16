/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.message;

/**
 *   <xs:complexType name="StructureSpecificDataHeaderType">
      <xs:annotation>
         <xs:documentation>StructureSpecificDataHeaderType defines the header structure for a structure specific data message.</xs:documentation>
      </xs:annotation>
      <xs:complexContent>
         <xs:restriction base="BaseHeaderType">
            <xs:sequence>
               <xs:element name="ID" type="common:IDType"/>
               <xs:element name="Test" type="xs:boolean" default="false"/>
               <xs:element name="Prepared" type="HeaderTimeType"/>
               <xs:element name="Sender" type="SenderType"/>
               <xs:element name="Receiver" type="PartyType" minOccurs="0" maxOccurs="unbounded"/>
               <xs:element ref="common:Name" minOccurs="0" maxOccurs="unbounded"/>
               <xs:element name="Structure" type="common:StructureSpecificDataStructureType" maxOccurs="unbounded"/>
               <xs:element name="DataProvider" type="common:DataProviderReferenceType" minOccurs="0"/>
               <xs:element name="DataSetAction" type="common:ActionType" minOccurs="0"/>
               <xs:element name="DataSetID" type="common:IDType" minOccurs="0" maxOccurs="unbounded"/>
               <xs:element name="Extracted" type="xs:dateTime" minOccurs="0"/>
               <xs:element name="ReportingBegin" type="common:ObservationalTimePeriodType" minOccurs="0"/>
               <xs:element name="ReportingEnd" type="common:ObservationalTimePeriodType" minOccurs="0"/>
               <xs:element name="EmbargoDate" type="xs:dateTime" minOccurs="0"/>
               <xs:element name="Source" type="common:TextType" minOccurs="0" maxOccurs="unbounded"/>
            </xs:sequence>
         </xs:restriction>
      </xs:complexContent>
   </xs:complexType>

 * @author James
 */
public class StructureSpecificDataHeaderType extends BaseHeaderType {
    
}

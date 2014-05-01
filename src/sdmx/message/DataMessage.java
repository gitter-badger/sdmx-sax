/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.message;

import java.util.List;
import sdmx.data.DataSet;
import sdmx.data.flat.FlatDataSet;
import sdmx.structure.StructuresType;

/**
	<xs:complexType name="GenericDataType">
		<xs:annotation>
			<xs:documentation>GenericDataType defines the contents of a generic data message.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MessageType">
				<xs:sequence>
					<xs:element name="Header" type="GenericDataHeaderType"/>
					<xs:element name="DataSet" type="data:DataSetType" minOccurs="0" maxOccurs="unbounded"/>
					<xs:element ref="footer:Footer" minOccurs="0"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class DataMessage extends MessageType {
    private String namespace = null;
    private String namespacePrefix = null;
    
    private List<DataSet> dataSets = null;
    public DataMessage(){
    }
    public DataMessage(List<DataSet> datasets){
        this.dataSets=datasets;
    }

    /**
     * @return the structures
     */
    public List<DataSet> getDataSets() {
        return dataSets;
    }

    /**
     * @param structures the structures to set
     */
    public void setDataSets(List<DataSet> datasets) {
        this.dataSets=datasets;
    }
    public void dump() {
        for(int i=0;i<dataSets.size();i++) {
            dataSets.get(i).dump();
        }
    }

    /**
     * @return the namespace
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * @param namespace the namespace to set
     */
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * @return the namespacePrefix
     */
    public String getNamespacePrefix() {
        return namespacePrefix;
    }

    /**
     * @param namespacePrefix the namespacePrefix to set
     */
    public void setNamespacePrefix(String namespacePrefix) {
        this.namespacePrefix = namespacePrefix;
    }
}

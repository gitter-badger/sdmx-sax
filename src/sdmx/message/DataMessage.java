/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.message;

import java.util.ArrayList;
import java.util.List;
import sdmx.common.PayloadStructureType;
import sdmx.common.StructureUsage;
import sdmx.commonreferences.DataStructureRefType;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.StructureUsageRefType;
import sdmx.commonreferences.StructureUsageReferenceBaseType;
import sdmx.commonreferences.StructureUsageReferenceType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;
import sdmx.commonreferences.types.StructureUsageTypeCodelistType;
import sdmx.data.DataSet;
import sdmx.data.flat.FlatDataSet;
import sdmx.structure.StructuresType;
import sdmx.structure.base.StructureUsageType;
import sdmx.xml.anyURI;

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
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *   SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
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
    public void setDataStructure(DataStructureReferenceType ref,anyURI uri) {
        List<PayloadStructureType> structures = this.getHeader().getStructures();
        if( structures == null ) {
            structures = new ArrayList<PayloadStructureType>();
        }
        PayloadStructureType payload = structures.size()==0?null:structures.get(0);
        if( payload!=null ) {
            System.out.println("Strucure");
            payload.getStructure().dump();
            return;
        }
        payload = new PayloadStructureType();
        payload.setStructure(ref);
        structures.add(payload);
        getHeader().setStructures(structures);
    }
}

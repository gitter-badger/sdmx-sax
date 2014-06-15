/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.structureddata;

import java.util.ArrayList;
import java.util.List;
import sdmx.Registry;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedIDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.VersionType;
import sdmx.message.DataMessage;
import sdmx.structure.datastructure.DataStructureType;

/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *  SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public class StructuredDataMessage {
    private DataMessage dataMessage = null;
    private Registry registry = null;
    
    
    private List<StructuredDataSet> list = new ArrayList<StructuredDataSet>();
    
    public StructuredDataMessage(DataMessage dat,Registry reg) {
        this.dataMessage=dat;
        this.registry=reg;
        for(int i=0;i<dataMessage.getDataSets().size();i++) {
            list.add(buildDecoratedDataSet(i));
        }
    }
    
    
    public int size() { return dataMessage.getDataSets().size(); }
    public StructuredDataSet getDecoratedDataSet(int i) {
        return list.get(i);
    }
    public StructuredDataSet buildDecoratedDataSet(int i) {
        NestedNCNameIDType agency = dataMessage.getHeader().getStructures().get(0).getStructure().getRef().getAgencyId();
        NestedIDType id = dataMessage.getHeader().getStructures().get(0).getStructure().getRef().getId();
        VersionType vers = dataMessage.getHeader().getStructures().get(0).getStructure().getRef().getVersion();
        System.out.println("Ref="+agency+":"+id+":"+vers);
        DataStructureType structure = registry.findDataStructure(agency, id.asID(), vers);
        System.out.println("Structure="+structure);
        return new StructuredDataSet(dataMessage.getDataSets().get(i),registry,structure);
    }
}

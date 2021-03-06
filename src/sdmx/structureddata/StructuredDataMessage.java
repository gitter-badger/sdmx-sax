/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structureddata;

import java.util.ArrayList;
import java.util.List;
import sdmx.Registry;
import sdmx.commonreferences.DataStructureReference;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedID;
import sdmx.commonreferences.NestedNCNameID;
import sdmx.commonreferences.Version;
import sdmx.message.DataMessage;
import sdmx.structure.dataflow.DataflowType;
import sdmx.structure.datastructure.DataStructureType;

/**
 * This file is part of SdmxSax.
 *
 * SdmxSax is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * SdmxSax is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * SdmxSax. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright James Gardner 2014
 */
public class StructuredDataMessage {

    private DataMessage dataMessage = null;
    private Registry registry = null;
    private DataflowType dataflow = null;

    private List<StructuredDataSet> list = new ArrayList<StructuredDataSet>();

    public StructuredDataMessage(DataMessage dat, Registry reg) {
        this.dataMessage = dat;
        this.registry = reg;
        for (int i = 0; i < dataMessage.getDataSets().size(); i++) {
            list.add(buildStructuredDataSet(i));
        }
    }

    public int size() {
        return getDataMessage().getDataSets().size();
    }

    public StructuredDataSet getStructuredDataSet(int i) {
        return list.get(i);
    }

    public StructuredDataSet buildStructuredDataSet(int i) {
        //dataMessage.getHeader().getStructures().get(0).getStructure().dump();
        //NestedNCNameID agency = dataMessage.getHeader().getStructures().get(0).getStructure().getAgencyId();
        //IDType id = dataMessage.getHeader().getStructures().get(0).getStructure().getMaintainableParentId();
        //Version vers = dataMessage.getHeader().getStructures().get(0).getStructure().getMaintainedParentVersion();
        //System.out.println("Ref="+agency+":"+id+":"+vers);
        DataStructureType structure = getRegistry().find(getDataMessage().getHeader().getStructures().get(0).getStructure().asDataStructureReference());
        //System.out.println("Structure="+structure);
        if (this.dataflow == null) {
            this.setDataflow(structure.asDataflow());
        }
        return new StructuredDataSet(getDataMessage().getDataSets().get(i), getRegistry(), structure);
    }

    /**
     * @return the dataMessage
     */
    public DataMessage getDataMessage() {
        return dataMessage;
    }

    /**
     * @return the registry
     */
    public Registry getRegistry() {
        return registry;
    }

    /**
     * @return the dataflow
     */
    public DataflowType getDataflow() {
        return dataflow;
    }

    /**
     * @param dataflow the dataflow to set
     */
    public void setDataflow(DataflowType dataflow) {
        this.dataflow = dataflow;
    }
}

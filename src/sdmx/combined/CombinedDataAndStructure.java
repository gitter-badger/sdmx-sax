/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.combined;

import sdmx.Registry;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedIDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.VersionType;
import sdmx.message.DataMessage;
import sdmx.structure.datastructure.DataStructureType;

/**
 *
 * @author James
 */
public class CombinedDataAndStructure {
    private DataMessage dataMessage = null;
    private Registry registry = null;
    public int size() { return dataMessage.getDataSets().size(); }
    public DecoratedDataSet getDecoratedDataSet(int i) {
        NestedNCNameIDType agency = dataMessage.getHeader().getStructures().get(0).getStructure().getRef().getAgencyId();
        NestedIDType id = dataMessage.getHeader().getStructures().get(0).getStructure().getRef().getId();
        VersionType vers = dataMessage.getHeader().getStructures().get(0).getStructure().getRef().getVersion();
        IDType idtype = new IDType(id.toString());
        DataStructureType structure = registry.findDataStructure(agency, idtype, vers);
        return new DecoratedDataSet(dataMessage.getDataSets().get(i),registry,structure);
    }
}

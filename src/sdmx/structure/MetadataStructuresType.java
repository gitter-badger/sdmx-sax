/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure;

import java.util.ArrayList;
import java.util.List;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedID;
import sdmx.commonreferences.NestedNCNameID;
import sdmx.commonreferences.Version;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structure.metadatastructure.MetadataStructureType;

/**
 *
 * @author James
 */

public class MetadataStructuresType {

    private List<MetadataStructureType> metadataStructures = new ArrayList<MetadataStructureType>();

    /**
     * @return the metadataStructures
     */
    public List<MetadataStructureType> getMetadataStructures() {
        return metadataStructures;
    }

    /**
     * @param metadataStructures the metadataStructures to set
     */
    public void setMetadataStructures(List<MetadataStructureType> metadataStructures) {
        this.metadataStructures = metadataStructures;
    }
public MetadataStructureType findMetadataStructure(String agency,String id,String vers) {
        IDType findid = new IDType(id);
        NestedNCNameID ag = new NestedNCNameID(agency);
        Version ver = new Version(vers);
        return findMetadataStructure(ag,findid,ver);
    }
    public MetadataStructureType findMetadataStructure(NestedNCNameID agency2,NestedID findid,Version ver) {
        for(int i=0;i<metadataStructures.size();i++) {
            if( metadataStructures.get(i).identifiesMe(agency2,findid,ver)) {
                return metadataStructures.get(i);
            }
        }
        return null;
    }
}

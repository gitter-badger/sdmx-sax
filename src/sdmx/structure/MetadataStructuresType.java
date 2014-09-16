/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure;

import java.util.ArrayList;
import java.util.List;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedIDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.VersionType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structure.metadatastructure.MetadataStructureType;

/**
 *
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
        NestedNCNameIDType ag = new NestedNCNameIDType(agency);
        VersionType ver = new VersionType(vers);
        return findMetadataStructure(ag,findid,ver);
    }
    public MetadataStructureType findMetadataStructure(NestedNCNameIDType agency2,NestedIDType findid,VersionType ver) {
        for(int i=0;i<metadataStructures.size();i++) {
            if( metadataStructures.get(i).identifiesMe(agency2,findid,ver)) {
                return metadataStructures.get(i);
            }
        }
        return null;
    }
}

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
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
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

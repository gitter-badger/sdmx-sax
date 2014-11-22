/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.cube;

import java.util.List;
import sdmx.commonreferences.IDType;
import sdmx.data.ColumnMapper;
import sdmx.data.flat.FlatObs;
import sdmx.data.key.FullKey;
import sdmx.structure.base.Component;
import sdmx.structure.base.NameableType;
import sdmx.structure.datastructure.AttributeType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structure.datastructure.DimensionType;
import sdmx.structure.datastructure.MeasureDimensionType;
import sdmx.structure.datastructure.PrimaryMeasure;
import sdmx.structure.datastructure.TimeDimensionType;

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
public class Cube {

    private List<String> order = null;
    DataStructureType struct = null;

    public Cube(DataStructureType struct) {
        this.struct = struct;
    }

    private RootCubeDimension root = new RootCubeDimension();

    public RootCubeDimension getRootCubeDimension() {
        return root;
    }

    public void putObservation(List<String> order,ColumnMapper mapper, FlatObs obs) {
        CubeDimension dim = getRootCubeDimension();
        this.order=order;
        TimeCubeDimension time = null;
        CubeObservation cubeobs = null;
        for (int i = 0; i < struct.getDataStructureComponents().getDimensionList().size(); i++) {
            //if( struct.getDataStructureComponents().getDimensionList().getDimension(i).)
            // This line goes through the components in their datastructure order
            //IDType dimId = struct.getDataStructureComponents().getDimensionList().getDimension(i).getId();
            // This line goes through the components in their specified order
            IDType dimId = new IDType(order.get(i));
            CubeDimension myDim = dim.getSubDimension(obs.getValue(mapper.getColumnIndex(dimId.toString())));
            if (myDim == null) {
                //myDim = new HashMapCubeDimension(dimId.toString(), obs.getValue(mapper.getColumnIndex(dimId.toString())));
                myDim = new ListCubeDimension(dimId.toString(), obs.getValue(mapper.getColumnIndex(dimId.toString())));
                dim.putSubDimension(myDim);
            }
            dim = myDim;
        }
        CubeDimension myDim = null;
        IDType dimId = struct.getDataStructureComponents().getDimensionList().getTimeDimension().getId();
        int i = mapper.getColumnIndex(dimId.toString());
        String s = obs.getValue(i);
        myDim = dim.getSubDimension(obs.getValue(mapper.getColumnIndex(dimId.toString())));
        if (myDim == null) {
            myDim = new TimeCubeDimension(dimId.toString(), obs.getValue(mapper.getColumnIndex(dimId.toString())));
            dim.putSubDimension(myDim);
        }
        time = (TimeCubeDimension) myDim;
        String cross = null;
        IDType dimId2 = null;
        if( struct.getDataStructureComponents().getDimensionList().getMeasureDimension()!=null){
            dimId2 = struct.getDataStructureComponents().getDimensionList().getMeasureDimension().getId();
            cross = obs.getValue(mapper.getColumnIndex(dimId2.toString()));
        }
        IDType dimId3 = struct.getDataStructureComponents().getMeasureList().getPrimaryMeasure().getId();
        if (dimId2
                != null) {
            cubeobs = new CubeObservation(dimId2.toString(), cross, dimId3.toString(), obs.getValue(mapper.getColumnIndex(dimId3.toString())));
        } else {
            cubeobs = new CubeObservation(null, null, dimId3.toString(), obs.getValue(mapper.getColumnIndex(dimId3.toString())));
        }

        time.putObservation(cubeobs);

        for (int k = 0;k < struct.getDataStructureComponents().getAttributeList().size(); k++) {
            String name = struct.getDataStructureComponents().getAttributeList().getAttribute(k).getId().toString();
            String value = null;
            if (mapper.getColumnIndex(name) != -1) {
                value = obs.getValue(mapper.getColumnIndex(name));
                cubeobs.putAttribute(new CubeAttribute(name, value));
            }
        }
    }
    public CubeObservation find(FullKey key) {
        CubeDimension dim = getRootCubeDimension();
        CubeDimension oldDim = dim;
        for(int i=0;i<this.struct.getDataStructureComponents().getDimensionList().size();i++) {
            dim = dim.getSubDimension((String)key.getComponent(dim.getSubDimension()));
            if( dim == null ) {
                //System.out.println("Can't find dim:"+key.getComponent(order.get(i))+":"+oldDim.getSubDimension());
                return null;
            }
            oldDim = dim;
        }
        TimeDimensionType time = this.struct.getDataStructureComponents().getDimensionList().getTimeDimension();
        if( time == null ) {
            throw new RuntimeException("Time Dimension Is Null");
        }else{
            String timeValue = NameableType.toIDString((String)key.getComponent(time.getId().toString()));
            TimeCubeDimension tcd = (TimeCubeDimension)dim.getSubDimension(timeValue);
            if( tcd == null ) {
                //System.out.println("TCD null:"+key.getComponent(time.getId().toString()+":"+timeValue));
                //dim.dump();
                return null;
            }
            if( struct.getDataStructureComponents().getDimensionList().getMeasureDimension()!=null){
                String measure = NameableType.toIDString(key.getComponent(struct.getDataStructureComponents().getDimensionList().getMeasureDimension().getId().toString()));
                //tcd.dump();
                //System.out.println("Measure="+measure);
                return tcd.getObservation(measure);
            }else {
                CubeObservation co = tcd.getObservation(struct.getDataStructureComponents().getMeasureList().getPrimaryMeasure().getId().toString());
                return co;
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.cube;

import sdmx.commonreferences.IDType;
import sdmx.data.ColumnMapper;
import sdmx.data.flat.FlatObs;
import sdmx.structure.base.Component;
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

    DataStructureType struct = null;

    public Cube(DataStructureType struct) {
        this.struct = struct;
    }

    private RootCubeDimension root = new RootCubeDimension();

    public RootCubeDimension getRootCubeDimension() {
        return root;
    }

    public void putObservation(ColumnMapper mapper, FlatObs obs) {
        CubeDimension dim = getRootCubeDimension();
        for (int i = 0; i < struct.getDataStructureComponents().getDimensionList().size(); i++) {
            IDType dimId = struct.getDataStructureComponents().getDimensionList().getDimension(i).getId();
            CubeDimension myDim = dim.getSubDimension(obs.getValue(mapper.getColumnIndex(dimId.toString())));
            if (myDim == null) {
                myDim = new MultipleValueCubeDimension(dimId.toString(), obs.getValue(mapper.getColumnIndex(dimId.toString())));
                dim.putSubDimension(myDim);
            }
            dim = myDim;
        }
        IDType dimId = struct.getDataStructureComponents().getTimeDimension().getId();
        CubeDimension myDim = dim.getSubDimension(obs.getValue(mapper.getColumnIndex(dimId.toString())));
        if (myDim == null) {
            myDim = new TimeCubeDimension(dimId.toString(), obs.getValue(mapper.getColumnIndex(dimId.toString())));
            dim.putSubDimension(myDim);
        }
        TimeCubeDimension time = (TimeCubeDimension) myDim;
        CubeObservation cubeobs = null;

        for (int i = 0; i < struct.getDataStructureComponents().getMeasureList().size(); i++) {
            IDType dimId2 = struct.getDataStructureComponents().getMeasureList().getMeasure(i).getId();
            cubeobs = time.getObservation(obs.getValue(mapper.getColumnIndex(dimId2.toString())));
            if (cubeobs == null) {
                cubeobs = new CubeObservation(dimId2.toString(), obs.getValue(mapper.getColumnIndex(dimId2.toString())));
                time.putObservation(cubeobs);
            }
        }
        IDType dimId3 = struct.getDataStructureComponents().getMeasureList().getPrimaryMeasure().getId();
        if (cubeobs == null) {
            cubeobs = new CubeObservation(dimId3.toString(), obs.getValue(mapper.getColumnIndex(dimId3.toString())));
            time.putObservation(cubeobs);
        }

        for (int i = 0; i < struct.getDataStructureComponents().getAttributeList().size(); i++) {
            String name = struct.getDataStructureComponents().getAttributeList().getAttribute(i).getId().toString();
            String value = null;
            if (mapper.getColumnIndex(name) != -1) {
                value = obs.getValue(mapper.getColumnIndex(name));
                cubeobs.putAttribute(new CubeAttribute(name, value));
            }
        }
    }
}

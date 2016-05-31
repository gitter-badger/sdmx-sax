/*
    This file is part of sdmx-sax.

    sdmx-sax is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    sdmx-sax is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with sdmx-sax.  If not, see <http://www.gnu.org/licenses/>.
    Copyright (C) 2015 James Gardner
*/
package sdmx.cube;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import sdmx.commonreferences.IDType;
import sdmx.data.ColumnMapper;
import sdmx.data.flat.FlatObs;
import sdmx.data.key.FullKey;
import sdmx.structure.base.Component;
import sdmx.structure.base.NameableType;
import sdmx.structure.codelist.CodeType;
import sdmx.structure.datastructure.AttributeType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structure.datastructure.DimensionType;
import sdmx.structure.datastructure.MeasureDimensionType;
import sdmx.structure.datastructure.PrimaryMeasure;
import sdmx.structure.datastructure.TimeDimensionType;
import sdmx.structureddata.ValueTypeResolver;

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

    private int size = 0;
    private List<String> order = null;
    DataStructureType struct = null;
    private HashMap<String, List<String>> validCodes = new HashMap<String, List<String>>();

    public Cube(DataStructureType struct) {
        this.struct = struct;
    }

    private RootCubeDimension root = new RootCubeDimension();

    public RootCubeDimension getRootCubeDimension() {
        return root;
    }

    public void putObservation(List<String> order, ColumnMapper mapper, FlatObs obs) {
        CubeDimension dim = getRootCubeDimension();
        this.order = order;
        TimeCubeDimension time = null;
        CubeObservation cubeobs = null;
        for (int i = 0; i < struct.getDataStructureComponents().getDimensionList().size(); i++) {
            //if( struct.getDataStructureComponents().getDimensionList().getDimension(i).)
            // This line goes through the components in their datastructure order
            //IDType dimId = struct.getDataStructureComponents().getDimensionList().getDimension(i).getId();
            // This line goes through the components in their specified order
            IDType dimId = null;
            if (order != null) {
                dimId = new IDType(order.get(i));
            } else {
                dimId = struct.getDataStructureComponents().getDimensionList().getDimension(i).getId();
            }
            if (validCodes.get(dimId.toString()) == null) {
                validCodes.put(dimId.toString(), new ArrayList<String>());
            }
            /*
                If the data you are trying to make a cube from does not have a complete key
                with values for all dimensions, mapper.getColumnIndex(dimId.toString()) returns -1
                here (because there is no dimension of that name in the FlatObservation)
                this filters down into FlatObservation.getValue(-1) which causes an array index
                out of bounds exception!
            */
            CubeDimension myDim = dim.getSubDimension(obs.getValue(mapper.getColumnIndex(dimId.toString())));
            if (myDim == null) {
                //myDim = new HashMapCubeDimension(dimId.toString(), obs.getValue(mapper.getColumnIndex(dimId.toString())));
                myDim = new ListCubeDimension(dimId.toString(), obs.getValue(mapper.getColumnIndex(dimId.toString())));
                dim.putSubDimension(myDim);
                if (!validCodes.get(dimId.toString()).contains(myDim.getValue())) {
                    validCodes.get(dimId.toString()).add(myDim.getValue());
                }
            }
            dim = myDim;
        }
        CubeDimension myDim = null;
        IDType dimId = struct.getDataStructureComponents().getDimensionList().getTimeDimension().getId();
        if (validCodes.get(dimId.toString()) == null) {
            validCodes.put(dimId.toString(), new ArrayList<String>());
        }
        int i = mapper.getColumnIndex(dimId.toString());
        String s = obs.getValue(i);
        myDim = dim.getSubDimension(obs.getValue(mapper.getColumnIndex(dimId.toString())));
        if (myDim == null) {
            myDim = new TimeCubeDimension(dimId.toString(), obs.getValue(mapper.getColumnIndex(dimId.toString())));
            dim.putSubDimension(myDim);
            if (!validCodes.get(dimId.toString()).contains(myDim.getValue())) {
                validCodes.get(dimId.toString()).add(myDim.getValue());
            }
        }
        time = (TimeCubeDimension) myDim;
        String cross = null;
        IDType dimId2 = null;
        if (struct.getDataStructureComponents().getDimensionList().getMeasureDimension() != null) {
            dimId2 = struct.getDataStructureComponents().getDimensionList().getMeasureDimension().getId();
            if (validCodes.get(dimId2.toString()) == null) {
                validCodes.put(dimId2.toString(), new ArrayList<String>());
            }
            cross = obs.getValue(mapper.getColumnIndex(dimId2.toString()));
            if (!validCodes.get(dimId2.toString()).contains(cross)) {
                validCodes.get(dimId2.toString()).add(cross);
            }

        }
        IDType dimId3 = struct.getDataStructureComponents().getMeasureList().getPrimaryMeasure().getId();
        if (dimId2
                != null) {
            cubeobs = new CubeObservation(dimId2.toString(), cross, dimId3.toString(), obs.getValue(mapper.getColumnIndex(dimId3.toString())));
        } else {
            cubeobs = new CubeObservation(null, null, dimId3.toString(), obs.getValue(mapper.getColumnIndex(dimId3.toString())));
        }

        time.putObservation(cubeobs);

        for (int k = 0; k < struct.getDataStructureComponents().getAttributeList().size(); k++) {
            String name = struct.getDataStructureComponents().getAttributeList().getAttribute(k).getId().toString();
            String value = null;
            if (mapper.getColumnIndex(name) != -1) {
                value = obs.getValue(mapper.getColumnIndex(name));
                cubeobs.putAttribute(new CubeAttribute(name, value));
            }
        }
        size++;
    }

    public CubeObservation find(FullKey key) {
        return find(key, false);
    }

    public CubeObservation find(FullKey key, boolean latest) {
        CubeDimension dim = getRootCubeDimension();
        CubeDimension oldDim = dim;
        for (int i = 0; i < this.struct.getDataStructureComponents().getDimensionList().size(); i++) {
            dim = dim.getSubDimension((String) key.getComponent(dim.getSubDimension()));
            if (dim == null) {
                //System.out.println("Can't find dim:"+key.getComponent(order.get(i))+":"+oldDim.getSubDimension());
                return null;
            }
            oldDim = dim;
        }
        TimeDimensionType time = this.struct.getDataStructureComponents().getDimensionList().getTimeDimension();
        if (time == null) {
            throw new RuntimeException("Time Dimension Is Null");
        } else {
            if (latest) {
                Set times = dim.listDimensionValues();
                List<String> timesList = new ArrayList<String>(times);
                Collections.sort(timesList);
                String timeValue = timesList.get(timesList.size()-1);
                TimeCubeDimension tcd = (TimeCubeDimension) dim.getSubDimension(timeValue);
                if (tcd == null) {
                //System.out.println("TCD null:"+key.getComponent(time.getId().toString()+":"+timeValue));
                    //dim.dump();
                    return null;
                }
                if (struct.getDataStructureComponents().getDimensionList().getMeasureDimension() != null) {
                    String measure = NameableType.toIDString(key.getComponent(struct.getDataStructureComponents().getDimensionList().getMeasureDimension().getId().toString()));
                //tcd.dump();
                    //System.out.println("Measure="+measure);
                    return tcd.getObservation(measure);
                } else {
                    CubeObservation co = tcd.getObservation(struct.getDataStructureComponents().getMeasureList().getPrimaryMeasure().getId().toString());
                    return co;
                }
            } else {
                String timeValue = NameableType.toIDString((String) key.getComponent(time.getId().toString()));
                TimeCubeDimension tcd = (TimeCubeDimension) dim.getSubDimension(timeValue);
                if (tcd == null) {
                //System.out.println("TCD null:"+key.getComponent(time.getId().toString()+":"+timeValue));
                    //dim.dump();
                    return null;
                }
                if (struct.getDataStructureComponents().getDimensionList().getMeasureDimension() != null) {
                    String measure = NameableType.toIDString(key.getComponent(struct.getDataStructureComponents().getDimensionList().getMeasureDimension().getId().toString()));
                //tcd.dump();
                    //System.out.println("Measure="+measure);
                    return tcd.getObservation(measure);
                } else {
                    CubeObservation co = tcd.getObservation(struct.getDataStructureComponents().getMeasureList().getPrimaryMeasure().getId().toString());
                    return co;
                }
            }
        }
    }

    public List<String> getValidCodes(String col) {
        return validCodes.get(col);
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }
}

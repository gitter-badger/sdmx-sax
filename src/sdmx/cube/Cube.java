/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.cube;

import sdmx.data.ColumnMapper;
import sdmx.data.flat.FlatObs;

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

    private CubeDimension root = null;

    public CubeDimension getRootCubeDimension() {
        return root;
    }
    public void putObservation(ColumnMapper mapper,FlatObs obs) {
        CubeDimension dim = getRootCubeDimension();
        CubeDimension previous = dim;
        if( dim == null ) {
            root = new MultipleValueCubeDimension(mapper.getColumnName(0),obs.getValue(0));
            dim = root;
            previous = dim;
        }
        for(int i=1;i<mapper.size();i++) {
            dim = dim.getSubDimension(obs.getValue(i));
            if( dim == null ) {
                dim = new MultipleValueCubeDimension(mapper.getColumnName(i),obs.getValue(i));
                previous.putSubDimension(dim);
            }
            previous = dim;
        }
    }
}

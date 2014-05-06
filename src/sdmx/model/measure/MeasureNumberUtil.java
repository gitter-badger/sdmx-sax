/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.model.measure;

import java.math.BigInteger;
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
public class MeasureNumberUtil {
/*
    public static MeasureNumber fromConceptAndDim(ConceptType concept, BaseDimensionType dim, String value) {
        RepresentationType rep = dim.getLocalRepresentation();
        if (rep == null) {
            rep = concept.getCoreRepresentation();
        }
        if (rep.getTextFormat() == null) {
            return new DoubleMeasureNumber(value);
        }
        if (rep.getTextFormat().getDecimals() == null) {
            return new DoubleMeasureNumber(value);
        } else {
            int decimals = rep.getTextFormat().getDecimals().intValue();
            if (decimals == 0) {
                return new IntegerMeasureNumber(value);
            } else {
                return new DoubleMeasureNumber(value);
            }
        }
    }

    public static MeasureNumber fromConceptAndDim(ConceptType concept, PrimaryMeasureType dim, String value) {
        RepresentationType rep = dim.getLocalRepresentation();
        if (rep == null) {
            rep = concept.getCoreRepresentation();
        }
        if (rep.getTextFormat() == null) {
            return new DoubleMeasureNumber(value);
        }
        if (rep.getTextFormat().getDecimals() == null) {
            return new DoubleMeasureNumber(value);
        } else {
            int decimals = rep.getTextFormat().getDecimals().intValue();
            if (decimals == 0) {
                return new IntegerMeasureNumber(value);
            } else {
                return new DoubleMeasureNumber(value);
            }
        }
    }
    */
}

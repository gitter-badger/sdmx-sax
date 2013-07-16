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

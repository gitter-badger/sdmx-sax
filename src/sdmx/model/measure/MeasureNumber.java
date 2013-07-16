/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.model.measure;


/**
 *
 * @author James
 */
public interface MeasureNumber extends Comparable {
    public static final MeasureNumber SMALL = new DoubleMeasureNumber(Double.MIN_VALUE);
    public static final MeasureNumber BIG = new DoubleMeasureNumber(Double.MAX_VALUE);
    @Override
    public String toString();
    @Override
    public boolean equals(Object o);
    @Override
    public int hashCode();

    public Number getNumberValue();
}

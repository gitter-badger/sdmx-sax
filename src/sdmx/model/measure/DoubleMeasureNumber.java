/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.model.measure;
/**
 *
 * @author James
 */
public class DoubleMeasureNumber implements MeasureNumber {

    Double val = null;
    public DoubleMeasureNumber(String s) {
        val=Double.parseDouble(s);
    }
    public DoubleMeasureNumber(double d) {
        this.val=d;
    }

    public String toString() { return val.toString(); }
    public Number getNumberValue() { return val; }
    public Double getDoubleValue() { return val; }
    public int compareTo(Object o) {
        if( o instanceof DoubleMeasureNumber ) {
            DoubleMeasureNumber d = (DoubleMeasureNumber)o;
            return Double.compare(val, d.val);
        }else throw new RuntimeException("Not A DoubleMeasure!");
    }
    public String getTextFormatName() { return "Double"; }
}

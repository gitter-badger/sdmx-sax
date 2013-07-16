/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.model.measure;



/**
 *
 * @author James
 */
public class IntegerMeasureNumber implements MeasureNumber {

    Integer val = null;

    public IntegerMeasureNumber(String s) {
        val = Integer.parseInt(s);
    }

    public IntegerMeasureNumber(int d) {
        this.val = d;
    }

    public String toString() {
        return val.toString();
    }

    public Number getNumberValue() {
        return val;
    }

    public Integer getIntegerValue() {
        return val;
    }

    public int compareTo(Object o) {
        if (o instanceof IntegerMeasureNumber) {
            IntegerMeasureNumber d = (IntegerMeasureNumber) o;
            return val.compareTo(d.val);

        } else {
            throw new RuntimeException(
                    "Not An IntegerMeasure!");
        }
    }

    public String getTextFormatName() {
        return "Integer";

    }

}

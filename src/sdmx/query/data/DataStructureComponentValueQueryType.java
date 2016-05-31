/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.data;

import java.util.List;
import sdmx.commonreferences.NCNameID;
import sdmx.query.base.NumericValue;
import sdmx.query.base.TextValue;
import sdmx.query.base.TimeValue;

/**
 *
 * @author James
 */

public class DataStructureComponentValueQueryType {
    private NCNameID id = null;
    private List<NumericValue> numericValues = null;
    private List<TextValue> textValues = null;
    private List<TimeValue> timeValues = null;
    private String value = null;

    /**
     * @return the id
     */
    public NCNameID getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(NCNameID id) {
        this.id = id;
    }

    /**
     * @return the numericValues
     */
    public List<NumericValue> getNumericValues() {
        return numericValues;
    }

    /**
     * @param numericValues the numericValues to set
     */
    public void setNumericValues(List<NumericValue> numericValues) {
        this.numericValues = numericValues;
    }

    /**
     * @return the textValue
     */
    public List<TextValue> getTextValues() {
        return textValues;
    }

    /**
     * @param textValue the textValue to set
     */
    public void setTextValues(List<TextValue> textValue) {
        this.textValues = textValue;
    }

    /**
     * @return the timeValue
     */
    public List<TimeValue> getTimeValues() {
        return timeValues;
    }

    /**
     * @param timeValue the timeValue to set
     */
    public void setTimeValues(List<TimeValue> timeValue) {
        this.timeValues = timeValue;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
}

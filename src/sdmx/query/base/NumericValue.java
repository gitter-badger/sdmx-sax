/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import sdmx.common.OrderedOperatorType;

/**
 *
 * @author James
 */
public class NumericValue extends NumericValueType {
     public NumericValue(double d, OrderedOperatorType operator) {
         super(d,operator);
     }
}

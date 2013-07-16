/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.xml;

/**
 *
 * @author James
 */
public class positiveInteger {
    int i = 0;
    public positiveInteger(int i) {
        if( i<0)throw new RuntimeException(i+" is not a positive integer!");
        this.i=i;
    }
    public int getValue() { return i; }
}

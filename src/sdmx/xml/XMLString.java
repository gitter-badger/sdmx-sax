/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.xml;

import sdmx.common.DataType;

/**
 *
 * @author James
 */
public class XMLString {
    String value = null;
    public XMLString(String s) {
        this.value=s;
    }
    public String getString() { return value; }
    public String toString() {
        return value;
    }
}

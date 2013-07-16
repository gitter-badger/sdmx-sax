/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.xml;

/**
 *
 * @author James
 */
import sdmx.xml.XMLString;
import java.util.regex.*;

public class RegexXMLString extends XMLString {

    public RegexXMLString(String s) {
        super(s);
        Pattern[] patterns = getPatternArray();
        for (int i = 0; i < patterns.length; i++) {
            if (!patterns[i].matcher(s).matches()) {
                throw new RuntimeException("Input " + s + " does not match Pattern:" + patterns[i].pattern());
            }
        }
    }
// Override Me
    public Pattern[] getPatternArray() {
        return new Pattern[]{};
    }
}

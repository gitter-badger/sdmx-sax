/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.xml;

/**
 *
 * @author James
 */
/**
 * This file is part of SdmxSax.
 *
 * SdmxSax is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * SdmxSax is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * SdmxSax. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright James Gardner 2014
 */
import sdmx.xml.XMLString;
import java.util.regex.*;
import sdmx.SdmxIO;

public class RegexXMLString extends XMLString {

    public RegexXMLString(String s) {
        super(s);
        Pattern[] patterns = getPatternArray();
        for (int i = 0; i < patterns.length; i++) {
            if (!patterns[i].matcher(s).matches()) {
                if (SdmxIO.isStrictRegex()) {
                    throw new ExceptionInInitializerError("Input " + s + " does not match Pattern:" + patterns[i].pattern());
                }else {
                    System.out.println("Input "+s+" does not match Pattern:"+patterns[i].pattern()+" for class:"+getClass().getSimpleName());
                }
            }
        }
    }
// Override Me

    public Pattern[] getPatternArray() {
        return new Pattern[]{};
    }
}

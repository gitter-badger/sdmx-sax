/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.regex.Pattern;
import sdmx.xml.RegexXMLString;

/**
 *
 * @author James
 */
public class BaseReportPeriodType extends RegexXMLString {
    public static final String PATTERN = "\\d{4}\\-([ASTQ]\\d{1}|[MW]\\d{2}|[D]\\d{3})(Z|((\\+|\\-)\\d{2}:\\d{2}))?";
    public static final Pattern REGEX_PATTERN = Pattern.compile(PATTERN);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN};
// Override Me
    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
    public BaseReportPeriodType(String s) {
        super(s);
    }

}

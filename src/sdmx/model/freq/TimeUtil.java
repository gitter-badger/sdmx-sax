/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.model.freq;

/**
 *
 * @author James
 */
public class TimeUtil {

    public static TimeDetail parse(String freq, String s) {
        if ("".equals(s)) {
            throw new RuntimeException("Time Detail of \'\'");
        }
        if (freq != null) {
            if ("A".equals(freq)) {
                return new AnnualTimeDetail(s);
            } else if ("B".equals(freq)) {
                return new BusinessTimeDetail(s);
            } else if ("D".equals(freq)) {
                return new DailyTimeDetail(s);
            } else if ("M".equals(freq)) {
                return new MonthlyTimeDetail(s);
            } else if ("N".equals(freq)) {
                return new MinutelyTimeDetail(s);
            } else if ("Q".equals(freq)) {
                return new QuarterlyTimeDetail(s);
            } else if ("S".equals(freq)) {
                return new HalfYearlyTimeDetail(s);
            } else if ("W".equals(freq)) {
                return new WeeklyTimeDetail(s);
            }
        }
        return new StringTimeDetail(s);
    }
}

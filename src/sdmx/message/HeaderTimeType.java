/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.message;

import sdmx.xml.DateTime;
import sdmx.xml.DateType;

/**
 *	<xs:simpleType name="HeaderTimeType">
		<xs:annotation>
			<xs:documentation>Provides a union type of xs:date and xs:dateTime for the header fields in the message.</xs:documentation>
		</xs:annotation>
		<xs:union memberTypes="xs:dateTime xs:date"/>
	</xs:simpleType>

 * @author James
 */
public class HeaderTimeType {

    private DateTime date;

    public HeaderTimeType() {
        
    }

    /**
     * @return the date
     */
    public DateTime getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(DateTime date) {
        this.date = date;
    }
}

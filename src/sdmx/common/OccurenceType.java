/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

/**
 *	<xs:simpleType name="OccurenceType">
		<xs:annotation>
			<xs:documentation>OccurenceType is used to express the maximum occurrence of an object. It combines an integer, greater than 1, and the literal text, "unbounded", for objects which have no upper limit on its occurrence.</xs:documentation>
		</xs:annotation>
		<xs:union memberTypes="MaxOccursNumberType UnboundedCodeType"/>
	</xs:simpleType>
 * @author James
 */
public class OccurenceType {
    public static final String UNBOUNDED_TEXT = "unbounded";
    public static final String ONE_TEXT = "1";
    public static final OccurenceType UNBOUNDED = new OccurenceType(UNBOUNDED_TEXT);
    public static final OccurenceType ONE = new OccurenceType(ONE_TEXT);

    String ocurrs = "1";
    public OccurenceType(String s) {
        this.ocurrs=s;
    }
    
    public int getMaxOccurence() {
        if( "unbounded".equals(ocurrs) ) return Integer.MAX_VALUE;
        else {
            return Integer.parseInt(ocurrs);
        }
    }
    public static OccurenceType fromString(String s) {
       if( s == null ) return null;
       if( UNBOUNDED_TEXT.equals(s)) return UNBOUNDED;
       try{
           Integer.parseInt(s);
           return new OccurenceType(s);
       }catch(NumberFormatException nfe) {
           throw new RuntimeException("Invalid OccurenceType:"+s);
       }  
    }
}

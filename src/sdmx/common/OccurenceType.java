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
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *   SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

/**
 *	<xs:simpleType name="VersionQueryType">
		<xs:annotation>
			<xs:documentation>VersionQueryType combines the VersionType and LateBoundVersionType to allow one to query for either a specific version of an object, or the latest version by specifying the '*' value.</xs:documentation>
		</xs:annotation>
		<xs:union memberTypes="VersionType LateBoundVersionType"/>
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
public class VersionQueryType extends VersionType {
    public static void main(String args[]) {}
    public static final VersionQueryType ALL = new VersionQueryType("*");
    boolean all = false;
    private String s = null;
    public VersionQueryType(String s) {
        super("0");
        this.s=s;
        if( "*".equals(s) ) all=true;
    }
    public boolean compare(VersionType v) {
        if( all ) return true;
        if( v == null ) return true;
        else return getString().equals(v.getString());
    }
    public String getString() {
        return s;
    }
    public String toString() { return getString(); }
}

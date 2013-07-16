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
public class VersionQueryType extends VersionType {
    public static void main(String args[]) {}
    public static final VersionQueryType ALL = new VersionQueryType("*");
    boolean all = false;
    public VersionQueryType(String s) {
        super("0");
        if( "*".equals(s) ) all=true;
    }
    public boolean compare(VersionType v) {
        if( all ) return true;
        if( v == null ) return true;
        else return getString().equals(v.getString());
    }
}

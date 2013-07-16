/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import sdmx.common.TextOperatorType;
import sdmx.common.TextType;

/**
 *	<xs:complexType name="QueryTextType">
		<xs:annotation>
			<xs:documentation>QueryTextType describes the structure of a textual query value. A language must be specified if parallel multi-lingual values are available, otherwise it is ignored.</xs:documentation>
		</xs:annotation>
		<xs:simpleContent>
			<xs:extension base="common:TextType">
				<xs:attribute name="operator" type="common:TextOperatorType" default="equal">
					<xs:annotation>
						<xs:documentation>The operator attribute indicates how the supplied value should be applied to the objects being searched in order to constitute a match. For example, a value of "EqualTo" means the value of the field being search should exactly match the value supplied. See the defining type for further details.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:extension>
		</xs:simpleContent>
	</xs:complexType>

 * @author James
 */
public class QueryTextType extends TextType {
    TextOperatorType operator = TextOperatorType.EQUAL;
    public QueryTextType(String lang,String s,TextOperatorType operator) {
        super(lang,s);
        this.operator = operator;
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.codelist;

import java.util.ArrayList;
import java.util.List;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NCNameID;
import sdmx.commonreferences.NestedID;
import sdmx.commonreferences.NestedNCNameID;
import sdmx.structure.base.ItemSchemeType;
import sdmx.structure.base.ItemType;

/**
 * <xs:complexType name="CodelistType">
 * <xs:annotation>
 * <xs:documentation>CodelistType defines the structure of a codelist. A
 * codelist is defined as a list from which some statistical concepts (coded
 * concepts) take their values.</xs:documentation>
 * </xs:annotation>
 * <xs:complexContent>
 * <xs:restriction base="ItemSchemeType">
 * <xs:sequence>
 * <xs:element ref="common:Annotations" minOccurs="0"/>
 * <xs:element ref="common:Name" maxOccurs="unbounded"/>
 * <xs:element ref="common:Description" minOccurs="0" maxOccurs="unbounded"/>
 * <xs:sequence minOccurs="0" maxOccurs="unbounded">
 * <xs:element ref="Code"/>
 * </xs:sequence>
 * </xs:sequence>
 * <xs:attribute name="id" type="common:NCNameIDType" use="required">
 * <xs:annotation>
 * <xs:documentation>The id attribute holds the identification of the code list.
 * The type of this id is restricted to the common:NCNNameIDType. This is
 * necessary, since the code list may be used to create simple types in data and
 * metadata structure specific schemas and therefore must be compliant with the
 * NCName type in XML Schema (see common:NCNameIDType for further
 * details).</xs:documentation>
 * </xs:annotation>
 * </xs:attribute>
 * </xs:restriction>
 * </xs:complexContent>
 * </xs:complexType>	 *
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
public class CodelistType extends ItemSchemeType {

    private NCNameID id = null;

    public CodelistType() {

    }

    public CodeType getCode(int i) {
        return (CodeType) super.getItem(i);
    }

    public void setCode(int i, CodeType c) {
        super.setItem(i, c);
    }
    public void addCode(CodeType c) {
        super.getItems().add(c);
    }

    public void removeCode(CodeType c) {
        super.getItems().remove(c);
    }

    public void setCodes(List<CodeType> codes) {
        List<ItemType> items = new ArrayList<ItemType>();
        items.addAll(codes);
        super.setItems(items);
    }

    public CodeType findCode(String id) {
        return findCode(new IDType(id));
    }

    public CodeType findCode(IDType id) {
        return (CodeType) super.findItem(id);
    }
    public List<CodeType> findSubCodes(IDType id) {
        List<CodeType> result = new ArrayList<CodeType>();
        List<ItemType> codes = findSubItems(id);
        for(int i=0;i<codes.size();i++) {
            result.add((CodeType)codes.get(i));
        }
        return result;
    }

    public String toHTMLString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Codelist:" + super.getId().toString() + "<BR>");
        for (int i = 0; i < super.size(); i++) {
            sb.append(getCode(i).toHTMLString(0));
        }
        return sb.toString();
    }

    public void dump() {
        for (int i = 0; i < this.size(); i++) {
            this.getCode(i).dump();
        }
    }

    /**
     * @return the id
     */
    @Override
    public NCNameID getId() {
        return id;
    }

    @Override
    public void setId(IDType id) {
        this.id = (NCNameID) id;
    }

    /**
     * @param id the id to set
     */
    public void setId(NCNameID id) {
        this.id = id;
    }

    public List<ItemType> getLevel(int i) {
        List<ItemType> result = new ArrayList<ItemType>();
        if (i == 0) {
            for (int j = 0; j < size(); j++) {
                if (getCode(j).getParent() == null) {
                    result.add(getCode(j));
                }
            }
        }
        else if( i == 1 ) {
            List<ItemType> higher = getLevel(0);
            for(ItemType c:higher) {
                result.addAll(this.findSubItems(c.getId()));
            }
        }
        else if (i > 1) {
            List<ItemType> higher = getLevel(i - 1);
            for(ItemType c:higher) {
                result.addAll(this.findSubItems(c.getId()));
            }
        }
        return result;
    }
    public int getLevels() {
        
        for(int i=0;i<20;i++) {
            if( getLevel(i).size()==0 ) {
                return i-1;
            }
        }
        return 20;
    }
}

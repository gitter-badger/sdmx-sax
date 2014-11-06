/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.codelist;

import java.util.ArrayList;
import java.util.List;
import sdmx.commonreferences.LocalCodeReference;
import sdmx.structure.base.ItemType;

/**
 *
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
public class CodeType extends ItemType {

    LocalCodeReference parent = null;

    public CodeType getCode(int i) {
        return (CodeType) super.getItem(i);
    }

    public void setCode(int i, CodeType c) {
        super.setItem(i, c);
    }

    public void setCodes(List<CodeType> codes) {
        List<ItemType> items = new ArrayList<ItemType>(codes.size());
        items.addAll(codes);
        super.setItems(items);
    }

    public String toString() {
        if (getDescriptions() != null && getDescriptions().size() > 0) {
            return getDescriptions().get(0).getText();
        }
        if (getNames() != null && getNames().size() > 0) {
            return getNames().get(0).getText();
        }
        return super.getId().getString();
    }

    public String toHTMLString(int spaces) {
        StringBuffer sb = new StringBuffer();
        for (int k = 0; k < spaces; k++) {
            sb.append(" ");
        }
        sb.append("Code:" + super.getId().toString() + "<BR>");
        if (getAnnotations() != null) {
            for (int i = 0; i < super.getAnnotations().size(); i++) {
                for (int k = 0; k < spaces; k++) {
                    sb.append(" ");
                }
                sb.append("Annotation Title:" + super.getAnnotations().getAnnotation(i).getAnnotationTitle() + "<BR>");
                for (int k = 0; k < spaces; k++) {
                    sb.append(" ");
                }
                sb.append("Type:" + super.getAnnotations().getAnnotation(i).getAnnotationType() + "<BR>");
                for (int k = 0; k < spaces; k++) {
                    sb.append(" ");
                }
                sb.append("URL:" + super.getAnnotations().getAnnotation(i).getAnnotationUrl() + "<BR>");
                for (int k = 0; k < spaces; k++) {
                    sb.append(" ");
                }
                for (int j = 0; j < super.getAnnotations().getAnnotation(i).getAnnotationText().size(); j++) {
                    for (int k = 0; k < spaces; k++) {
                        sb.append(" ");
                    }
                    sb.append(super.getAnnotations().getAnnotation(i).getAnnotationText().get(j).getLang());
                    sb.append(":");
                    sb.append(super.getAnnotations().getAnnotation(i).getAnnotationText().get(j).getText() + "<BR>");
                }
            }
        }
        sb.append("Descriptions " + getDescriptions().size()+"<BR>");
        for (int j = 0; j < getDescriptions().size(); j++) {
            for (int k = 0; k < spaces; k++) {
                sb.append(" ");
            }
            sb.append(getDescriptions().get(j).getLang());
            sb.append(":");
            sb.append(getDescriptions().get(j).getText() + "<BR>");
        }

        for (int i = 0; i < super.size(); i++) {
            sb.append(getCode(i).toHTMLString(spaces + 3));
        }
        return sb.toString();
    }

    public void dump() {
        System.out.println("Code:"+this.getId()+":"+this.findName("en")+":"+this.findDescription("en"));
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import sdmx.SdmxIO;
import sdmx.common.Description;
import sdmx.common.Name;
import sdmx.structure.concept.ConceptType;

/**
 * <xs:complexType name="NameableType" abstract="true">
 * <xs:annotation>
 * <xs:documentation>NameableType is an abstract base type for all nameable
 * objects.</xs:documentation>
 * </xs:annotation>
 * <xs:complexContent>
 * <xs:extension base="IdentifiableType">
 * <xs:sequence>
 * <xs:element ref="common:Name" maxOccurs="unbounded">
 * <xs:annotation>
 * <xs:documentation>Name provides for a human-readable name for the object.
 * This may be provided in multiple, parallel language-equivalent
 * forms.</xs:documentation>
 * </xs:annotation>
 * </xs:element>
 * <xs:element ref="common:Description" minOccurs="0" maxOccurs="unbounded">
 * <xs:annotation>
 * <xs:documentation>Description provides for a longer human-readable
 * description of the object. This may be provided in multiple, parallel
 * language-equivalent forms.</xs:documentation>
 * </xs:annotation>
 * </xs:element>
 * </xs:sequence>
 * </xs:extension>
 * </xs:complexContent>
 * </xs:complexType>
 *
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
public class NameableType extends IdentifiableType {

    private List<Name> names = null;
    private List<Description> descriptions = null;

    /**
     * @return the names
     */
    public List<Name> getNames() {
        return names;
    }

    /**
     * @param names the names to set
     */
    public void setNames(List<Name> names1) {
        this.names = names1;
    }

    /**
     * @return the descriptions
     */
    public List<Description> getDescriptions() {
        return descriptions;
    }

    /**
     * @param descriptions the descriptions to set
     */
    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

    public Name findName(String lang) {
        if (names == null) {
            return null;
        }
        Name def = null;
        for (int i = 0; i < names.size(); i++) {
            if (lang != null && lang.equals(names.get(i).getLang())) {
                return names.get(i);
            }
            if (names.get(i).getLang() == null) {
                def = names.get(i);
            }
        }
        if (def == null && !"en".equals(lang)) {
            def = findName("en");
        }
        return def;
    }

    public Description findDescription(String lang) {
        if (descriptions == null) {
            return null;
        }
        Description def = null;
        for (int i = 0; i < descriptions.size(); i++) {
            if (lang != null && lang.equals(descriptions.get(i).getLang())) {
                return descriptions.get(i);
            }
            if (descriptions.get(i).getLang() == null) {
                def = descriptions.get(i);
            }
        }
        if (!"en".equals(lang)) {
            return findDescription("en");
        }
        return def;
    }

    public String toString() {
        Locale loc = Locale.getDefault();
        Name name = findName(loc.getLanguage());
        if (name != null) {
            return name.toString();
        }
        Description desc = findDescription(loc.getLanguage());
        if (desc != null) {
            return desc.getText();
        }
        return "NameableType";
    }

    public String getName() {
        if (SdmxIO.isSanitiseNames()) {
            return sanitise(toString(this));
        } else {
            return toString(this);
        }
    }

    private static String toString(NameableType named) {
        Locale loc = Locale.getDefault();
        //if (concept.equals("FREQ")) {
        //    ItemType code2 = getCode();
        //    System.out.println("FREQ Code=" + code2);
        //}
        if (named == null) {
            return "";
        }
        Description desc = named.findDescription(loc.getLanguage());
        if (desc == null) {
            Name name = named.findName(loc.getLanguage());
            if (name == null) {
                return named.getId().toString();
            }
            return name.getText();
        }
        return desc.getText();
    }
    private static String toString(NameableType named,Locale loc) {
        //if (concept.equals("FREQ")) {
        //    ItemType code2 = getCode();
        //    System.out.println("FREQ Code=" + code2);
        //}
        if (named == null) {
            return "";
        }
        Description desc = named.findDescription(loc.getLanguage());
        if (desc == null) {
            Name name = named.findName(loc.getLanguage());
            if (name == null) {
                return named.getId().toString();
            }
            return name.getText();
        }
        return desc.getText();
    }

    public static String toString(Object o) {
        if (o == null) {
            return "";
        }
        if (o instanceof String) {
            return (String) o;
        }
        if (o instanceof NameableType) {
            return toString((NameableType) o);
        }
        throw new RuntimeException("Not String or Nameable " + o.getClass());
    }
    public static String toString(Object o,Locale loc) {
        if (o == null) {
            return "";
        }
        if (o instanceof String) {
            return (String) o;
        }
        if (o instanceof NameableType) {
            return toString((NameableType) o,loc);
        }
        throw new RuntimeException("Not String or Nameable " + o.getClass());
    }

    private static String toIDString(NameableType named) {
        return named.getId().toString();
    }

    public static String toIDString(Object o) {
        if (o == null) {
            return "";
        }
        if (o instanceof String) {
            return (String) o;
        }
        if (o instanceof NameableType) {
            return toIDString((NameableType) o);
        }
        throw new RuntimeException("Not String or Nameable " + o.getClass());
    }

    public static String sanitise(String s) {
        return s;
        /*
        if (s.contains("'")) {
            s = s.replace("'", "&apos;");
        }
        if (s.contains("\"")) {
            s = s.replace("\"", "&quot;");
        }
        return s;
                */
        
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structureddata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import sdmx.Registry;
import sdmx.common.DataType;
import sdmx.common.Name;
import sdmx.commonreferences.ConceptReference;
import sdmx.commonreferences.ConceptSchemeReference;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemSchemeReferenceBase;
import sdmx.commonreferences.NestedID;
import sdmx.commonreferences.NestedNCNameID;
import sdmx.commonreferences.RefBase;
import sdmx.commonreferences.types.ItemSchemeTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.data.flat.FlatDataSet;
import sdmx.structure.base.Component;
import sdmx.structure.base.ItemBaseType;
import sdmx.structure.base.ItemSchemeType;
import sdmx.structure.base.ItemType;
import sdmx.structure.base.RepresentationType;
import sdmx.structure.codelist.CodeType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.datastructure.AttributeType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structure.datastructure.DimensionType;
import sdmx.structure.datastructure.MeasureDimensionType;
import sdmx.structure.datastructure.PrimaryMeasure;
import sdmx.structure.datastructure.TimeDimensionType;

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
public class ValueTypeResolver {

    public static ItemType resolveCode(Registry registry, DataStructureType struct, String column, String value) {
        if (value == null) {
            return null;
        }
        Component dim = struct.getDataStructureComponents().findDimension(column);
        if (dim == null && "type".equals(column)) {
            dim = struct.getDataStructureComponents().getDimensionList().getMeasureDimension();
        }
        ConceptReference conceptRef = dim.getConceptIdentity();
        RepresentationType rep = null;
        ConceptType concept = null;
        if (conceptRef != null) {
            concept = registry.find(conceptRef);
            if (concept == null) {
                System.out.println("Cant find concept:" + dim.getConceptIdentity().getId());
                System.out.println(conceptRef.getAgencyId() + ":" + conceptRef.getMaintainableParentId() + ":" + conceptRef.getId() + ":" + conceptRef.getVersion());
                CodeType ct = new CodeType();
                ct.setId(new IDType(value));
                Name name = new Name("en", value);
                ct.setNames(Collections.singletonList(name));
                return ct;
            }
            rep = concept.getCoreRepresentation();
        }
        RepresentationType localRep = dim.getLocalRepresentation();
        if (localRep != null) {
            rep = localRep;
        }
        if (rep != null) {
            if (rep.getEnumeration() != null) {
                if (rep.getEnumeration().getRefClass().toInt() == ItemSchemeTypeCodelistType.CODELIST.toInt()) {
                    CodelistType codelist = registry.find(rep.getEnumeration().asCodelistReference());
                    IDType id = null;
                    try {
                        id = new IDType(value);
                    } catch (ExceptionInInitializerError ie) {
                        // Ignore
                    }
                    CodeType ct = null;
                    if (id != null) {
                        ct = codelist.findCode(id);
                    }
                    if (ct == null) {
                        CodeType ct2 = new CodeType();
                        ct2.setId(id);
                        Locale loc = Locale.getDefault();
                        Name name = new Name("en", "Missing Code:" + value);
                        ArrayList<Name> names = new ArrayList<Name>();
                        names.add(name);
                        ct2.setNames(names);
                        return ct2;
                    } else {
                        return ct;
                    }
                } else {
                    ConceptSchemeType cs = registry.find(rep.getEnumeration().asConceptSchemeReference());
                    ConceptType conceptMeasure = null;
                    for (int i = 0; i < cs.size() && conceptMeasure == null; i++) {
                        ConceptType tempConcept = cs.getConcept(i);
                        if (tempConcept.getCode() != null && tempConcept.getCode().equals(value)) {
                            conceptMeasure = cs.getConcept(i);
                        } else if (tempConcept.getId().equals(value)) {
                            conceptMeasure = tempConcept;
                        }
                    }
                    if (conceptMeasure != null) {
                        //System.out.println("ConceptMeasure:"+conceptMeasure);
                        return conceptMeasure;

                    }
                    return null;
                }
            }
        } else {
            CodeType itm = new CodeType();
            Name name = new Name(Locale.getDefault().getLanguage(), value);
            List<Name> names = Collections.singletonList(name);
            itm.setNames(names);
            return itm;
        }
        return null;
    }

    public static ItemSchemeType getPossibleCodes(Registry registry, DataStructureType struct, String column) {
        Component dim = struct.getDataStructureComponents().findDimension(column);
        ConceptReference conceptRef = dim.getConceptIdentity();
        RepresentationType rep = null;
        ConceptType concept = null;
        if (conceptRef != null) {
            concept = registry.find(conceptRef);
            if (concept != null) {
                rep = concept.getCoreRepresentation();
            }
        }
        RepresentationType localRep = dim.getLocalRepresentation();
        if (localRep != null) {
            rep = localRep;
        }
        if (rep != null) {
            if (rep.getEnumeration() != null) {
                if (rep.getEnumeration().getRefClass() == ObjectTypeCodelistType.CONCEPTSCHEME) {
                    ConceptSchemeType cscheme = registry.find(rep.getEnumeration().asConceptSchemeReference());
                    if (cscheme == null) {
                        throw new RuntimeException("Can't find ConceptScheme!" + rep.getEnumeration().getMaintainableParentId().toString());
                    }
                    return cscheme;
                } else {
                    CodelistType codelist = registry.find(rep.getEnumeration().asCodelistReference());
                    if (codelist == null) {
                        throw new RuntimeException("Cant find codelist");
                    } else {
                        return codelist;
                    }
                }
            }
        }
        throw new RuntimeException("Problem occurred looking for codelist:"+column);
    }
}

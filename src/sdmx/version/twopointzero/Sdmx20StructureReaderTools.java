/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointzero;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.sdmx.resources.sdmxml.schemas.v20.structure.ComponentsType;
import org.sdmx.resources.sdmxml.schemas.v20.structure.PrimaryMeasureType;
import sdmx.common.ActionType;
import sdmx.common.AnnotationType;
import sdmx.common.DataType;
import sdmx.common.Description;
import sdmx.common.Name;
import sdmx.common.StandardTimePeriodType;
import sdmx.common.TextType;
import sdmx.common.DimensionTypeType;
import sdmx.common.ObservationalTimePeriodType;
import sdmx.common.PayloadStructureType;
import sdmx.common.TimezoneType;
import sdmx.commonreferences.ConceptRefType;
import sdmx.commonreferences.ConceptReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemSchemeRefBaseType;
import sdmx.commonreferences.ItemSchemeReferenceBaseType;
import sdmx.commonreferences.LocalItemRefBaseType;
import sdmx.commonreferences.LocalItemReferenceType;
import sdmx.commonreferences.NCNameIDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.StructureRefBaseType;
import sdmx.commonreferences.StructureReferenceBaseType;
import sdmx.commonreferences.VersionType;
import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.ItemSchemeTypeCodelistType;
import sdmx.commonreferences.types.ItemTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.exception.TypeValueNotFoundException;
import sdmx.message.BaseHeaderType;
import sdmx.message.ContactType;
import sdmx.message.HeaderTimeType;
import sdmx.message.PartyType;
import sdmx.message.SenderType;
import sdmx.message.StructureType;
import sdmx.structure.CodelistsType;
import sdmx.structure.ConceptsType;
import sdmx.structure.DataStructuresType;
import sdmx.structure.StructuresType;
import sdmx.structure.base.RepresentationType;
import sdmx.structure.base.TextFormatType;
import sdmx.structure.codelist.CodeType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptRepresentation;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.concept.ISOConceptReferenceType;
import sdmx.structure.datastructure.AttributeListType;
import sdmx.structure.datastructure.AttributeType;
import sdmx.structure.datastructure.DataStructureComponents;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structure.datastructure.DimensionListType;
import sdmx.structure.datastructure.DimensionType;
import sdmx.structure.datastructure.MeasureDimensionType;
import sdmx.structure.datastructure.MeasureListType;
import sdmx.structure.datastructure.PrimaryMeasure;
import sdmx.structure.datastructure.SimpleDataStructureRepresentationType;
import sdmx.structure.datastructure.TimeDimensionType;
import static sdmx.version.twopointone.Sdmx21StructureReaderTools.toContactList;
import static sdmx.version.twopointone.Sdmx21StructureReaderTools.toIDType;
import static sdmx.version.twopointone.Sdmx21StructureReaderTools.toNames;
import static sdmx.version.twopointone.Sdmx21StructureReaderTools.toTextType;
import static sdmx.version.twopointone.Sdmx21StructureReaderTools.toTimezoneType;
import sdmx.registry.LocalRegistry;
import sdmx.Registry;
import sdmx.xml.DateTime;
import sdmx.xml.DateType;
import sdmx.xml.ID;
import sdmx.xml.anyURI;
import sdmx.xml.duration;
import sdmx.xml.positiveInteger;

/**
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
public class Sdmx20StructureReaderTools {

    Registry registry = null;

    public Sdmx20StructureReaderTools() {
    }

    public Sdmx20StructureReaderTools(Registry registry) {
        // Temporary Registry for loading structure into before loading into main registry.
        this.registry = registry;
    }
    org.sdmx.resources.sdmxml.schemas.v20.message.StructureDocument structDoc = null;
    NestedNCNameIDType mainAgencyId = null;
    NestedNCNameIDType currentKeyFamilyAgency = null;

    public StructureType parseStructure(InputStream in) throws XmlException, IOException, TypeValueNotFoundException {
        XmlOptions xmlOptions = new XmlOptions();
        xmlOptions.setCharacterEncoding("utf-16");
        xmlOptions.setLoadStripComments();
        xmlOptions.setLoadTrimTextBuffer();
        xmlOptions.setLoadStripWhitespace();
        structDoc = org.sdmx.resources.sdmxml.schemas.v20.message.StructureDocument.Factory.parse(in, xmlOptions);
        mainAgencyId = new NestedNCNameIDType(structDoc.getStructure().getHeader().getSenderArray(0).getId());
        return parseStructure(structDoc);
    }

    public StructureType parseStructure(Reader in) throws XmlException, IOException, TypeValueNotFoundException {
        XmlOptions xmlOptions = new XmlOptions();
        xmlOptions.setCharacterEncoding("utf-16");
        xmlOptions.setLoadStripComments();
        xmlOptions.setLoadTrimTextBuffer();
        xmlOptions.setLoadStripWhitespace();
        structDoc = org.sdmx.resources.sdmxml.schemas.v20.message.StructureDocument.Factory.parse(in, xmlOptions);
        mainAgencyId = new NestedNCNameIDType(structDoc.getStructure().getHeader().getSenderArray(0).getId());
        return parseStructure(structDoc);
    }

    public StructureType parseStructure(org.sdmx.resources.sdmxml.schemas.v20.message.StructureDocument structDoc) throws TypeValueNotFoundException {
        StructureType sd = new StructureType();
        registry = sd;
        StructuresType struct = new StructuresType();
        sd.setStructures(struct);
        try {
            struct.setCodelists(toCodelists(structDoc.getStructure().getCodeLists()));
            struct.setConcepts(toConcepts(structDoc.getStructure().getConcepts()));
            struct.setDataStructures(toDataStructures(structDoc.getStructure().getKeyFamilies()));
            sd.setHeader(toHeaderType(structDoc.getStructure().getHeader()));
        } catch (URISyntaxException ex) {
            //System.out.println("Exception!");
            ex.printStackTrace();
            Logger.getLogger(Sdmx20StructureReaderTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        sd.setStructures(struct);
        return sd;
    }

    public NestedNCNameIDType toNCName(String s) {
        return new NestedNCNameIDType(s);
    }

    public NCNameIDType toNCNameIDType(String s) {
        return new NCNameIDType(s);
    }

    public IDType toIDType(String s) {
        if (s == null) {
            return null;
        }
        return new IDType(s);
    }

    public CodelistType toCodelist(org.sdmx.resources.sdmxml.schemas.v20.structure.CodeListType cl1) throws URISyntaxException {
        if (cl1 == null) {
            return null;
        }
        CodelistType cl2 = new CodelistType();
        cl2.setId(toIDType(cl1.getId()));
        cl2.setAgencyID(toNestedNCNameIDType(cl1.getAgencyID()));
        cl2.setVersion(toVersionType(cl1.getVersion()));
        cl2.setAnnotations(toAnnotations(cl1.getAnnotations()));
        cl2.setDescriptions(toDescriptions(cl1.getDescriptionArray()));
        cl2.setExternalReference(cl1.getIsExternalReference());
        cl2.setFinal(cl1.getIsFinal());
        cl2.setUri(toAnyURI(cl1.getUri()));
        cl2.setUrn(toAnyURI(cl1.getUrn()));
// No Partial Attribute in sdmx 2.0
//        cl2.setPartial(cl1.getIsPartial());
        cl2.setNames(toNames(cl1.getNameArray()));
// no Hierarchical Codelists in sdmx 2.0
        cl2.setCodes(toCodes(cl1.getCodeArray()));
// No Version in sdmx 2.0
//        cl2.setVersion(toVersionType(cl1.getVersion()));
// No External Reference Url in sdmx 2.0
//        cl2.setExternalReferences(toExternalReference(cl1.getServiceURL(), cl1.getStructureURL()));
        //cl1.getS
        return cl2;
    }

    public List<CodeType> toCodes(org.sdmx.resources.sdmxml.schemas.v20.structure.CodeType[] codes) throws URISyntaxException {
        List<CodeType> codelist = new ArrayList<CodeType>();
        for (int i = 0; i < codes.length; i++) {
            codelist.add(toCode(codes[i]));
        }
        return codelist;
    }

    public sdmx.common.Annotations toAnnotations(org.sdmx.resources.sdmxml.schemas.v20.common.AnnotationsType annots1) {
        if (annots1 == null) {
            return null;
        }
        sdmx.common.Annotations annots2 = new sdmx.common.Annotations();
        for (int i = 0; i < annots1.getAnnotationArray().length; i++) {
            annots2.addAnnotation(toAnnotation(annots1.getAnnotationArray(i)));
        }
        return annots2;

    }

    public sdmx.common.AnnotationType toAnnotation(org.sdmx.resources.sdmxml.schemas.v20.common.AnnotationType ann) {
        AnnotationType an = new AnnotationType();
        // id field not in sdmx 2.0
        //String id = ann.getId();
        //an.setId(id);
        for (int i = 0; i < ann.getAnnotationTextArray().length; i++) {
            an.getAnnotationText().add(toTextType(ann.getAnnotationTextArray(i)));
        }
        an.setAnnotationTitle(ann.getAnnotationTitle());
        an.setAnnotationType(ann.getAnnotationType());
        an.setAnnotationUrl(ann.getAnnotationURL());
        return an;
    }

    public sdmx.common.TextType toTextType(org.sdmx.resources.sdmxml.schemas.v20.common.TextType tt) {
        TextType tt1 = new TextType(tt.getLang(), tt.getStringValue());
        return tt1;
    }

    public List<sdmx.common.TextType> toTextType(org.sdmx.resources.sdmxml.schemas.v20.common.TextType[] tt) {
        List<TextType> list = new ArrayList<TextType>();
        for (int i = 0; i < tt.length; i++) {
            list.add(toTextType(tt[i]));
        }
        return list;
    }

    public List<sdmx.common.Description> toDescriptions(org.sdmx.resources.sdmxml.schemas.v20.common.TextType[] tt) {
        List<Description> descs = new ArrayList<Description>();
        for (int i = 0; i < tt.length; i++) {
            descs.add(toDescription(tt[i]));
        }
        return descs;
    }

    public sdmx.common.Description toDescription(org.sdmx.resources.sdmxml.schemas.v20.common.TextType tt) {
        //System.out.println("ToDescription:"+tt.getLang()+":"+tt.getStringValue());
        Description tt1 = new Description(tt.getLang(), tt.getStringValue());
        return tt1;

    }

    public NestedNCNameIDType toNestedNCNameIDType(String ncname) {
        if (ncname == null) {
            return null;
        }
        return new NestedNCNameIDType(ncname);
    }

    public List<sdmx.common.Name> toNames(org.sdmx.resources.sdmxml.schemas.v20.common.TextType[] tt) {
        List<Name> descs = new ArrayList<Name>();
        for (int i = 0; i < tt.length; i++) {
            descs.add(toName(tt[i]));
        }
        return descs;
    }

    public sdmx.common.Name toName(org.sdmx.resources.sdmxml.schemas.v20.common.TextType tt) {
        //System.out.println("lang="+tt.getLang()+":"+tt.getStringValue());
        Name tt1 = new Name(tt.getLang(), tt.getStringValue());
        return tt1;
    }

    public CodeType toCode(org.sdmx.resources.sdmxml.schemas.v20.structure.CodeType cl1) throws URISyntaxException {
        CodeType cl2 = new CodeType();
        cl2.setAnnotations(toAnnotations(cl1.getAnnotations()));
        // No Name Array in sdmx 2.0
        //cl2.setNames(toNames(cl1.getNameArray()));
        cl2.setDescriptions(toDescriptions(cl1.getDescriptionArray()));
        // Codelist Id is 'Value' in sdmx 2.0
        cl2.setId(toIDType(cl1.getValue().toString()));
        // No URI in sdmx 2.0
        //        cl2.setUri(toAnyURI(cl1.getUrn()));
        cl2.setUrn(toAnyURI(cl1.getUrn()));
        // No Hierarchical Codelists in sdmx 2.0
        //cl2.setCodes(toCodes(cl1.getItemArray()));
        return cl2;
    }

    public CodelistsType toCodelists(org.sdmx.resources.sdmxml.schemas.v20.structure.CodeListsType cl1) throws URISyntaxException {
        if (cl1 == null) {
            return null;
        }
        List<CodelistType> codelists = new ArrayList<CodelistType>();
        for (int i = 0; i < cl1.getCodeListArray().length; i++) {
            codelists.add(toCodelist(cl1.getCodeListArray(i)));
        }
        CodelistsType cl2 = new CodelistsType(codelists);
        return cl2;
    }

    public anyURI toAnyURI(String s) throws URISyntaxException {
        if (s == null) {
            return null;
        }
        return new anyURI(s);
    }

    public ConceptsType toConcepts(org.sdmx.resources.sdmxml.schemas.v20.structure.ConceptsType con1) throws TypeValueNotFoundException, URISyntaxException {
        if (con1 == null) {
            return null;
        }
        ConceptsType con2 = new ConceptsType();
        List<ConceptSchemeType> cons = new ArrayList<>();
        for (int i = 0; i < con1.getConceptSchemeArray().length; i++) {
            cons.add(toConceptScheme(con1.getConceptSchemeArray(i)));
        }
        for (int i = 0; i < con1.getConceptArray().length; i++) {
            ConceptType ct = toConcept(con1.getConceptArray(i));
            ConceptSchemeType cs = findStandaloneConceptScheme(cons, toNestedNCNameIDType(con1.getConceptArray(i).getAgencyID()));
            cs.addConcept(ct);
        }
        con2.setConceptSchemes(cons);
        return con2;
    }

    public ConceptSchemeType findStandaloneConceptScheme(List<ConceptSchemeType> list, NestedNCNameIDType agency) {
        ConceptSchemeType standalone = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals("STANDALONE_CONCEPT_SCHEME") && list.get(i).getAgencyID().equals(agency)) {
                return list.get(i);
            }
        }
        standalone = new ConceptSchemeType();
        standalone.setId(new IDType("STANDALONE_CONCEPT_SCHEME"));
        standalone.setAgencyID(agency);
        standalone.setVersion(new VersionType("1.0"));
        list.add(standalone);
        return standalone;
    }

    public ConceptSchemeType toConceptScheme(org.sdmx.resources.sdmxml.schemas.v20.structure.ConceptSchemeType con1) throws TypeValueNotFoundException, URISyntaxException {
        if (con1 == null) {
            return null;
        }
        ConceptSchemeType con2 = new ConceptSchemeType();
        con2.setAgencyID(toNestedNCNameIDType(con1.getAgencyID()));
        con2.setAnnotations(toAnnotations(con1.getAnnotations()));
        con2.setDescriptions(toDescriptions(con1.getDescriptionArray()));
        con2.setExternalReference(con1.getIsExternalReference());
        con2.setFinal(con1.getIsFinal());
        con2.setNames(toNames(con1.getNameArray()));
        con2.setId(toIDType(con1.getId().toString()));
        con2.setUri(toAnyURI(con1.getUri()));
        con2.setUrn(toAnyURI(con1.getUrn()));
        // No Version in sdmx 2.0
        //con2.setVersion(toVersionType(con1.getVersion()));
        // No External Reference in sdmx 2.0
        //con2.setExternalReferences(toExternalReference(con1.getServiceURL(), con1.getStructureURL()));
        List<ConceptType> cons = new ArrayList<>();
        for (int i = 0; i < con1.getConceptArray().length; i++) {
            cons.add(toConceptType(con2, con1.getConceptArray(i)));
        }
        con2.setConcepts(cons);
        Iterator<ConceptType> it = cons.iterator();
        while (it.hasNext()) {
            ConceptType con = it.next();
            if (con.getParent() != null) {
                ConceptType parent;
                parent = con2.findConcept(con.getParent().getRef().getId());
                if (parent == null) {
                    throw new RuntimeException("Cannot find parent concept referenced in concept:" + con1.getId() + ":parent:" + con.getParent().getRef().getId());
                } else {
                    it.remove();
                    parent.addConcept(con);
                }
            }
        }
        return con2;
    }

    public ConceptType toConceptType(ConceptSchemeType cscheme, org.sdmx.resources.sdmxml.schemas.v20.structure.ConceptType con1) throws TypeValueNotFoundException, URISyntaxException {
        if (con1 == null) {
            return null;
        }
        ConceptType con2 = new ConceptType();
        con2.setAnnotations(toAnnotations(con1.getAnnotations()));
        con2.setDescriptions(toDescriptions(con1.getDescriptionArray()));
        con2.setNames(toNames(con1.getNameArray()));
        con2.setId(toIDType(con1.getId().toString()));
        con2.setUri(toAnyURI(con1.getUri()));
        con2.setUrn(toAnyURI(con1.getUrn()));
        con2.setAgencyID(toNestedNCNameIDType(con1.getAgencyID()));
        con2.setVersion(toVersionType(con1.getVersion()));
        // Parent ID is stored as local item reference type with id.
        con2.setParent(toLocalItemReferenceType(con1.getParent()));
        // No CoreRepresentation in sdmx 2.0
        //con2.setCoreRepresentation(toConceptRepresentation(con1.getCoreRepresentation()));
        // No ISOConceptRef in sdmx 2.0
        //con2.setIsoConceptRef(toISOConceptRef(con1.getISOConceptReference()));
        return con2;
    }

    public LocalItemReferenceType toLocalItemReferenceType(String id) throws TypeValueNotFoundException {
        if (id == null) {
            return null;
        }
        LocalItemReferenceType lrt2 = new LocalItemReferenceType(new LocalItemRefBaseType(toIDType(id), ItemTypeCodelistType.CONCEPT, ItemSchemePackageTypeCodelistType.CONCEPTSCHEME));
        return lrt2;
    }
    /*
     * This is for the case of a simple stand alone non hierarchical Concept (it is stored as a ConceptScheme)
     */

    public ConceptType toConcept(org.sdmx.resources.sdmxml.schemas.v20.structure.ConceptType con1) throws URISyntaxException {
        if (con1 == null) {
            return null;
        }
        ConceptType con2 = new ConceptType();
        con2.setAnnotations(toAnnotations(con1.getAnnotations()));
        con2.setDescriptions(toDescriptions(con1.getDescriptionArray()));
        //con2.setFinal(con1.getIsFinal());
        con2.setNames(toNames(con1.getNameArray()));
        //System.out.println("CT ID="+con1.getId());
        con2.setId(toIDType(con1.getId()));
        con2.setUri(toAnyURI(con1.getUri()));
        con2.setUrn(toAnyURI(con1.getUrn()));
        con2.setAgencyID(toNestedNCNameIDType(con1.getAgencyID()));
        con2.setVersion(toVersionType(con1.getVersion()));
        // No Version in sdmx 2.0
        //con2.setVersion(toVersionType(con1.getVersion()));
        // No External Reference in sdmx 2.0
        //con2.setExternalReferences(toExternalReference(con1.getServiceURL(), con1.getStructureURL()));
        return con2;
    }

    public DataStructuresType toDataStructures(org.sdmx.resources.sdmxml.schemas.v20.structure.KeyFamiliesType kf) throws URISyntaxException, TypeValueNotFoundException {
        if (kf == null) {
            return null;
        }
        List<DataStructureType> dss = new ArrayList<DataStructureType>();
        DataStructuresType dst = new DataStructuresType();
        for (int i = 0; i < kf.sizeOfKeyFamilyArray(); i++) {
            dss.add(toDataStructure(kf.getKeyFamilyArray(i)));
        }
        dst.setDataStructures(dss);
        return dst;
    }

    public DataStructureType toDataStructure(org.sdmx.resources.sdmxml.schemas.v20.structure.KeyFamilyType kf) throws URISyntaxException, TypeValueNotFoundException {
        if (kf == null) {
            return null;
        }
        DataStructureType ds = new DataStructureType();
        ds.setNames(toNames(kf.getNameArray()));
        ds.setAnnotations(toAnnotations(kf.getAnnotations()));
        ds.setId(toIDType(kf.getId()));
        ds.setAgencyID(toNestedNCNameIDType(kf.getAgencyID()));
        currentKeyFamilyAgency = ds.getAgencyID();
        if (currentKeyFamilyAgency == null) {
            currentKeyFamilyAgency = mainAgencyId;
        }
        ds.setVersion(toVersionType(kf.getVersion()));
        ds.setDescriptions(toDescriptions(kf.getDescriptionArray()));
        ds.setExternalReference(kf.getIsExternalReference());
        ds.setFinal(kf.getIsFinal());
        ds.setUri(toAnyURI(kf.getUri()));
        ds.setUrn(toAnyURI(kf.getUrn()));
        ds.setDataStructureComponents(toDataStructureComponents(kf.getComponents()));

        return ds;
    }

    public VersionType toVersionType(String s) {
        if (s == null) {
            return null;
        }
        return new VersionType(s);
    }

    public DataStructureComponents toDataStructureComponents(org.sdmx.resources.sdmxml.schemas.v20.structure.ComponentsType c1) throws TypeValueNotFoundException, URISyntaxException {
        if (c1 == null) {
            return null;
        }
        DataStructureComponents c2 = new DataStructureComponents();
        c2.setDimensionList(toDimensionListType(c1.getDimensionArray()));
        c2.setAttributeList(toAttributeList(c1.getAttributeArray()));
        c2.setMeasureList(toMeasureList(c1));
        c2.setTimeDimension(toTimeDimension(c1.getTimeDimension()));
        return c2;
    }

    public DimensionListType toDimensionListType(org.sdmx.resources.sdmxml.schemas.v20.structure.DimensionType[] d1) throws TypeValueNotFoundException, URISyntaxException {
        DimensionListType dlt = new DimensionListType();
        List<DimensionType> d2 = new ArrayList<DimensionType>();
        for (int i = 0; i < d1.length; i++) {
            d2.add(toDimensionType(d1[i]));
        }
        dlt.setDimensions(d2);
        return dlt;
    }

    public DimensionType toDimensionType(org.sdmx.resources.sdmxml.schemas.v20.structure.DimensionType d1) throws TypeValueNotFoundException, URISyntaxException {
        ConceptSchemeType cscheme = getConceptScheme(d1);
        ConceptType concept = getConcept(cscheme, d1);
        //System.out.println("ConceptT ID="+concept.getId());

        //System.out.println("Dimension=" + d1.getConceptRef());
        //System.out.println("Cscheme=" + cscheme);
        //System.out.println("Concept=" + concept);
        DimensionType d2 = new DimensionType();
        CodelistType code = getCodelist(d1);
        if (concept != null) {
            d2.setConceptIdentity(toConceptReference(cscheme, concept));
        }
        //System.out.println("Dim:"+d1.getConceptRef()+":code="+code);
        if (code != null) {
            d2.setLocalRepresentation(toLocalRepresentation(code, toTextFormatType(d1.getTextFormat())));
        }
        return d2;
    }

    public ConceptReferenceType toConceptReference(ConceptSchemeType csch, ConceptType cs) throws TypeValueNotFoundException, URISyntaxException {
        if (cs == null) {
            return null;
        }
        if (cs.getId() != null) {
            ConceptReferenceType srt2 = new ConceptReferenceType(toConceptRefType(csch, cs), cs.getUri());
            return srt2;
        } else {
            ConceptReferenceType srt2 = new ConceptReferenceType(cs.getUri());
            return srt2;
        }
    }

    public ConceptRefType toConceptRefType(ConceptSchemeType csch, ConceptType cs) {
        // Sdmx2.0 concepts dont have maintainable parent Id's
        //System.out.println("Vers1:"+cs.getVersion());
        if (csch != null) {
            ConceptRefType ref2 = new ConceptRefType(csch.getId(), csch.getVersion(), cs.getId());
            ref2.setAgencyId(csch.getAgencyID());
            //System.out.println("Cref=:"+ref2.getAgencyId()+":"+ref2.getMaintainableParentId().toString()+":"+ref2.getId()+":-"+registry.findConceptScheme(ref2.getAgencyId(), ref2.getMaintainableParentId()));
            //System.out.println("cs.getId()=="+cs.getId());
            return ref2;
        } else {
            ConceptRefType ref2 = new ConceptRefType(new IDType(cs.getAgencyID().toString()), cs.getVersion(), cs.getId());
            //System.out.println("Vers2:"+ref2.getVersion());
            return ref2;
        }
    }

    public RepresentationType toLocalRepresentation(CodelistType codelist, TextFormatType ttf) throws TypeValueNotFoundException, URISyntaxException {
        SimpleDataStructureRepresentationType lr2 = new SimpleDataStructureRepresentationType();
        lr2.setTextFormat(ttf);
        if (codelist != null) {
            lr2.setEnumeration(toItemSchemeReference(codelist));
        }
        return lr2;
    }

    public SimpleDataStructureRepresentationType toSimpleDataStructureRepresentation(CodelistType codelist, TextFormatType ttf) throws TypeValueNotFoundException, URISyntaxException {
        if (codelist == null) {
            return null;
        }
        SimpleDataStructureRepresentationType lr2 = new SimpleDataStructureRepresentationType();
        lr2.setTextFormat(ttf);
        lr2.setEnumeration(toItemSchemeReference(codelist));
        return lr2;
    }

    public ItemSchemeReferenceBaseType toItemSchemeReference(CodelistType code) throws URISyntaxException, TypeValueNotFoundException {
        if (code == null) {
            return null;
        }
        ItemSchemeReferenceBaseType srt2 = new ItemSchemeReferenceBaseType(toItemSchemeRefBaseType(code), code.getUrn());
        return srt2;
    }

    public ItemSchemeRefBaseType toItemSchemeRefBaseType(CodelistType codelist) throws TypeValueNotFoundException {
        ItemSchemeRefBaseType ref2;
        ref2 = new ItemSchemeRefBaseType(codelist.getAgencyID(), codelist.getId(), codelist.getVersion(), ItemSchemeTypeCodelistType.CODELIST, ItemSchemePackageTypeCodelistType.CODELIST);
        return ref2;
    }

    public AttributeListType toAttributeList(org.sdmx.resources.sdmxml.schemas.v20.structure.AttributeType[] a1) throws TypeValueNotFoundException, URISyntaxException {
        AttributeListType atts = new AttributeListType();
        List<AttributeType> a2 = new ArrayList<AttributeType>();
        for (int i = 0; i < a1.length; i++) {
            a2.add(toAttributeType(a1[i]));
        }
        atts.setAttributes(a2);
        return atts;

    }

    public AttributeType toAttributeType(org.sdmx.resources.sdmxml.schemas.v20.structure.AttributeType a1) throws TypeValueNotFoundException, URISyntaxException {
        AttributeType a2 = new AttributeType();
        ConceptSchemeType cscheme = getConceptScheme(a1);
        ConceptType concept = getConcept(cscheme, a1);

        CodelistType code = getCodelist(a1);
        if (concept != null) {
            a2.setConceptIdentity(toConceptReference(cscheme, concept));
        }
        if (code != null) {
            a2.setLocalRepresentation(toLocalRepresentation(code, toTextFormatType(a1.getTextFormat())));
            a2.getLocalRepresentation().setEnumeration(toItemSchemeReference(code));
        }
        return a2;
    }

    public TextFormatType toTextFormatType(org.sdmx.resources.sdmxml.schemas.v20.structure.TextFormatType tft1) throws TypeValueNotFoundException {
        if (tft1 == null) {
            return null;
        }
        TextFormatType tft2 = new TextFormatType();
        if (tft1.getDecimals() != null) {
            tft2.setDecimals(toPositiveInteger(tft1.getDecimals().intValue()));
        }
        tft2.setEndValue(tft1.getEndValue());
        tft2.setInterval(tft1.getInterval());
        if (tft1.getMaxLength() != null) {
            tft2.setMaxLength(toPositiveInteger(tft1.getMaxLength().intValue()));
        }
        if (tft1.getPattern() != null) {
            tft2.setPattern(tft1.getPattern());
        }
        tft2.setStartValue(tft1.getStartValue());
        if (tft1.getTextType() != null) {
            tft2.setTextType(DataType.fromStringWithException(tft1.getTextType().toString()));
        }
        if (tft1.getTimeInterval() != null) {
            tft2.setTimeInterval(toDuration(tft1.getTimeInterval()));
        }
        return tft2;
    }

    public positiveInteger toPositiveInteger(int i) {
        return new positiveInteger(i);
    }

    public StandardTimePeriodType toStandardTimePeriod(Object time) {
        System.out.println("DO ME:Sdmx20Tools.toStandardTimePeriod!!!");
        System.out.println("EndTime=" + time);
        return null;
    }

    public duration toDuration(GDuration timeInterval) {
        System.out.println("DO ME:Sdmx20Tools.toDuration(GDuration)!!!");
        return null;
        //timeInterval.get
    }

    public BaseHeaderType toHeaderType(org.sdmx.resources.sdmxml.schemas.v20.message.HeaderType header) throws URISyntaxException {
        if (header == null) {
            return null;
        }
        BaseHeaderType header2 = new BaseHeaderType();
        // No DataProvider in SDMX 2.0
        //header2.setDataProvider(toDataProviderReferenceType(header.get));
        header2.setDataSetAction(toActionType(header.getDataSetAction()));
        header2.setDataSetID(toDataSetIDTypeList(header.getDataSetID()));
        // No Embargodate in sdmx 2.0
        //header2.setEmbargoDate(toDateTime(header.getEmbargoDate()));
        header2.setExtracted(toDateTime(header.getExtracted()));
        header2.setId(header.getID());
        header2.setNames(toNames(header.getNameArray()));
        header2.setPrepared(toHeaderTimeType(header.getPrepared()));
        header2.setReceivers(toPartyTypeList(header.getReceiverArray()));
        header2.setReportingBegin(toObservationalTimePeriodType(header.getReportingBegin()));
        header2.setReportingEnd(toObservationalTimePeriodType(header.getReportingEnd()));
        header2.setSender(partyListToSender(toPartyTypeList(header.getSenderArray())));
        header2.setSource(toTextType(header.getSourceArray()));
// Data Structure        
        PayloadStructureType pst = new PayloadStructureType();
        pst.setStructureID(toID(header.getDataSetID()));
        StructureRefBaseType ref = new StructureRefBaseType(toNestedNCNameIDType(header.getKeyFamilyAgency()), toIDType(header.getKeyFamilyRef()), VersionType.ONE, ObjectTypeCodelistType.STRUCTURESET, PackageTypeCodelistType.DATASTRUCTURE);
        StructureReferenceBaseType reference = new StructureReferenceBaseType(ref, null);
        pst.setStructure(reference);
        List<PayloadStructureType> payload = new ArrayList<PayloadStructureType>();
        payload.add(pst);
        header2.setStructures(payload);

        header2.setTest(header.getTest());

        return header2;
    }

    public ActionType toActionType(org.sdmx.resources.sdmxml.schemas.v20.common.ActionType.Enum at) {
        if (at == null) {
            return null;
        }
        return ActionType.fromString(at.toString());
    }

    public List<IDType> toIDTypeList(String[] idtypes) {
        List<IDType> list = new ArrayList<IDType>();
        for (int i = 0; i < idtypes.length; i++) {
            list.add(toIDType(idtypes[i]));
        }
        return list;
    }

    public List<IDType> toDataSetIDTypeList(String idtype) {
        List<IDType> list = new ArrayList<IDType>();
        list.add(toIDType(idtype));
        return list;
    }

    public DateTime toDateTime(Calendar c) {
        if (c == null) {
            return null;
        }
        return new DateTime(c);
    }

    public sdmx.xml.DateType toDateType(Calendar c) {
        if (c == null) {
            return null;
        }
        return new DateType(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DATE));
    }

    public HeaderTimeType toHeaderTimeType(Calendar c) {
        HeaderTimeType htt = new HeaderTimeType();
        htt.setDate(toDateTime(c));
        return htt;
    }

    public List<PartyType> toPartyTypeList(org.sdmx.resources.sdmxml.schemas.v20.message.PartyType[] receiverArray) throws URISyntaxException {
        List<PartyType> list = new ArrayList<PartyType>();
        for (int i = 0; i < receiverArray.length; i++) {
            PartyType pt = new PartyType();
            pt.setId(toIDType(receiverArray[i].getId()));
            pt.setContacts(toContactList(receiverArray[i].getContactArray()));
            pt.setNames(toNames(receiverArray[i].getNameArray()));
            list.add(pt);
        }
        return list;
    }

    public List<ContactType> toContactList(org.sdmx.resources.sdmxml.schemas.v20.message.ContactType[] contactArray) throws URISyntaxException {
        List<ContactType> list = new ArrayList<ContactType>();
        for (int i = 0; i < contactArray.length; i++) {
            ContactType ct = new ContactType();
            ct.setNames(toNames(contactArray[i].getNameArray()));
            ct.setDepartments(toTextType(contactArray[i].getDepartmentArray()));
            ct.setEmails(toStringList(contactArray[i].getEmailArray()));
            ct.setFaxes(toStringList(contactArray[i].getFaxArray()));
            ct.setRoles(toTextType(contactArray[i].getRoleArray()));
            ct.setTelephones(toStringList(contactArray[i].getTelephoneArray()));
            ct.setX400s(toStringList(contactArray[i].getX400Array()));
            ct.setUris(toAnyURIList(contactArray[i].getURIArray()));
            list.add(ct);
        }
        return list;
    }

    public List<String> toStringList(String[] emailArray) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < emailArray.length; i++) {
            list.add(emailArray[i]);
        }
        return list;
    }

    public List<anyURI> toAnyURIList(String[] uriArray) throws URISyntaxException {
        List<anyURI> list = new ArrayList<anyURI>();
        for (int i = 0; i < uriArray.length; i++) {
            list.add(toAnyURI(uriArray[i]));
        }
        return list;
    }

    public ObservationalTimePeriodType toObservationalTimePeriodType(Object reportingEnd) {
        return null;
    }

    public SenderType partyListToSender(List<PartyType> list) {
        if (list.size() == 0) {
            return null;
        }
        SenderType pt = new SenderType();
        pt.setId(list.get(0).getId());
        pt.setNames(list.get(0).getNames());
        pt.setContacts(list.get(0).getContacts());
        return pt;
    }

    public ID toID(String s) {
        if (s == null) {
            return null;
        }
        return new ID(s);
    }

    public MeasureListType toMeasureList(ComponentsType c1) throws TypeValueNotFoundException, URISyntaxException {
        if (c1 == null) {
            return null;
        }
        MeasureListType measurelist = new MeasureListType();
        measurelist.setPrimaryMeasure(toPrimaryMeasure(c1.getPrimaryMeasure()));
        return measurelist;
    }

    public PrimaryMeasure toPrimaryMeasure(PrimaryMeasureType pm1) throws TypeValueNotFoundException, URISyntaxException {
        PrimaryMeasure pm2 = new PrimaryMeasure();
        ConceptSchemeType cscheme = getConceptScheme(pm1);
        ConceptType concept = getConcept(cscheme, pm1);
        CodelistType code = getCodelist(pm1);
        if (concept != null) {
            pm2.setConceptIdentity(toConceptReference(cscheme, concept));
        }
        pm2.setLocalRepresentation(toLocalRepresentation(code, toTextFormatType(pm1.getTextFormat())));
        return pm2;
    }

    public TimeDimensionType toTimeDimension(org.sdmx.resources.sdmxml.schemas.v20.structure.TimeDimensionType td1) throws TypeValueNotFoundException, URISyntaxException {
        if (td1 == null) {
            return null;
        }
        TimeDimensionType td2 = new TimeDimensionType();
        ConceptSchemeType cscheme = getConceptScheme(td1);
        ConceptType concept = getConcept(cscheme, td1);
        CodelistType code = getCodelist(td1);
        if (concept != null) {
            td2.setConceptIdentity(toConceptReference(cscheme, concept));
        }
        if (code != null) {
            td2.setLocalRepresentation(toLocalRepresentation(code, toTextFormatType(td1.getTextFormat())));
            td2.getLocalRepresentation().setEnumeration(toItemSchemeReference(code));
        }
        return td2;
    }

    public ConceptSchemeType getConceptScheme(org.sdmx.resources.sdmxml.schemas.v20.structure.DimensionType dim) {
        //System.out.println(d1.getConceptSchemeAgency()+":"+d1.getConceptSchemeRef()+":"+d1.getConceptRef()+":"+d1.getConceptVersion());
        if (dim.getConceptSchemeAgency() != null && dim.getConceptSchemeRef() != null && dim.getConceptRef() != null) {
            NestedNCNameIDType csa = new NestedNCNameIDType(dim.getConceptSchemeAgency());
            IDType csi = new IDType(dim.getConceptSchemeRef());
            return registry.findConceptScheme(csa, csi);
        } else if (dim.getConceptSchemeRef() != null && dim.getConceptRef() != null) {
            NestedNCNameIDType csa = currentKeyFamilyAgency;
            IDType csi = new IDType(dim.getConceptSchemeRef());
            return registry.findConceptScheme(csa, csi);
        } else if (dim.getConceptRef() != null) {
            NestedNCNameIDType csa = currentKeyFamilyAgency;
            IDType csi = new IDType("STANDALONE_CONCEPT_SCHEME");
            ConceptSchemeType cst = registry.findConceptScheme(csa, csi);
            ConceptType ct = cst != null ? cst.findConcept(new IDType(dim.getConceptRef())) : null;
            if (ct == null) {
                ct = findConcept(dim.getConceptRef());
                cst = registry.findConceptScheme(ct.getAgencyID(), new IDType("STANDALONE_CONCEPT_SCHEME"));
            } else {
                cst = registry.findConceptScheme(ct.getAgencyID(), new IDType("STANDALONE_CONCEPT_SCHEME"));
            }
            return cst;
        } else {
            return null;
        }
    }

    public ConceptType getConcept(ConceptSchemeType scheme, org.sdmx.resources.sdmxml.schemas.v20.structure.DimensionType dim) {
        if (scheme != null) {
            return scheme.findConcept(dim.getConceptRef());
        } else {
            return null;
        }
    }

    public ConceptSchemeType getConceptScheme(org.sdmx.resources.sdmxml.schemas.v20.structure.TimeDimensionType dim) {
        //System.out.println(d1.getConceptSchemeAgency()+":"+d1.getConceptSchemeRef()+":"+d1.getConceptRef()+":"+d1.getConceptVersion());
        if (dim.getConceptSchemeAgency() != null && dim.getConceptSchemeRef() != null && dim.getConceptRef() != null) {
            NestedNCNameIDType csa = new NestedNCNameIDType(dim.getConceptSchemeAgency());
            IDType csi = new IDType(dim.getConceptSchemeRef());
            return registry.findConceptScheme(csa, csi);
        } else if (dim.getConceptSchemeRef() != null && dim.getConceptRef() != null) {
            NestedNCNameIDType csa = currentKeyFamilyAgency;
            IDType csi = new IDType(dim.getConceptSchemeRef());
            return registry.findConceptScheme(csa, csi);
        } else if (dim.getConceptRef() != null) {
            NestedNCNameIDType csa = currentKeyFamilyAgency;
            IDType csi = new IDType("STANDALONE_CONCEPT_SCHEME");
            ConceptSchemeType cst = registry.findConceptScheme(csa, csi);
            ConceptType ct = cst != null ? cst.findConcept(new IDType(dim.getConceptRef())) : null;
            if (ct == null) {
                ct = findConcept(dim.getConceptRef());
                cst = registry.findConceptScheme(ct.getAgencyID(), new IDType("STANDALONE_CONCEPT_SCHEME"));
            } else {
                cst = registry.findConceptScheme(ct.getAgencyID(), new IDType("STANDALONE_CONCEPT_SCHEME"));
            }
            return cst;
        } else {
            return null;
        }
    }

    public ConceptType getConcept(ConceptSchemeType scheme, org.sdmx.resources.sdmxml.schemas.v20.structure.TimeDimensionType dim) {
        if (scheme != null) {
            return scheme.findConcept(dim.getConceptRef());
        } else {
            return null;
        }
    }

    public ConceptSchemeType getConceptScheme(org.sdmx.resources.sdmxml.schemas.v20.structure.PrimaryMeasureType dim) {
        //System.out.println(d1.getConceptSchemeAgency()+":"+d1.getConceptSchemeRef()+":"+d1.getConceptRef()+":"+d1.getConceptVersion());
        if (dim.getConceptSchemeAgency() != null && dim.getConceptSchemeRef() != null && dim.getConceptRef() != null) {
            NestedNCNameIDType csa = new NestedNCNameIDType(dim.getConceptSchemeAgency());
            IDType csi = new IDType(dim.getConceptSchemeRef());
            return registry.findConceptScheme(csa, csi);
        } else if (dim.getConceptSchemeRef() != null && dim.getConceptRef() != null) {
            NestedNCNameIDType csa = currentKeyFamilyAgency;
            IDType csi = new IDType(dim.getConceptSchemeRef());
            return registry.findConceptScheme(csa, csi);
        } else if (dim.getConceptRef() != null) {
            NestedNCNameIDType csa = currentKeyFamilyAgency;
            IDType csi = new IDType("STANDALONE_CONCEPT_SCHEME");
            ConceptSchemeType cst = registry.findConceptScheme(csa, csi);
            ConceptType ct = cst != null ? cst.findConcept(new IDType(dim.getConceptRef())) : null;
            if (ct == null) {
                ct = findConcept(dim.getConceptRef());
                cst = registry.findConceptScheme(ct.getAgencyID(), new IDType("STANDALONE_CONCEPT_SCHEME"));
            } else {
                cst = registry.findConceptScheme(ct.getAgencyID(), new IDType("STANDALONE_CONCEPT_SCHEME"));
            }
            return cst;
        } else {
            return null;
        }
    }

    public ConceptType getConcept(ConceptSchemeType scheme, org.sdmx.resources.sdmxml.schemas.v20.structure.PrimaryMeasureType dim) {
        if (scheme != null) {
            return scheme.findConcept(dim.getConceptRef());
        } else {
            return null;
        }
    }

    public ConceptSchemeType getConceptScheme(org.sdmx.resources.sdmxml.schemas.v20.structure.AttributeType dim) {
        //System.out.println(d1.getConceptSchemeAgency()+":"+d1.getConceptSchemeRef()+":"+d1.getConceptRef()+":"+d1.getConceptVersion());
        if (dim.getConceptSchemeAgency() != null && dim.getConceptSchemeRef() != null && dim.getConceptRef() != null) {
            NestedNCNameIDType csa = new NestedNCNameIDType(dim.getConceptSchemeAgency());
            IDType csi = new IDType(dim.getConceptSchemeRef());
            return registry.findConceptScheme(csa, csi);
        } else if (dim.getConceptSchemeRef() != null && dim.getConceptRef() != null) {
            NestedNCNameIDType csa = currentKeyFamilyAgency;
            IDType csi = new IDType(dim.getConceptSchemeRef());
            return registry.findConceptScheme(csa, csi);
        } else if (dim.getConceptRef() != null) {
            NestedNCNameIDType csa = currentKeyFamilyAgency;
            IDType csi = new IDType("STANDALONE_CONCEPT_SCHEME");
            ConceptSchemeType cst = registry.findConceptScheme(csa, csi);
            ConceptType ct = cst != null ? cst.findConcept(new IDType(dim.getConceptRef())) : null;
            if (ct == null) {
                ct = findConcept(dim.getConceptRef());
                cst = registry.findConceptScheme(ct.getAgencyID(), new IDType("STANDALONE_CONCEPT_SCHEME"));
            } else {
                cst = registry.findConceptScheme(ct.getAgencyID(), new IDType("STANDALONE_CONCEPT_SCHEME"));
            }
            return cst;
        } else {
            return null;
        }
    }

    public ConceptType getConcept(ConceptSchemeType scheme, org.sdmx.resources.sdmxml.schemas.v20.structure.AttributeType dim) {
        if (scheme != null) {
            return scheme.findConcept(dim.getConceptRef());
        } else {
            return null;
        }
    }

    public ConceptType findConcept(String name) {
        // Infer agencyId from keyfamilyId
        NestedNCNameIDType agency = currentKeyFamilyAgency;
        IDType id = new IDType(name);
        ConceptType ct = registry.findConcept(agency, id);
        if (ct == null) {
            // We've really failed somewhere... 
            // now all we can use is the ConceptRef!!
            ct = registry.findConcept(id);
        }
        System.out.println("Trying to find concept:" + name + " returning:" + ct);
        return ct;
    }

    public CodelistType getCodelist(org.sdmx.resources.sdmxml.schemas.v20.structure.DimensionType dim) {
        if (dim.getCodelist() == null) {
            return null;
        }
        CodelistType code = null;
        if (dim.getCodelistAgency() == null && dim.getCodelistVersion() == null) {
            // All we have is a codelist name
            code = registry.findCodelist(mainAgencyId, new IDType(dim.getCodelist()));
        } else if (dim.getCodelistAgency() != null && dim.getCodelistVersion() != null) {
            code = registry.findCodelist(new NestedNCNameIDType(dim.getCodelistAgency()), new IDType(dim.getCodelist()), new VersionType(dim.getCodelistVersion()));
        } else if (dim.getCodelistAgency() != null && dim.getCodelistVersion() == null) {
            // Only codelist and codelistAgency
            code = registry.findCodelist(new NestedNCNameIDType(dim.getCodelistAgency()), new IDType(dim.getCodelist()));
        }
        return code;
    }

    public CodelistType getCodelist(org.sdmx.resources.sdmxml.schemas.v20.structure.AttributeType dim) {
        if (dim.getCodelist() == null) {
            return null;
        }
        CodelistType code = null;
        if (dim.getCodelistAgency() == null && dim.getCodelistVersion() == null) {
            // All we have is a codelist name
            code = registry.findCodelist(mainAgencyId, new IDType(dim.getCodelist()));
        } else if (dim.getCodelistAgency() != null && dim.getCodelistVersion() != null) {
            code = registry.findCodelist(new NestedNCNameIDType(dim.getCodelistAgency()), new IDType(dim.getCodelist()), new VersionType(dim.getCodelistVersion()));
        } else if (dim.getCodelistAgency() != null && dim.getCodelistVersion() == null) {
            // Only codelist and codelistAgency
            code = registry.findCodelist(new NestedNCNameIDType(dim.getCodelistAgency()), new IDType(dim.getCodelist()));
        }
        return code;
    }

    public CodelistType getCodelist(org.sdmx.resources.sdmxml.schemas.v20.structure.TimeDimensionType dim) {
        if (dim.getCodelist() == null) {
            return null;
        }
        CodelistType code = null;
        if (dim.getCodelistAgency() == null && dim.getCodelistVersion() == null) {
            // All we have is a codelist name
            code = registry.findCodelist(mainAgencyId, new IDType(dim.getCodelist()));
        } else if (dim.getCodelistAgency() != null && dim.getCodelistVersion() != null) {
            code = registry.findCodelist(new NestedNCNameIDType(dim.getCodelistAgency()), new IDType(dim.getCodelist()), new VersionType(dim.getCodelistVersion()));
        } else if (dim.getCodelistAgency() != null && dim.getCodelistVersion() == null) {
            // Only codelist and codelistAgency
            code = registry.findCodelist(new NestedNCNameIDType(dim.getCodelistAgency()), new IDType(dim.getCodelist()));
        }
        return code;
    }

    public CodelistType getCodelist(org.sdmx.resources.sdmxml.schemas.v20.structure.PrimaryMeasureType dim) {
        if (dim.getCodelist() == null) {
            return null;
        }
        CodelistType code = null;
        if (dim.getCodelistAgency() == null && dim.getCodelistVersion() == null) {
            // All we have is a codelist name
            code = registry.findCodelist(mainAgencyId, new IDType(dim.getCodelist()));
        } else if (dim.getCodelistAgency() != null && dim.getCodelistVersion() != null) {
            code = registry.findCodelist(new NestedNCNameIDType(dim.getCodelistAgency()), new IDType(dim.getCodelist()), new VersionType(dim.getCodelistVersion()));
        } else if (dim.getCodelistAgency() != null && dim.getCodelistVersion() == null) {
            // Only codelist and codelistAgency
            code = registry.findCodelist(new NestedNCNameIDType(dim.getCodelistAgency()), new IDType(dim.getCodelist()));
        }
        return code;
    }
}

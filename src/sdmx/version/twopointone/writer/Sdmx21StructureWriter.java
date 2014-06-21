/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointone.writer;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.xmlbeans.XmlOptions;
import org.sdmx.resources.sdmxml.schemas.v21.common.AnnotationType;
import org.sdmx.resources.sdmxml.schemas.v21.common.AnnotationsType;
import org.sdmx.resources.sdmxml.schemas.v21.common.ConceptReferenceType;
import org.sdmx.resources.sdmxml.schemas.v21.common.DataProviderReferenceType;
import org.sdmx.resources.sdmxml.schemas.v21.common.ItemSchemeReferenceBaseType;
import org.sdmx.resources.sdmxml.schemas.v21.common.ItemSchemeReferenceType;
import org.sdmx.resources.sdmxml.schemas.v21.common.LocalDimensionReferenceType;
import org.sdmx.resources.sdmxml.schemas.v21.common.LocalGroupKeyDescriptorReferenceType;
import org.sdmx.resources.sdmxml.schemas.v21.common.LocalItemReferenceType;
import org.sdmx.resources.sdmxml.schemas.v21.common.LocalPrimaryMeasureReferenceType;
import org.sdmx.resources.sdmxml.schemas.v21.common.RefBaseType;
import org.sdmx.resources.sdmxml.schemas.v21.common.SimpleDataType;
import org.sdmx.resources.sdmxml.schemas.v21.common.TextType;
import org.sdmx.resources.sdmxml.schemas.v21.message.BaseHeaderType;
import org.sdmx.resources.sdmxml.schemas.v21.message.ContactType;
import org.sdmx.resources.sdmxml.schemas.v21.message.PartyType;
import org.sdmx.resources.sdmxml.schemas.v21.message.StructureDocument;
import org.sdmx.resources.sdmxml.schemas.v21.message.StructureType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.AttributeListType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.AttributeRelationshipType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.AttributeType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.CodeType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.CodededTextFormatType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.CodelistType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.CodelistsType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.ConceptRepresentation;
import org.sdmx.resources.sdmxml.schemas.v21.structure.ConceptSchemeType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.ConceptType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.ConceptsType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.DataStructureComponentsType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.DataStructureType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.DataStructuresType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.DimensionListType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.DimensionType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.ISOConceptReferenceType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.MaintainableType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.MeasureListType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.NameableType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.PrimaryMeasureType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.RepresentationType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.StructuresType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.TextFormatType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.TimeDimensionType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.UsageStatusType;
import sdmx.common.Annotations;
import sdmx.common.DataType;
import sdmx.common.Name;
import sdmx.structure.base.ItemType;
import sdmx.structure.datastructure.DataStructureComponents;
import sdmx.structure.datastructure.PrimaryMeasure;
import sdmx.structure.datastructure.SimpleDataStructureRepresentationType;
import sdmx.version.twopointone.Sdmx21StructureReaderTools;

public class Sdmx21StructureWriter {

    public static void write(sdmx.message.StructureType structure, OutputStream out) throws IOException {
        StructureDocument doc = toStructureDocument(structure);
        XmlOptions options = new XmlOptions();
        Map namespaces = new HashMap<String, String>();
        namespaces.put("mes", "http://www.sdmx.org/resources/sdmxml/schemas/v2_1/message");
        namespaces.put("str", "http://www.sdmx.org/resources/sdmxml/schemas/v2_1/structure");
        namespaces.put("com", "http://www.sdmx.org/resources/sdmxml/schemas/v2_1/common");
        options.setSaveSuggestedPrefixes(namespaces);
        options.setSaveAggressiveNamespaces();
        options.setSavePrettyPrint();
        options.setSavePrettyPrintIndent(4);
        options.setUnsynchronized();
        options.setCharacterEncoding("ISO-8859-1");
        doc.save(out, options);
    }

    public static StructureDocument toStructureDocument(sdmx.message.StructureType structure) {
        StructureDocument doc = StructureDocument.Factory.newInstance();
        doc.setStructure(toStructureType(structure));
        return doc;
    }

    public static org.sdmx.resources.sdmxml.schemas.v21.message.StructureType toStructureType(sdmx.message.StructureType structure1) {
        StructureType structure2 = StructureType.Factory.newInstance();
        toHeader(structure2.addNewHeader(), structure1.getHeader());
        structure2.setStructures(toStructuresType(structure1.getStructures()));
        return structure2;
    }

    private static StructuresType toStructuresType(sdmx.structure.StructuresType structure1) {
        StructuresType structures2 = StructuresType.Factory.newInstance();
        if (structure1.getCodelists() != null) {
            structures2.setCodelists(toCodelists(structure1.getCodelists()));
        }
        if (structure1.getConcepts() != null) {
            structures2.setConcepts(toConcepts(structure1.getConcepts()));
        }
        if (structure1.getDataStructures() != null) {
            structures2.setDataStructures(toDataStructure(structure1.getDataStructures()));
        }
        return structures2;
    }

    public static CodelistsType toCodelists(sdmx.structure.CodelistsType codelists) {
        CodelistsType codelists2 = CodelistsType.Factory.newInstance();
        for (int i = 0; i < codelists.getCodelists().size(); i++) {
            CodelistType codelist = codelists2.addNewCodelist();
            toCodelist(codelist, codelists.getCodelists().get(i));
        }
        return codelists2;
    }

    public static void toCodelist(CodelistType codelist2, sdmx.structure.codelist.CodelistType codelist) {
        toMaintainableType(codelist2, codelist);
        for (int i = 0; i < codelist.size(); i++) {
            toCodeType(codelist2.addNewCode(), codelist.getItem(i));
        }
    }

    public static void toNameableType(NameableType m2, sdmx.structure.base.NameableType m1) {
        if (m1.getNames() != null) {
            for (int i = 0; i < m1.getNames().size(); i++) {
                TextType name = m2.addNewName();
                toTextType(name, m1.getNames().get(i));
            }
        }
        if (m1.getDescriptions() != null) {
            for (int i = 0; i < m1.getDescriptions().size(); i++) {
                TextType name = m2.addNewDescription();
                toTextType(name, m1.getDescriptions().get(i));
            }
        }
        if (m1.getAnnotations() != null) {
            toAnnotationsType(m2.addNewAnnotations(), m1.getAnnotations());
        }
        m2.setId(m1.getId().toString());
        if (m1.getUri() != null) {
            m2.setUri(m1.getUri().getString());
        }
        if (m1.getUrn() != null) {
            m2.setUrn(m2.getUrn());
        }
    }

    public static void toMaintainableType(MaintainableType m2, sdmx.structure.base.MaintainableType m1) {
        if (m1.getAgencyID() != null) {
            m2.setAgencyID(m1.getAgencyID().toString());
        }
        if (m1.isExternalReference() != null) {
            m2.setIsExternalReference(m1.isExternalReference());
        }
        if (m1.isFinal() != null) {
            m2.setIsFinal(m1.isFinal());
        }
        if (m1.getExternalReferences() != null && m1.getExternalReferences().getStructureURL() != null) {
            m2.setStructureURL(m1.getExternalReferences().getStructureURL());
        }
        if (m1.getExternalReferences() != null && m1.getExternalReferences().getServiceURL() != null) {
            m2.setServiceURL(m1.getExternalReferences().getServiceURL());
        }
        if (m1.getVersion() != null) {
            m2.setVersion(m1.getVersion().toString());
        }
        if (m1.getValidFrom() != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(m1.getValidFrom().getDate());
            m2.setValidFrom(c);
        }
        if (m1.getValidTo() != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(m1.getValidTo().getDate());
            m2.setValidTo(c);
        }
        toNameableType(m2, m1);
    }

    public static void toTextType(TextType text2, sdmx.common.TextType text) {
        text2.setStringValue(text.getText());
        text2.setLang(text.getLang());
    }

    public static void toAnnotationType(AnnotationType annot, sdmx.common.AnnotationType annotation) {
        annot.setAnnotationTitle(annotation.getAnnotationTitle());
        annot.setAnnotationType(annotation.getAnnotationType());
        annot.setAnnotationURL(annotation.getAnnotationUrl());
        annot.setId(annotation.getId());
        for (int i = 0; i < annotation.getAnnotationText().size(); i++) {
            toTextType(annot.addNewAnnotationText(), annotation.getAnnotationText().get(i));
        }
    }

    public static void toCodeType(CodeType code2, ItemType item) {
        sdmx.structure.codelist.CodeType code = (sdmx.structure.codelist.CodeType) item;
        toNameableType(code2, code);
        if (item.getParent() != null) {
            code2.setParent(toLocalItemReference(code2.addNewParent(), item.getParent()));
        }
    }

    public static LocalItemReferenceType toLocalItemReference(LocalItemReferenceType ref2, sdmx.commonreferences.LocalItemReferenceType ref) {
        if (ref.getRef() != null) {
            toRef(ref2.addNewRef(), ref.getRef());
        }
        if (ref.getUrn() != null) {
            ref2.setURN(ref.getUrn().getString());
        }
        return ref2;
    }

    public static void toRef(RefBaseType ref2, sdmx.commonreferences.RefBaseType ref) {
        if (ref.getAgencyId() != null) {
            ref2.setAgencyID(ref.getAgencyId().toString());
        }
        if (ref.getId() != null) {
            ref2.setId(ref.getId().toString());
        }
        if (ref.getVersion() != null) {
            ref2.setVersion(ref.getVersion().toString());
        }
        if (ref.getMaintainableParentId() != null) {
            ref2.setMaintainableParentID(ref.getMaintainableParentId().toString());
        }
        if (ref.getMaintainableParentVersion() != null) {
            ref2.setMaintainableParentVersion(ref.getMaintainableParentVersion().toString());
        }
        if (ref.getContainerId() != null) {
            ref2.setContainerID(ref.getContainerId().toString());
        }
    }

    public static ConceptsType toConcepts(sdmx.structure.ConceptsType concepts) {
        ConceptsType concepts2 = ConceptsType.Factory.newInstance();
        Iterator<sdmx.structure.concept.ConceptSchemeType> it = concepts.getConceptSchemes().iterator();
        while (it.hasNext()) {
            ConceptSchemeType cscheme = concepts2.addNewConceptScheme();
            toConceptScheme(cscheme, it.next());
        }
        return concepts2;
    }

    public static void toConceptScheme(ConceptSchemeType cscheme, sdmx.structure.concept.ConceptSchemeType next) {
        toMaintainableType(cscheme, next);
        Iterator<sdmx.structure.base.ItemType> it = next.getItems().iterator();
        while (it.hasNext()) {
            ConceptType concept = cscheme.addNewConcept();
            toConcept(concept, it.next());
        }
    }

    public static void toConcept(ConceptType concept2, ItemType next) {
        toNameableType(concept2, next);
        if (next.getParent() != null) {
            concept2.setParent(toLocalItemReference(concept2.addNewParent(), next.getParent()));
        }
        sdmx.structure.concept.ConceptType concept = (sdmx.structure.concept.ConceptType) next;
        if (concept.getCoreRepresentation() != null) {
            toCoreRepresentation(concept2.addNewCoreRepresentation(), concept.getCoreRepresentation());
        }
        if (concept.getIsoConceptRef() != null) {
            toISOConceptReference(concept2.addNewISOConceptReference(), concept.getIsoConceptRef());
        }
    }

    public static void toCoreRepresentation(ConceptRepresentation corerep2, sdmx.structure.concept.ConceptRepresentation corerep) {
        if (corerep.getEnumeration() != null) {
            toItemSchemeReference(corerep2.addNewEnumeration(), corerep.getEnumeration());
        }
        if (corerep.getEnumerationFormat() != null) {
            toCodededTextFormatType(corerep2.getEnumerationFormat(), corerep.getEnumerationFormat());
        }
        if (corerep.getTextFormat() != null) {
            toTextFormat(corerep2.addNewTextFormat(), corerep.getTextFormat());
        }
    }

    public static void toItemSchemeReference(ItemSchemeReferenceBaseType reference2, sdmx.commonreferences.ItemSchemeReferenceBaseType reference) {
        toRef(reference2.addNewRef(), reference.getRef());
        if (reference.getUrn() != null) {
            reference2.setURN(reference.getUrn().getString());
        }
    }

    public static void toCodededTextFormatType(CodededTextFormatType ctf2, sdmx.structure.base.CodededTextFormatType ctf) {
        if (ctf.getDecimals() != null) {
            ctf2.setDecimals(new BigInteger(ctf.getDecimals().toString()));
        }
        if (ctf.getEndValue() != null) {
            ctf2.setEndValue(new BigDecimal(ctf.getEndValue().toString()));
        }
        if (ctf.getInterval() != null) {
            ctf2.setInterval(new BigDecimal(ctf.getInterval().toString()));
        }
        if (ctf.isMultiLingual() != null) {
            ctf2.setIsMultiLingual(ctf.isMultiLingual());
        }
        if (ctf.isSequence() != null) {
            ctf2.setIsSequence(ctf.isSequence());
        }
        if (ctf.getMaxLength() != null) {
            ctf2.setMaxLength(new BigInteger(ctf.getMaxLength().toString()));
        }
        if (ctf.getMaxValue() != null) {
            ctf2.setMaxValue(new BigDecimal(ctf.getMaxValue().toString()));
        }
        if (ctf.getMinLength() != null) {
            ctf2.setMinLength(new BigInteger(ctf.getMinValue().toString()));
        }
        if (ctf2.getMinValue() != null) {
            ctf2.setMinValue(new BigDecimal(ctf.getMinValue()));
        }
        if (ctf.getPattern() != null) {
            ctf2.setPattern(ctf.getPattern());
        }
        if (ctf.getStartValue() != null) {
            ctf2.setStartValue(new BigDecimal(ctf.getStartValue().toString()));
        }
        if (ctf.getTextType() != null) {
            ctf2.setTextType(SimpleDataType.Enum.forString(ctf.getTextType().toString()));
        }
    }

    public static void toTextFormat(TextFormatType ctf2, sdmx.structure.base.TextFormatType ctf) {
        if (ctf.getDecimals() != null) {
            ctf2.setDecimals(new BigInteger(Integer.toString(ctf.getDecimals().getValue())));
        }
        if (ctf.getEndValue() != null) {
            ctf2.setEndValue(new BigDecimal(ctf.getEndValue().toString()));
        }
        if (ctf.getInterval() != null) {
            ctf2.setInterval(new BigDecimal(ctf.getInterval().toString()));
        }
        if (ctf.isMultiLingual() != null) {
            ctf2.setIsMultiLingual(ctf.isMultiLingual());
        }
        if (ctf.isSequence() != null) {
            ctf2.setIsSequence(ctf.isSequence());
        }
        if (ctf.getMaxLength() != null) {
            ctf2.setMaxLength(new BigInteger(Integer.toString(ctf.getMaxLength().getValue())));
        }
        if (ctf.getMaxValue() != null) {
            ctf2.setMaxValue(new BigDecimal(ctf.getMaxValue().toString()));
        }
        if (ctf.getMinLength() != null) {
            ctf2.setMinLength(new BigInteger(Integer.toString(ctf.getMinLength().getValue())));
        }
        if (ctf2.getMinValue() != null) {
            ctf2.setMinValue(new BigDecimal(ctf.getMinValue()));
        }
        if (ctf.getPattern() != null) {
            ctf2.setPattern(ctf.getPattern());
        }
        if (ctf.getStartValue() != null) {
            ctf2.setStartValue(new BigDecimal(ctf.getStartValue().toString()));
        }
        if (ctf.getTextType() != null) {
            ctf2.setTextType(SimpleDataType.Enum.forString(ctf.getTextType().toString()));
        }
    }

    public static void toISOConceptReference(ISOConceptReferenceType iso2, sdmx.structure.concept.ISOConceptReferenceType iso) {
        if (iso.getAgencyId() != null) {
            iso2.setConceptAgency(iso.getAgencyId());
        }
        if (iso.getConceptId() != null) {
            iso2.setConceptID(iso.getConceptId());
        }
        if (iso.getConceptSchemeId() != null) {
            iso2.setConceptSchemeID(iso.getConceptSchemeId());
        }
    }

    public static DataStructuresType toDataStructure(sdmx.structure.DataStructuresType dataStructures) {
        DataStructuresType dataStructures2 = DataStructuresType.Factory.newInstance();
        Iterator<sdmx.structure.datastructure.DataStructureType> it = dataStructures.getDataStructures().iterator();
        while (it.hasNext()) {
            toDataStructure(dataStructures2.addNewDataStructure(), it.next());
        }
        return dataStructures2;
    }

    public static void toDataStructure(DataStructureType ds2, sdmx.structure.datastructure.DataStructureType ds) {
        toMaintainableType(ds2, ds);
        if (ds.getDataStructureComponents() != null) {
            toDataStructureComponents(ds2.addNewDataStructureComponents(), ds.getDataStructureComponents());
        }
    }

    private static void toDataStructureComponents(DataStructureComponentsType dsc2, DataStructureComponents dsc) {
        if (dsc.getAttributeList() != null) {
            toAttributeList(dsc2.addNewAttributeList(), dsc.getAttributeList());
        }

        if (dsc.getDimensionList() != null) {
            toDimensionList(dsc2.addNewDimensionList(), dsc.getDimensionList());
            if (dsc.getDimensionList().getTimeDimension() != null) {
                toTimeDimension(dsc2.getDimensionList().addNewTimeDimension(), dsc.getDimensionList().getTimeDimension());
            }
        }
        if (dsc.getMeasureList() != null) {
            toMeasureList(dsc2.addNewMeasureList(), dsc.getMeasureList());
        }
        /*
         if (dsc.getGroup() != null) {
         toGroup(dsc2.addNewGroup(), dsc.getGroup());
         }

         */
    }

    private static void toAttributeList(AttributeListType att2, sdmx.structure.datastructure.AttributeListType att) {
        if (att.getAnnotations() != null) {
            toAnnotationsType(att2.addNewAnnotations(), att.getAnnotations());
        }
        Iterator<sdmx.structure.datastructure.AttributeType> it = att.getAttributes().iterator();
        while (it.hasNext()) {
            toAttribute(att2.addNewAttribute(), it.next());
        }
    }

    private static void toAnnotationsType(AnnotationsType annots2, Annotations annots) {
        for (int i = 0; i < annots.size(); i++) {
            AnnotationType annot = annots2.addNewAnnotation();
            toAnnotationType(annot, annots.getAnnotation(i));
        }
    }

    private static void toAttribute(AttributeType att2, sdmx.structure.datastructure.AttributeType att) {
        if (att.getAnnotations() != null) {
            toAnnotationsType(att2.addNewAnnotations(), att.getAnnotations());
        }
        if (att.getId() != null) {
            att2.setId(att.getId().toString());
        }
        if (att.getAssignmentStatus() != null) {
            att2.setAssignmentStatus(UsageStatusType.Enum.forString(att.getAssignmentStatus().toString()));
        }
        if (att.getRelationshipType() != null) {
            toAttributeRelationship(att2.addNewAttributeRelationship(), att.getRelationshipType());
        }
        if (att.getConceptIdentity() != null) {
            toConceptReferenceType(att2.addNewConceptIdentity(), att.getConceptIdentity());
        }
        if (att.getLocalRepresentation() != null) {
            toLocalRepresentation(att2.addNewLocalRepresentation(), att.getLocalRepresentation());
        }
    }

    private static void toAttributeRelationship(AttributeRelationshipType rel2, sdmx.structure.datastructure.AttributeRelationshipType rel) {
        if (rel.getAttachGroup() != null) {
            toAttachGroup(rel2.addNewAttachmentGroup(), rel.getAttachGroup());
        }
        if (rel.getDimensions() != null) {
            Iterator<sdmx.commonreferences.LocalDimensionReferenceType> it = rel.getDimensions().iterator();
            while (it.hasNext()) {
                toLocalDimensionReferenceType(rel2.addNewDimension(), it.next());
            }
        }
        if (rel.getGroups() != null) {
            Iterator<sdmx.commonreferences.LocalGroupKeyDescriptorReferenceType> it = rel.getGroups().iterator();
            while (it.hasNext()) {
                toLocalGroupKeyDescriptorReference(rel2.addNewGroup(), it.next());
            }
        }
        if (rel.getPrimaryMeasure() != null) {
            toLocalPrimaryMeasureReferenceType(rel2.addNewPrimaryMeasure(), rel.getPrimaryMeasure());
        }
    }

    private static void toAttachGroup(LocalGroupKeyDescriptorReferenceType group2, sdmx.commonreferences.LocalGroupKeyDescriptorReferenceType group) {
        if (group.getRef() != null) {
            toRef(group2.addNewRef(), group.getRef());
        }
        if (group.getUrn() != null) {
            group2.setURN(group.getUrn().getString());
        }
    }

    private static void toLocalDimensionReferenceType(LocalDimensionReferenceType reference2, sdmx.commonreferences.LocalDimensionReferenceType reference) {
        if (reference.getRef() != null) {
            toRef(reference2.addNewRef(), reference.getRef());
        }
        if (reference.getUrn() != null) {
            reference2.setURN(reference.getUrn().getString());
        }
    }

    private static void toLocalGroupKeyDescriptorReference(LocalGroupKeyDescriptorReferenceType group2, sdmx.commonreferences.LocalGroupKeyDescriptorReferenceType group) {
        if (group.getRef() != null) {
            toRef(group2.addNewRef(), group.getRef());
        }
        if (group.getUrn() != null) {
            group2.setURN(group.getUrn().getString());
        }
    }

    private static void toConceptReferenceType(ConceptReferenceType reference2, sdmx.commonreferences.ConceptReferenceType reference) {
        if (reference.getRef() != null) {
            toRef(reference2.addNewRef(), reference.getRef());
        }
        if (reference.getUrn() != null) {
            reference2.setURN(reference.getUrn().getString());
        }
    }

    private static void toLocalRepresentation(RepresentationType localrep2, SimpleDataStructureRepresentationType localrep) {
        if (localrep.getEnumeration() != null) {
            toItemSchemeReference(localrep2.addNewEnumeration(), localrep.getEnumeration());
            if (localrep.getEnumerationFormat() != null) {
                toCodededTextFormatType(localrep2.getEnumerationFormat(), localrep.getEnumerationFormat());
            }
        } else if (localrep.getTextFormat() != null) {
            toTextFormat(localrep2.addNewTextFormat(), localrep.getTextFormat());
        }
    }

    private static void toLocalRepresentation(RepresentationType localrep2, sdmx.structure.base.RepresentationType localrep) {
        if (localrep.getEnumeration() != null) {
            toItemSchemeReference(localrep2.addNewEnumeration(), localrep.getEnumeration());
            if (localrep.getEnumerationFormat() != null) {
                toCodededTextFormatType(localrep2.getEnumerationFormat(), localrep.getEnumerationFormat());
            }
        } else if (localrep.getTextFormat() != null) {
            toTextFormat(localrep2.addNewTextFormat(), localrep.getTextFormat());
        }
    }

    private static void toTDLocalRepresentation(RepresentationType localrep2, sdmx.structure.base.RepresentationType localrep) {
        if (localrep.getEnumeration() != null) {
            ItemSchemeReferenceBaseType reference = ItemSchemeReferenceBaseType.Factory.newInstance();
            toItemSchemeReference(reference, localrep.getEnumeration());
            localrep2.setEnumeration(reference);
            if (localrep.getEnumerationFormat() != null) {
                toCodededTextFormatType(localrep2.getEnumerationFormat(), localrep.getEnumerationFormat());
            }
        } else if (localrep.getTextFormat() != null) {
            toTextFormat(localrep2.addNewTextFormat(), localrep.getTextFormat());
        }
    }

    private static void toDimensionList(DimensionListType dim2, sdmx.structure.datastructure.DimensionListType dim) {
        if (dim.getAnnotations() != null) {
            toAnnotationsType(dim2.addNewAnnotations(), dim.getAnnotations());
        }
        if (dim.getId() != null) {
            dim2.setId(dim.getId().toString());
        }
        if (dim.getUri() != null) {
            dim2.setUri(dim.getUri().getString());
        }
        if (dim.getUrn() != null) {
            dim2.setUrn(dim.getUrn().getString());
        }
        Iterator<sdmx.structure.datastructure.DimensionType> it = dim.getDimensions().iterator();
        while (it.hasNext()) {
            toDimensionType(dim2.addNewDimension(), it.next());
        }
    }

    private static void toDimensionType(DimensionType dim2, sdmx.structure.datastructure.DimensionType dim) {
        if (dim.getAnnotations() != null) {
            toAnnotationsType(dim2.addNewAnnotations(), dim.getAnnotations());
        }
        if (dim.getId() != null) {
            dim2.setId(dim.getId().toString());
        }
        if (dim.getUri() != null) {
            dim2.setUri(dim.getUri().getString());
        }
        if (dim.getUrn() != null) {
            dim2.setUrn(dim.getUrn().getString());
        }
        if (dim.getConceptIdentity() != null) {
            toConceptReferenceType(dim2.addNewConceptIdentity(), dim.getConceptIdentity());
        }
        if (dim.getLocalRepresentation() != null) {
            toLocalRepresentation(dim2.addNewLocalRepresentation(), dim.getLocalRepresentation());
        }
        if (dim.getPosition() != null) {
            dim2.setPosition(dim.getPosition());
        }
        if (dim.getRoles() != null) {
            Iterator<sdmx.commonreferences.ConceptReferenceType> it = dim.getRoles().iterator();
            while (it.hasNext()) {
                toConceptReferenceType(dim2.addNewConceptRole(), it.next());
            }
        }
    }

    private static void toLocalPrimaryMeasureReferenceType(LocalPrimaryMeasureReferenceType reference2, sdmx.commonreferences.LocalPrimaryMeasureReferenceType reference) {
        if (reference.getRef() != null) {
            toRef(reference2.addNewRef(), reference.getRef());
        }
        if (reference.getUrn() != null) {
            reference2.setURN(reference.getUrn().getString());
        }
    }

    private static void toMeasureList(MeasureListType mlist2, sdmx.structure.datastructure.MeasureListType mlist) {
        if (mlist.getAnnotations() != null) {
            toAnnotationsType(mlist2.addNewAnnotations(), mlist.getAnnotations());
        }
        if (mlist.getId() != null) {
            mlist2.setId(mlist.getId().getString());
        }
        if (mlist.getUri() != null) {
            mlist2.setUri(mlist.getUri().getString());
        }
        if (mlist.getUrn() != null) {
            mlist2.setUrn(mlist.getUrn().getString());
        }
        if (mlist.getPrimaryMeasure() != null) {
            toPrimaryMeasure(mlist2.addNewPrimaryMeasure(), mlist.getPrimaryMeasure());
        }

    }

    private static void toPrimaryMeasure(PrimaryMeasureType prim2, PrimaryMeasure prim) {
        if (prim.getAnnotations() != null) {
            toAnnotationsType(prim2.addNewAnnotations(), prim.getAnnotations());
        }
        if (prim.getId() != null) {
            prim2.setId(prim.getId().getString());
        }
        if (prim.getUri() != null) {
            prim2.setUri(prim.getUri().getString());
        }
        if (prim.getUrn() != null) {
            prim2.setUrn(prim.getUrn().getString());
        }
        if (prim.getConceptIdentity() != null) {
            toConceptReferenceType(prim2.addNewConceptIdentity(), prim.getConceptIdentity());
        }
        if (prim.getLocalRepresentation() != null) {
            toLocalRepresentation(prim2.addNewLocalRepresentation(), prim.getLocalRepresentation());
        }
    }

    private static void toTimeDimension(TimeDimensionType time2, sdmx.structure.datastructure.TimeDimensionType time) {
        if (time.getLocalRepresentation() != null) {
            toTDLocalRepresentation(time2.addNewLocalRepresentation(), time.getLocalRepresentation());
            //toLocalRepresentation(time2.addNewLocalRepresentation(), time.getLocalRepresentation());
        }
        if (time.getAnnotations() != null) {
            toAnnotationsType(time2.addNewAnnotations(), time.getAnnotations());
        }
        if (time.getId() != null) {
            time2.setId(time.getId().getString());
        }
        if (time.getUri() != null) {
            time2.setUri(time.getUri().getString());
        }
        if (time.getUrn() != null) {
            time2.setUrn(time.getUrn().getString());
        }
        if (time.getConceptIdentity() != null) {
            toConceptReferenceType(time2.addNewConceptIdentity(), time.getConceptIdentity());
        }

    }

    private static void toHeader(BaseHeaderType header2, sdmx.message.BaseHeaderType header) {
        if (header.getId() != null) {
            header2.setID(header.getId());
        }
        if (header.getTest() != null) {
            header2.setTest(header.getTest());
        }
        if (header.getDataProvider() != null) {
            toDataProvider(header2.addNewDataProvider(), header.getDataProvider());
        }
        if (header.getDataSetAction() != null) {
            header2.setDataSetAction(org.sdmx.resources.sdmxml.schemas.v21.common.ActionType.Enum.forString(header.getDataSetAction().getString()));
        }
        if (header.getPrepared() != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(header.getPrepared().getDate().getDate());
            header2.setPrepared(cal);
        }
        if (header.getDataSetID() != null) {
            Iterator<sdmx.commonreferences.IDType> it = header.getDataSetID().iterator();
            while (it.hasNext()) {
                header2.addDataSetID(it.next().toString());

            }
        }
        if (header.getEmbargoDate() != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(header.getEmbargoDate().getDate());
            header2.setEmbargoDate(cal);
        }
        if (header.getExtracted() != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(header.getExtracted().getDate());
            header2.setExtracted(cal);
        }
        if (header.getNames() != null) {
            Iterator<sdmx.common.Name> it = header.getNames().iterator();
            while (it.hasNext()) {
                toTextType(header2.addNewName(), it.next());
            }
        }
        if (header.getReceivers() != null) {
            Iterator<sdmx.message.PartyType> it = header.getReceivers().iterator();
            while (it.hasNext()) {
                toPartyType(header2.addNewReceiver(), it.next());
            }
        }
        if (header.getSender() != null) {
            toPartyType(header2.addNewSender(), header.getSender());
        }
    }

    private static void toDataProvider(DataProviderReferenceType reference2, sdmx.commonreferences.DataProviderReferenceType reference) {
        if (reference.getRef() != null) {
            toRef(reference2.addNewRef(), reference.getRef());
        }
        if (reference.getUrn() != null) {
            reference2.setURN(reference.getUrn().getString());
        }
    }

    private static void toPartyType(PartyType party2, sdmx.message.PartyType party) {
        if (party.getId() != null) {
            party2.setId(party.getId().toString());
        }
        if (party.getNames() != null) {
            Iterator<Name> it = party.getNames().iterator();
            while (it.hasNext()) {
                toTextType(party2.addNewName(), it.next());
            }
        }
        if (party.getContacts() != null) {
            Iterator<sdmx.message.ContactType> it = party.getContacts().iterator();
            while (it.hasNext()) {
                toContactType(party2.addNewContact(), it.next());
            }
        }
    }

    private static void toContactType(ContactType contact2, sdmx.message.ContactType contact) {
        if (contact.getNames() != null) {
            Iterator<sdmx.common.Name> it = contact.getNames().iterator();
            while (it.hasNext()) {
                toTextType(contact2.addNewName(), it.next());
            }
        }
        if (contact.getDepartments() != null) {
            Iterator<sdmx.common.TextType> it = contact.getDepartments().iterator();
            while (it.hasNext()) {
                toTextType(contact2.addNewDepartment(), it.next());
            }
        }
        if (contact.getEmails() != null) {
            Iterator<String> it = contact.getEmails().iterator();
            while (it.hasNext()) {
                contact2.addNewEmail().setStringValue(it.next());
            }
        }
        if (contact.getFaxes() != null) {
            Iterator<String> it = contact.getFaxes().iterator();
            while (it.hasNext()) {
                contact2.addNewFax().setStringValue(it.next());
            }
        }
        if (contact.getRoles() != null) {
            Iterator<sdmx.common.TextType> it = contact.getRoles().iterator();
            while (it.hasNext()) {
                toTextType(contact2.addNewRole(), it.next());
            }
        }
        if (contact.getTelephones() != null) {
            Iterator<String> it = contact.getTelephones().iterator();
            while (it.hasNext()) {
                contact2.addNewTelephone().setStringValue(it.next());
            }
        }
        if (contact.getUris() != null) {
            Iterator<sdmx.xml.anyURI> it = contact.getUris().iterator();
            while (it.hasNext()) {
                contact2.addNewURI().setStringValue(it.next().getString());
            }
        }
        if (contact.getX400s() != null) {
            Iterator<String> it = contact.getX400s().iterator();
            while (it.hasNext()) {
                contact2.addX400(it.next());
            }
        }
    }
}

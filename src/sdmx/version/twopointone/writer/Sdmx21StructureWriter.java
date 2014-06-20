/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointone.writer;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import org.sdmx.resources.sdmxml.schemas.v21.common.AnnotationType;
import org.sdmx.resources.sdmxml.schemas.v21.common.AnnotationsType;
import org.sdmx.resources.sdmxml.schemas.v21.common.LocalItemReferenceType;
import org.sdmx.resources.sdmxml.schemas.v21.common.RefBaseType;
import org.sdmx.resources.sdmxml.schemas.v21.common.TextType;
import org.sdmx.resources.sdmxml.schemas.v21.message.StructureDocument;
import org.sdmx.resources.sdmxml.schemas.v21.message.StructureType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.CodeType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.CodelistType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.CodelistsType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.MaintainableType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.NameableType;
import org.sdmx.resources.sdmxml.schemas.v21.structure.StructuresType;
import sdmx.structure.base.ItemType;

public class Sdmx21StructureWriter {

    public static void write(sdmx.message.StructureType structure, OutputStream out) throws IOException {
        StructureDocument doc = toStructureDocument(structure);
        doc.save(out);
    }

    public static StructureDocument toStructureDocument(sdmx.message.StructureType structure) {
        StructureDocument doc = StructureDocument.Factory.newInstance();
        doc.setStructure(toStructureType(structure));
        return doc;
    }

    public static org.sdmx.resources.sdmxml.schemas.v21.message.StructureType toStructureType(sdmx.message.StructureType structure1) {
        StructureType structure2 = StructureType.Factory.newInstance();
        structure2.setStructures(toStructuresType(structure1.getStructures()));
        return structure2;
    }

    private static StructuresType toStructuresType(sdmx.structure.StructuresType structure1) {
        StructuresType structures2 = StructuresType.Factory.newInstance();
        structures2.setCodelists(toCodelists(structure1.getCodelists()));
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
        for(int i=0;i<codelist.size();i++) {
            toCodeType(codelist2.addNewCode(),codelist.getItem(i));
        }
    }

    public static void toNameableType(NameableType m2, sdmx.structure.base.NameableType m1){
        if(m1.getNames()!=null)for (int i = 0; i < m1.getNames().size(); i++) {
            TextType name = m2.addNewName();
            toTextType(name, m1.getNames().get(i));
        }
        if(m1.getDescriptions()!=null)for (int i = 0; i < m1.getDescriptions().size(); i++) {
            TextType name = m2.addNewDescription();
            toTextType(name, m1.getDescriptions().get(i));
        }
        if (m1.getAnnotations() != null) {
            AnnotationsType annots = m2.addNewAnnotations();
            for (int i = 0; i < m1.getAnnotations().size(); i++) {
                AnnotationType annot = annots.addNewAnnotation();
                toAnnotationType(annot,m1.getAnnotations().getAnnotation(i));
            }
        }
        m2.setId(m1.getId().toString());
        if( m1.getUri()!=null)m2.setUri(m1.getUri().getString());
        if( m1.getUrn()!=null)m2.setUrn(m2.getUrn());
    }
    public static void toMaintainableType(MaintainableType m2, sdmx.structure.base.MaintainableType m1) {
        m2.setAgencyID(m1.getAgencyID().toString());
        m2.setIsExternalReference(m1.isExternalReference());
        m2.setIsFinal(m1.isFinal());
        if( m1.getVersion()!=null)m2.setVersion(m1.getVersion().toString());
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
        for(int i=0;i<annotation.getAnnotationText().size();i++) {
            toTextType(annot.addNewAnnotationText(),annotation.getAnnotationText().get(i));
        }
    }

    public static void toCodeType(CodeType code2, ItemType item) {
        sdmx.structure.codelist.CodeType code = (sdmx.structure.codelist.CodeType)item;
        toNameableType(code2, code);
        if( item.getParent()!=null) {
            code2.setParent(toLocalItemReference(code2.addNewParent(),item.getParent()));
        }
        
    }

    public static LocalItemReferenceType toLocalItemReference(LocalItemReferenceType ref2,sdmx.commonreferences.LocalItemReferenceType ref) {
        if( ref.getRef()!=null ) {
            toRef(ref2.addNewRef(),ref.getRef());
        }
        if( ref.getUrn()!=null ) {
            ref2.setURN(ref.getUrn().getString());
        }
        return ref2;
    }

    public static void toRef(RefBaseType ref2, sdmx.commonreferences.RefBaseType ref) {
        if( ref.getAgencyId()!=null )ref2.setAgencyID(ref.getAgencyId().toString());
        if( ref.getId()!=null)ref2.setId(ref.getId().toString());
        if( ref.getVersion()!=null)ref2.setVersion(ref.getVersion().toString());
        if( ref.getMaintainableParentId()!=null)ref2.setMaintainableParentID(ref.getMaintainableParentId().toString());
        if( ref.getMaintainableParentVersion()!=null) ref2.setMaintainableParentVersion(ref.getMaintainableParentVersion().toString());
        if( ref.getContainerId()!=null)ref2.setContainerID(ref.getContainerId().toString());
    }
}

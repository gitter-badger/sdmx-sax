/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import sdmx.commonreferences.IDType;
import sdmx.commonreferences.MetadataStructureRefType;
import sdmx.commonreferences.StructureReferenceBaseType;
import sdmx.structure.constraint.ConstraintAttachmentTypeChoice;
import sdmx.xml.anyURI;

/**
 *
 * @author James
 */
public class MetadataStructureReferenceType extends StructureReferenceBaseType implements ConstraintAttachmentTypeChoice {
   public MetadataStructureReferenceType(MetadataStructureRefType ref, anyURI uri) {
       super(ref,uri);
   }
   public MetadataStructureReferenceType(anyURI uri) {
       super(uri);
   }
}

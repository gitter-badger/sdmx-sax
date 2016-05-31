/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure;

import sdmx.structure.constraint.AttachmentConstraintType;
import sdmx.structure.constraint.ContentConstraintType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author James
 */

public class ConstraintsType {
    private List<AttachmentConstraintType> attachmentConstraints = new ArrayList<AttachmentConstraintType>();
    private List<ContentConstraintType> contentConstraints = new ArrayList<ContentConstraintType>();

    /**
     * @return the attachmentConstraints
     */
    public List<AttachmentConstraintType> getAttachmentConstraints() {
        return attachmentConstraints;
    }

    /**
     * @param attachmentConstraints the attachmentConstraints to set
     */
    public void setAttachmentConstraints(List<AttachmentConstraintType> attachmentConstraints) {
        this.attachmentConstraints = attachmentConstraints;
    }

    /**
     * @return the contentConstraints
     */
    public List<ContentConstraintType> getContentConstraints() {
        return contentConstraints;
    }

    /**
     * @param contentConstraints the contentConstraints to set
     */
    public void setContentConstraints(List<ContentConstraintType> contentConstraints) {
        this.contentConstraints = contentConstraints;
    }
}

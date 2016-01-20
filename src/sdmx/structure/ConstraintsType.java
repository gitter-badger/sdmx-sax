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
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
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

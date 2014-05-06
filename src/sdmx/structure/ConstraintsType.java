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

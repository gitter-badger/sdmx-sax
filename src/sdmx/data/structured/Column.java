/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data.structured;

import sdmx.data.AttachmentLevel;

/**
 *
 * @author James
 */
public class Column {
    private String name = null;
    private AttachmentLevel attachment = AttachmentLevel.OBSERVATION;

    public Column(String name,AttachmentLevel attach) {
        this.name=name;
        this.attachment=attach;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the attachment
     */
    public AttachmentLevel getAttachment() {
        return attachment;
    }

    /**
     * @param attachment the attachment to set
     */
    public void setAttachment(AttachmentLevel attachment) {
        this.attachment = attachment;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data;

/**
 *
 * @author James
 */
public interface Attachable {
    public String getValue(String s);
    public void setValue(String s,String val);
    public AttachmentLevel getAttachmentLevel();
    public String getValue(int i);
    public void setValue(int i,String val);
}

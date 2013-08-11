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
    public Object getValue(String s);
    public void setValue(String s,Object val);
    public AttachmentLevel getAttachmentLevel();
    public Object getValue(int i);
    public void setValue(int i,Object val);
}

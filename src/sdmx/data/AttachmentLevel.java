/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author James
 */
public class AttachmentLevel {
    public static final int ATTACHMENT_DATASET = 0;
    public static final int ATTACHMENT_SERIES = 1;
    public static final int ATTACHMENT_OBSERVATION = 2;
    public static final int ATTACHMENT_GROUP = 3;
    public static final String ATTACHMENT_DATASET_STRING = "DataSet";
    public static final String ATTACHMENT_SERIES_STRING = "Series";
    public static final String ATTACHMENT_OBSERVATION_STRING = "Observation";
    public static final String ATTACHMENT_GROUP_STRING = "Group";
    public static final AttachmentLevel DATASET = new AttachmentLevel(ATTACHMENT_DATASET_STRING,ATTACHMENT_DATASET);
    public static final AttachmentLevel SERIES = new AttachmentLevel(ATTACHMENT_SERIES_STRING,ATTACHMENT_SERIES);
    public static final AttachmentLevel OBSERVATION = new AttachmentLevel(ATTACHMENT_OBSERVATION_STRING,ATTACHMENT_OBSERVATION);
    public static final AttachmentLevel GROUP = new AttachmentLevel(ATTACHMENT_GROUP_STRING,ATTACHMENT_GROUP);    
    
    private String name = null;
    private int id = 0;
    
    private static final List<AttachmentLevel> LIST = new ArrayList<AttachmentLevel>();
    
    public AttachmentLevel(String s,int id) {
        this.name=s;
        this.id=id;
        LIST.add(this);
    }
    public String getName() { return name; }
    public int getId() {return id; }
    public static AttachmentLevel fromString(String s) {
        for(int i=0;i<LIST.size();i++) {
            if( LIST.get(i).getName().equals(s))return LIST.get(i);
        }
        return null;        
    }    
    public static AttachmentLevel fromId(int id) {
        for(int i=0;i<LIST.size();i++) {
            if( LIST.get(i).getId()==id ) return LIST.get(i);
        }
        return null;        
    }    
    
}

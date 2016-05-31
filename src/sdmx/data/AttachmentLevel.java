/*
    This file is part of sdmx-sax.

    sdmx-sax is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    sdmx-sax is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with sdmx-sax.  If not, see <http://www.gnu.org/licenses/>.
    Copyright (C) 2015 James Gardner
*/
package sdmx.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author James
 */

public class AttachmentLevel {
    private static final List<AttachmentLevel> LIST = new ArrayList<AttachmentLevel>();
    
    public static void main(String args[]) {}
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

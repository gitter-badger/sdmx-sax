/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import sdmx.message.DataStructure;
import sdmx.message.MetadataStructure;
import sdmx.message.StructureType;
import sdmx.data.flat.FlatDataSet;
import sdmx.message.DataMessage;
import sdmx.Registry;

/**
 *
 * @author James
 */
public interface SdmxParserProvider {
    public int getVersionIdentifier();
    public boolean canParse(String header);
    public boolean isStructure(String header);
    public boolean isData(String header);
    public boolean isMetadata(String header);
    public StructureType parseStructure(InputStream in)throws IOException ;
    public StructureType parseStructure(Reader in)throws IOException ;
    
    public StructureType parseStructure(Registry registry,InputStream in)throws IOException ;
    public StructureType parseStructure(Registry registry,Reader in)throws IOException ;
    
    public DataMessage parseData(String header,InputStream in)throws IOException ;
    public DataMessage parseData(String header,Reader in)throws IOException ;
    public DataMessage parseData(String header,InputStream in,boolean flat)throws IOException ;
    public DataMessage parseData(String header,Reader in,boolean flat)throws IOException ;
   
}

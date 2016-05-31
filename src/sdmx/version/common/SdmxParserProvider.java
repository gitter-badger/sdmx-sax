/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import sdmx.Registry;
import sdmx.message.DataStructure;
import sdmx.message.MetadataStructure;
import sdmx.message.StructureType;
import sdmx.data.flat.FlatDataSet;
import sdmx.message.DataMessage;

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
    public StructureType parseStructure(ParseParams params,InputStream in)throws IOException ;
    public StructureType parseStructure(ParseParams params,Reader in)throws IOException ;
    public DataMessage parseData(ParseParams params,InputStream in)throws IOException ;
    public DataMessage parseData(ParseParams params,Reader in)throws IOException ;
   
}

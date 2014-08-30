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
public interface SdmxParserProvider {
    public int getVersionIdentifier();
    public boolean canParse(String header);
    public boolean isStructure(String header);
    public boolean isData(String header);
    public boolean isMetadata(String header);
    public StructureType parseStructure(InputStream in,String header)throws IOException ;
    public StructureType parseStructure(Reader in,String header)throws IOException ;
    
    public StructureType parseStructure(Registry registry,InputStream in,String header)throws IOException ;
    public StructureType parseStructure(Registry registry,Reader in,String header)throws IOException ;
    
    public DataMessage parseData(String header,InputStream in)throws IOException ;
    public DataMessage parseData(String header,Reader in)throws IOException ;
    public DataMessage parseData(String header,InputStream in,boolean flat)throws IOException ;
    public DataMessage parseData(String header,Reader in,boolean flat)throws IOException ;
   
}

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

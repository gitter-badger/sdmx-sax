/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointone;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xmlbeans.XmlException;
import sdmx.message.StructureType;
import sdmx.SdmxIO;
import sdmx.version.common.SdmxParserProvider;
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
public class Sdmx21ParserProvider implements SdmxParserProvider {
    static{
        SdmxIO.register(new Sdmx21ParserProvider());
    }
    @Override
    public int getVersionIdentifier() {
        return SdmxIO.VERSION21;
    }
    public static boolean isSdmx21(String header) {
        if (header.indexOf("<StructureSpecificTimeSeriesData") != -1) {
            return true;
        } else if (header.indexOf("<message:StructureSpecificTimeSeriesData") != -1) {
            return true;
        } else if (header.indexOf("<StructureSpecificData") != -1) {
            return true;
        } else if (header.indexOf("<message:StructureSpecificData") != -1) {
            return true;
        } else if (header.indexOf("<message:Structure xmlns:message=\"http://www.sdmx.org/resources/sdmxml/schemas/v2_1/message\"") != -1) {
            return true;
        } else if (header.indexOf("<Structure xmlns=\"http://www.sdmx.org/resources/sdmxml/schemas/v2_1/") != -1) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean canParse(String header) {
        return isSdmx21(header);
    }

    @Override
    public StructureType parseStructure(InputStream in) {
        try {
            return Sdmx21StructureReaderTools.toStructureDocument(in);
        } catch (XmlException ex) {
            Logger.getLogger(Sdmx21ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx21ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean isStructure(String header) {
        if (header.indexOf(":Structure ") != -1) {
            return true;
        } else if (header.indexOf("<Structure ") != -1) {
            return true;
        }else {
            return false;
        }
    }
    public boolean isData(String header) {
        if (header.indexOf("GenericData") != -1) {
            return true;
        }else if (header.indexOf("GenericTimeSeriesData") != -1) {
            return true;
        } else if (header.indexOf("StructureSpecificData") != -1) {
            return true;
        } else if (header.indexOf("StructureSpecificTimeSeriesData") != -1) {
            return true;
        }else {
            return false;
        }
    }
    public boolean isMetadata(String header) {
        if (header.indexOf("GenericMetadata") != -1) {
            return true;
        } else if (header.indexOf("StructureSpecificMetadata") != -1) {
            return true;
        }else {
            return false;
        }
    }
    
    public DataMessage parseData(String header,Registry registry,InputStream in, StructureType struct) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StructureType parseStructure(Registry registry, InputStream in) throws IOException {
        StructureType st = parseStructure(in);
        registry.load(st);
        return st;
    }

    public DataMessage parseData(InputStream in) throws IOException {
        return null;
    }

    @Override
    public DataMessage parseData(String header, InputStream in) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StructureType parseStructure(Reader in) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StructureType parseStructure(Registry registry, Reader in) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataMessage parseData(String header, Reader in) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataMessage parseData(String header, InputStream in, boolean flat) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataMessage parseData(String header, Reader in, boolean flat) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

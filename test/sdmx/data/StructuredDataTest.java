/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import sdmx.Registry;
import sdmx.message.DataMessage;
import sdmx.message.StructureType;
import sdmx.SdmxIO;
import sdmx.version.twopointzero.Sdmx20DataParserTest;
import sdmx.version.twopointzero.Sdmx20StructureParserTest;
import sdmx.exception.ParseException;
import sdmx.net.LocalRegistry;

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
public class StructuredDataTest {
    Registry registry = LocalRegistry.getDefaultWorkspace();
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Finish Test Structured Data");
    }
    @Test
    public void testCompactSampleFlat() throws IOException, ParseException {
        System.out.println("Start Flat Benchmark");
        StructureType struct = null;
        try {
            InputStream in = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/sdmx20-samples/StructureSample.xml");
            struct = SdmxIO.parseStructure(in);
            LocalRegistry.getDefaultWorkspace().load(struct);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20DataParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("Primary Measure="+struct.getStructures().getDataStructures().getDataStructures().get(0).getDataStructureComponents().getMeasureList().getPrimaryMeasure().getLocalRepresentation().getTextFormat().getTextType().toString());
        long t1= System.currentTimeMillis();
        InputStream in = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/sdmx20-samples/CompactSample.xml");
        DataMessage data = SdmxIO.parseData(in);
        long t2 = System.currentTimeMillis();
        System.out.println("Read:"+data.getDataSets().get(0).size()+" Observations "+(t2-t1)+" ms");
        data.dump();        
    }
    @Test
    public void testCompactSample() throws IOException, ParseException {
        System.out.println("Start Structured Test");
        StructureType struct = null;
        try {
            InputStream in = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/sdmx20-samples/StructureSample.xml");
            struct = SdmxIO.parseStructure(in);
            LocalRegistry.getDefaultWorkspace().load(struct);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20DataParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        long t1= System.currentTimeMillis();
        InputStream in = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/sdmx20-samples/CompactSample.xml");
        DataMessage data = SdmxIO.parseData(in);
        long t2 = System.currentTimeMillis();
        System.out.println("Read:"+data.getDataSets().get(0).size()+" Observations "+(t2-t1)+" ms");
        data.dump();
        
    }
}

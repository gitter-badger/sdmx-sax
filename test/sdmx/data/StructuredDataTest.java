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
import sdmx.message.DataMessage;
import sdmx.message.StructureType;
import sdmx.version.common.SdmxIO;
import sdmx.version.twopointzero.Sdmx20DataParserTest;
import sdmx.version.twopointzero.Sdmx20StructureParserTest;
import sdmx.workspace.LocalRegistry;
import sdmx.workspace.Registry;

/**
 *
 * @author James
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
    public void testCompactSampleFlat() throws IOException {
        System.out.println("Start Flat Benchmark");
        StructureType struct = null;
        try {
            InputStream in = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/sdmx20-samples/StructureSample.xml");
            struct = SdmxIO.parseStructure(in);
            LocalRegistry.getDefaultWorkspace().load(struct);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20DataParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Primary Measure="+struct.getStructures().getDataStructures().getDataStructures().get(0).getDataStructureComponents().getMeasureList().getPrimaryMeasure().getLocalRepresentation().getTextFormat().getTextType().toString());
        long t1= System.currentTimeMillis();
        InputStream in = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/sdmx20-samples/CompactSample.xml");
        DataMessage data = SdmxIO.parseData(in,true);
        long t2 = System.currentTimeMillis();
        System.out.println("Read:"+data.getDataSets().get(0).size()+" Observations "+(t2-t1)+" ms");
        ValueTypeResolver.resolveDataSet(registry, data.getDataSets().get(0), struct.getStructures().getDataStructures().getDataStructures().get(0));
        long t3 = System.currentTimeMillis();
        System.out.println("Resolution:"+data.getDataSets().get(0).size()+" Observations "+(t3-t2)+" ms");
        data.dump();        
    }
    @Test
    public void testCompactSample() throws IOException {
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
        DataMessage data = SdmxIO.parseData(in,false);
        long t2 = System.currentTimeMillis();
        System.out.println("Read:"+data.getDataSets().get(0).size()+" Observations "+(t2-t1)+" ms");
        ValueTypeResolver.resolveDataSet(registry, data.getDataSets().get(0), struct.getStructures().getDataStructures().getDataStructures().get(0));
        long t3 = System.currentTimeMillis();
        System.out.println("Resolution:"+data.getDataSets().get(0).size()+" Observations "+(t3-t2)+" ms");

        data.dump();
        
    }
}

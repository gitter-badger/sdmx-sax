/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.version.twopointzero;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLStreamException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sdmx.data.ValueTypeResolver;
import sdmx.message.DataMessage;
import sdmx.message.StructureType;
import sdmx.version.common.SdmxIO;
import sdmx.version.twopointzero.writer.CompactDataWriter;
import sdmx.workspace.LocalRegistry;
import sdmx.workspace.Registry;

/**
 *
 * @author James
 */
public class Sdmx20DataWriteTest {
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Start Test Data Writing");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Finish Test Data Writing");
    }
    
    Registry registry = LocalRegistry.getDefaultWorkspace();
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isSdmx20 method, of class Sdmx20StructureParserProvider.
     */
    @Test
    public void testCompactSample() throws IOException, XMLStreamException {
        long t1= System.currentTimeMillis();
        InputStream in = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/sdmx20-samples/CompactSample.xml");
        DataMessage data = SdmxIO.parseData(in,false);
        long t2 = System.currentTimeMillis();
        System.out.println("Read:"+data.getDataSets().get(0).size()+" Observations "+(t2-t1)+" ms");
        long t3 = System.currentTimeMillis();
        OutputStream out = new FileOutputStream("testOut/CompactSampleOut.xml");
        CompactDataWriter.write(data, out);
        out.close();
        data.dump();
    }

}

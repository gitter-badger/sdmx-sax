/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.json;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sdmx.Registry;
import sdmx.SdmxIO;
import sdmx.commonreferences.DataStructureReference;
import sdmx.exception.ParseException;
import sdmx.message.StructureType;
import sdmx.net.LocalRegistry;
import sdmx.version.common.ParseDataCallbackHandler;
import sdmx.version.twopointone.writer.Sdmx21StreamingDataWriterTest;

/**
 *
 * @author James
 */
public class JSONStreamingTest {
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    @Before
    public void setUp() throws ParseException {
    }

    @After
    public void tearDown() {
    }
    @Test
    public void testStructureSpecific1() {
        try {
            Registry reg = LocalRegistry.getDefaultWorkspace();
            StructureType struct = SdmxIO.parseStructure(new FileInputStream("test/resources/sdmx21-samples/exr/ecb_exr_ng/ecb_exr_ng_full-edited.xml"));
            reg.load(struct);
            DataStructureReference ref = struct.getStructures().getDataStructures().getDataStructures().get(0).asReference();
            FileOutputStream fos = new FileOutputStream("testOut/ecb_exr_ng_ts-streaming.json");
            ParseDataCallbackHandler cbHandler = SdmxIO.openForStreamWriting("application/vnd.sdmx.draft-sdmx-json+json;version=2.1", fos, reg, ref);
            FileInputStream fin = new FileInputStream("test/resources/sdmx21-samples/exr/ecb_exr_ng/structured/ecb_exr_ng_ts.xml");
            SdmxIO.parseData(fin, cbHandler);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sdmx21StreamingDataWriterTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx21StreamingDataWriterTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Sdmx21StreamingDataWriterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}

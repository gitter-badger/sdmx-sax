/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointone.writer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sdmx.SdmxIO;
import sdmx.exception.ParseException;
import sdmx.version.twopointone.Sdmx21StructureParserTest;

/**
 *
 * @author James
 */
public class Sdmx21StreamingDataWriterTest {
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
            FileOutputStream fos = new FileOutputStream("testOut/ecb_exr_ng_ts-streaming_compact_out.xml");
            StreamingStructureSpecificDataWriter writer = new StreamingStructureSpecificDataWriter(fos);
            FileInputStream fin = new FileInputStream("test/resources/sdmx21-samples/exr/ecb_exr_ng/structured/ecb_exr_ng_ts.xml");
            SdmxIO.parseData(fin, writer);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sdmx21StreamingDataWriterTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx21StreamingDataWriterTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Sdmx21StreamingDataWriterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    @Test
    public void testGeneric1() {
        try {
            FileOutputStream fos = new FileOutputStream("testOut/ecb_exr_ng_ts-streaming_generic_out.xml");
            StreamingStructureSpecificDataWriter writer = new StreamingStructureSpecificDataWriter(fos);
            FileInputStream fin = new FileInputStream("test/resources/sdmx21-samples/exr/ecb_exr_ng/generic/ecb_exr_ng_ts.xml");
            SdmxIO.parseData(fin, writer);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sdmx21StreamingDataWriterTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx21StreamingDataWriterTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Sdmx21StreamingDataWriterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

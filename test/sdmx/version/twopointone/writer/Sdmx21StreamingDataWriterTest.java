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
import sdmx.Registry;
import sdmx.SdmxIO;
import sdmx.commonreferences.DataStructureReference;
import sdmx.exception.ParseException;
import sdmx.message.StructureType;
import sdmx.net.LocalRegistry;
import sdmx.structure.dataflow.DataflowType;
import sdmx.version.common.ParseDataCallbackHandler;
import sdmx.version.common.ParseParams;
import sdmx.version.json.JSONStreamingTest;
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
            Registry reg = LocalRegistry.getDefaultWorkspace();
            StructureType struct = SdmxIO.parseStructure(new FileInputStream("test/resources/sdmx21-samples/exr/ecb_exr_ng/ecb_exr_ng_full-edited.xml"));
            reg.load(struct);
            DataflowType ref = struct.getStructures().getDataStructures().getDataStructures().get(0).asDataflow();
            FileOutputStream fos = new FileOutputStream("testOut/ecb_exr_ng_ts-streaming_ss21_out.xml");
            ParseParams params = new ParseParams();
            params.setRegistry(reg);
            params.setDataflow(ref);
            ParseDataCallbackHandler cbHandler = SdmxIO.openForStreamWriting("application/vnd.sdmx.structurespecificdata+xml;version=2.1", fos, params);
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
    @Test
    public void testGeneric1() {
        try {
            Registry reg = LocalRegistry.getDefaultWorkspace();
            StructureType struct = SdmxIO.parseStructure(new FileInputStream("test/resources/sdmx21-samples/exr/ecb_exr_ng/ecb_exr_ng_full-edited.xml"));
            reg.load(struct);
            DataflowType ref = struct.getStructures().getDataStructures().getDataStructures().get(0).asDataflow();
            FileOutputStream fos = new FileOutputStream("testOut/ecb_exr_ng_ts-streaming_generic_out.xml");
            ParseParams params = new ParseParams();
            params.setRegistry(reg);
            params.setDataflow(ref);
            ParseDataCallbackHandler cbHandler = SdmxIO.openForStreamWriting("application/vnd.sdmx.genericdata+xml;version=2.1", fos,params);
            FileInputStream fin = new FileInputStream("test/resources/sdmx21-samples/exr/ecb_exr_ng/generic/ecb_exr_ng_ts.xml");
            SdmxIO.parseData(fin, cbHandler);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sdmx21StreamingDataWriterTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx21StreamingDataWriterTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Sdmx21StreamingDataWriterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void testUIS() throws IOException {
        StructureType uisStruct = null;
        ParseParams params = new ParseParams();
        params.setRegistry(new LocalRegistry());
        try {
            InputStream in = JSONStreamingTest.class.getResourceAsStream("/resources/uis-20/structure.xml");
            uisStruct = SdmxIO.parseStructure(params,in);
        } catch (IOException ex) {
            Logger.getLogger(JSONStreamingTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JSONStreamingTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        InputStream dataIn = JSONStreamingTest.class.getResourceAsStream("/resources/uis-20/28b18979-129f-43bc-94ae-42f31add907a.xml");
        FileOutputStream fos = new FileOutputStream("testOut/uis-data-generic-2.1.xml");
        params.setDataflow(uisStruct.getStructures().getDataStructures().getDataStructures().get(0).asDataflow());
        ParseDataCallbackHandler cbHandler = SdmxIO.openForStreamWriting("application/vnd.sdmx.genericdata+xml;version=2.1", fos, params);
        long t1 = System.currentTimeMillis();
        try {
            SdmxIO.parseData(dataIn, cbHandler);
            
            //data6.dump();
        } catch (ParseException ex) {
            Logger.getLogger(JSONStreamingTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Time taken to convert uis sdmx to genericdata 2.1 = "+(t2-t1));
    }
    @Test
    public void testUIS2() throws IOException {
        StructureType uisStruct = null;
        ParseParams params = new ParseParams();
        params.setRegistry(new LocalRegistry());
        try {
            InputStream in = JSONStreamingTest.class.getResourceAsStream("/resources/uis-20/structure.xml");
            uisStruct = SdmxIO.parseStructure(params,in);
        } catch (IOException ex) {
            Logger.getLogger(JSONStreamingTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JSONStreamingTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        InputStream dataIn = JSONStreamingTest.class.getResourceAsStream("/resources/uis-20/28b18979-129f-43bc-94ae-42f31add907a.xml");
        FileOutputStream fos = new FileOutputStream("testOut/uis-data-structurespecific-2.1.xml");
        params.setDataflow(uisStruct.getStructures().getDataStructures().getDataStructures().get(0).asDataflow());
        ParseDataCallbackHandler cbHandler = SdmxIO.openForStreamWriting("application/vnd.sdmx.structurespecificdata+xml;version=2.1", fos, params);
        long t1 = System.currentTimeMillis();
        try {
            SdmxIO.parseData(dataIn, cbHandler);
            
            //data6.dump();
        } catch (ParseException ex) {
            Logger.getLogger(JSONStreamingTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Time taken to convert uis sdmx to structurespecific data 2.1 = "+(t2-t1));
    }
}

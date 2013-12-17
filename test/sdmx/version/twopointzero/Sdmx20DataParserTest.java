/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointzero;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.VersionType;
import sdmx.data.ValueTypeResolver;
import sdmx.message.DataMessage;
import sdmx.message.StructureType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.version.common.SdmxIO;
import sdmx.workspace.LocalRegistry;
import sdmx.workspace.RESTServiceRegistry;
import sdmx.workspace.Registry;

/**
 *
 * @author James
 */
public class Sdmx20DataParserTest {
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Start Test Data Parsing");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Finish Test Data Parsing");
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
    public void testCompactSample() throws IOException {
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
        ValueTypeResolver.resolveDataSet(registry, data.getDataSets().get(0), struct.getStructures().getDataStructures().getDataStructures().get(0));
        long t3 = System.currentTimeMillis();
        System.out.println("Resolution:"+data.getDataSets().get(0).size()+" Observations "+(t3-t2)+" ms");
        data.dump();
    }
    @Test
    public void testGeneric() throws IOException {
        System.out.println("Test Generic");
        StructureType struct = null;
        try {
            InputStream in = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/sdmx20-samples/StructureSample.xml");
            struct = SdmxIO.parseStructure(in);
            LocalRegistry.getDefaultWorkspace().load(struct);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20DataParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        long t1= System.currentTimeMillis();
        InputStream in = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/sdmx20-samples/GenericSample.xml");
        DataMessage data = SdmxIO.parseData(in);
        long t2 = System.currentTimeMillis();
        System.out.println("Read:"+data.getDataSets().get(0).size()+" Observations "+(t2-t1)+" ms");
        ValueTypeResolver.resolveDataSet(registry, data.getDataSets().get(0), struct.getStructures().getDataStructures().getDataStructures().get(0));
        long t3 = System.currentTimeMillis();
        System.out.println("Resolution:"+data.getDataSets().get(0).size()+" Observations "+(t3-t2)+" ms");
        data.dump();
    }

    @Test
    public void testABSCPI() throws IOException {
        StructureType cpiStruct = null;
        try {
            InputStream in = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/cpi-structure.xml");
            cpiStruct = SdmxIO.parseStructure(in);
            LocalRegistry.getDefaultWorkspace().load(cpiStruct);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20DataParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        long t1= System.currentTimeMillis();
        InputStream in2 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/cpi-data.xml");
        DataMessage data2 = SdmxIO.parseData(in2);
        long t2 = System.currentTimeMillis();
        System.out.println("Read:"+data2.getDataSets().get(0).size()+" Observations "+(t2-t1)+" ms");
        ValueTypeResolver.resolveDataSet(registry, data2.getDataSets().get(0), cpiStruct.getStructures().getDataStructures().getDataStructures().get(0));
        long t3 = System.currentTimeMillis();
        System.out.println("Resolution:"+data2.getDataSets().get(0).size()+" Observations "+(t3-t2)+" ms");

        data2.dump();
    }
    @Test
    public void testIMFPGI() throws IOException {
        StructureType pgiStruct = null;
        try {
            InputStream in = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/imf-20/PGIDSD.xml");
            pgiStruct = SdmxIO.parseStructure(in);
            LocalRegistry.getDefaultWorkspace().load(pgiStruct);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20DataParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        long t1= System.currentTimeMillis();
        InputStream in3 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/imf-20/PGICompact.xml");
        DataMessage data3 = SdmxIO.parseData(in3);
        long t2 = System.currentTimeMillis();
        System.out.println("Read:"+data3.getDataSets().get(0).size()+" Observations "+(t2-t1)+" ms");
        ValueTypeResolver.resolveDataSet(registry, data3.getDataSets().get(0), pgiStruct.getStructures().getDataStructures().getDataStructures().get(0));
        long t3 = System.currentTimeMillis();
        System.out.println("Resolution:"+data3.getDataSets().get(0).size()+" Observations "+(t3-t2)+" ms");

        //data3.dump();
    }

    @Test
    public void testABSALC() throws IOException {
        StructureType alcStruct = null;
        try {
            InputStream in = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/alc-structure.xml");
            alcStruct = SdmxIO.parseStructure(in);
            LocalRegistry.getDefaultWorkspace().load(alcStruct);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20DataParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        long t1 = System.currentTimeMillis();
        InputStream in5 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/alc-data.xml");
        DataMessage data5 = SdmxIO.parseData(in5);
        long t2 = System.currentTimeMillis();
        System.out.println("Read:"+data5.getDataSets().get(0).size()+" Observations "+(t2-t1)+" ms");
        ValueTypeResolver.resolveDataSet(registry, data5.getDataSets().get(0), alcStruct.getStructures().getDataStructures().getDataStructures().get(0));
        long t3 = System.currentTimeMillis();
        System.out.println("Resolution:"+data5.getDataSets().get(0).size()+" Observations "+(t3-t2)+" ms");
    }
    /* 
       This test is quite long....
       * */
/*
    @Test
    public void testUISStruct() throws IOException {
        StructureType uisStruct = null;
        try {
            InputStream in = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/uis-20/structure.xml");
            uisStruct = SdmxIO.parseStructure(in);
            LocalRegistry.getDefaultWorkspace().load(uisStruct);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20DataParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        long t1 = System.currentTimeMillis();
        InputStream in6 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/uis-20/28b18979-129f-43bc-94ae-42f31add907a.xml");
        DataMessage data6 = SdmxIO.parseData(in6);
        long t2 = System.currentTimeMillis();
        System.out.println("Read:"+data6.getDataSets().get(0).size()+" Observations "+(t2-t1)+" ms");
        ValueTypeResolver.resolveDataSet(LocalRegistry.getDefaultWorkspace(), data6.getDataSets().get(0), uisStruct.getStructures().getDataStructures().getDataStructures().get(0));
        long t3 = System.currentTimeMillis();
        System.out.println("Resolution:"+data6.getDataSets().get(0).size()+" Observations "+(t3-t2)+" ms");
        //data6.dump();
    }*/
/*
    @Test
    public void testFAOCAPTURE() throws IOException {
        RESTServiceRegistry registry = new RESTServiceRegistry("FAO", "http://www.fao.org/figis/sdmx");
        long t1 = System.currentTimeMillis();
        DataStructureType faoStruct = registry.findDataStructure(new NestedNCNameIDType("FAO"), new IDType("CAPTURE_DATASTRUCTURE"), new VersionType("0.1"));
        long t2 = System.currentTimeMillis();
        System.out.println("Loaded FAO Capture Struct:"+(t2-t1)+" ms");
        InputStream in7 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/fao-20/CAPTURE_DATA.xml");
        DataMessage data7 = SdmxIO.parseData(in7);
        long t3 = System.currentTimeMillis();
        System.out.println("Read:"+data7.getDataSets().get(0).size()+" Observations "+(t3-t2)+" ms");
        ValueTypeResolver.resolveDataSet(registry, data7.getDataSets().get(0), faoStruct);
        long t4 = System.currentTimeMillis();
        System.out.println("Resolution:"+data7.getDataSets().get(0).size()+" Observations "+(t4-t3)+" ms");
        data7.dump();
    }
    */
}

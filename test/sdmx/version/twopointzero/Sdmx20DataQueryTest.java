/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointzero;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipInputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sdmx.data.DataSet;
import sdmx.combined.ValueTypeResolver;
import sdmx.data.flat.FlatObs;
import sdmx.data.key.PartialKey;
import sdmx.message.DataMessage;
import sdmx.message.StructureType;
import sdmx.query.data.DataParametersType;
import sdmx.query.data.DataQuery;
import sdmx.query.data.DimensionValueType;
import sdmx.SdmxIO;
import sdmx.registry.LocalRegistry;
import sdmx.Registry;

/**
 *
 * @author James
 */
public class Sdmx20DataQueryTest {

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

    @Test
    public void testQuery() throws IOException {
        StructureType uisStruct = null;
        try {
            InputStream in = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/uis-20/structure.xml");
            uisStruct = SdmxIO.parseStructure(in);
            LocalRegistry.getDefaultWorkspace().load(uisStruct);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20DataParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        long t1 = System.currentTimeMillis();
        ZipInputStream zip = new ZipInputStream(Sdmx20StructureParserTest.class.getResourceAsStream("/resources/uis-20/28b18979-129f-43bc-94ae-42f31add907a.zip"));
        zip.getNextEntry();
        InputStream in6 = zip;
        DataMessage data6 = SdmxIO.parseData(in6,true);
        long t2 = System.currentTimeMillis();
        System.out.println("Read:" + data6.getDataSets().get(0).size() + " Observations " + (t2 - t1) + " ms");
        
        long t3 = System.currentTimeMillis();
        System.out.println("Resolution:" + data6.getDataSets().get(0).size() + " Observations " + (t3 - t2) + " ms");
        PartialKey key = new PartialKey();
        key.setComponent("REF_AREA", "ABW");
        key.setComponent("UNIT", "NUMBER");
        List<FlatObs> list = data6.getDataSets().get(0).query(key);
        System.out.println("Size="+list.size());
        //ValueTypeResolver.resolveDataSet(LocalRegistry.getDefaultWorkspace(), d7, uisStruct.getStructures().getDataStructures().getDataStructures().get(0));
        for(int i=0;i<list.size();i++) {
            for(int j=0;j<list.get(i).size();j++) {
                System.out.print(list.get(i).getValue(j));
                if( j < list.get(i).size()-1)System.out.print(" ");
                if( j==list.get(i).size()-1) System.out.println();
            }
        }
        //data6.dump();
    }
}

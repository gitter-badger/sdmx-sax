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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sdmx.data.DataSet;
import sdmx.data.ValueTypeResolver;
import sdmx.message.DataMessage;
import sdmx.message.StructureType;
import sdmx.query.data.DataParametersType;
import sdmx.query.data.DataQuery;
import sdmx.query.data.DimensionValueType;
import sdmx.version.common.SdmxIO;
import sdmx.workspace.LocalRegistry;
import sdmx.workspace.Registry;

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
        InputStream in6 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/uis-20/28b18979-129f-43bc-94ae-42f31add907a.xml");
        DataMessage data6 = SdmxIO.parseData(in6,true);
        long t2 = System.currentTimeMillis();
        System.out.println("Read:" + data6.getDataSets().get(0).size() + " Observations " + (t2 - t1) + " ms");
        
        //ValueTypeResolver.resolveDataSet(LocalRegistry.getDefaultWorkspace(), data6.getDataSets().get(0), uisStruct.getStructures().getDataStructures().getDataStructures().get(0));
        long t3 = System.currentTimeMillis();
        System.out.println("Resolution:" + data6.getDataSets().get(0).size() + " Observations " + (t3 - t2) + " ms");
        DataQuery query = new DataQuery();
        DataParametersType where = new DataParametersType();
        List<DimensionValueType> dims = new ArrayList<DimensionValueType>();
        DimensionValueType d1 = new DimensionValueType("REF_AREA","ABW");
        dims.add(d1);
        DimensionValueType d2 = new DimensionValueType("UNIT","NUMBER");
        dims.add(d2);
        where.setDimensionValue(dims);
        query.setDataWhere(where);
        DataSet d7 = data6.getDataSets().get(0).query(query);
        System.out.println("Size="+d7.size());
        d7.dump();
        //data6.dump();

    }
}

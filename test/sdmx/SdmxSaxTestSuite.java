/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sdmx.data.StructuredDataTest;
import sdmx.message.StructureTypeTest;
import sdmx.version.common.SOAPStripperInputStreamTest;
import sdmx.version.twopointone.Sdmx21StructureParserTest;
import sdmx.version.twopointzero.Sdmx20DataParserTest;
import sdmx.version.twopointzero.Sdmx20DataQueryTest;
import sdmx.version.twopointzero.Sdmx20DataWriteTest;
import sdmx.version.twopointzero.Sdmx20ServiceTest;
import sdmx.version.twopointzero.Sdmx20StructureParserTest;
import sdmx.workspace.LocalRegistryTest;

/**
 *
 * @author James
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    SdmxIOTest.class,
    Sdmx21StructureParserTest.class,
    Sdmx20StructureParserTest.class,
    Sdmx20DataParserTest.class,
    Sdmx20ServiceTest.class,
    SOAPStripperInputStreamTest.class,
    StructuredDataTest.class,
    Sdmx20DataQueryTest.class,
    Sdmx20DataWriteTest.class,
    LocalRegistryTest.class,
    StructureTypeTest.class
})
public class SdmxSaxTestSuite {
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    @Before
    public void setUp() throws Exception {
    }
    @After
    public void tearDown() throws Exception {
    }

}

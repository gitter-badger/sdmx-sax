/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.common;

import sdmx.SdmxIO;
import java.io.InputStream;
import java.io.PushbackInputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sdmx.message.StructureType;

/**
 *
 * @author James
 */
public class SdmxIOTest {
    
    public SdmxIOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkVersion method, of class SdmxIO.
     */
    @Test
    public void testCheckVersion1() throws Exception {
        System.out.println("checkVersion1");
        InputStream in = SdmxIOTest.class.getResourceAsStream("/resources/sdmx20-samples/CompactSample.xml");
        PushbackInputStream pushback = new PushbackInputStream(in,8192);
        int expResult = SdmxIO.VERSION20;
        int result = SdmxIO.checkVersion(pushback);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckVersion2() throws Exception {
        System.out.println("checkVersion2");
        InputStream in = SdmxIOTest.class.getResourceAsStream("/resources/sdmx20-samples/CrossSectionalSample.xml");
        PushbackInputStream pushback = new PushbackInputStream(in,8192);
        int expResult = SdmxIO.VERSION20;
        int result = SdmxIO.checkVersion(pushback);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckVersion3() throws Exception {
        System.out.println("checkVersion3");
        InputStream in = SdmxIOTest.class.getResourceAsStream("/resources/sdmx20-samples/GenericSample.xml");
        PushbackInputStream pushback = new PushbackInputStream(in,8192);
        int expResult = SdmxIO.VERSION20;
        int result = SdmxIO.checkVersion(pushback);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckVersion4() throws Exception {
        System.out.println("checkVersion4");
        InputStream in = SdmxIOTest.class.getResourceAsStream("/resources/sdmx21-samples/demography/demography_xs.xml");
        PushbackInputStream pushback = new PushbackInputStream(in,8192);
        int expResult = SdmxIO.VERSION21;
        int result = SdmxIO.checkVersion(pushback);
        assertEquals(expResult, result);
    }
}

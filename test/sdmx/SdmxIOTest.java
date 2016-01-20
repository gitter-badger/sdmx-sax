/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx;

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
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
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

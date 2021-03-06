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
import sdmx.commonreferences.ReferenceTypeTest;
import sdmx.cube.CubeTest;
import sdmx.data.StructuredDataTest;
import sdmx.message.StructureTypeTest;
import sdmx.registry.LocalRegistryTest;
import sdmx.version.common.SOAPStripperInputStreamTest;
import sdmx.version.twopointone.Sdmx21StructureParserTest;
import sdmx.version.twopointone.writer.Sdmx21StreamingDataWriterTest;
import sdmx.version.twopointzero.Sdmx20DataParserTest;
import sdmx.version.twopointzero.Sdmx20DataWriteTest;
import sdmx.version.twopointzero.Sdmx20ServiceTest;
import sdmx.version.twopointzero.Sdmx20StructureParserTest;
import sdmx.version.twopointzero.Sdmx20StructureWriteTest;
import sdmx.version.twopointzero.compact.CompactDataEventHandlerTest;
import sdmx.version.twopointzero.generic.GenericDataContentHandlerTest;

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
@RunWith(Suite.class)
@Suite.SuiteClasses({
    SdmxIOTest.class,
    Sdmx21StructureParserTest.class,
    Sdmx20StructureParserTest.class,
    Sdmx20DataParserTest.class,
    //Sdmx20ServiceTest.class,
    SOAPStripperInputStreamTest.class,
    StructuredDataTest.class,
    Sdmx20DataWriteTest.class,
    LocalRegistryTest.class,
    StructureTypeTest.class,
    CompactDataEventHandlerTest.class,
    GenericDataContentHandlerTest.class,
    CubeTest.class,
    ReferenceTypeTest.class,
    Sdmx20StructureWriteTest.class,
    Sdmx21StreamingDataWriterTest.class
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

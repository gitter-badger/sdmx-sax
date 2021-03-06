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
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sdmx.Registry;
import sdmx.SdmxIO;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedNCNameID;
import sdmx.commonreferences.Version;
import sdmx.exception.ParseException;
import sdmx.message.DataMessage;
import sdmx.message.StructureType;
import sdmx.net.LocalRegistry;
import sdmx.structure.base.Component;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structureddata.ValueTypeResolver;

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
public class Sdmx20DataParserTest1 {
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
    public void testABSCensus() throws IOException, ParseException {
        StructureType cenStruct = null;
        try {
            InputStream in = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/abs_census2011_b04.xml");
            cenStruct = SdmxIO.parseStructure(in);
            LocalRegistry.getDefaultWorkspace().load(cenStruct);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20DataParserTest1.class.getName()).log(Level.SEVERE, null, ex);
        }
        Component c = cenStruct.getStructures().getDataStructures().getDataStructures().get(0).getDataStructureComponents().findDimension("INDP");
        assertNotNull(c);
    }

}

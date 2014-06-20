/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.version.twopointone.writer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sdmx.SdmxIO;
import sdmx.exception.ParseException;
import sdmx.message.BaseHeaderType;
import sdmx.message.StructureType;
import sdmx.version.twopointone.Sdmx21StructureParserTest;

/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *   SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public class Sdmx21StructureWriterTest {

    public Sdmx21StructureWriterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    StructureType doc1 = null;
    StructureType doc2 = null;
    StructureType doc3 = null;

    @Before
    public void setUp() throws ParseException {
        try {
            InputStream in = Sdmx21StructureParserTest.class.getResourceAsStream("/resources/sdmx21-samples/demography/demography.xml");
            doc1 = SdmxIO.parseStructure(in);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx21StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            InputStream in = Sdmx21StructureParserTest.class.getResourceAsStream("/resources/sdmx21-samples/demography/esms.xml");
            doc2 = SdmxIO.parseStructure(in);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx21StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            InputStream in = Sdmx21StructureParserTest.class.getResourceAsStream("/resources/abs-20/8nrpver5-structure.xml");
            doc3 = SdmxIO.parseStructure(in);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx21StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
        doc1 = null;
        doc2 = null;
    }

    @Test
    public void test1() {
        try {
            FileOutputStream fos = new FileOutputStream("testOut/structureOut1.xml");
            Sdmx21StructureWriter.write(doc1, fos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sdmx21StructureWriterTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx21StructureWriterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Test
    public void test2() {
        try {
            FileOutputStream fos = new FileOutputStream("testOut/structureOut2.xml");
            Sdmx21StructureWriter.write(doc2, fos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sdmx21StructureWriterTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx21StructureWriterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Test
    public void test3() {
        try {
            FileOutputStream fos = new FileOutputStream("testOut/structureOut3.xml");
            Sdmx21StructureWriter.write(doc3, fos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sdmx21StructureWriterTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx21StructureWriterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

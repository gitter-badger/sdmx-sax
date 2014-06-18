/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.version.twopointone.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sdmx.SdmxIO;
import sdmx.exception.ParseException;
import sdmx.message.DataMessage;
import sdmx.message.HeaderTimeType;

/**
 *
 * @author James
 */
public class GenericData21Test {
    public GenericData21Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    DataMessage msg = null;
    @Before
    public void setUp() throws FileNotFoundException, IOException, ParseException {
        FileInputStream fis = new FileInputStream("test/resources/sdmx21-samples/exr/ecb_exr_ng/generic/ecb_exr_ng_flat.xml");
        msg = SdmxIO.parseData(fis, false);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGenericData1() throws IOException {
        String result = "Generic";
        assertEquals(result,msg.getHeader().getId());
    }   
    @Test
    public void testGenericData2() throws IOException {
        assertEquals(Boolean.FALSE,msg.getHeader().getTest());
    }   
    @Test
    public void testGenericData3() throws IOException {
        HeaderTimeType prepared = msg.getHeader().getPrepared();
        Locale[] locs = Locale.getAvailableLocales();
        Locale loc = null;
        
        for(int i=0;i<locs.length;i++) {
            if( locs[i].getDisplayCountry().equals("Germany")) loc = locs[i];
        }
        Calendar c=  Calendar.getInstance(loc);
        c.setTime(prepared.getDate().getDate());
        assertEquals(2010,c.get(Calendar.YEAR));
        assertEquals(Calendar.JANUARY,c.get(Calendar.MONTH));
        assertEquals(4,c.get(Calendar.DAY_OF_MONTH));
        assertEquals(11,c.get(Calendar.HOUR));
        assertEquals(21,c.get(Calendar.MINUTE));
        assertEquals(49,c.get(Calendar.SECOND));
    }   
    @Test
    public void testGenericData4() throws IOException {
        assertEquals("ECB",msg.getHeader().getSender().getId().toString());
    }   
    @Test
    public void testGenericData5() throws IOException {
        assertEquals("STR1",msg.getHeader().getStructures().get(0).getStructureID().toString());
    }   
    @Test
    public void testGenericData6() throws IOException {
        assertEquals("AllDimensions",msg.getHeader().getStructures().get(0).getDimensionAtObservation().toString());
    }   
    @Test
    public void testGenericData7() throws IOException {
        assertEquals("ECB",msg.getHeader().getStructures().get(0).getStructure().getRef().getAgencyId().toString());
    }   
    @Test
    public void testGenericData8() throws IOException {
        assertEquals("ECB_EXR_NG",msg.getHeader().getStructures().get(0).getStructure().getRef().getId().toString());
    }   
    @Test
    public void testGenericData9() throws IOException {
        assertEquals("1.0",msg.getHeader().getStructures().get(0).getStructure().getRef().getVersion().toString());
    }   
}
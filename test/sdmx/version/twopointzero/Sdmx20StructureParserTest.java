/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointzero;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sdmx.commonreferences.ConceptRefType;
import sdmx.commonreferences.RefBaseType;
import sdmx.commonreferences.VersionType;
import sdmx.message.StructureType;
import sdmx.structure.ConceptsType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.version.common.SdmxIO;

/**
 *
 * @author James
 */
public class Sdmx20StructureParserTest {
    
    public Sdmx20StructureParserTest() {
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
     * Test of isSdmx20 method, of class Sdmx20StructureParserProvider.
     */
    @Test
    public void testStructureSample() {
        System.out.println("test SDMX 2.0 Parse");
        String header = "";
        boolean expResult = false;
        InputStream in = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/sdmx20-samples/StructureSample.xml");
        StructureType doc = null;
        try {
            doc = SdmxIO.parseStructure(in);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc);
        
        assertEquals("BIS_01",doc.getHeader().getId().toString());
        assertTrue(doc.getHeader().getTest());
        // No Truncated attribute in sdmx 2.1, so no test for it here.
        assertEquals("Trans46301",doc.getHeader().getNames().get(0).getText());
        assertEquals("en",doc.getHeader().getNames().get(0).getLang());
        Calendar c = Calendar.getInstance();
        c.setTime(doc.getHeader().getPrepared().getDate().getDate());
        assertEquals(c.get(Calendar.YEAR),2002);
        assertEquals(c.get(Calendar.MONTH),2);
        assertEquals(c.get(Calendar.DATE),11);
        assertEquals(c.get(Calendar.HOUR),10);
        assertEquals(c.get(Calendar.MINUTE),30);
        assertEquals(c.get(Calendar.SECOND),47);
        assertEquals(c.get(Calendar.ZONE_OFFSET),28800000);
        assertEquals("BIS",doc.getHeader().getSender().getId().toString());
        assertEquals("Bank for International Settlements",doc.getHeader().getSender().getNames().get(0).getText());
        assertEquals("en",doc.getHeader().getSender().getNames().get(0).getLang());
        assertEquals("G.B. Smith",doc.getHeader().getSender().getContacts().get(0).getNames().get(0).getText());
        assertEquals("en",doc.getHeader().getSender().getContacts().get(0).getNames().get(0).getLang());
        assertEquals("+000.000.0000",doc.getHeader().getSender().getContacts().get(0).getTelephones().get(0));

        assertEquals("ECB",doc.getHeader().getReceivers().get(0).getId().toString());
        assertEquals("European Central Bank",doc.getHeader().getReceivers().get(0).getNames().get(0).getText());
        assertEquals("en",doc.getHeader().getReceivers().get(0).getNames().get(0).getLang());
        assertEquals("B.S. Featherstone",doc.getHeader().getReceivers().get(0).getContacts().get(0).getNames().get(0).getText());
        assertEquals("en",doc.getHeader().getReceivers().get(0).getContacts().get(0).getNames().get(0).getLang());
        assertEquals("Statistics Division",doc.getHeader().getReceivers().get(0).getContacts().get(0).getDepartments().get(0).getText());
        assertEquals("en",doc.getHeader().getReceivers().get(0).getContacts().get(0).getDepartments().get(0).getLang());
        assertEquals("+000.000.0001",doc.getHeader().getReceivers().get(0).getContacts().get(0).getTelephones().get(0));
        c = doc.getHeader().getExtracted().toCalendar();
        assertEquals(c.get(Calendar.YEAR),2002);
        assertEquals(c.get(Calendar.MONTH),2);
        assertEquals(c.get(Calendar.DATE),11);
        assertEquals(c.get(Calendar.HOUR),9);
        assertEquals(c.get(Calendar.MINUTE),30);
        assertEquals(c.get(Calendar.SECOND),47);
        assertEquals(c.get(Calendar.ZONE_OFFSET),-18000000);
        
        CodelistType cl = doc.getStructures().getCodelists().findCodelist("BIS", "CL_OBS_STATUS", "1.0");

        assertNotNull(cl);
        assertEquals("http://www.bis.org/structure/codelists/cl_obs_status.xml",cl.getUri().getString());
        assertEquals("Observation Status",cl.findName("en").toString());
        assertEquals("Present",cl.findCode("A").findDescription("en").toString());
        assertEquals("Missing",cl.findCode("M").findDescription("en").toString());

        cl = doc.getStructures().getCodelists().findCodelist("BIS","CL_COLLECTION","1.0");
        assertEquals("Average of observations through period",cl.findCode("A").findDescription("en").toString());
        assertEquals("Beginning of period",cl.findCode("B").findDescription("en").toString());
        assertEquals("End of period",cl.findCode("E").findDescription("en").toString());
        assertEquals("Highest in period",cl.findCode("H").findDescription("en").toString());
        assertEquals("Lowest in period",cl.findCode("L").findDescription("en").toString());
        assertEquals("Middle of period",cl.findCode("M").findDescription("en").toString());
        assertEquals("Summed through period",cl.findCode("S").findDescription("en").toString());
        assertEquals("Unknown",cl.findCode("U").findDescription("en").toString());
        assertEquals("Other",cl.findCode("V").findDescription("en").toString());
        assertEquals("Annualised summed",cl.findCode("Y").findDescription("en").toString());
        cl = doc.getStructures().getCodelists().findCodelist("BIS", "CL_DECIMALS", "1.0");
        assertEquals("one",cl.findCode("1").findDescription("en").toString());
        assertEquals("two",cl.findCode("2").findDescription("en").toString());
        assertEquals("three",cl.findCode("3").findDescription("en").toString());
        assertEquals("four",cl.findCode("4").findDescription("en").toString());
        assertEquals("five",cl.findCode("5").findDescription("en").toString());
        assertEquals("six",cl.findCode("6").findDescription("en").toString());
        assertEquals("seven",cl.findCode("7").findDescription("en").toString());
        assertEquals("eight",cl.findCode("8").findDescription("en").toString());
        cl = doc.getStructures().getCodelists().findCodelist("BIS", "CL_BIS_OBS_CONF", "1.0");
        assertEquals("Observation confidentiality code list",cl.findName("en").toString());
        assertEquals("Non-publishable and confidential",cl.findCode("C").findDescription("en").toString());
        assertEquals("Free",cl.findCode("F").findDescription("en").toString());
        assertEquals("Non-publishable, but non-confidential",cl.findCode("N").findDescription("en").toString());
        assertEquals("Confidential statistical information due to identifiable respondents",cl.findCode("R").findDescription("en").toString());
        cl = doc.getStructures().getCodelists().findCodelist("BIS", "CL_BIS_UNIT", "1.0");
        assertEquals("BIS Unit",cl.findName("en").toString());
        assertEquals("Swiss Francs",cl.findCode("CHF").findDescription("en").toString());
        assertEquals("United States Dollars",cl.findCode("USD").findDescription("en").toString());
        assertEquals("New Zealand Dollars",cl.findCode("NZD").findDescription("en").toString());
        assertEquals("Euros",cl.findCode("EUR").findDescription("en").toString());
        cl = doc.getStructures().getCodelists().findCodelist("BIS", "CL_UNIT_MULT","1.0");
        assertEquals("Unit multiplier",cl.findName("en").toString());
        assertEquals("Units",cl.findCode("0").findDescription("en").toString());
        assertEquals("Tens",cl.findCode("1").findDescription("en").toString());
        assertEquals("Hundreds",cl.findCode("2").findDescription("en").toString());
        assertEquals("Thousands",cl.findCode("3").findDescription("en").toString());
        assertEquals("Ten Thousands",cl.findCode("4").findDescription("en").toString());
        assertEquals("Millions",cl.findCode("5").findDescription("en").toString());
        assertEquals("Billions",cl.findCode("6").findDescription("en").toString());
 
        ConceptsType cons = doc.getStructures().getConcepts();
        ConceptType cs = cons.findConceptScheme("BIS", "TIME", "1.0").findConcept("TIME");
        
        assertEquals("http://www.bis.org/structure/concepts/VIS_CTY.xml",cs.getUri().getString());
        assertEquals("Time",cs.findName("en").toString());
        cs = cons.findConceptScheme("BIS", "FREQ", "1.0").findConcept("FREQ");
        assertEquals("http://www.bis.org/structure/concepts/FREQ.xml",cs.getUri().getString());
        assertEquals("Frequency",cs.findName("en").toString());
        cs = cons.findConceptScheme("BIS", "JD_TYPE", "1.0").findConcept("JD_TYPE");
        assertEquals("http://www.bis.org/structure/concepts/JD_TYPE.xml",cs.getUri().getString());
        assertEquals("Data Type (amounts outstanding, net disbursement or changes)",cs.findName("en").toString());
        cs = cons.findConceptScheme("BIS", "JD_CATEGORY", "1.0").findConcept("JD_CATEGORY");
        assertEquals("http://www.bis.org/structure/concepts/JD_CATEGORY.xml",cs.getUri().getString());
        assertEquals("Debt category",cs.findName("en").toString());
        cs = cons.findConceptScheme("BIS", "VIS_CTY", "1.0").findConcept("VIS_CTY");
        assertEquals("http://www.bis.org/structure/concepts/VIS_CTY.xml",cs.getUri().getString());
        assertEquals("Vis-a-vis country",cs.findName("en").toString());
        
        cs = cons.findConceptScheme("BIS", "AVAILABILITY", "1.0").findConcept("AVAILABILITY");
        assertEquals("http://www.bis.org/structure/concepts/AVAILABILITY.xml",cs.getUri().getString());
        assertEquals("Availability",cs.findName("en").toString());
        
        cs = cons.findConceptScheme("BIS", "COLLECTION", "1.0").findConcept("COLLECTION");
        assertEquals("http://www.bis.org/structure/concepts/COLLECTION.xml",cs.getUri().getString());
        assertEquals("Collection indicator",cs.findName("en").toString());

        cs = cons.findConceptScheme("BIS", "DECIMALS", "1.0").findConcept("DECIMALS");
        assertEquals("http://www.bis.org/structure/concepts/DECIMALS.xml",cs.getUri().getString());
        assertEquals("Decimals",cs.findName("en").toString());
        
        cs = cons.findConceptScheme("BIS", "OBS_CONF", "1.0").findConcept("OBS_CONF");
        assertEquals("http://www.bis.org/structure/concepts/OBS_CONF.xml",cs.getUri().getString());
        assertEquals("Observation confidentiality",cs.findName("en").toString());

        cs = cons.findConceptScheme("BIS", "TIME_FORMAT", "1.0").findConcept("TIME_FORMAT");
        assertEquals("http://www.bis.org/structure/concepts/TIME_FORMAT.xml",cs.getUri().getString());
        assertEquals("Time Format",cs.findName("en").toString());

        cs = cons.findConceptScheme("BIS", "OBS_STATUS", "1.0").findConcept("OBS_STATUS");
        assertEquals("http://www.bis.org/structure/concepts/OBS_STATUS.xml",cs.getUri().getString());
        assertEquals("Observation status",cs.findName("en").toString());

        cs = cons.findConceptScheme("BIS", "OBS_PRE_BREAK", "1.0").findConcept("OBS_PRE_BREAK");
        assertEquals("http://www.bis.org/structure/concepts/OBS_PRE_BREAK.xml",cs.getUri().getString());
        assertEquals("Pre-break observation",cs.findName("en").toString());

        cs = cons.findConceptScheme("BIS", "BIS_UNIT", "1.0").findConcept("BIS_UNIT");
        assertEquals("http://www.bis.org/structure/concepts/UNIT.xml",cs.getUri().getString());
        assertEquals("Unit",cs.findName("en").toString());
        
        cs = cons.findConceptScheme("BIS", "UNIT_MULT", "1.0").findConcept("UNIT_MULT");
        assertEquals("http://www.bis.org/structure/concepts/UNIT_MULT.xml",cs.getUri().getString());
        assertEquals("Unit multiplier",cs.findName("en").toString());

        cs = cons.findConceptScheme("BIS", "OBS_VALUE", "1.0").findConcept("OBS_VALUE");
        assertEquals("http://www.bis.org/structure/concepts/OBS_VALUE.xml",cs.getUri().getString());
        assertEquals("Observation value",cs.findName("en").toString());

        cs = cons.findConceptScheme("BIS", "STOCKS", "1.0").findConcept("STOCKS");
        assertEquals("http://www.bis.org/structure/concepts/STOCKS.xml",cs.getUri().getString());
        assertEquals("Stocks as measure",cs.findName("en").toString());
        
        cs = cons.findConceptScheme("BIS", "FLOWS", "1.0").findConcept("FLOWS");
        assertEquals("http://www.bis.org/structure/concepts/FLOWS.xml",cs.getUri().getString());
        assertEquals("Flows as measure",cs.findName("en").toString());

        DataStructureType ds = doc.getStructures().getDataStructures().getDataStructures().get(0);
        // "BIS" is filled in from the conceptRef field
        RefBaseType ref = ds.getDataStructureComponents().getDimensionList().getDimension(0).getConceptIdentity().getRef();
        //System.out.println(ref.getMaintainableParentId()+":"+ref.getMaintainableParentVersion()+":"+ref.getAgencyId()+":"+ref.getId()+":"+ref.getVersion());
        assertEquals("BIS",ds.getDataStructureComponents().getDimensionList().getDimensions().get(0).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("FREQ",ds.getDataStructureComponents().getDimensionList().getDimensions().get(0).getConceptIdentity().getRef().getId().toString());
        // 1.0 is filled in from the conceptRef field.
        assertEquals("1.0",ds.getDataStructureComponents().getDimensionList().getDimensions().get(0).getConceptIdentity().getRef().getMaintainableParentVersion().toString());

        assertEquals("BIS",ds.getDataStructureComponents().getDimensionList().getDimensions().get(1).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("JD_TYPE",ds.getDataStructureComponents().getDimensionList().getDimensions().get(1).getConceptIdentity().getRef().getId().toString());
        // 1.0 is filled in from the conceptRef field.
        assertEquals("1.0",ds.getDataStructureComponents().getDimensionList().getDimensions().get(1).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("BIS",ds.getDataStructureComponents().getDimensionList().getDimensions().get(1).getLocalRepresentation().getEnumeration().getRef().getAgencyId().toString());
        assertEquals("CL_JD_TYPE",ds.getDataStructureComponents().getDimensionList().getDimensions().get(1).getLocalRepresentation().getEnumeration().getRef().getId().toString());
        assertEquals("1.0",ds.getDataStructureComponents().getDimensionList().getDimensions().get(1).getLocalRepresentation().getEnumeration().getRef().getVersion().toString());
        
        assertEquals("BIS",ds.getDataStructureComponents().getDimensionList().getDimensions().get(2).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("JD_CATEGORY",ds.getDataStructureComponents().getDimensionList().getDimensions().get(2).getConceptIdentity().getRef().getId().toString());
        // 1.0 is filled in from the conceptRef field.
        assertEquals("1.0",ds.getDataStructureComponents().getDimensionList().getDimensions().get(2).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("BIS",ds.getDataStructureComponents().getDimensionList().getDimensions().get(2).getLocalRepresentation().getEnumeration().getRef().getAgencyId().toString());
        assertEquals("CL_JD_CATEGORY",ds.getDataStructureComponents().getDimensionList().getDimensions().get(2).getLocalRepresentation().getEnumeration().getRef().getId().toString());
        assertEquals("1.0",ds.getDataStructureComponents().getDimensionList().getDimensions().get(2).getLocalRepresentation().getEnumeration().getRef().getVersion().toString());

        assertEquals("BIS",ds.getDataStructureComponents().getDimensionList().getDimensions().get(3).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("VIS_CTY",ds.getDataStructureComponents().getDimensionList().getDimensions().get(3).getConceptIdentity().getRef().getId().toString());
        // 1.0 is filled in from the conceptRef field.
        assertEquals("1.0",ds.getDataStructureComponents().getDimensionList().getDimensions().get(3).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("BIS",ds.getDataStructureComponents().getDimensionList().getDimensions().get(3).getLocalRepresentation().getEnumeration().getRef().getAgencyId().toString());
        assertEquals("CL_BIS_IF_REF_AREA",ds.getDataStructureComponents().getDimensionList().getDimensions().get(3).getLocalRepresentation().getEnumeration().getRef().getId().toString());
        assertEquals("1.0",ds.getDataStructureComponents().getDimensionList().getDimensions().get(3).getLocalRepresentation().getEnumeration().getRef().getVersion().toString());

    }
   @Test
   public void testsABSStructures() {
        InputStream in1 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/8nrpver5-structure.xml");
        StructureType doc1 = null;
        try {
            doc1 = SdmxIO.parseStructure(in1);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        assertNotNull(doc1);
        InputStream in2 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/alc-structure.xml");
        StructureType doc2 = null;
        try {
            doc2 = SdmxIO.parseStructure(in2);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc2);        
        InputStream in3 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/ba_gccsa-structure.xml");
        StructureType doc3 = null;
        try {
            doc3 = SdmxIO.parseStructure(in3);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc3);
        InputStream in4 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/ba_sa2-structure.xml");
        StructureType doc4 = null;
        try {
            doc4 = SdmxIO.parseStructure(in4);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc4);
        InputStream in5 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/bop-structure.xml");
        StructureType doc5 = null;
        try {
            doc5 = SdmxIO.parseStructure(in5);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc5);
        InputStream in6 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/capex-structure.xml");
        StructureType doc6 = null;
        try {
            doc6 = SdmxIO.parseStructure(in6);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc6);
        InputStream in7 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/cpi-structure.xml");
        StructureType doc7 = null;
        try {
            doc7 = SdmxIO.parseStructure(in7);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc7);
        InputStream in8 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/hf_structure.xml");
        StructureType doc8 = null;
        try {
            doc8 = SdmxIO.parseStructure(in8);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc8);
        InputStream in9 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/house_price_indexes-structure.xml");
        StructureType doc9 = null;
        try {
            doc9 = SdmxIO.parseStructure(in9);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc9);
        InputStream in10 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/ias_2-structure.xml");
        StructureType doc10 = null;
        try {
            doc10 = SdmxIO.parseStructure(in10);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc10);
        InputStream in11 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/ias_3-structure.xml");
        StructureType doc11 = null;
        try {
            doc11 = SdmxIO.parseStructure(in11);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc11);
        InputStream in12 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/ias_3-structure.xml");
        StructureType doc12 = null;
        try {
            doc12 = SdmxIO.parseStructure(in12);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc12);
        InputStream in13 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/ias_4-structure.xml");
        StructureType doc13 = null;
        try {
            doc13 = SdmxIO.parseStructure(in13);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc13);
        InputStream in14 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/ias_5-structure.xml");
        StructureType doc14 = null;
        try {
            doc14 = SdmxIO.parseStructure(in14);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc14);
        InputStream in15 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/iip_dsid5671-structure.xml");
        StructureType doc15 = null;
        try {
            doc15 = SdmxIO.parseStructure(in15);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc15);
        InputStream in16 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/itpi_export-structure.xml");
        StructureType doc16 = null;
        try {
            doc16 = SdmxIO.parseStructure(in16);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc16);
        InputStream in17 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/itpi_import-structure.xml");
        StructureType doc17 = null;
        try {
            doc17 = SdmxIO.parseStructure(in17);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc17);
        InputStream in18 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/labour_price_index-structure.xml");
        StructureType doc18 = null;
        try {
            doc18 = SdmxIO.parseStructure(in18);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc18);
        InputStream in19 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/lf-structure.xml");
        StructureType doc19 = null;
        try {
            doc19 = SdmxIO.parseStructure(in19);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc19);
        InputStream in20 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/merch_exp-structure.xml");
        StructureType doc20 = null;
        try {
            doc20 = SdmxIO.parseStructure(in20);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc20);
        InputStream in21 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/merch_imp-structure.xml");
        StructureType doc21 = null;
        try {
            doc21 = SdmxIO.parseStructure(in21);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc21); 
        InputStream in22 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/newmvsales-structure.xml");
        StructureType doc22 = null;
        try {
            doc22 = SdmxIO.parseStructure(in22);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc22);
        InputStream in23 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/nrplga8-structure.xml");
        StructureType doc23 = null;
        try {
            doc23 = SdmxIO.parseStructure(in23);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(doc23);
   }
}

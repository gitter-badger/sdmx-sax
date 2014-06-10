/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointone;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sdmx.common.Name;
import sdmx.commonreferences.CategoryReferenceType;
import sdmx.commonreferences.ObjectReferenceType;
import sdmx.commonreferences.VersionType;
import sdmx.message.BaseHeaderType;
import sdmx.message.StructureType;
import sdmx.structure.CodelistsType;
import sdmx.structure.ConceptsType;
import sdmx.structure.categorisation.CategorisationType;
import sdmx.structure.category.CategorySchemeType;
import sdmx.structure.category.CategoryType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.dataflow.DataflowType;
import sdmx.structure.datastructure.AttributeType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structure.datastructure.DimensionListType;
import sdmx.structure.datastructure.DimensionType;
import sdmx.SdmxIO;
import sdmx.exception.ParseException;
import sdmx.version.twopointzero.Sdmx20StructureParserTest;

/**
 *
 * @author James
 */
/**
 * This file is part of SdmxSax.
 *
 * SdmxSax is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * SdmxSax is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * SdmxSax. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright James Gardner 2014
 */
public class Sdmx21StructureParserTest {

    public Sdmx21StructureParserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    StructureType doc1 = null;
    StructureType doc2 = null;

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
    }

    @After
    public void tearDown() {
        doc1 = null;
        doc2 = null;
    }

    @Test
    public void testHeader1() {
        BaseHeaderType header = doc1.getHeader();
        assertEquals(header.getId().toString(), "DEMOGRAPHY");
    }

    @Test
    public void testHeader2() {
        BaseHeaderType header = doc1.getHeader();
        assertFalse(header.getTest());
    }

    @Test
    public void testHeader3() {
        BaseHeaderType header = doc1.getHeader();
        Calendar c = Calendar.getInstance();
        c.setTime(header.getPrepared().getDate().getDate());
        assertEquals(c.get(Calendar.YEAR), 2010);
        assertEquals(c.get(Calendar.MONTH), 10);
        assertEquals(c.get(Calendar.DATE), 13);
        assertEquals(c.get(Calendar.HOUR), 8);
        assertEquals(c.get(Calendar.MINUTE), 0);
        assertEquals(c.get(Calendar.SECOND), 33);
        assertEquals(c.get(Calendar.ZONE_OFFSET), 28800000);
    }

    @Test
    public void testHeader4() {
        BaseHeaderType header = doc1.getHeader();
        assertEquals(header.getSender().getId().toString(), "ESTAT");
    }

    @Test
    public void testHeader5() {
        BaseHeaderType header = doc2.getHeader();
        assertEquals(header.getId().toString(), "ESMS");
    }

    @Test
    public void testHeader6() {
        BaseHeaderType header = doc2.getHeader();
        assertFalse(header.getTest());
    }

    @Test
    public void testHeader7() {
        BaseHeaderType header = doc2.getHeader();
        Calendar c = Calendar.getInstance();
        c.setTime(header.getPrepared().getDate().getDate());
        assertEquals(c.get(Calendar.YEAR), 2010);
        assertEquals(c.get(Calendar.MONTH), 10);
        assertEquals(c.get(Calendar.DATE), 13);
        assertEquals(c.get(Calendar.HOUR), 8);
        assertEquals(c.get(Calendar.MINUTE), 0);
        assertEquals(c.get(Calendar.SECOND), 33);
        assertEquals(c.get(Calendar.ZONE_OFFSET), 28800000);

    }

    @Test
    public void testHeader8() {
        BaseHeaderType header = doc2.getHeader();
        assertEquals(header.getSender().getId().toString(), "ESTAT");
    }

    /**
     * Test of getVersionIdentifier method, of class
     * Sdmx21StructureParserProvider.
     */
    @Test
    public void testCodelists1() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("SDMX", "CL_DECIMALS", "1.0");
        assertTrue(cl.isExternalReference());
    }

    @Test
    public void testCodelists2() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("SDMX", "CL_DECIMALS", "1.0");
        assertEquals("../common/common.xml", cl.getExternalReferences().getStructureURL());
    }

    @Test
    public void testCodelists3() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("SDMX", "CL_FREQ", "1.0");
        assertEquals("../common/common.xml", cl.getExternalReferences().getStructureURL());
    }

    @Test
    public void testCodelists4() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("SDMX", "CL_FREQ", "1.0");
        assertEquals("Code list for Frequency (FREQ)", cl.findName("en").toString());
    }

    @Test
    public void testCodelists5() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("SDMX", "CL_CONF_STATUS", "1.0");
        assertEquals("../common/common.xml", cl.getExternalReferences().getStructureURL());
    }

    @Test
    public void testCodelists6() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("SDMX", "CL_CONF_STATUS", "1.0");
        // Dont ask me why all these linefeeeds an tabs are doing here...
        assertEquals("\n					code list for Confidentiality Status (CONF_STATUS)\n\t\t\t\t", cl.findName("en").toString());
    }

    @Test
    public void testCodelists7() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("SDMX", "CL_OBS_STATUS", "1.0");
        assertEquals("../common/common.xml", cl.getExternalReferences().getStructureURL());
    }

    @Test
    public void testCodelists8() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("SDMX", "CL_OBS_STATUS", "1.0");
        assertEquals("Observation status", cl.findName("en").toString());
    }

    @Test
    public void testCodelists9() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("SDMX", "CL_UNIT_MULT", "1.0");
        assertEquals("../common/common.xml", cl.getExternalReferences().getStructureURL());
    }

    @Test
    public void testCodelists10() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("SDMX", "CL_UNIT_MULT", "1.0");
        // Dont ask me why all these linefeeeds an tabs are doing here...
        assertEquals("\n					code list for the Unit Multiplier (UNIT_MULT)\n\t\t\t\t", cl.findName("en").toString());
    }

    @Test
    public void testCodelists11() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("ESTAT", "CL_UNIT", "1.0");
        assertTrue(cl.isPartial());
    }

    @Test
    public void testCodelists12() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("ESTAT", "CL_UNIT", "1.0");
        assertEquals("Unit code list", cl.findName("en").toString());
    }

    @Test
    public void testCodelists13() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("ESTAT", "CL_UNIT", "1.0");
        assertEquals("Persons", cl.findCode("PERS").findName("en").toString());
    }

    @Test
    public void testCodelists14() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("ESTAT", "CL_UNIT", "1.0");
        assertEquals("Children per woman (fertility rate)", cl.findCode("CPW").findName("en").toString());
    }

    @Test
    public void testCodelists15() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("ESTAT", "CL_UNIT", "1.0");
        assertEquals("Years", cl.findCode("YRS").findName("en").toString());
    }

    @Test
    public void testCodelists16() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("ESTAT", "CL_SEX", "1.0");
        assertFalse(cl.isPartial());
    }

    @Test
    public void testCodelists17() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("ESTAT", "CL_SEX", "1.0");
        assertEquals("Sex codelist", cl.findName("en").toString());
    }

    @Test
    public void testCodelists18() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("ESTAT", "CL_SEX", "1.0");
        assertEquals("Female", cl.findCode("F").findName("en").toString());
    }

    @Test
    public void testCodelists19() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("ESTAT", "CL_SEX", "1.0");
        assertEquals("Male", cl.findCode("M").findName("en").toString());
    }

    @Test
    public void testCodelists20() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("ESTAT", "CL_SEX", "1.0");
        assertEquals("Total", cl.findCode("T").findName("en").toString());
    }

    @Test
    public void testCodelists21() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("ESTAT", "CL_COUNTRY", "1.0");
        assertTrue(cl.isPartial());
    }

    @Test
    public void testCodelists22() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("ESTAT", "CL_COUNTRY", "1.0");
        assertEquals("Country Codelist", cl.findName("en").toString());
    }

    @Test
    public void testCodelists23() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("ESTAT", "CL_COUNTRY", "1.0");
        assertEquals("Belgium", cl.findCode("BE").findName("en").toString());
    }

    @Test
    public void testCodelists24() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("ESTAT", "CL_COUNTRY", "1.0");
        assertEquals("Greece", cl.findCode("EL").findName("en").toString());
    }

    @Test
    public void testCodelists25() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("ESTAT", "CL_COUNTRY", "1.0");
        assertEquals("Luxembourg", cl.findCode("LU").findName("en").toString());
    }

    @Test
    public void testCodelists26() {
        CodelistsType cls = doc1.getStructures().getCodelists();
        CodelistType cl = cls.findCodelist("ESTAT", "CL_COUNTRY", "1.0");
        assertEquals("United Kingdom", cl.findCode("UK").findName("en").toString());
    }

    @Test
    public void testConcepts1() {
        ConceptsType css = doc1.getStructures().getConcepts();
        ConceptSchemeType cs = css.findConceptScheme("SDMX", "CROSS_DOMAIN_CONCEPTS", "1.0");
        assertEquals("SDMX Cross Domain Concept Scheme", cs.findName("en").toString());
    }    
    @Test
    public void testConcepts2() {
        ConceptsType css = doc1.getStructures().getConcepts();
        ConceptSchemeType cs = css.findConceptScheme("SDMX", "CROSS_DOMAIN_CONCEPTS", "1.0");
        assertTrue(cs.isExternalReference());
    }
    @Test
    public void testConcepts3() {
        ConceptsType css = doc1.getStructures().getConcepts();
        ConceptSchemeType cs = css.findConceptScheme("SDMX", "CROSS_DOMAIN_CONCEPTS", "1.0");
        assertEquals("../common/common.xml", cs.getExternalReferences().getStructureURL());
    }
    
    @Test
    public void testConcepts4() {
        ConceptsType css = doc1.getStructures().getConcepts();
        ConceptSchemeType cs = css.findConceptScheme("ESTAT", "DEMO_CONCEPTS", "1.0");
        assertEquals("Demography domain concept scheme", cs.findName("en").toString());
        assertFalse(cs.isFinal());
        assertFalse(cs.isPartial());
        assertEquals("Reporting Country", cs.findConcept("COUNTRY").findName("en").toString());
        assertEquals("Sex", cs.findConcept("SEX").findName("en").toString());
        assertEquals("Demography", cs.findConcept("DEMO").findName("en").toString());
    }
    @Test
    public void testConcepts5() {
        ConceptsType css = doc1.getStructures().getConcepts();
        ConceptSchemeType cs = css.findConceptScheme("ESTAT", "DEMO_MEASURES", "1.0");
        assertEquals("Demography measures concept scheme", cs.findName("en").toString());
        assertFalse(cs.isFinal());
        assertFalse(cs.isPartial());
        assertEquals("Population on 1 January of Year X", cs.findConcept("PJANT").findName("en").toString());
        assertEquals("Integer", cs.findConcept("PJANT").getCoreRepresentation().getTextFormat().getTextType().toString());
        assertEquals(0d, cs.findConcept("PJANT").getCoreRepresentation().getTextFormat().getMinValue(), 0d);
        assertEquals("Births in Year X", cs.findConcept("LBIRTHST").findName("en").toString());
        assertEquals("Integer", cs.findConcept("LBIRTHST").getCoreRepresentation().getTextFormat().getTextType().toString());
        assertEquals(0d, cs.findConcept("LBIRTHST").getCoreRepresentation().getTextFormat().getMinValue(), 0d);

        assertEquals("Deaths in Year X", cs.findConcept("DEATHST").findName("en").toString());
        assertEquals("Integer", cs.findConcept("DEATHST").getCoreRepresentation().getTextFormat().getTextType().toString());
        assertEquals(0d, cs.findConcept("DEATHST").getCoreRepresentation().getTextFormat().getMinValue(), 0d);

        assertEquals("Statistical adjustment in Year X", cs.findConcept("ADJT").findName("en").toString());
        assertEquals("Integer", cs.findConcept("ADJT").getCoreRepresentation().getTextFormat().getTextType().toString());
        assertNull(cs.findConcept("ADJT").getCoreRepresentation().getTextFormat().getMinValue());

        assertEquals("Population on 1 January Year X+1", cs.findConcept("PJAN1T").findName("en").toString());
        assertEquals("Integer", cs.findConcept("PJAN1T").getCoreRepresentation().getTextFormat().getTextType().toString());
        assertEquals(0d, cs.findConcept("PJAN1T").getCoreRepresentation().getTextFormat().getMinValue(), 0d);

        assertEquals("Births outside marriage in Year X", cs.findConcept("LBIRTHOUT").findName("en").toString());
        assertEquals("Integer", cs.findConcept("LBIRTHOUT").getCoreRepresentation().getTextFormat().getTextType().toString());
        assertEquals(0d, cs.findConcept("LBIRTHOUT").getCoreRepresentation().getTextFormat().getMinValue(), 0d);

        assertEquals("Deaths under 1 year in Year X", cs.findConcept("DEATHUN1").findName("en").toString());
        assertEquals("Integer", cs.findConcept("DEATHUN1").getCoreRepresentation().getTextFormat().getTextType().toString());
        assertEquals(0d, cs.findConcept("DEATHUN1").getCoreRepresentation().getTextFormat().getMinValue(), 0d);

        assertEquals("Marriages in Year X", cs.findConcept("MAR").findName("en").toString());
        assertEquals("Integer", cs.findConcept("MAR").getCoreRepresentation().getTextFormat().getTextType().toString());
        assertEquals(0d, cs.findConcept("MAR").getCoreRepresentation().getTextFormat().getMinValue(), 0d);

        assertEquals("Divorces in Year X", cs.findConcept("DIV").findName("en").toString());
        assertEquals("Integer", cs.findConcept("DIV").getCoreRepresentation().getTextFormat().getTextType().toString());
        assertEquals(0d, cs.findConcept("DIV").getCoreRepresentation().getTextFormat().getMinValue(), 0d);

        assertEquals("Immigrants in Year X", cs.findConcept("IMMIT").findName("en").toString());
        assertEquals("Integer", cs.findConcept("IMMIT").getCoreRepresentation().getTextFormat().getTextType().toString());
        assertEquals(0d, cs.findConcept("IMMIT").getCoreRepresentation().getTextFormat().getMinValue(), 0d);

        assertEquals("Emigrants in Year X", cs.findConcept("EMIGT").findName("en").toString());
        assertEquals("Integer", cs.findConcept("EMIGT").getCoreRepresentation().getTextFormat().getTextType().toString());
        assertEquals(0d, cs.findConcept("EMIGT").getCoreRepresentation().getTextFormat().getMinValue(), 0d);

        assertEquals("Net migration in Year X", cs.findConcept("NETMT").findName("en").toString());
        assertEquals("Integer", cs.findConcept("NETMT").getCoreRepresentation().getTextFormat().getTextType().toString());
        assertNull(cs.findConcept("NETMT").getCoreRepresentation().getTextFormat().getMinValue());

        assertEquals("Total fertility rate in Year X", cs.findConcept("TFRNSI").findName("en").toString());
        assertEquals("Decimal", cs.findConcept("TFRNSI").getCoreRepresentation().getTextFormat().getTextType().toString());
        assertEquals(2, cs.findConcept("TFRNSI").getCoreRepresentation().getTextFormat().getDecimals().getValue(), 0);

        assertEquals("Life expectancy at birth in Year X", cs.findConcept("LEXPNSIT").findName("en").toString());
        assertEquals("Decimal", cs.findConcept("LEXPNSIT").getCoreRepresentation().getTextFormat().getTextType().toString());
        assertEquals(1, cs.findConcept("LEXPNSIT").getCoreRepresentation().getTextFormat().getDecimals().getValue(), 0);

    }

    @Test
    public void testDataStructure1() {
        DataStructureType ds = doc1.getStructures().getDataStructures().findDataStructure("ESTAT", "DEMOGRAPHY", "1.0");
        assertEquals("ESTAT", ds.getAgencyID().toString());
        assertEquals("DEMOGRAPHY", ds.getId().toString());
        assertEquals("1.0", ds.getVersion().toString());
        DimensionListType dlt = ds.getDataStructureComponents().getDimensionList();
        System.out.println("Test=" + dlt.getDimension(0).getConceptIdentity().getRef().getAgencyId());
        assertEquals("SDMX", dlt.getDimensions().get(0).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("CROSS_DOMAIN_CONCEPTS", dlt.getDimensions().get(0).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", dlt.getDimensions().get(0).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("FREQ", dlt.getDimensions().get(0).getConceptIdentity().getRef().getId().toString());

        assertEquals("ESTAT", dlt.getDimensions().get(1).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("DEMO_CONCEPTS", dlt.getDimensions().get(1).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", dlt.getDimensions().get(1).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("COUNTRY", dlt.getDimensions().get(1).getConceptIdentity().getRef().getId().toString());
        assertEquals("ESTAT", dlt.getDimensions().get(1).getLocalRepresentation().getEnumeration().getRef().getAgencyId().toString());

        assertEquals("CL_COUNTRY", dlt.getDimensions().get(1).getLocalRepresentation().getEnumeration().getRef().getId().toString());
        assertEquals("1.0", dlt.getDimensions().get(1).getLocalRepresentation().getEnumeration().getRef().getVersion().toString());

        assertEquals("ESTAT", dlt.getDimensions().get(2).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("DEMO_CONCEPTS", dlt.getDimensions().get(2).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", dlt.getDimensions().get(2).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("SEX", dlt.getDimensions().get(2).getConceptIdentity().getRef().getId().toString());
        assertEquals("ESTAT", dlt.getDimensions().get(2).getLocalRepresentation().getEnumeration().getRef().getAgencyId().toString());
        assertEquals("CL_SEX", dlt.getDimensions().get(2).getLocalRepresentation().getEnumeration().getRef().getId().toString());
        assertEquals("1.0", dlt.getDimensions().get(2).getLocalRepresentation().getEnumeration().getRef().getVersion().toString());

        assertEquals("ESTAT", ds.getDataStructureComponents().getMeasureList().getMeasure(0).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("DEMO_CONCEPTS", ds.getDataStructureComponents().getMeasureList().getMeasure(0).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", ds.getDataStructureComponents().getMeasureList().getMeasure(0).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("DEMO", ds.getDataStructureComponents().getMeasureList().getMeasure(0).getConceptIdentity().getRef().getId().toString());
        assertEquals("ESTAT", ds.getDataStructureComponents().getMeasureList().getMeasure(0).getLocalRepresentation().getEnumeration().getRef().getAgencyId().toString());
        assertEquals("DEMO_MEASURES", ds.getDataStructureComponents().getMeasureList().getMeasure(0).getLocalRepresentation().getEnumeration().getRef().getId().toString());
        assertEquals("1.0", ds.getDataStructureComponents().getMeasureList().getMeasure(0).getLocalRepresentation().getEnumeration().getRef().getVersion().toString());
        assertEquals("ConceptScheme", ds.getDataStructureComponents().getMeasureList().getMeasure(0).getLocalRepresentation().getEnumeration().getRef().getRefClass().toString());
        List<AttributeType> atts = ds.getDataStructureComponents().getAttributeList().getAttributes();
        assertEquals("Mandatory", atts.get(0).getAssignmentStatus().toString());

        assertEquals("OBS_STATUS", atts.get(3).getId().toString());
        assertEquals("SDMX", atts.get(0).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("CROSS_DOMAIN_CONCEPTS", atts.get(0).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("SDMX", atts.get(0).getLocalRepresentation().getEnumeration().getRef().getAgencyId().toString());
        assertEquals("CL_DECIMALS", atts.get(0).getLocalRepresentation().getEnumeration().getRef().getId().toString());
        assertEquals("1.0", atts.get(0).getLocalRepresentation().getEnumeration().getRef().getVersion().toString());
        assertEquals("DEMO", atts.get(0).getRelationshipType().getDimensions().get(0).getRef().getId().toString());
        assertEquals("Mandatory", atts.get(1).getAssignmentStatus().toString());
        assertEquals("SDMX", atts.get(1).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("CROSS_DOMAIN_CONCEPTS", atts.get(1).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", atts.get(1).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("UNIT_MEASURE", atts.get(1).getConceptIdentity().getRef().getId().toString());
        assertEquals("CL_UNIT", atts.get(1).getLocalRepresentation().getEnumeration().getRef().getId().toString());
        assertEquals("ESTAT", atts.get(1).getLocalRepresentation().getEnumeration().getRef().getAgencyId().toString());
        assertEquals("1.0", atts.get(1).getLocalRepresentation().getEnumeration().getRef().getVersion().toString());

        assertEquals("Mandatory", atts.get(2).getAssignmentStatus().toString());
        assertEquals("UNIT_MULT", atts.get(2).getId().toString());

        assertEquals("SDMX", atts.get(2).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("CROSS_DOMAIN_CONCEPTS", atts.get(2).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", atts.get(2).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("UNIT_MULT", atts.get(2).getConceptIdentity().getRef().getId().toString());
        assertEquals("SDMX", atts.get(2).getLocalRepresentation().getEnumeration().getRef().getAgencyId().toString());
        assertEquals("1.0", atts.get(2).getLocalRepresentation().getEnumeration().getRef().getVersion().toString());
        assertEquals("CL_UNIT_MULT", atts.get(2).getLocalRepresentation().getEnumeration().getRef().getId().toString());
        assertEquals("DEMO", atts.get(2).getRelationshipType().getDimensions().get(0).getRef().getId().toString());

        assertEquals("Mandatory", atts.get(3).getAssignmentStatus().toString());
        assertEquals("OBS_STATUS", atts.get(3).getId().toString());
        assertEquals("SDMX", atts.get(3).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("CROSS_DOMAIN_CONCEPTS", atts.get(3).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", atts.get(3).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("OBS_STATUS", atts.get(3).getConceptIdentity().getRef().getId().toString());
        assertEquals("OBS_VALUE", atts.get(3).getRelationshipType().getPrimaryMeasure().getRef().getId().toString());

        assertEquals("OBS_VALUE", ds.getDataStructureComponents().getMeasureList().getPrimaryMeasure().getConceptIdentity().getRef().getId().toString());
        assertEquals("SDMX", ds.getDataStructureComponents().getMeasureList().getPrimaryMeasure().getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("CROSS_DOMAIN_CONCEPTS", ds.getDataStructureComponents().getMeasureList().getPrimaryMeasure().getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", ds.getDataStructureComponents().getMeasureList().getPrimaryMeasure().getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("Decimal", ds.getDataStructureComponents().getMeasureList().getPrimaryMeasure().getLocalRepresentation().getTextFormat().getTextType().toString());
    }

    @Test
    public void testParse2() {
        CategorisationType ct = doc2.getStructures().getCategorisations().findCategorisation("ESTAT", "DEMO_TOT", "1.0");
        assertNull(doc2.getStructures().getCategorisations().findCategorisation("TEST", "TEST", "1.0"));
        assertNotNull(ct);
        ObjectReferenceType source = ct.getSource();
        assertEquals("ESTAT", source.getRef().getAgencyId().toString());
        assertEquals("DEMO_TOT", source.getRef().getId().toString());
        assertEquals("1.0", source.getRef().getVersion().toString());
        assertEquals("Dataflow", source.getRef().getRefClass().toString());
        assertEquals("datastructure", source.getRef().getPack().toString());
        assertNotNull(source);
        CategoryReferenceType crt = ct.getTarget();
        assertEquals("ESTAT", crt.getRef().getAgencyId().toString());
        assertEquals("DATAFLOWS_SCHEME", crt.getRef().getMaintainableParentId().toString());
        assertEquals("1.0", crt.getRef().getMaintainableParentVersion().toString());
        assertEquals("PSC.DEM.TOT", crt.getRef().getId().toString());

        assertNotNull(crt);
        DataflowType df = doc2.getStructures().getDataflows().findDataflow("ESTAT", "DEMO_TOT", "1.0");
        assertNotNull(df);
        assertEquals("ESTAT", df.getStructure().getRef().getAgencyId().toString());
        assertEquals("DEMOGRAPHY", df.getStructure().getRef().getId().toString());
        assertEquals("1.0", df.getStructure().getRef().getVersion().toString());
        Name name = df.findName("en");
        assertEquals("Demography totals", name.getText());
        CategorySchemeType scheme = doc2.getStructures().getCategorySchemes().findCategoryScheme("ESTAT", "DATAFLOWS_SCHEME", "1.0");
        assertEquals("ESTAT Dataflows Category Scheme", scheme.findName("en").toString());
        assertNotNull(scheme);
        assertNotNull(scheme.findCategory("TOT"));
        assertEquals("Total population and demographic events", scheme.findCategory("TOT").findName("en").toString());
        assertNotNull(scheme.findCategory("POP"));
        assertEquals("Population", scheme.findCategory("POP").findName("en").toString());
        assertNotNull(scheme.findCategory("FERT"));
        assertEquals("Fertility", scheme.findCategory("FERT").findName("en").toString());
        assertNotNull(scheme.findCategory("MORT"));
        assertEquals("Mortality", scheme.findCategory("MORT").findName("en").toString());
        assertNotNull(scheme.findCategory("MARR"));
        assertEquals("Marriage and divorce", scheme.findCategory("MARR").findName("en").toString());
        assertNotNull(scheme.findCategory("DEM"));
        assertEquals("Demography", scheme.findCategory("DEM").findName("en").toString());
        assertNotNull(scheme.findCategory("PSC"));
        assertEquals("Population and social conditions", scheme.findCategory("PSC").findName("en").toString());
        CodelistType cl_country = doc2.getStructures().getCodelists().findCodelist("ESTAT", "CL_COUNTRY", "1.0");
        assertNull(cl_country.getExternalReferences());
        assertNotNull(cl_country);
        assertNotNull(cl_country.findCode("BE"));
        assertNotNull(cl_country.findCode("BE").findName("en"));
        assertEquals("Country Codelist", cl_country.findName("en").toString());
        assertEquals("Belgium", cl_country.findCode("BE").findName("en").toString());
        assertEquals("Luxembourg", cl_country.findCode("LU").findName("en").toString());
        assertTrue(cl_country.isPartial());
        ConceptSchemeType cs = doc2.getStructures().getConcepts().findConceptScheme("ESTAT", "ESMS_CONCEPTS", "1.0");
        assertNull(cs.getExternalReferences());
        assertEquals("Address Country", cs.findConcept("ADDRESS").findConcept("ADDRESS_COUNTRY").findName("en").toString());
        assertEquals("Address City", cs.findConcept("ADDRESS").findConcept("ADDRESS_CITY").findName("en").toString());
        assertEquals("Address Street", cs.findConcept("ADDRESS").findConcept("ADDRESS_STREET").findName("en").toString());
        assertEquals("Address Postal Code", cs.findConcept("ADDRESS").findConcept("ADDRESS_POST_CODE").findName("en").toString());
        assertEquals("Comment", cs.findConcept("COMMENT").findName("en").toString());
        assertEquals("Contact", cs.findConcept("CONTACT").findName("en").toString());
        assertEquals("Contact email address", cs.findConcept("CONTACT").findConcept("CONTACT_EMAIL").findName("en").toString());
        assertEquals("Contact name", cs.findConcept("CONTACT").findConcept("CONTACT_NAME").findName("en").toString());
        assertEquals("Contact phone number", cs.findConcept("CONTACT").findConcept("CONTACT_PHONE").findName("en").toString());
        assertEquals("Data description", cs.findConcept("DATA_DESCR").findName("en").toString());
        assertEquals("Metadata last ceritfied", cs.findConcept("META_UPDATE").findConcept("META_CERTIFIED").findName("en").toString());
        assertEquals("Metadata last update", cs.findConcept("META_UPDATE").findConcept("META_LAST_UPDATE").findName("en").toString());
        assertEquals("Metadata last posted", cs.findConcept("META_UPDATE").findConcept("META_POSTED").findName("en").toString());
        assertEquals("Metadata Update", cs.findConcept("META_UPDATE").findName("en").toString());
        assertEquals("Next Date", cs.findConcept("NEXT_DATE").findName("en").toString());
        assertEquals("Organisation", cs.findConcept("ORGANISATION").findName("en").toString());
        assertEquals("Organisation unit", cs.findConcept("ORGANISATION").findConcept("ORGANISATION_UNIT").findName("en").toString());
        assertEquals("Statistical presentation", cs.findConcept("STAT_PRES").findName("en").toString());

        assertEquals("ESMS_SIMPLE", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getId().toString());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getAgencyID().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getVersion().toString());
        assertEquals("Simple Eurostat SDMX Metadata Structure", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).findName("en").toString());
        assertEquals("Simplified version of the Eurostat SDMX Metadata Structure", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).findDescription("en").toString());
        assertEquals("CATEGORY_TARGET", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(0).getId().toString());
//            doc.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(0).getReportPeriodTarget().get(0).getLocalRepresentation();
        assertEquals("ObservationalTimePeriod", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(0).getReportPeriodTarget().get(0).getLocalRepresentation().getTextFormat().getTextType().toString());
        assertEquals("DATA_PROVIDER", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(0).getIdentifiableObjectTarget().get(0).getId().toString());
        assertEquals("DataProvider", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(0).getIdentifiableObjectTarget().get(0).getObjectType().toString());
        assertEquals("IdentifiableReference", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(0).getIdentifiableObjectTarget().get(0).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("CATEGORY", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(0).getIdentifiableObjectTarget().get(1).getId().toString());
        assertEquals("Category", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(0).getIdentifiableObjectTarget().get(1).getObjectType().toString());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(0).getIdentifiableObjectTarget().get(1).getLocalRepresentation().getEnumeration().getRef().getAgencyId().toString());
        assertEquals("DATAFLOWS_SCHEME", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(0).getIdentifiableObjectTarget().get(1).getLocalRepresentation().getEnumeration().getRef().getId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(0).getIdentifiableObjectTarget().get(1).getLocalRepresentation().getEnumeration().getRef().getVersion().toString());
        assertEquals("CategoryScheme", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(0).getIdentifiableObjectTarget().get(1).getLocalRepresentation().getEnumeration().getRef().getRefClass().toString());
        assertEquals("categoryscheme", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(0).getIdentifiableObjectTarget().get(1).getLocalRepresentation().getEnumeration().getRef().getPack().toString());

        assertEquals("DATAFLOW_TARGET", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(1).getId().toString());
        assertEquals("ObservationalTimePeriod", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(1).getReportPeriodTarget().get(0).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("DATA_PROVIDER", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(1).getIdentifiableObjectTarget().get(0).getId().toString());
        assertEquals("DataProvider", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(1).getIdentifiableObjectTarget().get(0).getObjectType().toString());
        assertEquals("IdentifiableReference", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(1).getIdentifiableObjectTarget().get(0).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("DATA_FLOW", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(1).getIdentifiableObjectTarget().get(1).getId().toString());
        assertEquals("Dataflow", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(1).getIdentifiableObjectTarget().get(1).getObjectType().toString());
        assertEquals("IdentifiableReference", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getTargets().get(1).getIdentifiableObjectTarget().get(1).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("ESMS_SIMPLE_REPORT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getId().toString());
        assertEquals("CONTACT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getId().toString());
        assertTrue(doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).isPresentational());

        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("CONTACT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getConceptIdentity().getRef().getId().toString());

        assertEquals("ORGANISATION", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(0).getId().toString());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(0).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("ORGANISATION", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(0).getConceptIdentity().getRef().getId().toString());
        assertEquals("String", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(0).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("ORGANISATION_UNIT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(1).getId().toString());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(1).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(1).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(1).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("ORGANISATION_UNIT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(1).getConceptIdentity().getRef().getId().toString());
        assertEquals("String", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(1).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("NAME", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(2).getId().toString());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(2).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(2).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(2).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("CONTACT_NAME", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(2).getConceptIdentity().getRef().getId().toString());
        assertEquals("String", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(2).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("ADDRESS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getId().toString());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("ADDRESS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getConceptIdentity().getRef().getId().toString());

        assertEquals("STREET", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(0).getId().toString());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(0).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("ADDRESS_STREET", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(0).getConceptIdentity().getRef().getId().toString());
        assertEquals("String", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(0).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("CITY", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(1).getId().toString());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(1).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(1).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(1).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("ADDRESS_CITY", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(1).getConceptIdentity().getRef().getId().toString());
        assertEquals("String", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(1).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("POSTAL_CODE", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(2).getId().toString());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(2).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(2).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(2).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("ADDRESS_POST_CODE", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(2).getConceptIdentity().getRef().getId().toString());
        assertEquals("String", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(2).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("COUNTRY", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(3).getId().toString());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(3).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(3).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(3).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("ADDRESS_COUNTRY", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(3).getConceptIdentity().getRef().getId().toString());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(3).getLocalRepresentation().getEnumeration().getRef().getAgencyId().toString());
        assertEquals("CL_COUNTRY", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(3).getLocalRepresentation().getEnumeration().getRef().getId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(3).getMetadataAttributes().get(3).getLocalRepresentation().getEnumeration().getRef().getVersion().toString());

        assertEquals("PHONE", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(4).getId().toString());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(4).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(4).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(4).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("CONTACT_PHONE", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(4).getConceptIdentity().getRef().getId().toString());

        assertEquals("EMAIL", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(5).getId().toString());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(5).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(5).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(5).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("CONTACT_EMAIL", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(0).getMetadataAttributes().get(5).getConceptIdentity().getRef().getId().toString());

        assertEquals("META_UPDATE", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getId().toString());
        assertTrue(doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).isPresentational());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("META_UPDATE", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getConceptIdentity().getRef().getId().toString());

        assertEquals("CERTIFIED", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(0).getId().toString());
        assertFalse(doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(0).isPresentational());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(0).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("META_CERTIFIED", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(0).getConceptIdentity().getRef().getId().toString());
        assertEquals("GregorianDay", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(0).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("POSTED", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(1).getId().toString());
        assertFalse(doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(1).isPresentational());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(1).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(1).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(1).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("META_POSTED", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(1).getConceptIdentity().getRef().getId().toString());
        assertEquals("DateTime", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(1).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("NEXT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(1).getMetadataAttributes().get(0).getId().toString());
        assertFalse(doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(1).isPresentational());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(1).getMetadataAttributes().get(0).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(1).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(1).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("NEXT_DATE", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(1).getMetadataAttributes().get(0).getConceptIdentity().getRef().getId().toString());
        assertEquals("DateTime", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(1).getMetadataAttributes().get(0).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("UPDATED", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(2).getId().toString());
        assertFalse(doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(2).isPresentational());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(2).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(2).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(2).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("META_LAST_UPDATE", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(2).getConceptIdentity().getRef().getId().toString());
        assertEquals("DateTime", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(2).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("NEXT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(2).getMetadataAttributes().get(0).getId().toString());
        assertFalse(doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(2).isPresentational());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(2).getMetadataAttributes().get(0).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(2).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(2).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("NEXT_DATE", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(2).getMetadataAttributes().get(0).getConceptIdentity().getRef().getId().toString());
        assertEquals("DateTime", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(2).getMetadataAttributes().get(0).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("STAT_PRES", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(2).getId().toString());
        assertTrue(doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(2).isPresentational());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(2).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(2).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(2).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("STAT_PRES", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(2).getConceptIdentity().getRef().getId().toString());

        assertEquals("DATA_DESCR", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(2).getMetadataAttributes().get(0).getId().toString());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(2).getMetadataAttributes().get(0).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(2).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(2).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("DATA_DESCR", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(2).getMetadataAttributes().get(0).getConceptIdentity().getRef().getId().toString());
        assertEquals("XHTML", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getMetadataAttributes().get(2).getMetadataAttributes().get(0).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("CATEGORY_TARGET", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getLocalMetadataTarget().get(0).getRef().getId().toString());
        assertEquals("DATAFLOW_TARGET", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(0).getLocalMetadataTarget().get(1).getRef().getId().toString());

        assertEquals("ESMS_UPDATE_REPORT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getId().toString());
        assertEquals("META_UPDATE", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getId().toString());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("META_UPDATE", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getConceptIdentity().getRef().getId().toString());

        assertEquals("CERTIFIED", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(0).getId().toString());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(0).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("META_CERTIFIED", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(0).getConceptIdentity().getRef().getId().toString());
        assertEquals("GregorianDay", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(0).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("POSTED", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(1).getId().toString());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(1).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(1).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(1).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("META_POSTED", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(1).getConceptIdentity().getRef().getId().toString());
        assertEquals("DateTime", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(1).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("NEXT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(0).getId().toString());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(0).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("NEXT_DATE", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(0).getConceptIdentity().getRef().getId().toString());
        assertEquals("DateTime", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(1).getMetadataAttributes().get(0).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("UPDATED", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(2).getId().toString());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(2).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(2).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(2).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("META_LAST_UPDATE", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(2).getConceptIdentity().getRef().getId().toString());
        assertEquals("DateTime", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(2).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("NEXT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(2).getMetadataAttributes().get(0).getId().toString());
        assertEquals("ESTAT", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(2).getMetadataAttributes().get(0).getConceptIdentity().getRef().getAgencyId().toString());
        assertEquals("ESMS_CONCEPTS", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(2).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentId().toString());
        assertEquals("1.0", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(2).getMetadataAttributes().get(0).getConceptIdentity().getRef().getMaintainableParentVersion().toString());
        assertEquals("NEXT_DATE", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(2).getMetadataAttributes().get(0).getConceptIdentity().getRef().getId().toString());
        assertEquals("DateTime", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getMetadataAttributes().get(0).getMetadataAttributes().get(2).getMetadataAttributes().get(0).getLocalRepresentation().getTextFormat().getTextType().toString());

        assertEquals("DATAFLOW_TARGET", doc2.getStructures().getMetadataStructures().getMetadataStructures().get(0).getReports().get(1).getLocalMetadataTarget().get(0).getRef().getId().toString());
    }
}

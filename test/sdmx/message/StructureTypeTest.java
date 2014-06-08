/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.message;

import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sdmx.commonreferences.ConceptRefType;
import sdmx.commonreferences.ConceptReferenceType;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemSchemeRefType;
import sdmx.commonreferences.ItemSchemeReferenceBaseType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.VersionType;
import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.ItemSchemeTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.structure.StructuresType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.SdmxIO;
import sdmx.version.twopointzero.Sdmx20StructureParserTest;

/**
 *
 * @author James
 */
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
public class StructureTypeTest {

    public StructureTypeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    StructureType doc = null;

    @Before
    public void setUp() {
        System.out.println("test registry interface on StructureType");
        boolean expResult = false;
        InputStream in = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/sdmx20-samples/StructureSample.xml");
        try {
            doc = SdmxIO.parseStructure(in);
        } catch (Exception ex) {
            Logger.getLogger(Sdmx20StructureParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getStructures method, of class StructureType.
     */
    @Test
    public void testGetStructures() {
        System.out.println("getStructures");
        assertNotNull(doc.getStructures());
    }

    /**
     * Test of load method, of class StructureType.
     */
    @Test
    public void testLoad() {
        System.out.println("load");
        try {
            doc.load(doc);
            fail("Successfully loaded structure into another structure!!??");
        } catch (UnsupportedOperationException uoe) {

        }
    }

    /**
     * Test of unload method, of class StructureType.
     */
    @Test
    public void testUnload() {
        System.out.println("load");
        try {
            doc.unload(doc);
            fail("Successfully unloaded structure from another structure!!??");
        } catch (UnsupportedOperationException uoe) {

        }
    }

    /**
     * Test of findDataStructure method, of class StructureType.
     */
    @Test
    public void testFindDataStructure_3args() {
        DataStructureType ds = doc.findDataStructure(new NestedNCNameIDType("BIS"), new IDType("BIS_JOINT_DEBT"), new VersionType("1.0"));
        assertNotNull(ds);
    }

    /**
     * Test of findDataStructure method, of class StructureType.
     */
    @Test
    public void testFindDataStructure_3args2() {
        DataStructureType ds = doc.findDataStructure(new NestedNCNameIDType("BIS"), new IDType("BIS_JOINT_DEBT"), null);
        assertNotNull(ds);
    }

    /**
     * Test of findDataStructure method, of class StructureType.
     */
    @Test
    public void testFindDataStructure_NestedNCNameIDType_IDType() {
        DataStructureType ds = doc.findDataStructure(new NestedNCNameIDType("BIS"), new IDType("BIS_JOINT_DEBT"));
        assertNotNull(ds);
    }

    /**
     * Test of findConceptScheme method, of class StructureType.
     */
    @Test
    public void testFindConceptScheme_NestedNCNameIDType_ConceptReferenceType() {
        ConceptRefType ref = new ConceptRefType(new IDType("STANDALONE_CONCEPT_SCHEME"), new VersionType("1.0"), new IDType("STOCKS"));
        ConceptReferenceType cref = new ConceptReferenceType(ref, null);
        ConceptSchemeType cs = doc.findConceptScheme(new NestedNCNameIDType("BIS"), cref);
        assertNotNull(cs);
    }

    /**
     * Test of findCodelist method, of class StructureType.
     */
    @Test
    public void testFindCodelist_ItemSchemeReferenceBaseType() {
        ItemSchemeRefType ref = new ItemSchemeRefType(ItemSchemeTypeCodelistType.CODELIST, ItemSchemePackageTypeCodelistType.CODELIST);
        ref.setAgencyId(new NestedNCNameIDType("BIS"));
        ref.setId(new IDType("CL_COLLECTION"));
        ref.setVersion(new VersionType("1.0"));
        ItemSchemeReferenceBaseType cref = new ItemSchemeReferenceBaseType(ref, null);
        CodelistType cl = doc.findCodelist(cref);
        assertNotNull(cl);
    }

    /**
     * Test of findCodelistById method, of class StructureType.
     */
    @Test
    public void testFindCodelistById() {
        System.out.println("findCodelistById");
        IDType id = new IDType("CL_COLLECTION");
        CodelistType cl = doc.findCodelistById(id);
        assertNotNull(cl);
    }

    /**
     * Test of findCodelist method, of class StructureType.
     */
    @Test
    public void testFindCodelist_3args_1() {
        System.out.println("findCodelist");
        NestedNCNameIDType codelistAgency = new NestedNCNameIDType("BIS");
        IDType codelist = new IDType("CL_COLLECTION");
        VersionType codelistVersion = new VersionType("1.0");
        CodelistType result = doc.findCodelist(codelistAgency, codelist, codelistVersion);
        assertNotNull(result);
    }

    /**
     * Test of findCodelist method, of class StructureType.
     */
    @Test
    public void testFindCodelist_NestedNCNameIDType_IDType() {
        System.out.println("findCodelist");
        NestedNCNameIDType codelistAgency = new NestedNCNameIDType("BIS");
        IDType codelist = new IDType("CL_COLLECTION");
        StructureType instance = new StructureType();
        CodelistType result = doc.findCodelist(codelistAgency, codelist);
        assertNotNull(result);
    }

    /**
     * Test of findCodelist method, of class StructureType.
     */
    @Test
    public void testFindCodelist_String_String() {
        System.out.println("findCodelist");
        String codelistAgency = "BIS";
        String codelist = "CL_COLLECTION";
        CodelistType result = doc.findCodelist(codelistAgency, codelist);
        assertNotNull(result);
    }

    /**
     * Test of findConceptScheme method, of class StructureType.
     */
    @Test
    public void testFindConceptScheme_NestedNCNameIDType_IDType() {
        System.out.println("findConceptScheme");
        NestedNCNameIDType csa = new NestedNCNameIDType("BIS");
        IDType csi = new IDType("STANDALONE_CONCEPT_SCHEME");
        ConceptSchemeType result = doc.findConceptScheme(csa, csi);
        assertNotNull(result);
    }

    /**
     * Test of findConceptSchemeById method, of class StructureType.
     */
    @Test
    public void testFindConceptSchemeById() {
        System.out.println("findConceptSchemeById");
        IDType id = new IDType("STANDALONE_CONCEPT_SCHEME");
        ConceptSchemeType result = doc.findConceptSchemeById(id);
        assertNotNull(id);
    }

    /**
     * Test of findConcept method, of class StructureType.
     */
    @Test
    public void testFindConcept_NestedNCNameIDType_IDType() {
        System.out.println("findConcept");
        NestedNCNameIDType agency = new NestedNCNameIDType("BIS");
        IDType id = new IDType("JD_CATEGORY");
        ConceptType result = doc.findConcept(agency, id);
        assertNotNull(result);
    }

    /**
     * Test of findConcept method, of class StructureType.
     */
    @Test
    public void testFindConcept_IDType() {
        System.out.println("findConcept");
        IDType id = new IDType("JD_CATEGORY");
        ConceptType result = doc.findConcept(id);
        assertNotNull(result);
    }

    /**
     * Test of listDataSets method, of class StructureType.
     */
    @Test
    public void testListDataSets() {
        System.out.println("listDataSets");
        try {
            assertEquals(1,doc.listDataflows().size());
        } catch (Exception ex) {
        }
    }

}

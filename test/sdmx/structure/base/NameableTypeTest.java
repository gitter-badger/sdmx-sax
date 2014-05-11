/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.structure.base;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sdmx.common.Description;
import sdmx.common.Name;

/**
 *
 * @author James
 */
public class NameableTypeTest {
    
    public NameableTypeTest() {
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
     * Test of getNames method, of class NameableType.
     */
    @Test
    public void testGetNames() {
        System.out.println("getNames");
        NameableType instance = new NameableType();
        Name name1 = new Name("en","Name");
        List<Name> names = new ArrayList<Name>();
        names.add(name1);
        instance.setNames(names);
        String expResult = "Name";
        assertEquals(expResult, instance.toString());
    }    
    @Test
    public void testGetNames2() {
        System.out.println("getNames");
        NameableType instance = new NameableType();
        Name name1 = new Name("en","Name");
        Name name2 = new Name("fr","Jaime");
        List<Name> names = new ArrayList<Name>();
        names.add(name1);
        names.add(name2);
        instance.setNames(names);
        String expResult = "Name";
        assertEquals(expResult, instance.findName("de").toString());
    }    
    @Test
    public void testGetNames3() {
        System.out.println("getNames");
        NameableType instance = new NameableType();
        Name name1 = new Name("en","Name");
        Name name2 = new Name("fr","Jaime");
        List<Name> names = new ArrayList<Name>();
        names.add(name1);
        names.add(name2);
        instance.setNames(names);
        String expResult = "Jaime";
        assertEquals(expResult, instance.findName("fr").toString());
    }    
}

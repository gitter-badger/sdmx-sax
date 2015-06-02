/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.cube;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import javax.xml.stream.XMLStreamException;
import static org.junit.Assert.*;
import org.junit.Test;
import sdmx.SdmxIO;
import sdmx.exception.ParseException;
import sdmx.message.DataMessage;
import sdmx.message.StructureType;
import sdmx.version.twopointzero.Sdmx20StructureParserTest;
import sdmx.version.twopointzero.writer.CompactDataWriter;

/**
 *
 * @author James
 */
public class CubeTest {
    
    public CubeTest() {
    }

    @Test
    public void testCompactSample2() throws IOException, XMLStreamException, ParseException {
        long t1= System.currentTimeMillis();
        InputStream in = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/sdmx20-samples/CompactSample.xml");
        InputStream in2 = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/sdmx20-samples/StructureSample.xml");
        DataMessage data = SdmxIO.parseData(in);//Flat
        StructureType struct = SdmxIO.parseStructure(in2);
        long t2 = System.currentTimeMillis();
        System.out.println("Read:"+data.getDataSets().get(0).size()+" Observations "+(t2-t1)+" ms");
        Cube cube = new Cube(struct.getStructures().getDataStructures().getDataStructures().get(0));
        cube = data.getDataSets().get(0).query(cube,null);
        long t3 = System.currentTimeMillis();
        System.out.println("Made Cube "+(t3-t2)+" ms");
        cube.getRootCubeDimension().dump();
    }
/*
    @Test
    public void testCompactSample3() throws IOException, XMLStreamException, ParseException {
        long t1= System.currentTimeMillis();
        InputStream in = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/uis-20/structure.xml");
        StructureType struct = SdmxIO.parseStructure(in);

        ZipFile zipFile = new ZipFile("./test/resources/uis-20/28b18979-129f-43bc-94ae-42f31add907a.zip");
        InputStream in2 = zipFile.getInputStream(zipFile.entries().nextElement());
        DataMessage data = SdmxIO.parseData(in2,true);//Flat
        
        long t2 = System.currentTimeMillis();
        System.out.println("Read:"+data.getDataSets().get(0).size()+" Observations "+(t2-t1)+" ms");
        Cube cube = new Cube(struct.getStructures().getDataStructures().getDataStructures().get(0));
        cube = data.getDataSets().get(0).query(cube,null);
        long t3 = System.currentTimeMillis();
        System.out.println("Made Cube "+(t3-t2)+" ms");
        //cube.getRootCubeDimension().dump();
    }
*/
}

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
import javax.xml.stream.XMLStreamException;
import org.junit.Test;
import static org.junit.Assert.*;
import sdmx.SdmxIO;
import sdmx.exception.ParseException;
import sdmx.message.DataMessage;
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
        DataMessage data = SdmxIO.parseData(in,true);//Flat
        long t2 = System.currentTimeMillis();
        System.out.println("Read:"+data.getDataSets().get(0).size()+" Observations "+(t2-t1)+" ms");
        Cube cube = data.getDataSets().get(0).query(null);
        cube.getRootCubeDimension().dump();
    }
}

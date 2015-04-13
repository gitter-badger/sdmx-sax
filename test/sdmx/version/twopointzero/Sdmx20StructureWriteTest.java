/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointzero;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;
import sdmx.SdmxIO;
import sdmx.exception.ParseException;
import sdmx.message.DataMessage;
import sdmx.message.StructureType;
import sdmx.net.LocalRegistry;
import sdmx.version.twopointzero.writer.GenericDataWriter;
import sdmx.version.twopointzero.writer.Sdmx20StructureWriter;

/**
 *
 * @author James
 */
public class Sdmx20StructureWriteTest {
    @Test
    public void testGenericSample2() throws IOException, XMLStreamException, ParseException {
        long t1= System.currentTimeMillis();
        InputStream structIn = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/DSID1230571/DSID1230571 - DataSD.xml");
        LocalRegistry reg = LocalRegistry.getDefaultWorkspace();
        StructureType struct = SdmxIO.parseStructure(reg,structIn);
        OutputStream out = new FileOutputStream("testOut/DSID1230571 - DataSD-2.0.xml");
        Sdmx20StructureWriter.write(struct, out);
        out.close();
    }
    @Test
    public void testGenericSample1() throws IOException, XMLStreamException, ParseException {
        long t1= System.currentTimeMillis();
        InputStream structIn = Sdmx20StructureParserTest.class.getResourceAsStream("/resources/abs-20/abs_census2011_t33.xml");
        LocalRegistry reg = LocalRegistry.getDefaultWorkspace();
        StructureType struct = SdmxIO.parseStructure(reg,structIn);
        OutputStream out = new FileOutputStream("testOut/abs_census2011_t33-out.xml");
        Sdmx20StructureWriter.write(struct, out);
        out.close();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.common;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PushbackInputStream;
import org.apache.commons.io.IOUtils;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author James
 */
public class SOAPStripperInputStreamTest {
    @Test
    public void testCheckVersion1() throws Exception {
        InputStream in = SOAPStripperInputStreamTest.class.getResourceAsStream("/resources/soap/soapresponse.xml");
        SOAPStrippingInputStream sin = new SOAPStrippingInputStream(in, "<GetDataStructureDefinitionResult>", "</GetDataStructureDefinitionResult>");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        IOUtils.copy(sin, baos);
        System.out.println("New Stream:"+new String(baos.toByteArray()));
    }
}

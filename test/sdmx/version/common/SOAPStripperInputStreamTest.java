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
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
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

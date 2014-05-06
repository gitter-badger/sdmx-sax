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

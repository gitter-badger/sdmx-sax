/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.json;

import sdmx.version.twopointone.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLStreamException;
import sdmx.SdmxIO;
import sdmx.message.DataMessage;
import sdmx.message.StructureType;
import sdmx.util.DataUtilities;
import sdmx.version.common.ParseParams;
import sdmx.version.common.SdmxWriterProvider;
import sdmx.version.twopointone.writer.Sdmx21StructureWriter;
import sdmx.version.twopointone.writer.StreamingStructureSpecificDataWriter;
import sdmx.version.twopointone.writer.StreamingStructureSpecificTimeSeriesWriter;
import sdmx.version.twopointzero.writer.GenericDataWriter;
import sdmx.version.twopointzero.writer.StreamingCompactDataWriter;
import sdmx.version.twopointzero.writer.StreamingGenericDataWriter;

/**
 *
 * @author James
 */
public class JSONMessageWriterProvider implements SdmxWriterProvider {

    static {
        SdmxIO.register(new JSONMessageWriterProvider());
    }

    List<String> supported = new ArrayList<String>();

    {
        //supported.add("application/vnd.sdmx.genericdata+xml;version=2.1");
        //supported.add("application/vnd.sdmx.generictimeseriesdata+xml;version=2.1");
        supported.add("application/json");
        //supported.add("application/vnd.sdmx.genericmetadata+xml;version=2.1");
        //supported.add("application/vnd.sdmx.structurespecificmetadata+xml;version=2.1");
        //supported.add("application/vnd.sdmx.structure+xml;version=2.0");
        //supported.add("application/vnd.sdmx.schema+xml;version=2.1");
    }

    @Override
    public List<String> getSupportedMIMETypes() {
        return Collections.unmodifiableList(supported);
    }

    @Override
    public void save(ParseParams params, String mime, OutputStream out, DataMessage message) {
        System.out.println("JSON Message Writer Provider");
        if ("application/json".equals(mime)) {
            try {
                JSONStatWriter.write(message, params.getDataflow(), params.getRegistry(), params.getLocale(), out);
            } catch (XMLStreamException ex) {
                Logger.getLogger(JSONMessageWriterProvider.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(JSONMessageWriterProvider.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            throw new RuntimeException(mime + " not supported by " + getClass().getName());
        }

    }

    @Override
    public void save(ParseParams params, String mime, OutputStream out, StructureType message) throws IOException {
        throw new RuntimeException(mime + " is not supported by " + getClass().getName());
    }

}
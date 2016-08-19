/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.csv;

import sdmx.version.json.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLStreamException;
import sdmx.Registry;
import sdmx.SdmxIO;
import sdmx.commonreferences.DataStructureReference;
import sdmx.message.DataMessage;
import sdmx.message.StructureType;
import sdmx.structure.dataflow.DataflowType;
import sdmx.version.common.ParseDataCallbackHandler;
import sdmx.version.common.ParseParams;
import sdmx.version.common.SdmxStreamWriterProvider;
import sdmx.version.twopointone.Sdmx21StreamWriterProvider;
import sdmx.version.twopointone.writer.StreamingGeneric21DataWriter;
import sdmx.version.twopointone.writer.StreamingStructureSpecificDataWriter;
import sdmx.version.twopointone.writer.StreamingStructureSpecificTimeSeriesWriter;

/**
 *
 * @author James
 */
public class CSVWriterProvider implements sdmx.version.common.SdmxWriterProvider {
    static{
        SdmxIO.register(new CSVWriterProvider());
    }
    List<String> supported = new ArrayList<String>();
    {
        supported.add("text/csv");
    }
    
    @Override
    public List<String> getSupportedMIMETypes() {
        return Collections.unmodifiableList(supported);
    }

    public void save(ParseParams params, String mime, OutputStream out, DataMessage message) throws IOException {
        try {
            CSVWriter.write(message,params.getRegistry(), params.getLocale(),out);
        } catch (XMLStreamException ex) {
            Logger.getLogger(CSVWriterProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void save(ParseParams params, String mime, OutputStream out, StructureType message) throws IOException {
        throw new UnsupportedOperationException();
    }
    
}

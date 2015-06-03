/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointone;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sdmx.SdmxIO;
import sdmx.message.DataMessage;
import sdmx.message.StructureType;
import sdmx.util.DataUtilities;
import sdmx.version.common.SdmxWriterProvider;
import sdmx.version.twopointone.writer.Sdmx21StructureWriter;
import sdmx.version.twopointone.writer.StreamingStructureSpecificDataWriter;
import sdmx.version.twopointone.writer.StreamingStructureSpecificTimeSeriesWriter;

/**
 *
 * @author James
 */
public class Sdmx21MessageWriterProvider implements SdmxWriterProvider {
    
    static{
        SdmxIO.register(new Sdmx21MessageWriterProvider());
    }
    
    List<String> supported = new ArrayList<String>();
    {
        //supported.add("application/vnd.sdmx.genericdata+xml;version=2.1");
        //supported.add("application/vnd.sdmx.generictimeseriesdata+xml;version=2.1");
        supported.add("application/vnd.sdmx.structurespecificdata+xml;version=2.1");
        supported.add("application/vnd.sdmx.structurespecifictimeseriesdata+xml;version=2.1");
        //supported.add("application/vnd.sdmx.genericmetadata+xml;version=2.1");
        //supported.add("application/vnd.sdmx.structurespecificmetadata+xml;version=2.1");
        supported.add("application/vnd.sdmx.structure+xml;version=2.1");
        //supported.add("application/vnd.sdmx.schema+xml;version=2.1");
    }
    @Override
    public List<String> getSupportedMIMETypes() {
        return Collections.unmodifiableList(supported);
    }

    @Override
    public void save(String mime,OutputStream out, DataMessage message) {
        if( "application/vnd.sdmx.structurespecificdata+xml;version=2.1".equals(mime)) {
            DataUtilities.writeTo(message, new StreamingStructureSpecificDataWriter(out));
        }
        else if( "application/vnd.sdmx.structurespecifictimeseriesdata+xml;version=2.1".equals(mime)) {
            DataUtilities.writeTo(message, new StreamingStructureSpecificTimeSeriesWriter(out));
        }else {
            throw new RuntimeException(mime+" not supported by "+getClass().getName());
        }

    }

    @Override
    public void save(String mime,OutputStream out, StructureType message) throws IOException {
        if("application/vnd.sdmx.structure+xml;version=2.1".equals(mime)) {
                Sdmx21StructureWriter.write(message, out);
        }else {
            throw new RuntimeException(mime+" is not supported by "+getClass().getName());
        }
    }
    
}

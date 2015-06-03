/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointone;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sdmx.Registry;
import sdmx.SdmxIO;
import static sdmx.SdmxIO.SAVE_MIME_TYPES;
import sdmx.commonreferences.DataStructureReference;
import sdmx.version.common.ParseDataCallbackHandler;
import sdmx.version.common.SdmxStreamWriterProvider;
import sdmx.version.twopointone.writer.StreamingGeneric21DataWriter;
import sdmx.version.twopointone.writer.StreamingStructureSpecificDataWriter;
import sdmx.version.twopointone.writer.StreamingStructureSpecificTimeSeriesWriter;

/**
 *
 * @author James
 */
public class Sdmx21StreamWriterProvider implements SdmxStreamWriterProvider {
    static{
        SdmxIO.register(new Sdmx21StreamWriterProvider());
    }
    List<String> supported = new ArrayList<String>();
    {
        supported.add("application/vnd.sdmx.genericdata+xml;version=2.1");
        supported.add("application/vnd.sdmx.generictimeseriesdata+xml;version=2.1");
        supported.add("application/vnd.sdmx.structurespecificdata+xml;version=2.1");
        supported.add("application/vnd.sdmx.structurespecifictimeseriesdata+xml;version=2.1");
        //supported.add("application/vnd.sdmx.genericmetadata+xml;version=2.1");
        //supported.add("application/vnd.sdmx.structurespecificmetadata+xml;version=2.1");
        //supported.add("application/vnd.sdmx.structure+xml;version=2.1");
        //supported.add("application/vnd.sdmx.schema+xml;version=2.1");

    }
    
    @Override
    public List<String> getSupportedMIMETypes() {
        return Collections.unmodifiableList(supported);
    }

    @Override
    public ParseDataCallbackHandler openForWriting(String mime, OutputStream out,Registry reg,DataStructureReference ref) {
        if("application/vnd.sdmx.genericdata+xml;version=2.1".equals(mime)){
            return new StreamingGeneric21DataWriter(out, reg, ref);
        }
        if("application/vnd.sdmx.generictimeseriesdata+xml;version=2.1".equals(mime)){
            return new StreamingGeneric21DataWriter(out, reg, ref);
        }
        if("application/vnd.sdmx.structurespecificdata+xml;version=2.1".equals(mime)){
            StreamingStructureSpecificDataWriter sssdw = new StreamingStructureSpecificDataWriter(out);
            sssdw.setDataStructureReferenceHint(ref);
            sssdw.setRegistry(reg);
            return sssdw;
        }
        if("application/vnd.sdmx.structurespecifictimeseriesdata+xml;version=2.1".equals(mime)){
            StreamingStructureSpecificTimeSeriesWriter sssdw = new StreamingStructureSpecificTimeSeriesWriter(out);
            sssdw.setDataStructureReferenceHint(ref);
            sssdw.setRegistry(reg);
            return sssdw;
        }
        throw new RuntimeException("MIME type:"+mime+" not supported by "+getClass().getName());
    }
    
}

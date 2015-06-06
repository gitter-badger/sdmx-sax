/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointzero;

import sdmx.version.twopointone.*;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sdmx.Registry;
import sdmx.SdmxIO;
import static sdmx.SdmxIO.SAVE_MIME_TYPES;
import sdmx.commonreferences.DataStructureReference;
import sdmx.structure.dataflow.DataflowType;
import sdmx.version.common.ParseDataCallbackHandler;
import sdmx.version.common.ParseParams;
import sdmx.version.common.SdmxStreamWriterProvider;
import sdmx.version.twopointone.writer.StreamingGeneric21DataWriter;
import sdmx.version.twopointone.writer.StreamingStructureSpecificDataWriter;
import sdmx.version.twopointone.writer.StreamingStructureSpecificTimeSeriesWriter;
import sdmx.version.twopointzero.writer.StreamingCompactDataWriter;
import sdmx.version.twopointzero.writer.StreamingGenericDataWriter;

/**
 *
 * @author James
 */
public class Sdmx20StreamWriterProvider implements SdmxStreamWriterProvider {
    static{
        SdmxIO.register(new Sdmx20StreamWriterProvider());
    }
    List<String> supported = new ArrayList<String>();
    {
        supported.add("application/vnd.sdmx.genericdata+xml;version=2.0");
        supported.add("application/vnd.sdmx.compactdata+xml;version=2.0");
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
    public ParseDataCallbackHandler openForWriting(String mime, OutputStream out,ParseParams params) {
        if("application/vnd.sdmx.genericdata+xml;version=2.0".equals(mime)){
            return new StreamingGenericDataWriter(out, params.getRegistry(), params.getDataflow());
        }
        if("application/vnd.sdmx.compactdata+xml;version=2.0".equals(mime)){
            StreamingCompactDataWriter sssdw = new StreamingCompactDataWriter(out);
            sssdw.setRegistry(params.getRegistry());
            sssdw.setDataflow(params.getDataflow());
            return sssdw;
        }
        throw new RuntimeException("MIME type:"+mime+" not supported by "+getClass().getName());
    }
    
}

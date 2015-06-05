/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.json;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sdmx.Registry;
import sdmx.SdmxIO;
import sdmx.commonreferences.DataStructureReference;
import sdmx.structure.dataflow.DataflowType;
import sdmx.version.common.ParseDataCallbackHandler;
import sdmx.version.common.SdmxStreamWriterProvider;
import sdmx.version.twopointone.Sdmx21StreamWriterProvider;
import sdmx.version.twopointone.writer.StreamingGeneric21DataWriter;
import sdmx.version.twopointone.writer.StreamingStructureSpecificDataWriter;
import sdmx.version.twopointone.writer.StreamingStructureSpecificTimeSeriesWriter;

/**
 *
 * @author James
 */
public class JSONStreamWriterProvider implements SdmxStreamWriterProvider {
    static{
        SdmxIO.register(new JSONStreamWriterProvider());
    }
    List<String> supported = new ArrayList<String>();
    {
        supported.add("application/vnd.sdmx.draft-sdmx-json+json;version=2.1");

    }
    
    @Override
    public List<String> getSupportedMIMETypes() {
        return Collections.unmodifiableList(supported);
    }

    @Override
    public ParseDataCallbackHandler openForWriting(String mime, OutputStream out,Registry reg,DataflowType flow) {
        if("application/vnd.sdmx.draft-sdmx-json+json;version=2.1".equals(mime)){
            StreamingSdmxJSONWriter writer = new StreamingSdmxJSONWriter(out, reg, flow);
            return writer;
        }
        throw new RuntimeException("MIME type:"+mime+" not supported by "+getClass().getName());
    }
    
}

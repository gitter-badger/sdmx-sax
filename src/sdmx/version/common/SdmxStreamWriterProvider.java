/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.common;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import sdmx.Registry;
import sdmx.commonreferences.DataStructureReference;

/**
 *
 * @author James
 */
public interface SdmxStreamWriterProvider {
    public List<String> getSupportedMIMETypes();
    public ParseDataCallbackHandler openForWriting(String mime,OutputStream out,Registry reg,DataStructureReference ref) throws IOException;
}

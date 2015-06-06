/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.common;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import sdmx.message.DataMessage;
import sdmx.message.StructureType;

/**
 *
 * @author James
 */
public interface SdmxWriterProvider {
    public List<String> getSupportedMIMETypes();
    public void save(ParseParams params,String mime,OutputStream out,DataMessage message) throws IOException;
    public void save(ParseParams params,String mime,OutputStream out,StructureType message) throws IOException;
}

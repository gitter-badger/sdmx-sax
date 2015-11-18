/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data;

import sdmx.Registry;
import sdmx.data.flat.FlatDataSetWriter;
import sdmx.data.structured.StructuredDataWriter;
import sdmx.footer.FooterType;
import sdmx.message.BaseHeaderType;
import sdmx.structure.dataflow.DataflowType;
import sdmx.version.common.ParseDataCallbackHandler;

/**
 *
 * @author James
 */
public class FlatParseDataCallbackHandler implements ParseDataCallbackHandler{

    @Override
    public void setNamespace(String prefix, String namespace) {
    }

    @Override
    public void headerParsed(BaseHeaderType header) {
    }

    @Override
    public void footerParsed(FooterType footer) {
    }

    @Override
    public DataSetWriter getDataSetWriter() {
        return new FlatDataSetWriter();
    }

    @Override
    public void documentFinished() {
    }

    @Override
    public String getDimensionAtObservationHint() {
        return null;
    }

    @Override
    public void setDimensionAtObservationHint(String s) {
    }

    @Override
    public void setDataflow(DataflowType flow) {
    }

    @Override
    public DataflowType getDataflow() {
        return null;
    }

    @Override
    public Registry getRegistry() {
        return null;
    }

    @Override
    public void setRegistry(Registry reg) {
    }
    
}

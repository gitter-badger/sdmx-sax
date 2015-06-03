/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.common;

import sdmx.Registry;
import sdmx.commonreferences.DataStructureReference;
import sdmx.data.DataSetWriter;
import sdmx.footer.FooterType;
import sdmx.message.BaseHeaderType;

/**
 *
 * @author James
 */
public interface ParseDataCallbackHandler {
    public void setNamespace(String prefix,String namespace);
    public void headerParsed(BaseHeaderType header);
    public void footerParsed(FooterType footer);
    public DataSetWriter getDataSetWriter();
    public void documentFinished();
    public String getDimensionAtObservationHint();
    public void setDimensionAtObservationHint(String s);
    public void setDataStructureReferenceHint(DataStructureReference ref);
    public DataStructureReference getDataStructureReferenceHint();
    public Registry getRegistry();
    public void setRegistry(Registry reg);
    
}

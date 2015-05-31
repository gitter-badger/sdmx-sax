/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.common;

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
}

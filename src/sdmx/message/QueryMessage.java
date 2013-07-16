/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.message;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.output.XMLOutputter;
import sdmx.message.BaseHeaderType;
/**
 *
 * @author James
 */
public class QueryMessage {
    private BaseHeaderType header = new BaseHeaderType();
    
    public String getQueryType() {
        return "DataStructureQuery";
    }

    /**
     * @return the header
     */
    public BaseHeaderType getHeader() {
        return header;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(BaseHeaderType header) {
        this.header = header;
    }
    
    

}

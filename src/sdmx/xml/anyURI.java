/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.xml;

import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author James
 */
public class anyURI {
    URI uri = null;
    String s = null;
    public anyURI(String s) throws URISyntaxException {
        this.s=s;
        this.uri=new URI(s);
    }
    public String getString() {return s; }
    public URI getURI() { return uri; }
    
}

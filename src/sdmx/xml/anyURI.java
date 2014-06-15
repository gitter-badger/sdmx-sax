/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.xml;

import java.net.URI;
import java.net.URISyntaxException;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.VersionType;

/**
 *
 * @author James
 */
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *   SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
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
    public boolean isSdmxUrn() {
        return s.startsWith("sdmx:");
    }
    public NestedNCNameIDType getAgencyID() {
        return null;
    }
    public IDType getID() {
        return null;
    }
    public VersionType getVersion() {
        return null;
    }
    public IDType getChildID() {
        return null;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.xml;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import sdmx.common.DataType;

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
public class XMLString implements Serializable {
    String value = null;
    public XMLString(String s) {
        this.value=s;
    }
    public String getString() { return value; }
    public String toString() {
        return value;
    }
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeUTF(value);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        this.value = ois.readUTF();
    }
}

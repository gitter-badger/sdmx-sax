/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.common;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *  SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public class Annotations extends AnnotationsType implements Serializable {
     public Annotations(List<AnnotationType> annots) {
         super(annots);
     }

    public Annotations() {
        super(new ArrayList<AnnotationType>());
    }
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeObject(super.getAnnotations());
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        super.setAnnotations((List<AnnotationType>)ois.readObject());
    }
}

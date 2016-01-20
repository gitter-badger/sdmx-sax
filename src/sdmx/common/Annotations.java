/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
 */
package sdmx.common;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

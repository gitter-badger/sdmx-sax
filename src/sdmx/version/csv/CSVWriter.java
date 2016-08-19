/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.csv;

/**
 *
 * @author James
 */
import sdmx.version.json.*;
import com.google.gson.stream.JsonWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import sdmx.version.twopointzero.writer.*;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.output.XMLOutputter;
import sdmx.Registry;
import sdmx.common.Name;
import sdmx.cube.Cube;
import sdmx.cube.CubeObservation;
import sdmx.data.DataSet;
import sdmx.data.Group;
import sdmx.data.flat.FlatObs;
import sdmx.data.key.FullKey;
import sdmx.structureddata.ValueTypeResolver;
import sdmx.data.structured.Obs;
import sdmx.data.structured.Series;
import sdmx.data.structured.StructuredColumnMapper;
import sdmx.message.*;
import sdmx.structure.base.NameableType;
import sdmx.structure.dataflow.DataflowType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structure.datastructure.DimensionType;
import sdmx.structure.datastructure.TimeDimensionType;
import static sdmx.version.twopointzero.writer.GenericDataWriter.writeName;
import net.hamnaberg.jsonstat.util.IntCartesianProduct;
import sdmx.structure.base.ItemType;
import sdmx.structure.datastructure.MeasureDimensionType;
import sdmx.structureddata.StructuredDataMessage;
import sdmx.structureddata.StructuredDataSet;

/**
 * This file is part of SdmxSax.
 *
 * SdmxSax is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * SdmxSax is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * SdmxSax. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright James Gardner 2014
 */
public class CSVWriter {

    public static final SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd");

    public static void write(DataMessage message,Registry reg, Locale loc, OutputStream out) throws XMLStreamException, IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
        StructuredDataMessage sdm = new StructuredDataMessage(message, reg);
        StructuredDataSet ds = sdm.getStructuredDataSet(0);
        for (int i = 0; i < ds.size(); i++) {
            for (int j = 0; j < ds.getColumnCount(); j++) {
                ItemType itm = ds.getStructuredValue(i, j).getCode();
                if (itm == null) {
                    bw.write(ds.getStructuredValue(i, j).getValue());
                } else {
                    bw.write(NameableType.toString(itm,loc));
                }
                if( j < ds.size()) {
                    bw.write(",");
                }
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

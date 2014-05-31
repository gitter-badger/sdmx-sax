/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data.flat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sdmx.data.AttachmentLevel;
import sdmx.data.ColumnMapper;
import sdmx.data.DataSet;
import sdmx.data.DataSetWriter;
import sdmx.data.Group;
import sdmx.data.flat.FlatObs;
import sdmx.data.key.FullKey;
import sdmx.data.key.PartialKey;
import sdmx.message.StructureType;
import sdmx.query.data.DataQuery;
import sdmx.structure.codelist.CodeType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.Registry;
import sdmx.cube.Cube;

/**
 * <xs:attributeGroup name="SetAttributeGroup">
 * <xs:annotation>
 * <xs:documentation>The SetAttributeGroup defines a common set of attributes
 * pertaining to any data set. The attributes are qualified, so that they will
 * be easily distinguished from attributes that are specific to the data
 * structure. Note that many of these attributes are duplications of fields
 * available in the header of the data messages. The reason for this is to allow
 * the header values to be overridden at the data set level when a message
 * contains more than one data set. If an attribute here does not have a value,
 * then the value from the header is applied to the data set.</xs:documentation>
 * </xs:annotation>
 * <xs:attribute name="structureRef" type="xs:IDREF" use="required"
 * form="qualified">
 * <xs:annotation>
 * <xs:documentation>The structureRef contains a reference to a structural
 * specification in the header of a data or reference metadata message. The
 * structural specification details which structure the data or reference
 * metadata conforms to, as well as providing additional information such as how
 * the data is structure (e.g. which dimension occurs at the observation level
 * for a data set).</xs:documentation>
 * </xs:annotation>
 * </xs:attribute>
 * <xs:attribute name="setID" type="common:IDType" use="optional"
 * form="qualified">
 * <xs:annotation>
 * <xs:documentation>The setID provides an identification of the data or
 * metadata set.</xs:documentation>
 * </xs:annotation>
 * </xs:attribute>
 * <xs:attribute name="action" type="common:ActionType" use="optional"
 * form="qualified">
 * <xs:annotation>
 * <xs:documentation>The action attribute indicates whether the file is
 * appending, replacing, or deleting.</xs:documentation>
 * </xs:annotation>
 * </xs:attribute>
 * <xs:attribute name="reportingBeginDate" type="common:BasicTimePeriodType"
 * use="optional" form="qualified">
 * <xs:annotation>
 * <xs:documentation>The reportingBeginDate indicates the inclusive start time
 * of the data reported in the data or metadata set.</xs:documentation>
 * </xs:annotation>
 * </xs:attribute>
 * <xs:attribute name="reportingEndDate" type="common:BasicTimePeriodType"
 * use="optional" form="qualified">
 * <xs:annotation>
 * <xs:documentation>The reportingEndDate indicates the inclusive end time of
 * the data reported in the data or metadata set.</xs:documentation>
 * </xs:annotation>
 * </xs:attribute>
 * <xs:attribute name="validFromDate" type="xs:dateTime" use="optional"
 * form="qualified">
 * <xs:annotation>
 * <xs:documentation>The validFromDate indicates the inclusive start time
 * indicating the validity of the information in the data or metadata
 * set.</xs:documentation>
 * </xs:annotation>
 * </xs:attribute>
 * <xs:attribute name="validToDate" type="xs:dateTime" use="optional"
 * form="qualified">
 * <xs:annotation>
 * <xs:documentation>The validToDate indicates the inclusive end time indicating
 * the validity of the information in the data or metadata
 * set.</xs:documentation>
 * </xs:annotation>
 * </xs:attribute>
 * <xs:attribute name="publicationYear" type="xs:gYear" use="optional"
 * form="qualified">
 * <xs:annotation>
 * <xs:documentation>The publicationYear holds the ISO 8601 four-digit
 * year.</xs:documentation>
 * </xs:annotation>
 * </xs:attribute>
 * <xs:attribute name="publicationPeriod"
 * type="common:ObservationalTimePeriodType" use="optional" form="qualified">
 * <xs:annotation>
 * <xs:documentation>The publicationPeriod specifies the period of publication
 * of the data or metadata in terms of whatever provisioning agreements might be
 * in force (i.e., "Q1 2005" if that is the time of publication for a data set
 * published on a quarterly basis).</xs:documentation>
 * </xs:annotation>
 * </xs:attribute>
 * <xs:attribute name="dataScope" type="DataScopeType" use="required"
 * form="qualified">
 * <xs:annotation>
 * <xs:documentation>The dataScope attribute indicates the scope at which the
 * data is meant to be validated. These scopes are hierarchical and are (from
 * the top down); DataStructure, ConstrainedDataStructure, Dataflow, and
 * ProvisionAgreement. the hierarchy of these scopes represent the cascading
 * level of constraints, which can restrict the valid values for components. For
 * example, a data structure defines a dimension with a coded representation. A
 * data flow might have a constraint associated with it which further restricts
 * the values allowed from the referenced code list to a subset of the values
 * allowed by the data structure definition. A provision agreement that is based
 * on the dataflow might also have a constraint, which further restricts the
 * subset of the codelist from the dataflow. Therefore, the allowed content
 * becomes stricter lower in the hierarchy. Data that is given a scope of one
 * value is stated to be valid at that level and all levels below it. Therefore,
 * this scope serves to state that data that is meant to be structured simply
 * against the data structure definition is not meant to be validated against
 * the a dataflow, where constraints might be applied.</xs:documentation>
 * </xs:annotation>
 * </xs:attribute>
 * </xs:attributeGroup>
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
public class FlatDataSet implements DataSet {

    List<Group> groups = null;
    FlatColumnMapper mapper = new FlatColumnMapper();
    List<FlatObs> observations = new ArrayList<FlatObs>();

    public FlatDataSet() {
    }

    public int getColumnIndex(String name) {
        return mapper.getColumnIndex(name);
    }

    public String getValue(int row, String col) {
        return getValue(row, mapper.getColumnIndex(col));
    }

    public String getValue(int row, int col) {
        if (observations.get(row) == null) {
            System.out.println("Null Obs");
        }
        return observations.get(row).getValue(col);
    }

    public void setValue(int row, String col, String val) {
        setValue(row, mapper.getColumnIndex(col), val);
    }

    public void setValue(int row, int col, String val) {
        observations.get(row).setValue(col, val);
    }

    public void addObservation(FlatObs o) {
        observations.add(o);
    }

    public boolean removeObservation(FlatObs o) {
        return observations.remove(o);
    }

    public int size() {
        return observations.size();
    }

    public FlatColumnMapper getColumnMapper() {
        return mapper;
    }

    public void dump() {
        for (int i = 0; i < mapper.size(); i++) {
            System.out.print(mapper.getColumnName(i) + "\t");
        }
        System.out.println();
        for (int i = 0; i < observations.size(); i++) {
            for (int j = 0; j < mapper.size(); j++) {
                Object o = getValue(i, j);
                if (o == null) {
                    System.out.print("null\t");
                } else {
                    String c = o.getClass().getSimpleName();
                    System.out.print(o.toString() + ":" + c + "\t");
                }
                //System.out.print(getValue(i,j)+"\t");
            }
            System.out.println();
        }
    }

    public int registerColumn(String s) {
        int col = mapper.registerColumn(s, AttachmentLevel.OBSERVATION);
        for (int i = 0; i < observations.size(); i++) {
            observations.get(i).setValue(col, null);
        }
        return col;
    }

    @Override
    public String getColumnName(int i) {
        return mapper.getColumnName(i);
    }

    @Override
    public int getColumnSize() {
        return mapper.size();
    }

    @Override
    public void writeTo(DataSetWriter writer) {
        writer.newDataSet();
        for (int i = 0; i < observations.size(); i++) {
            writer.newObservation();
            for (int j = 0; j < this.getColumnSize(); j++) {
                Object o = getValue(i, j);
                if (o == null) {
                    writer.writeObservationComponent(this.getColumnName(j), "");
                } else if (o instanceof String) {
                    writer.writeObservationComponent(this.getColumnName(j), (String) o);
                } else if (o instanceof CodeType) {
                    writer.writeObservationComponent(this.getColumnName(j), ((CodeType) o).getId().getString());
                } else if (o instanceof Double) {
                    writer.writeObservationComponent(this.getColumnName(j), ((Double) o).toString());
                }
            }
            writer.finishObservation();
        }
        writer.finishDataSet();
    }

    public FlatObs getFlatObs(int i) {
        return observations.get(i);
    }

    @Override
    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public int groupSize() {
        if (groups == null) {
            return 0;
        } else {
            return groups.size();
        }
    }

    public void applyGroupKey(PartialKey key, String column, String value) {
        int indx = mapper.getColumnIndex(column);
        for (int i = 0; i < this.size(); i++) {
            FlatObs flat = this.getFlatObs(i);
            if (key.matches(flat, mapper)) {
                flat.setValue(indx, value);
            } else {
                flat.setValue(indx, null);
            }
        }
    }

    @Override
    public void setGroups(List<Group> groups) {
        this.groups = groups;
        if( groups == null ) return;
        for (int i = 0; i < groups.size(); i++) {
            Group g = groups.get(i);
            Iterator<String> it = g.getGroupAttributes().keySet().iterator();
            while (it.hasNext()) {
                String s = it.next();
                getColumnMapper().registerColumn(it.next(), AttachmentLevel.GROUP);
                int indx = getColumnIndex(s);
                PartialKey key = new PartialKey(g.getGroupKey());
                applyGroupKey(key, s, (String) g.getGroupAttributes().get(s));
            }
        }
    }

    @Override
    public Cube query(DataQuery query) {
       Cube cube = new Cube();
       for(int i=0;i<size();i++) {
           cube.putObservation(mapper, getFlatObs(i));
       }
       return cube;
    }
}

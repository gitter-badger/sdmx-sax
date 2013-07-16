/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointzero;

import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import sdmx.message.DataQueryMessage;
import sdmx.message.DataStructureQueryMessage;
import sdmx.message.QueryMessage;
import sdmx.query.base.NumericValue;
import sdmx.query.base.QueryIDType;
import sdmx.query.base.TextValue;
import sdmx.query.base.TimeValue;
import sdmx.query.data.AttributeValueType;
import sdmx.query.data.DataParametersAndType;
import sdmx.query.data.DataParametersOrType;
import sdmx.query.data.DataParametersType;
import sdmx.query.data.DataQueryType;
import sdmx.query.data.DimensionValueType;
import sdmx.query.data.TimeDimensionValueType;

/**
 *
 * @author James
 */
public class Sdmx20QueryWriter {

    public static Element getHeader(QueryMessage query) {
        Namespace message = Namespace.getNamespace("message", "http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message");
        Element header = new Element("Header");
        header.setNamespace(Namespace.getNamespace("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message"));
        if (query.getHeader().getId() != null && !"".equals(query.getHeader().getId())) {
            Element id = new Element("ID");
            id.addContent(query.getHeader().getId());
            id.setNamespace(message);
            header.addContent(id);
        }
        if (query.getHeader().getTest() != null && !"".equals(query.getHeader().getTest())) {
            Element test = new Element("Test");
            test.addContent(query.getHeader().getTest().toString());
            test.setNamespace(message);
            header.addContent(test);
        }
        if (query.getHeader().getNames() != null && !"".equals(query.getHeader().getNames())) {
            Element name = new Element("Name");
            name.addContent(query.getHeader().getNames().get(0).getText());
            name.setNamespace(message);
            header.addContent(name);
        }
        if (query.getHeader().getPrepared() != null && !"".equals(query.getHeader().getPrepared())) {
            Element prep = new Element("Prepared");
            prep.addContent(query.getHeader().getPrepared().getDate().toString());
            prep.setNamespace(message);
            header.addContent(prep);
        }
        if (query.getHeader().getSender() != null) {
            Element send = new Element("Sender");
            send.setAttribute("id", query.getHeader().getSender().getId().toString());
            send.setNamespace(message);
            header.addContent(send);
        }
        if (query.getHeader().getReceivers() != null) {
            Element rec = new Element("Receiver");
            rec.setAttribute("id", query.getHeader().getReceivers().get(0).getId().toString());
            rec.setNamespace(message);
            header.addContent(rec);
        }
        return header;
    }

    public static Document toDocument(DataStructureQueryMessage query) {
        Document doc = new Document();
        Element root = new Element("QueryMessage");
        root.setNamespace(Namespace.getNamespace("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query"));
        Namespace message = Namespace.getNamespace("message", "http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message");
        Namespace queryNamespace = Namespace.getNamespace("query", "http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query");
        root.setNamespace(message);
        Element queryElement = new Element("Query");
        queryElement.setNamespace(message);
        Element keyfamilyWhere = new Element("KeyFamilyWhere");
        Element and = new Element("And");
        keyfamilyWhere.setNamespace(queryNamespace);
        Element kf = new Element("KeyFamily");
        kf.setNamespace(queryNamespace);
        and.setNamespace(queryNamespace);
        if (query.getDataStructureWhereType() != null&&query.getDataStructureWhereType().getId()!=null) {
            kf.setText(query.getDataStructureWhereType().getId().get(0).toString());
            and.addContent(kf);
        }
        keyfamilyWhere.addContent(and);
        //or.addContent(kf);
        
        //keyfamilyWhere.addContent(or);
        queryElement.addContent(keyfamilyWhere);
        root.addContent(getHeader(query));
        root.addContent(queryElement);
        doc.setRootElement(root);
        return doc;
    }

    public static Document toDocument(DataQueryMessage query) {
        Document doc = new Document();
        Element root = new Element("QueryMessage");
        Namespace message = Namespace.getNamespace("message", "http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message");
        Namespace queryNamespace = Namespace.getNamespace("query", "http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query");
        root.setNamespace(message);
        Element queryElement = new Element("Query");
        queryElement.setNamespace(message);
        Element dataWhere = toDataWhere(query.getQuery().getDataWhere());
        queryElement.addContent(dataWhere);
        root.addContent(getHeader(query));
        root.addContent(queryElement);
        doc.setRootElement(root);
        return doc;
    }

    public static Element toDataWhere(DataParametersType dw) {
        Element dataWhere = new Element("DataWhere");
        if (dw.getDataSetId() != null) {
            dataWhere.addContent(toQueryIDType("DataSet", dw.getDataSetId()));
        }
        if (dw.getAttributeValue() != null) {
            dataWhere.addContent(toAttributeValue(dw.getAttributeValue()));
        }
        if (dw.getDimensionValue() != null) {
            dataWhere.addContent(toDimensionValue(dw.getDimensionValue()));
        }
        if (dw.getTimeDimensionValue() != null) {
            dataWhere.addContent(toTimeDimensionElement(dw.getTimeDimensionValue()));
        }
        if (dw.getAnd() != null) {
            dataWhere.addContent(toAndElement(dw.getAnd()));
        }
        if (dw.getOr() != null) {
            dataWhere.addContent(toOrElement(dw.getOr()));
        }
        dataWhere.setNamespace(Namespace.getNamespace("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query"));
        return dataWhere;
    }

    public static List<Element> toOrElement(List<DataParametersOrType> q) {
        List<Element> list = new ArrayList<Element>();
        for (DataParametersOrType qi : q) {
            list.add(toOrElement(qi));
        }
        return list;
    }

    public static Element toOrElement(DataParametersOrType dw) {
        Element e = new Element("Or");
        if (dw.getDataSetId() != null) {
            e.addContent(toQueryIDType("DataSet", dw.getDataSetId()));
        }
        if (dw.getAttributeValue() != null) {
            e.addContent(toAttributeValue(dw.getAttributeValue()));
        }
        if (dw.getDimensionValue() != null) {
            e.addContent(toDimensionValue(dw.getDimensionValue()));
        }
        if (dw.getTimeDimensionValue() != null) {
            e.addContent(toTimeDimensionElement(dw.getTimeDimensionValue()));
        }
        if (dw.getAnd() != null) {
            e.addContent(toAndElement(dw.getAnd()));
        }
        e.setNamespace(Namespace.getNamespace("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query"));
        return e;
    }

    public static List<Element> toAndElement(List<DataParametersAndType> q) {
        List<Element> list = new ArrayList<Element>();
        for (DataParametersAndType qi : q) {
            list.add(toAndElement(qi));
        }
        return list;
    }

    public static Element toAndElement(DataParametersAndType dw) {
        Element e = new Element("And");
        if (dw.getDataSetId() != null) {
            e.addContent(toQueryIDType("DataSet", dw.getDataSetId()));
        }
        if (dw.getAttributeValue() != null) {
            e.addContent(toAttributeValue(dw.getAttributeValue()));
        }
        if (dw.getDimensionValue() != null) {
            e.addContent(toDimensionValue(dw.getDimensionValue()));
        }
        if (dw.getTimeDimensionValue() != null) {
            e.addContent(toTimeDimensionElement(dw.getTimeDimensionValue()));
        }
        if (dw.getOr() != null) {
            e.addContent(toOrElement(dw.getOr()));
        }
        e.setNamespace(Namespace.getNamespace("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query"));
        return e;
    }

    public static List<Element> toQueryIDType(String s, List<QueryIDType> q) {
        List<Element> list = new ArrayList<Element>();
        for (QueryIDType qi : q) {
            list.add(toQueryIDType(s, qi));
        }
        return list;
    }

    public static Element toQueryIDType(String s, QueryIDType q) {
        Element e = new Element(s);
        e.setText(q.getString());
        e.setNamespace(Namespace.getNamespace("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query"));
        return e;
    }

    public static List<Element> toAttributeValue(List<AttributeValueType> attributeValues) {
        List<Element> list = new ArrayList<Element>();
        for (AttributeValueType av : attributeValues) {
            list.add(toAttributeValue(av));
        }
        return list;
    }

    public static Element toAttributeValue(AttributeValueType attributeValue) {
        Element e = new Element("Attribute");
        e.setAttribute("id", attributeValue.getId().getString());
        if (attributeValue.getNumericValues() != null && attributeValue.getNumericValues().size() > 0) {
            e.addContent(toNumericValues(attributeValue.getNumericValues()));
        } else if (attributeValue.getTextValues() != null && attributeValue.getTextValues().size() > 0) {
            e.addContent(toTextValues(attributeValue.getTextValues()));
        } else if (attributeValue.getTimeValues() != null && attributeValue.getTimeValues().size() > 0) {
            e.addContent(toTimeValues(attributeValue.getTimeValues()));
        } else {
            e.setText(attributeValue.getValue());
        }
        e.setNamespace(Namespace.getNamespace("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query"));
        return e;
    }

    public static List<Element> toDimensionValue(List<DimensionValueType> dimValues) {
        List<Element> list = new ArrayList<Element>();
        for (DimensionValueType dm : dimValues) {
            list.add(toDimensionValue(dm));
        }
        return list;
    }

    public static Element toDimensionValue(DimensionValueType dimValue) {
        Element e = new Element("Dimension");
        e.setAttribute("id", dimValue.getId().getString());
        if (dimValue.getNumericValues() != null
                && dimValue.getNumericValues().size() > 0) {
            e.addContent(toNumericValues(dimValue.getNumericValues()));
        } else if (dimValue.getTextValues() != null
                && dimValue.getTextValues().size() > 0) {
            e.addContent(toTextValues(dimValue.getTextValues()));
        } else if (dimValue.getTimeValues() != null
                && dimValue.getTimeValues().size() > 0) {
            e.addContent(toTimeValues(dimValue.getTimeValues()));
        } else {
            e.setText(dimValue.getValue());
        }
        e.setNamespace(Namespace.getNamespace("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query"));
        return e;
    }

    public static List<Element> toNumericValues(List<NumericValue> numericValues) {
        List<Element> list = new ArrayList<Element>();
        for (NumericValue nv : numericValues) {
            list.add(toNumericValue(nv));
        }
        return list;
    }

    public static Element toNumericValue(NumericValue nv) {
        Element e = new Element("NumericValue");
        e.setText(Double.toString(nv.getValue()));
        e.setNamespace(Namespace.getNamespace("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query"));
        return e;
    }

    public static List<Element> toTextValues(List<TextValue> textValues) {
        List<Element> list = new ArrayList<Element>();
        for (TextValue tv : textValues) {
            list.add(toTextValue(tv));
        }
        return list;
    }

    public static Element toTextValue(TextValue tv) {
        Element e = new Element("TextValue");
        e.setAttribute("xml:lang", tv.getLang());
        e.setText(tv.getText());
        e.setNamespace(Namespace.getNamespace("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query"));
        return e;
    }

    public static List<Element> toTimeValues(List<TimeValue> timeValues) {
        List<Element> list = new ArrayList<Element>();
        for (TimeValue tm : timeValues) {
            list.add(toTimeValue(tm));
        }
        return list;
    }

    public static Element toTimeValue(TimeValue tv) {
        Element e = new Element("TimeValue");
        e.setText(tv.toString());
        e.setNamespace(Namespace.getNamespace("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query"));
        return e;
    }

    public static List<Element> toTimeDimensionElement(List<TimeDimensionValueType> timeDimensionValues) {
        List<Element> list = new ArrayList<Element>();
        for (TimeDimensionValueType tm : timeDimensionValues) {
            list.add(toTimeValueElement(tm));
        }
        return list;
    }

    public static Element toTimeValueElement(TimeDimensionValueType tv) {
        Element e = new Element("Time");
        Element start = new Element("StartTime");
        start.setText(tv.getStart().toString());
        Element end = new Element("EndTime");
        end.setText(tv.getEnd().toString());
        start.setNamespace(Namespace.getNamespace("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query"));
        end.setNamespace(Namespace.getNamespace("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query"));
        e.addContent(start);
        e.addContent(end);
        e.setNamespace(Namespace.getNamespace("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query"));
        return e;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointzero;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import sdmx.commonreferences.DataflowReference;
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
import sdmx.querykey.Query;
import sdmx.structure.dataflow.DataflowType;
import sdmx.xml.DateTime;

/**
 *
 * @author James
 */
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
public class QueryToSdmx20Query {

    public static final SimpleDateFormat displayFormat = new SimpleDateFormat("yyyy-MM-dd");
    /*
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:sdmx="http://stats.oecd.org/OECDStatWS/SDMX/">
   <soap:Body>
      <sdmx:GetDataStructureDefinition>
         <sdmx:QueryMessage><message:QueryMessage xmlns:message="http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message"><Header xmlns="http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message"><message:ID>none</message:ID><message:Test>false</message:Test><message:Prepared>2016-08-19T00:04:18+08:00</message:Prepared><message:Sender id="Sdmx-Sax" /><message:Receiver id="ABS" /></Header><message:Query><query:KeyFamilyWhere xmlns:query="http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query"><query:And /></query:KeyFamilyWhere></message:Query></message:QueryMessage>
</sdmx:QueryMessage>
      </sdmx:GetDataStructureDefinition>
   </soap:Body>
</soap:Envelope>
     */

    public static String toGetDataStructureListQuery(String providerRef, String soapNamespace) {
        StringBuffer sb = new StringBuffer();
        sb.append("<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:sdmx=\"http://stats.oecd.org/OECDStatWS/SDMX/\"><soap:Body><sdmx:GetDataStructureDefinition>"
                + "<sdmx:QueryMessage><message:QueryMessage xmlns:message=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\"><Header xmlns=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\"><message:ID>none</message:ID><message:Test>false</message:Test><message:Prepared>2016-08-19T00:04:18+08:00</message:Prepared><message:Sender id=\"Sdmx-Sax\" /><message:Receiver id=\"" + providerRef + "\" /></Header><message:Query><query:KeyFamilyWhere xmlns:query=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query\"><query:And /></query:KeyFamilyWhere></message:Query></message:QueryMessage>"
                + "</sdmx:QueryMessage></sdmx:GetDataStructureDefinition></soap:Body></soap:Envelope>");
        return sb.toString();
    }

    public static String toGetDataStructureQuery(String keyFamily, String providerRef, String soapNamespace) {
        StringBuffer sb = new StringBuffer();
        sb.append("<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:sdmx=\"http://stats.oecd.org/OECDStatWS/SDMX/\"><soap:Body><sdmx:GetDataStructureDefinition>"
                + "<sdmx:QueryMessage><message:QueryMessage xmlns:message=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\"><Header xmlns=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\"><message:ID>none</message:ID><message:Test>false</message:Test><message:Prepared>2016-08-19T00:08:29+08:00</message:Prepared><message:Sender id=\"Sdmx-Sax\" /><message:Receiver id=\"" + providerRef + "\" /></Header><message:Query><query:KeyFamilyWhere xmlns:query=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query\"><query:And><query:KeyFamily>" + keyFamily + "</query:KeyFamily></query:And></query:KeyFamilyWhere></message:Query></message:QueryMessage>"
                + "</sdmx:QueryMessage></sdmx:GetDataStructureDefinition></soap:Body></soap:Envelope>");
        return sb.toString();
    }

    public static String toGetDataQuery(Query q, String soapNamespace) {
        StringBuffer sb = new StringBuffer();
        sb.append("<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n"
                + "  <soap12:Body>\n"
                + "    <GetCompactData xmlns=\"http://stats.oecd.org/OECDStatWS/SDMX/\">\n"
                + "      <QueryMessage><message:QueryMessage xmlns:message=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\"><Header xmlns=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\"><message:ID>none</message:ID><message:Test>false</message:Test><message:Prepared>2016-08-19T00:11:33+08:00</message:Prepared><message:Sender id=\"Sdmx-Sax\" /><message:Receiver id=\"" + q.getProviderRef() + "\" /></Header><message:Query><DataWhere xmlns=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query\"><And><DataSet>" + q.getFlowRef() + "</DataSet><Time><StartTime>" + displayFormat.format(q.getQueryTime().getStartTime()) + "</StartTime><EndTime>" + displayFormat.format(q.getQueryTime().getEndTime()) + "</EndTime></Time>");
        for (int i = 0; i < q.size(); i++) {
            sb.append("<Or>");
            for (int j = 0; j < q.getQueryDimension(i).size(); j++) {
                sb.append("<Dimension id=\"" + q.getQueryDimension(i).getConcept() + "\">" + q.getQueryDimension(i).getValues().get(j) + "</Dimension>");
            }
            sb.append("</Or>");
        }
        sb.append("</And></DataWhere></message:Query></message:QueryMessage>\n");
        sb.append("</QueryMessage>\n");
        sb.append("</GetCompactData>\n");
        sb.append("</soap12:Body>\n");
        sb.append("</soap12:Envelope>");
        return sb.toString();
    }

    public static String toNSIGetDataStructureListQuery(String providerRef, String soapNamespace) {
        StringBuffer sb = new StringBuffer();
        sb.append("<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:sdmx=\"http://ec.europa.eu/eurostat/sri/service/2.0\">");
        sb.append("<soap:Body>");
        sb.append("<sdmx:QueryStructure>");
        sb.append("<sdmx:Query>");
        sb.append("<message:RegistryInterface xmlns:message=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\">");
        sb.append("<Header xmlns=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\">");
        sb.append("<message:ID>none</message:ID>");
        sb.append("<message:Test>false</message:Test>");
        sb.append("<message:Prepared>2016-08-19T19:32:41+08:00</message:Prepared>");
        sb.append("<message:Sender id=\"Sdmx-Sax\"/>");
        sb.append("<message:Receiver id=\"" + providerRef + "\"/>");
        sb.append("</Header>");
        sb.append("<message:QueryStructureRequest resolveReferences=\"false\">");
        sb.append("<registry:DataflowRef xmlns:registry=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/registry\"/>");
        sb.append("</message:QueryStructureRequest>");
        sb.append("</message:RegistryInterface>");
        sb.append("</sdmx:Query>");
        sb.append("</sdmx:QueryStructure>");
        sb.append("</soap:Body>");
        sb.append("</soap:Envelope>");
        return sb.toString();
    }

    public static String toNSIGetDataStructureQuery(String keyFamily, String providerRef, String soapNamespace) {
        StringBuffer sb = new StringBuffer();
        sb.append("<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:sdmx=\"http://ec.europa.eu/eurostat/sri/service/2.0\">");
        sb.append("<soap:Body>");
        sb.append("<sdmx:QueryStructure>");
        sb.append("<sdmx:Query><message:RegistryInterface xmlns:message=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\">");
        sb.append("<Header xmlns=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\"><message:ID>none</message:ID><message:Test>false</message:Test><message:Prepared>2016-08-19T19:38:21+08:00</message:Prepared><message:Sender id=\"Sdmx-Sax\" /><message:Receiver id=\"" + providerRef + "\" /></Header><message:QueryStructureRequest resolveReferences=\"true\"><registry:KeyFamilyRef xmlns:registry=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/registry\"><registry:AgencyID>" + providerRef + "</registry:AgencyID><registry:KeyFamilyID>" + keyFamily + "</registry:KeyFamilyID><registry:Version>1.0</registry:Version></registry:KeyFamilyRef></message:QueryStructureRequest></message:RegistryInterface>");
        sb.append("</sdmx:Query>");
        sb.append("</sdmx:QueryStructure>");
        sb.append("</soap:Body>");
        sb.append("</soap:Envelope>");
        return sb.toString();
    }

    public static String toNSIGetDataQuery(Query q, String soapNamespace) {
        StringBuffer sb = new StringBuffer();
        sb.append("<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">");
        sb.append("<soap12:Body>");
        sb.append("<GetCompactData xmlns=\"http://ec.europa.eu/eurostat/sri/service/2.0\">");
        sb.append("<Query><message:QueryMessage xmlns:message=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\"><Header xmlns=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\"><message:ID>none</message:ID><message:Test>false</message:Test><message:Prepared>2016-08-19T19:55:37+08:00</message:Prepared><message:Sender id=\"Sdmx-Sax\" /><message:Receiver id=\"" + q.getProviderRef() + "\" /></Header><message:Query><DataWhere xmlns=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query\"><And><Time><StartTime>" + displayFormat.format(q.getQueryTime().getStartTime()) + "</StartTime><EndTime>" + displayFormat.format(q.getQueryTime().getEndTime()) + "</EndTime></Time><Dataflow>" + q.getFlowRef() + "</Dataflow>");
        for (int i = 0; i < q.size(); i++) {
            sb.append("<Or>");
            for (int j = 0; j < q.getQueryDimension(i).size(); j++) {
                sb.append("<Dimension id=\"" + q.getQueryDimension(i).getConcept() + "\">" + q.getQueryDimension(i).getValues().get(j) + "</Dimension>");
            }
            sb.append("</Or>");
        }
        sb.append("</And></DataWhere></message:Query></message:QueryMessage>");
        sb.append("</Query>");
        sb.append("</GetCompactData>");
        sb.append("</soap12:Body>");
        sb.append("</soap12:Envelope>");
        return sb.toString();
    }
}

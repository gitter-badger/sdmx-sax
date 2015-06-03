/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.util;

import sdmx.data.DataSet;
import sdmx.message.DataMessage;
import sdmx.version.common.ParseDataCallbackHandler;

/**
 *
 * @author James
 */
public class DataUtilities {
     public static void writeTo(DataMessage message,ParseDataCallbackHandler cbHandler) {
         cbHandler.setNamespace(message.getNamespacePrefix(), message.getNamespace());
         cbHandler.headerParsed(message.getHeader());
         for(DataSet d:message.getDataSets()){
             d.writeTo(cbHandler.getDataSetWriter());
         }
         cbHandler.documentFinished();
     }
}

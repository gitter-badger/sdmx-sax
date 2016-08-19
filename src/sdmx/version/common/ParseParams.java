/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.common;

import java.util.Locale;
import sdmx.Registry;
import sdmx.commonreferences.DataStructureReference;
import sdmx.structure.dataflow.DataflowType;
import sdmx.structure.datastructure.DataStructureType;

/**
 *
 * @author James
 */
public class ParseParams {
    
    // SDMX 2.0 -> When parsing SDMX 2.0, 
    // concepts are not kept in concept schemes
    // so we have to create a concept scheme
    // if this flag is false, we create a concept scheme
    // called AgencyId:"STANDALONE_CONCEPT_SCHEME":1.0
    // if this flag is true, we create a concept scheme
    // calls AgencyId:DATAFLOW_ID+"_CONCEPT_SCHEME":1.0
    // private boolean useDataflowName = false;
     private Registry registry = null;
     private String header = null;
     private ParseDataCallbackHandler callbackHandler = null;
     private Locale locale = Locale.ENGLISH;

     public ParseParams() {
     }
     public ParseParams(Registry reg){
         this.registry=reg;
     }
     
     /**
     * @return the useDataflowName
     */
     /*
    public boolean isUseDataflowName() {
        return useDataflowName;
    }

    /**
     * @param useDataflowName the useDataflowName to set
     */
     /*
    public void setUseDataflowName(boolean useDataflowName) {
        this.useDataflowName = useDataflowName;
    }*/

    /**
     * @return the registry
     */
    public Registry getRegistry() {
        return registry;
    }

    /**
     * @param registry the registry to set
     */
    public void setRegistry(Registry registry) {
        this.registry = registry;
    }

    /**
     * @return the header
     */
    public String getHeader() {
        return header;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * @return the callbackHandler
     */
    public ParseDataCallbackHandler getCallbackHandler() {
        return callbackHandler;
    }

    /**
     * @param callbackHandler the callbackHandler to set
     */
    public void setCallbackHandler(ParseDataCallbackHandler callbackHandler) {
        this.callbackHandler = callbackHandler;
    }

    /**
     * @return the locale
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * @param locale the locale to set
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }
     
}

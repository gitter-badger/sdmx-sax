/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.common;

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
     private boolean useDataflowName = false;
     private String dimensionAtObservation = null;
     private String requestURI = null;
     private String dataStructureURI = null;
     private Registry registry = null;
     private DataflowType flow = null;
     private DataStructureReference dataStructureRef = null;
     private DataStructureType structure = null;
     private String header = null;
     private ParseDataCallbackHandler callbackHandler = null;

     public ParseParams() {
     }
     public ParseParams(Registry reg, DataflowType flow){
         this.registry=reg;
         this.flow=flow;
         this.dataStructureRef=flow.getStructure();
         this.structure = reg.find(dataStructureRef);
     }
     
     /**
     * @return the useDataflowName
     */
    public boolean isUseDataflowName() {
        return useDataflowName;
    }

    /**
     * @param useDataflowName the useDataflowName to set
     */
    public void setUseDataflowName(boolean useDataflowName) {
        this.useDataflowName = useDataflowName;
    }

    /**
     * @return the flow
     */
    public DataflowType getDataflow() {
        return flow;
    }

    /**
     * @param flow the flow to set
     */
    public void setDataflow(DataflowType flow) {
        this.flow = flow;
    }

    /**
     * @return the dimensionAtObservation
     */
    public String getDimensionAtObservation() {
        return dimensionAtObservation;
    }

    /**
     * @param dimensionAtObservation the dimensionAtObservation to set
     */
    public void setDimensionAtObservation(String dimensionAtObservation) {
        this.dimensionAtObservation = dimensionAtObservation;
    }

    /**
     * @return the requestURI
     */
    public String getRequestURI() {
        return requestURI;
    }

    /**
     * @param requestURI the requestURI to set
     */
    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    /**
     * @return the dataStructureURI
     */
    public String getDataStructureURI() {
        return dataStructureURI;
    }

    /**
     * @param dataStructureURI the dataStructureURI to set
     */
    public void setDataStructureURI(String dataStructureURI) {
        this.dataStructureURI = dataStructureURI;
    }

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
     * @return the dataStructureRef
     */
    public DataStructureReference getDataStructureRef() {
        return dataStructureRef;
    }

    /**
     * @param dataStructureRef the dataStructureRef to set
     */
    public void setDataStructureRef(DataStructureReference dataStructureRef) {
        this.dataStructureRef = dataStructureRef;
    }

    /**
     * @return the structure
     */
    public DataStructureType getStructure() {
        return structure;
    }

    /**
     * @param structure the structure to set
     */
    public void setStructure(DataStructureType structure) {
        this.structure = structure;
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
     
}

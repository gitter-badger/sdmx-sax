/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.querykey;

import java.util.ArrayList;
import java.util.List;
import sdmx.Registry;
import sdmx.structure.datastructure.DataStructureType;

/**
 * This object should be all a repository needs to perform a query
 *
 * @author James
 */
public interface Query {
    public List<String> getConceptNames();
    public QueryDimension getQueryDimension(int i);
    public List<QueryDimension> getQueryDimensions();
    public int size();
    public QueryTime getQueryTime();
    public int getQuerySize();
    public String getUpdatedAfter();
    public void setUpdatedAfter(String updatedAfter);
    public int getFirstNObservations();
    public void setFirstNObservations(int firstNObservations);
    public int getLastNObservations();
    public void setLastNObservations(int lastNObservations);
    public String getDimensionAtObservation();
    public void setDimensionAtObservation(String dimensionAtObservation);
    public String getDetail();
    public void setDetail(String detail);
    public boolean isIncludeHistory();
    public void setIncludeHistory(boolean includeHistory);
    public String getFlowRef();
    public void setFlowRef(String flowRef);
    public String getQueryString();
    public String getProviderRef();
    public void setProviderRef(String providerRef);
}

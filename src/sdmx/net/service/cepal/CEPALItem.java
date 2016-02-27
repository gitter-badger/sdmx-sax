/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.net.service.cepal;

/**
 *
 * @author James
 */
public class CEPALItem {
private String name = "";
private String idIndicator = "";
    public CEPALItem(String name, String idIndicator) {
        this.name=name;
        this.idIndicator=idIndicator;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the idIndicator
     */
    public String getIdIndicator() {
        return idIndicator;
    }

    /**
     * @param idIndicator the idIndicator to set
     */
    public void setIdIndicator(String idIndicator) {
        this.idIndicator = idIndicator;
    }
    
}

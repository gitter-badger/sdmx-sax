/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.net.service.nomis;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import sdmx.common.Name;
import sdmx.common.TextType;

/**
 *
 * @author James
 */
public class NOMISGeography {
    private String cubeId = "";
    private String cubeName = "";
    private String geography = "";
    private String geographyName = "";

    /**
     * @return the id
     */
    public String getCubeId() {
        return cubeId;
    }

    /**
     * @param id the id to set
     */
    public void setCubeId(String id) {
        this.cubeId = id;
    }

    /**
     * @return the geography
     */
    public String getGeography() {
        return geography;
    }

    /**
     * @param geography the geography to set
     */
    public void setGeography(String geography) {
        this.geography = geography;
    }

    /**
     * @return the geographyName
     */
    public String getGeographyName() {
        return geographyName;
    }

    /**
     * @param geographyName the geographyName to set
     */
    public void setGeographyName(String geographyName) {
        this.geographyName = geographyName;
    }

    /**
     * @return the cubeName
     */
    public String getCubeName() {
        return cubeName;
    }

    /**
     * @param cubeName the cubeName to set
     */
    public void setCubeName(String cubeName) {
        this.cubeName = cubeName;
    }

}

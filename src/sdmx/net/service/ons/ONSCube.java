/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.net.service.ons;

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
public class ONSCube {
    private String context = "";
    private String id = "";
    private String geography = "";
    private List<Name> contextNames = null;
    private List<Name> idNames = null;
    private List<Name> geographyNames = null;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the context
     */
    public String getContext() {
        return context;
    }

    /**
     * @param context the context to set
     */
    public void setContext(String context) {
        this.context = context;
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
     * @return the contextNames
     */
    public List<Name> getContextNames() {
        return contextNames;
    }

    /**
     * @param contextNames the contextNames to set
     */
    public void setContextNames(List<Name> contextNames) {
        this.contextNames = contextNames;
    }

    /**
     * @return the idNames
     */
    public List<Name> getIdNames() {
        return idNames;
    }

    /**
     * @param idNames the idNames to set
     */
    public void setIdNames(List<Name> idNames) {
        this.idNames = idNames;
    }

    /**
     * @return the geographyNames
     */
    public List<Name> getGeographyNames() {
        return geographyNames;
    }

    /**
     * @param geographyNames the geographyNames to set
     */
    public void setGeographyNames(List<Name> geographyNames) {
        this.geographyNames = geographyNames;
    }
    public String getMainId(){
        return getContext()+"_"+getId()+"_"+getGeography();
    }
    public List<Name> getMainNames(){
        Set<String> langs = new TreeSet<String>(new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).compareTo((String)o2);
            }
        });
        for(Name n:idNames){
            langs.add(n.getLang());
        }
        for(Name n:geographyNames){
            langs.add(n.getLang());
        }
        for(Name n:contextNames){
            langs.add(n.getLang());
        }
        List<Name> result =new ArrayList<Name>();
        for(String s:langs) {
            String text = findName(s,contextNames)+" "+findName(s,idNames)+" "+findName(s,geographyNames);
            Name name = new Name(s,text);
            result.add(name);
        }
        return result;
    }
    public String findName(String lang,List<Name> names) {
        for(Name n:names) {
            if( lang.equals(n.getLang())){
                return n.getText();
            }
        }
        if( "en".equals(lang)){
            return names.get(0).getText();
        }
        return findName("en",names);
    }
}

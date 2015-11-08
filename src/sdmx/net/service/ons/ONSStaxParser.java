/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.net.service.ons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import sdmx.common.Name;

public class ONSStaxParser {
    public static void main(String args[]) throws XMLStreamException, FileNotFoundException {
        List<ONSCube> parse = parseCollections(new FileInputStream("E:\\collections.xml"));
    }
    public static final int STATE_NOTHING= 0;
    public static final int STATE_ID = 1;
    public static final int STATE_NAME = 2;
    
    public static List<ONSCube> parseCollections(InputStream in) throws XMLStreamException {
        List<ONSCube> cubeList = new ArrayList<ONSCube>();
        ONSCube currCube = null;
        String tagContent = null;
        XMLInputFactory factory = XMLInputFactory.newInstance();

        XMLStreamReader reader
                = factory.createXMLStreamReader(in);

        int state = 0;
        String lastLang = null;
        while (reader.hasNext()) {
            int event = reader.next();
            switch(event) {
                case XMLStreamConstants.START_ELEMENT:
                    if( reader.getLocalName().equals("collection")){
                        currCube = new ONSCube();
                    }
                    if( reader.getLocalName().equals("id")){
                        state = STATE_ID;
                    }
                    if( reader.getLocalName().equals("name")){
                        state= STATE_NAME;
                        lastLang = reader.getAttributeValue(0);
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    if( state == STATE_ID ) {
                        currCube.setId(reader.getText().trim());                    
                    }
                    if( state == STATE_NAME && currCube!=null) {
                        List<Name> names = currCube.getIdNames();
                        if( names == null ) {
                            names = new ArrayList<Name>();
                        }
                        Name n = new Name(lastLang,reader.getText().trim());
                        names.add(n);
                        //System.out.println("Added name:"+n.getLang()+":"+n.getText());
                        currCube.setIdNames(names);
                        state=STATE_NOTHING;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if( reader.getLocalName().equals("collection")){
                        cubeList.add(currCube);
                        currCube=null;
                    }
                    if( reader.getLocalName().equals("name")){
                        lastLang=null;
                        state=STATE_NOTHING;
                    }
                    break;
            }
        }
        return cubeList;
    }
}
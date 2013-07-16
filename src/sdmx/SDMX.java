/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import javax.xml.bind.JAXBException;

/**
 *
 * @author jgardner
 */
public class SDMX {


    /*
     public static void dumpMeta(DataMessage dsd) {
     dumpMeta(dsd.getDataSet().getMetaStructure());
     }
     public static void dumpMeta(AbstractDataStructureDocument ms) {
     for(int i=0;i<ms.getDimensions().size();i++) {
     MetaDimension dim = ms.getDimensions().get(i);
     System.out.println("Dimension:"+dim.getConceptRef());
     System.out.println("Codelist=:"+dim.getCodelist());
     System.out.println("Type=:"+dim.getType());
     }
     for(int i=0;i<ms.getAttributes().size();i++) {
     AttributeImpl att = ms.getAttributes().get(i);
     System.out.println("Attribute:"+att.getConceptRef());
     System.out.println("Codelist=:"+att.getCodelist());
     System.out.println("Type=:"+att.getType());
     }
     for(int i=0;i<ms.getMeasures().size();i++) {
     MetaMeasure mm = ms.getMeasures().get(i);
     System.out.println("Measure:"+mm.getConceptRef());
     System.out.println("Codelist=:"+mm.getCodelist());
     System.out.println("Type=:"+mm.getType());
     }
     for(int i=0;i<ms.getTimeDimensions().size();i++) {
     MetaTimeDimension mtd = ms.getTimeDimensions().get(i);
     System.out.println("Measure:"+mtd.getConceptRef());
     System.out.println("Codelist=:"+mtd.getCodelist());
     System.out.println("Type=:"+mtd.getType());
     }
     MetaPrimaryMeasure pmm = ms.getPrimaryMeasure();
     System.out.println("PMeasure:"+pmm.getConceptRef());
     System.out.println("Codelist=:"+pmm.getCodelist());
     System.out.println("Type=:"+pmm.getType());
     }
     public static void dumpData(DataMessage doc) {
     List<Observation> lobs = doc.getDataSet().enumerateAllObservations();
     for(int i=0;i<lobs.size();i++) {
     System.out.println(lobs.get(i).toString());
     }
     }
     public static void dumpCategoryScheme(CategoryScheme cs) {
     int depth=1;
     for(int i=0;i<cs.getCategorySize();i++) {
     depth=dumpCategory(cs.getCategory(i),depth);
     }
     }
     private static int dumpCategory(Category c, int d) {
     for(int i=0;i<d;i++) {System.out.print("   ");}
     System.out.println(c.getName());
     d++;
     for(int i=0;i<c.getCategorySize();i++){
     d=dumpCategory(c.getCategory(i),d);
     }
     d--;
     return d;
     }
     */
}

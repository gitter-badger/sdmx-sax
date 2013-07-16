/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package readsdmx.sdmx20.crosssection;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.sdmx.resources.sdmxml.schemas.v2_0.message.Structure;
import org.sdmx.resources.sdmxml.schemas.v2_0.query.CodelistType;
import org.sdmx.resources.sdmxml.schemas.v2_0.structure.CodeListType;
import org.sdmx.resources.sdmxml.schemas.v2_0.structure.GroupType;
import org.sdmx.resources.sdmxml.schemas.v2_0.structure.KeyFamiliesType;
import org.sdmx.resources.sdmxml.schemas.v2_0.structure.KeyFamilyType;
import readsdmx.model.immutable.DataSet;
import readsdmx.model.meta.MetaDocumentStructure;
import readsdmx.model.meta.MetaStructure;
import readsdmx.sdmx20.Sdmx20MetaDocumentStructure;
import readsdmx.sdmx20.meta.Sdmx20MetaStructure;
/**
 *
 * @author James
 */
public class CrossSectionalDataStructureDocument extends Sdmx20MetaDocumentStructure {

    private Structure structure = null;
    private MetaStructure mstruc = null;

    public CrossSectionalDataStructureDocument(InputStream in) throws JAXBException {
        structure = unmarshal(Structure.class, in);
    }

    public static <T> T unmarshal(Class<T> docClass, InputStream inputStream)
            throws JAXBException {
        String packageName = docClass.getPackage().getName();
        JAXBContext jc = JAXBContext.newInstance(packageName);
        Unmarshaller u = jc.createUnmarshaller();
        T doc = (T) u.unmarshal(inputStream);
        return doc;
    }

    public KeyFamilyType getKeyFamily(String keyFamilyURI) {
        KeyFamiliesType kft = getStructure().getKeyFamilies();
        List<KeyFamilyType> kfs = kft.getKeyFamilies();
        for (int i = 0; i < kfs.size(); i++) {
            KeyFamilyType kf = kfs.get(i);
            if (kf.getUri() != null && kf.getUri().equals(keyFamilyURI)) {
                return kf;
            }
        }
        if (kfs.size() > 0) {
            return kfs.get(0);
        }
        return null;
    }

    /**
     * @return the structure
     */
    public Structure getStructure() {
        return structure;
    }

    public MetaStructure getMetaStructure(String keyFamilyURI) {
        Sdmx20MetaStructure ms = new Sdmx20MetaStructure(getKeyFamily(keyFamilyURI),this);
        mstruc=ms;
        System.out.println("MetaStructure="+ms);
        return ms;
    }
    
    public List<String> getGroupNames(String keyFamilyURI) {
        KeyFamilyType kf = getKeyFamily(keyFamilyURI);
        List<String> gNames = new ArrayList<String>(0);
        Iterator<GroupType> it = kf.getComponents().getGroups().iterator();
        while(it.hasNext()) {
            gNames.add(it.next().getId());
        }
        return gNames;
    }
    public CodeListType getCodelist(String name,String agency,String version) {
        if( name == null || agency==null || version==null ) return null;
        Iterator<CodeListType> it = structure.getCodeLists().getCodeLists().iterator();
        while(it.hasNext()) {
            CodeListType clt = it.next();
            if( name.equals(clt.getId())&&agency.equals(clt.getAgencyID())&&version.equals(clt.getVersion()))return clt;
        }
        return null;
    }
}

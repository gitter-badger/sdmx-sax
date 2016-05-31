/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.util.List;
import sdmx.common.AnnotableType;
import sdmx.common.AnnotationType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedID;
import sdmx.commonreferences.RefBase;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="IdentifiableType" abstract="true">
		<xs:annotation>
			<xs:documentation>IdentifiableType is an abstract base type for all identifiable objects.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="common:AnnotableType">
				<xs:attribute name="id" type="common:IDType" use="optional">
					<xs:annotation>
						<xs:documentation>The id is the identifier for the object.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="urn" type="xs:anyURI" use="optional">
					<xs:annotation>
						<xs:documentation>The urn attribute holds a valid SDMX Registry URN (see SDMX Registry Specification for details).</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="uri" type="xs:anyURI" use="optional">
					<xs:annotation>
						<xs:documentation>The uri attribute holds a URI that contains a link to a resource with additional information about the object, such as a web page. This uri is not a SDMX message.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:extension>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */

public class IdentifiableType extends AnnotableType {
    private IDType id;
    private anyURI urn;
    private anyURI uri;

    /**
     * @return the id
     */
    public IDType getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(IDType id) {
        this.id = id;
    }

    /**
     * @return the urn
     */
    public anyURI getUrn() {
        return urn;
    }

    /**
     * @param urn the urn to set
     */
    public void setUrn(anyURI urn) {
        this.urn = urn;
    }

    /**
     * @return the uri
     */
    public anyURI getUri() {
        return uri;
    }

    /**
     * @param uri the uri to set
     */
    public void setUri(anyURI uri) {
        this.uri = uri;
    }
    public boolean identifiesMe(IDType id2){
        if( this.getId()==null) return false;
        return this.getId().equals(id2);
    }
    public boolean identifiesMe(NestedID id2){
        if( this.getId()==null) return false;
        return this.getId().equals(id2);
    }
    public boolean identifiesMe(anyURI uri2){
        if( this.uri!=null&&this.urn!=null)
        return this.uri.equals(uri2)||this.urn.equals(uri2);
        else if( this.uri!=null ){
            return this.uri.equals(uri2);
        }else if( this.urn!=null) {
            return this.urn.equals(uri2);
        }
        return false;
    }
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeUTF(id!=null?id.toString():"");
        oos.writeUTF(urn!=null?urn.toString():"");
        oos.writeUTF(uri!=null?uri.toString():"");
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        String id = ois.readUTF();
        if( id!=null ) this.id = new IDType(id);
        String urn = ois.readUTF();
        try{
        if( !"".equals(urn) ) this.urn = new anyURI(urn);
        String uri = ois.readUTF();
        if( !"".equals(uri) ) this.uri = new anyURI(uri);
        }catch(URISyntaxException ex){}
    }
}

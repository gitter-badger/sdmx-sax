/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URISyntaxException;
import static org.junit.Assert.*;
import org.junit.Test;
import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.xml.anyURI;

/**
 *
 * @author James
 */
public class ReferenceTypeTest {
    
    public ReferenceTypeTest() {
    }

    @Test
    public void test1() throws URISyntaxException {
        ReferenceType reference = new ReferenceType(new anyURI("urn:sdmx:org.sdmx.infomodel.datastructure.DataStructure=ECB:ECB_FMD2(1.0)"));
        assertEquals(PackageTypeCodelistType.DATASTRUCTURE,reference.getPack());
        assertEquals(ObjectTypeCodelistType.DATASTRUCTURE,reference.getClazz());
        assertEquals(new NestedNCNameIDType("ECB").toString(),reference.getAgencyId().toString());
        assertEquals(new NestedIDType("ECB_FMD2").toString(),reference.getMaintainableParentId().toString());
        assertEquals(VersionType.ONE.toString(),reference.getVersion().toString());
    }
    @Test
    public void test2() throws URISyntaxException {
        ReferenceType reference = new ReferenceType(new anyURI("urn:sdmx:org.sdmx.infomodel.datastructure.DataStructure=TFFS:CRED_EXT_DEBT(1.0)"));
        assertEquals(PackageTypeCodelistType.DATASTRUCTURE,reference.getPack());
        assertEquals(ObjectTypeCodelistType.DATASTRUCTURE,reference.getClazz());
        assertEquals(new NestedNCNameIDType("TFFS").toString(),reference.getAgencyId().toString());
        assertEquals(new NestedIDType("CRED_EXT_DEBT").toString(),reference.getMaintainableParentId().toString());
        assertEquals(VersionType.ONE.toString(),reference.getVersion().toString());
    }
    @Test
    public void test3() throws URISyntaxException {
        ReferenceType reference = new ReferenceType(new anyURI("urn:sdmx:org.sdmx.infomodel.codelist.Code=ISO:CL_3166A2(1.0).AR"));
        assertEquals(PackageTypeCodelistType.CODELIST,reference.getPack());
        assertEquals(ObjectTypeCodelistType.CODE,reference.getClazz());
        assertEquals(new NestedNCNameIDType("ISO").toString(),reference.getAgencyId().toString());
        assertEquals(new NestedIDType("CL_3166A2").toString(),reference.getMaintainableParentId().toString());
//        assertEquals(new IDType("AR").toString(),reference.getId().toString());
        assertEquals(VersionType.ONE.toString(),reference.getVersion().toString());
    }
    @Test
    public void test4() throws URISyntaxException {
        ReferenceType reference = new ReferenceType(new anyURI("urn:sdmx:org.sdmx.infomodel.categoryscheme.Category=ESTAT:ESTAT_DATAFLOWS_SCHEME(1.0).STS.STSCONS"));
        assertEquals(PackageTypeCodelistType.CATEGORYSCHEME,reference.getPack());
        assertEquals(ObjectTypeCodelistType.CATEGORY,reference.getClazz());
        assertEquals(new NestedNCNameIDType("ESTAT").toString(),reference.getAgencyId().toString());
        assertEquals(new NestedIDType("ESTAT_DATAFLOWS_SCHEME").toString(),reference.getMaintainableParentId().toString());
        assertEquals(new IDType("STS").toString(),reference.getId().toString());
        assertEquals(VersionType.ONE.toString(),reference.getVersion().toString());
    }
}

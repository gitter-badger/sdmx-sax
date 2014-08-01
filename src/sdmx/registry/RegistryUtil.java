/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.registry;

import sdmx.Registry;
import sdmx.commonreferences.NestedIDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.StructureReferenceType;
import sdmx.commonreferences.URNUtilities;
import sdmx.commonreferences.VersionType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.structure.base.MaintainableType;

/**
 * This file is part of SdmxSax.
 *
 * SdmxSax is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * SdmxSax is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * SdmxSax. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright James Gardner 2014
 */
public class RegistryUtil {

    public static MaintainableType resolve(Registry registry, StructureReferenceType ref) {
        if (ref.getRef() != null) {
            NestedNCNameIDType agency = ref.getAgencyId();
            NestedIDType id = ref.getId();
            VersionType version = ref.getVersion();
            ObjectTypeCodelistType object = ref.getRefClass();
            PackageTypeCodelistType pack = ref.getPack();
            System.out.println(ObjectTypeCodelistType.INT_AGENCY);
            switch (object.toInt()) {
                case ObjectTypeCodelistType.INT_ANY:
                    break;
                case ObjectTypeCodelistType.INT_AGENCY:
                    break;
                case ObjectTypeCodelistType.INT_AGENCYSCHEME:
                    break;
                case ObjectTypeCodelistType.INT_ATTACHMENTCONSTRAINT:
                    break;
                case ObjectTypeCodelistType.INT_ATTRIBUTE:
                    break;
                case ObjectTypeCodelistType.INT_ATTRIBUTEDESCRIPTOR:
                    break;
                case ObjectTypeCodelistType.INT_CATEGORISATION:
                    break;
                case ObjectTypeCodelistType.INT_CATEGORY:
                    break;
                case ObjectTypeCodelistType.INT_CATEGORYSCHEMEMAP:
                    break;
                case ObjectTypeCodelistType.INT_CATEGORYSCHEME:
                    break;
                case ObjectTypeCodelistType.INT_CODE:
                    break;
                case ObjectTypeCodelistType.INT_CODEMAP:
                    break;
                case ObjectTypeCodelistType.INT_CODELIST:
                    return registry.findCodelist(agency, id.asID(), version);
                case ObjectTypeCodelistType.INT_CODELISTMAP:
                    break;
                case ObjectTypeCodelistType.INT_COMPONENTMAP:
                    break;
                case ObjectTypeCodelistType.INT_CONCEPT:

                    break;
                case ObjectTypeCodelistType.INT_CONCEPTMAP:
                    break;
                case ObjectTypeCodelistType.INT_CONCEPTSCHEME:
                    return registry.findConceptScheme(agency, id.asID());
                case ObjectTypeCodelistType.INT_CONCEPTSCHEMEMAP:
                    break;
                case ObjectTypeCodelistType.INT_CONSTRAINT:
                    break;
                case ObjectTypeCodelistType.INT_CONSTRAINTARGET:
                    break;
                case ObjectTypeCodelistType.INT_CONTENTCONSTRAINT:
                    break;
                case ObjectTypeCodelistType.INT_DATAFLOW:
                    return registry.findDataflow(agency, id.asID(), version);
                case ObjectTypeCodelistType.INT_DATACONSUMER:
                    break;
                case ObjectTypeCodelistType.INT_DATACONSUMERSCHEME:
                    break;
                case ObjectTypeCodelistType.INT_DATAPROVIDER:
                    break;
                case ObjectTypeCodelistType.INT_DATAPROVIDERSCHEME:
                    break;
                case ObjectTypeCodelistType.INT_DATASETTARGET:
                    break;
                case ObjectTypeCodelistType.INT_DATASTRUCTURE:
                    return registry.findDataStructure(agency, id.asID(), version);
                case ObjectTypeCodelistType.INT_DIMENSION:
                    break;
                case ObjectTypeCodelistType.INT_DIMENSIONDESCRIPTOR:
                    break;
                case ObjectTypeCodelistType.INT_DIMENSIONDESCRIPTORVALUESTARGET:
                    break;
                case ObjectTypeCodelistType.INT_GROUPDIMENSIONDESCRIPTOR:
                    break;
                case ObjectTypeCodelistType.INT_HIERARCHICALCODE:
                    break;
                case ObjectTypeCodelistType.INT_HIERARCHICALCODELIST:
                    break;
                case ObjectTypeCodelistType.INT_HIERARCHY:
                    break;
                case ObjectTypeCodelistType.INT_HYBRIDCODELISTMAP:
                    break;
                case ObjectTypeCodelistType.INT_HYBRIDCODEMAP:
                    break;
                case ObjectTypeCodelistType.INT_IDENTIFIABLEOBJECTTARGET:
                    break;
                case ObjectTypeCodelistType.INT_LEVEL:
                    break;
                case ObjectTypeCodelistType.INT_MEASUREDESCRIPTOR:
                    break;
                case ObjectTypeCodelistType.INT_MEASUREDIMENSION:
                    break;
                case ObjectTypeCodelistType.INT_METADATAFLOW:
                    break;
                case ObjectTypeCodelistType.INT_METADATAATTRIBUTE:
                    break;
                case ObjectTypeCodelistType.INT_METADATASET:
                    break;
                case ObjectTypeCodelistType.INT_METADATASTRUCTURE:
                    break;
                case ObjectTypeCodelistType.INT_METADATATARGET:
                    break;
                case ObjectTypeCodelistType.INT_ORGANISATION:
                    break;
                case ObjectTypeCodelistType.INT_ORGANISATIONMAP:
                    break;
                case ObjectTypeCodelistType.INT_ORGANISATIONSCHEME:
                    break;
                case ObjectTypeCodelistType.INT_ORGANISATIONSCHEMEMAP:
                    break;
                case ObjectTypeCodelistType.INT_ORGANISATIONUNIT:
                    break;
                case ObjectTypeCodelistType.INT_ORGANISATIONUNITSCHEME:
                    break;
                case ObjectTypeCodelistType.INT_PRIMARYMEASURE:
                    break;
                case ObjectTypeCodelistType.INT_PROCESS:
                    break;
                case ObjectTypeCodelistType.INT_PROCESSSTEP:
                    break;
                case ObjectTypeCodelistType.INT_PROVISIONAGREEMENT:
                    break;
                case ObjectTypeCodelistType.INT_REPORTINGCATEGORY:
                    break;
                case ObjectTypeCodelistType.INT_REPORTINGCATEGORYMAP:
                    break;
                case ObjectTypeCodelistType.INT_REPORTINGTAXONOMY:
                    break;
                case ObjectTypeCodelistType.INT_REPORTINGTAXONOMYMAP:
                    break;
                case ObjectTypeCodelistType.INT_REPORTINGYEARSTARTDAY:
                    break;
                case ObjectTypeCodelistType.INT_REPORTPERIODTARGET:
                    break;
                case ObjectTypeCodelistType.INT_REPORTSTRUCTURE:
                    break;
                case ObjectTypeCodelistType.INT_STRUCTUREMAP:
                    break;
                case ObjectTypeCodelistType.INT_STRUCTURESET:
                    break;
                case ObjectTypeCodelistType.INT_TIMEDIMENSION:
                    break;
                case ObjectTypeCodelistType.INT_TRANSITION:
                    break;
            }
            throw new RuntimeException("Ref Object Type not supported.");
        } else if (URNUtilities.isSdmxURN(ref.getUrn())) {
            String urn = ref.getUrn().getString();
            return null;
        } else {
            throw new RuntimeException("URN is not an SDMX URN!" + ref.getUrn().getString());
        }
    }
}

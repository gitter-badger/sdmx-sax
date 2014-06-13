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
import sdmx.commonreferences.VersionType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_AGENCY;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_AGENCYSCHEME;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_ANY;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_ATTACHMENTCONSTRAINT;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_ATTRIBUTE;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_ATTRIBUTEDESCRIPTOR;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_CATEGORISATION;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_CATEGORY;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_CATEGORYSCHEME;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_CATEGORYSCHEMEMAP;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_CODE;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_CODELIST;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_CODELISTMAP;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_COMPONENTMAP;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_CONCEPT;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_CONCEPTMAP;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_CONCEPTSCHEME;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_CONCEPTSCHEMEMAP;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_CONSTRAINT;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_CONSTRAINTARGET;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_CONTENTCONSTRAINT;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_DATACONSUMER;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_DATACONSUMERSCHEME;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_DATAFLOW;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_DATAPROVIDER;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_DATAPROVIDERSCHEME;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_DATASETTARGET;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_DATASTRUCTURE;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_DIMENSION;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_DIMENSIONDESCRIPTOR;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_DIMENSIONDESCRIPTORVALUESTARGET;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_GROUPDIMENSIONDESCRIPTOR;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_HIERARCHICALCODE;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_HIERARCHICALCODELIST;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_HIERARCHY;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_HYBRIDCODELISTMAP;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_HYBRIDCODEMAP;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_IDENTIFIABLEOBJECTTARGET;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_LEVEL;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_MEASUREDESCRIPTOR;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_MEASUREDIMENSION;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_METADATAATTRIBUTE;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_METADATAFLOW;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_METADATASET;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_METADATASTRUCTURE;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_METADATATARGET;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_ORGANISATION;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_ORGANISATIONMAP;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_ORGANISATIONSCHEME;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_ORGANISATIONSCHEMEMAP;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_ORGANISATIONUNIT;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_ORGANISATIONUNITSCHEME;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_PRIMARYMEASURE;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_PROCESS;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_PROCESSSTEP;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_PROVISIONAGREEMENT;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_REPORTINGCATEGORY;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_REPORTINGCATEGORYMAP;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_REPORTINGTAXONOMY;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_REPORTINGTAXONOMYMAP;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_REPORTINGYEARSTARTDAY;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_REPORTPERIODTARGET;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_REPORTSTRUCTURE;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_STRUCTUREMAP;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_STRUCTURESET;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_TIMEDIMENSION;
import static sdmx.commonreferences.types.ObjectTypeCodelistType.TARGET_TRANSITION;
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
            NestedNCNameIDType agency = ref.getRef().getAgencyId();
            NestedIDType id = ref.getRef().getId();
            VersionType version = ref.getRef().getVersion();
            ObjectTypeCodelistType object = ref.getRef().getRefClass();
            PackageTypeCodelistType pack = ref.getRef().getPack();
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
                    break;
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
                    break;
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
        } else if (ref.getUrn().isSdmxUrn()) {

        } else {
            throw new RuntimeException("URN is not an SDMX URN!" + ref.getUrn().getString());
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data;

import sdmx.common.DataType;
import sdmx.commonreferences.ConceptReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedIDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.data.flat.FlatDataSet;
import sdmx.structure.base.Component;
import sdmx.structure.base.RepresentationType;
import sdmx.structure.codelist.CodeType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.datastructure.AttributeType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structure.datastructure.DimensionType;
import sdmx.structure.datastructure.MeasureDimensionType;
import sdmx.structure.datastructure.PrimaryMeasure;
import sdmx.structure.datastructure.TimeDimensionType;
import sdmx.workspace.Registry;

/**
 *
 * @author James
 */
public class ValueTypeResolver {

    Registry registry = null;
    DataStructureType struct = null;

    public ValueTypeResolver(Registry reg, DataStructureType struct) {
        this.registry = reg;
        this.struct = struct;
    }

    public Object resolve(String column, String value) {
        if (value == null) {
            return null;
        }
        Component c = struct.getDataStructureComponents().findDimension(column);
        Object result = value;
        if (c instanceof DimensionType) {
            //System.out.println("Dimension");
            result = resolveDimension((DimensionType) c, value);
        }
        if (c instanceof AttributeType) {
            //System.out.println("Attribute");
            result = resolveDimension((AttributeType) c, value);
        }
        if (c instanceof MeasureDimensionType) {
            //System.out.println("MeasureDimension");
            result = resolveDimension((MeasureDimensionType) c, value);
        }
        if (c instanceof TimeDimensionType) {
            //System.out.println("TimeDimension");
            result = resolveDimension((TimeDimensionType) c, value);
        }
        if (c instanceof PrimaryMeasure) {
            //System.out.println("Primary Measure");
            result = resolveDimension((PrimaryMeasure) c, value);
        }
        //System.out.println("Concept:"+column+":"+value+" to "+result);
        return result;
    }

    public Object resolveDimension(MeasureDimensionType dim, String val) {
        NestedIDType dimId = dim.getConceptIdentity().getRef().getId();
        RepresentationType rep = null;
        if (val != null) {
            ConceptReferenceType conceptRef = dim.getConceptIdentity();
            ConceptType concept = null;
            if (conceptRef != null) {
                ConceptSchemeType con = registry.findConceptScheme(struct.getAgencyID(), conceptRef);
                concept = con.findConcept(dim.getConceptIdentity().getRef().getId());
                rep = concept.getCoreRepresentation();
            }
            RepresentationType localRep = dim.getLocalRepresentation();
            if (rep != null) {
                rep = localRep;
            }
            String svalue = val;
            if (localRep != null) {
                if (localRep.getEnumeration() != null) {
                    CodelistType codelist = registry.findCodelist(localRep.getEnumeration());
                    CodeType ct = codelist.findCode(svalue);
                    if (ct == null) {
                        throw new RuntimeException(svalue + " not found in Codelist:" + codelist.getAgencyID().toString() + ":" + codelist.getId().toString() + ":" + codelist.getVersion().toString());
                    } else {
                        return ct;
                    }
                }
            }
            if (concept != null) {
                if (concept.getCoreRepresentation() != null && concept.getCoreRepresentation().getEnumeration() != null) {
                    CodelistType codelist = registry.findCodelist(concept.getCoreRepresentation().getEnumeration());
                    CodeType ct = codelist.findCode(svalue);
                    if (ct == null) {
                        throw new RuntimeException(svalue + " not found in Codelist:" + codelist.getAgencyID().toString() + ":" + codelist.getId().toString() + ":" + codelist.getVersion().toString());
                    } else {
                        return ct;
                    }
                }
            }

            Object value = svalue;
            if (rep.getTextFormat() != null) {
                if (rep.getTextFormat().getTextType() == DataType.DECIMAL) {
                    value = Double.parseDouble(svalue);
                }
                if (rep.getTextFormat().getTextType() == DataType.INTEGER) {
                    value = Integer.parseInt(svalue);
                }
                if (rep.getTextFormat().getTextType() == DataType.STRING) {
                    value = svalue;
                }
            } else {
                value = svalue;
            }
            return value;
        } else {
            return null;
        }
    }

    public Object resolveDimension(PrimaryMeasure dim, String val) {
        NestedIDType dimId = dim.getConceptIdentity().getRef().getId();
        RepresentationType rep = null;
        if (val != null) {
            ConceptReferenceType conceptRef = dim.getConceptIdentity();
            ConceptType concept = null;
            if (conceptRef != null) {
                ConceptSchemeType con = registry.findConceptScheme(conceptRef.getRef().getAgencyId(), conceptRef.getRef().getMaintainableParentId());
                if (con == null) {
                    System.out.println("Cant find concept:" + conceptRef.getRef().getMaintainableParentId());
                }
                concept = con.findConcept(dim.getConceptIdentity().getRef().getId());
                rep = concept.getCoreRepresentation();
            }
            RepresentationType localRep = dim.getLocalRepresentation();
            if (localRep != null) {
                rep = localRep;
            }
            String svalue = val;
            if (rep != null) {
                if (rep.getEnumeration() != null) {
                    CodelistType codelist = registry.findCodelist(rep.getEnumeration());
                    CodeType ct = codelist.findCode(svalue);
                    if (ct == null) {
                        throw new RuntimeException(svalue + " not found in Codelist:" + codelist.getAgencyID().toString() + ":" + codelist.getId().toString() + ":" + codelist.getVersion().toString());
                    } else {
                        return ct;
                    }
                }
            }
            Object value = svalue;
            if (rep != null && rep.getTextFormat() != null) {
                if (rep.getTextFormat().getTextType() == DataType.DECIMAL) {
                    value = Double.parseDouble(svalue);
                }
                if (rep.getTextFormat().getTextType() == DataType.DOUBLE) {
                    value = Double.parseDouble(svalue);
                }
                if (rep.getTextFormat().getTextType() == DataType.FLOAT) {
                    value = Float.parseFloat(svalue);
                }

                if (rep.getTextFormat().getTextType() == DataType.INTEGER) {
                    value = Integer.parseInt(svalue);
                }
                if (rep.getTextFormat().getTextType() == DataType.STRING) {
                    value = svalue;
                }
            } else {
                value = svalue;
            }
            return value;
        } else {
            return null;
        }
    }

    public Object resolveDimension(TimeDimensionType dim, String val) {
        NestedIDType dimId = dim.getConceptIdentity().getRef().getId();
        RepresentationType rep = null;
        if (val != null) {
            ConceptReferenceType conceptRef = dim.getConceptIdentity();
            ConceptType concept = null;
            if (conceptRef != null) {
                ConceptSchemeType con = registry.findConceptScheme(struct.getAgencyID(), conceptRef);
                if (con == null) {
                    System.out.println("Cant find concept:" + conceptRef.getRef().getId().getString());
                }
                concept = con.findConcept(dim.getConceptIdentity().getRef().getId());
                rep = concept.getCoreRepresentation();
            }
            RepresentationType localRep = dim.getLocalRepresentation();
            if (localRep != null) {
                rep = localRep;
            }
            String svalue = val;
            if (rep != null) {
                if (rep.getEnumeration() != null) {
                    CodelistType codelist = registry.findCodelist(rep.getEnumeration());
                    CodeType ct = codelist.findCode(svalue);
                    if (ct == null) {
                        throw new RuntimeException(svalue + " not found in Codelist:" + codelist.getAgencyID().toString() + ":" + codelist.getId().toString() + ":" + codelist.getVersion().toString());
                    } else {
                        return ct;
                    }
                }
            }
            Object value = svalue;
            if (rep != null && rep.getTextFormat() != null) {
                if (rep.getTextFormat().getTextType() == DataType.DECIMAL) {
                    value = Double.parseDouble(svalue);
                }
                if (rep.getTextFormat().getTextType() == DataType.INTEGER) {
                    value = Integer.parseInt(svalue);
                }
                if (rep.getTextFormat().getTextType() == DataType.STRING) {
                    value = svalue;
                }
            } else {
                value = svalue;
            }
            return value;
        } else {
            return null;
        }
    }

    public Object resolveDimension(DimensionType dim, String val) {
        NestedIDType dimId = dim.getConceptIdentity().getRef().getId();
        RepresentationType rep = null;
        if (val != null) {
            ConceptReferenceType conceptRef = dim.getConceptIdentity();
            ConceptType concept = null;
            if (conceptRef != null) {
                ConceptSchemeType con = registry.findConceptScheme(struct.getAgencyID(), conceptRef);
                if (con == null) {
                    System.out.println("Cant find concept:" + conceptRef.getRef().getId().getString());
                }
                concept = con.findConcept(dim.getConceptIdentity().getRef().getId());
                rep = concept.getCoreRepresentation();
            }
            RepresentationType localRep = dim.getLocalRepresentation();
            if (localRep != null) {
                rep = localRep;
            }
            String svalue = val;
            if (rep != null) {
                if (rep.getEnumeration() != null) {
                    CodelistType codelist = registry.findCodelist(rep.getEnumeration());
                    CodeType ct = codelist.findCode(svalue);
                    if (ct == null) {
                        throw new RuntimeException(svalue + " not found in Codelist:" + codelist.getAgencyID().toString() + ":" + codelist.getId().toString() + ":" + codelist.getVersion().toString());
                    } else {
                        return ct;
                    }
                }
            }
            Object value = svalue;
            if (rep != null && rep.getTextFormat() != null) {
                if (rep.getTextFormat().getTextType() == DataType.DECIMAL) {
                    value = Double.parseDouble(svalue);
                }
                if (rep.getTextFormat().getTextType() == DataType.INTEGER) {
                    value = Integer.parseInt(svalue);
                }
                if (rep.getTextFormat().getTextType() == DataType.STRING) {
                    value = svalue;
                }
            } else {
                value = svalue;
            }
            return value;
        } else {
            return null;
        }
    }

    public Object resolveDimension(AttributeType dim, String val) {
        NestedIDType dimId = dim.getConceptIdentity().getRef().getId();
        RepresentationType rep = null;
        if (val != null) {
            ConceptReferenceType conceptRef = dim.getConceptIdentity();
            ConceptType concept = null;
            if (conceptRef != null) {
                ConceptSchemeType con = registry.findConceptScheme(struct.getAgencyID(), conceptRef);
                if (con == null) {
                    System.out.println("Cant find concept:" + conceptRef.getRef().getId().getString());
                }
                concept = con.findConcept(dim.getConceptIdentity().getRef().getId());
                rep = concept.getCoreRepresentation();
            }
            RepresentationType localRep = dim.getLocalRepresentation();
            if (localRep != null) {
                rep = localRep;
            }
            String svalue = val;
            if (rep != null) {
                if (rep.getEnumeration() != null) {
                    CodelistType codelist = registry.findCodelist(rep.getEnumeration());
                    CodeType ct = codelist.findCode(svalue);
                    if (ct == null) {
                        throw new RuntimeException(svalue + " not found in Codelist:" + codelist.getAgencyID() + ":" + codelist.getId() + ":" + codelist.getVersion());
                    } else {
                        return ct;
                    }
                }
            }
            Object value = svalue;
            if (rep != null && rep.getTextFormat() != null) {
                if (rep.getTextFormat().getTextType() == DataType.DECIMAL) {
                    value = Double.parseDouble(svalue);
                }
                if (rep.getTextFormat().getTextType() == DataType.INTEGER) {
                    value = Integer.parseInt(svalue);
                }
                if (rep.getTextFormat().getTextType() == DataType.STRING) {
                    value = svalue;
                }
            } else {
                value = svalue;
            }
            return value;
        } else {
            return null;
        }

    }

    public static void resolveDataSet(Registry registry, DataSet ds, DataStructureType struct) {
        ValueTypeResolver tr = new ValueTypeResolver(registry, struct);
        for (int i = 0; i < ds.size(); i++) {
            for (int j = 0; j < ds.getColumnSize(); j++) {
                Object o1 = ds.getValue(i, j);
                if( o1 instanceof String ) {
                   Object o2 = tr.resolve(ds.getColumnName(j), (String) o1);
                //System.out.println("Start Val=" + o1 + ": res=" + o2);
                   ds.setValue(i, j, o2);
                }

            }
        }
    }
}
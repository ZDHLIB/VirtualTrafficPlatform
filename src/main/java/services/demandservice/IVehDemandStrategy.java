package services.demandservice;

import models.vehdemands.VehFlow;
import org.dom4j.Document;

import java.util.List;

public interface IVehDemandStrategy {
    String xmlSchema = "http://www.w3.org/2001/XMLSchema-instance";
    String xmlSchemaNoTargetNamespace = "http://sumo.dlr.de/xsd/routes_file.xsd";

    public Document createVehDemandDocument (List<VehFlow> vehFlows);
}

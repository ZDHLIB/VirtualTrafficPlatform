package services.demandservice.flowservice;

import models.enums.VehDemandFlowEnum;
import models.vehdemands.VehFlow;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import utils.XMLUtils;

import java.io.FileWriter;
import java.nio.file.Path;
import java.util.List;

public class VehDemandFlowService {
    private IVehDemandFlowStrategy vehDemandStrategy;

    public VehDemandFlowService(VehDemandFlowEnum vehDemandFlowType) {
        switch (vehDemandFlowType) {
            case PROBABILITY:
                vehDemandStrategy = new VehDemandFlowProbStrategy();
                break;
            case VEHSPERHOUR:
                vehDemandStrategy = new VehDemandFlowNumStrategy();
                break;
            case PERIOD:
                vehDemandStrategy = new VehDemandFlowPeriodStrategy();
                break;
        }
    }

    public Path createVehDemandFlowXML(Path outputFlowFilePath, List<VehFlow> vehFlowList) {
        Document document = vehDemandStrategy.createVehDemandDocument(vehFlowList);
        XMLUtils.WriteXML(outputFlowFilePath.toString(), document);
        return outputFlowFilePath;
    }
}

package services.demandservice;

import models.enums.VehDemandFlowTypes;
import models.vehdemands.VehFlow;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.util.List;

public class VehDemandFlowService {
    private IVehDemandStrategy vehDemandStrategy;

    public VehDemandFlowService(VehDemandFlowTypes vehDemandFlowType) {
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

    public void createVehDemandFlowXMLFile(String filePath, List<VehFlow> vehFlowList) {
        Document doc = vehDemandStrategy.createVehDemandDocument(vehFlowList);
        OutputFormat format = OutputFormat.createPrettyPrint();
        try(FileWriter fileWriter = new FileWriter(filePath)){
            XMLWriter writer = new XMLWriter(fileWriter, format);
            writer.write(doc);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

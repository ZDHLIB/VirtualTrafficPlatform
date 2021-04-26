package services.demandservice.flowservice;

import models.enums.VehDemandFlowEnum;
import models.enums.VehicleClassEnum;
import models.vehdemands.VehFlow;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class VehDemandFlowServiceTest {

    private static List<VehFlow> vehFlows = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
        VehFlow vehFlow = new VehFlow(
                UUID.randomUUID().toString(),
                VehicleClassEnum.PASSENGER.getName(),
                "1-2",
                "2-3",
                "random",
                "best",
                0.0,
                0.0,
                3600.0,
                500,
                3600.0,
                0.3,
                500
        );
        vehFlows.add(vehFlow);
    }

    @Test
    void createVehDemandPeriodFlowXMLFile() {
        Path filePath = Paths.get("src", "test", "resources", "VehDemandPeriodFlow.rou.xml");
        VehDemandFlowService vehDemandFlowContext = new VehDemandFlowService(VehDemandFlowEnum.PERIOD);
        vehDemandFlowContext.createVehDemandFlowXML(filePath, vehFlows);
    }

    @Test
    void createVehDemandProbFlowXMLFile() {
        Path filePath = Paths.get("src", "test", "resources", "VehDemandProbFlow.rou.xml");
        VehDemandFlowService vehDemandFlowContext = new VehDemandFlowService(VehDemandFlowEnum.PROBABILITY);
        vehDemandFlowContext.createVehDemandFlowXML(filePath, vehFlows);
    }

    @Test
    void createVehDemandNumFlowXMLFile() {
        Path filePath = Paths.get("src", "test", "resources", "VehDemandNumFlow.rou.xml");
        VehDemandFlowService vehDemandFlowContext = new VehDemandFlowService(VehDemandFlowEnum.PERIOD);
        vehDemandFlowContext.createVehDemandFlowXML(filePath, vehFlows);
    }
}
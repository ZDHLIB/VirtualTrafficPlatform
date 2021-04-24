package services.demandservice;

import models.enums.VehDemandFlowTypes;
import models.enums.VehicleTypes;
import models.vehdemands.VehFlow;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class VehDemandFlowContextTest {
    private static List<VehFlow> vehFlows = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
        VehFlow vehFlow = new VehFlow(
                UUID.randomUUID().toString(),
                VehicleTypes.CAR.getName(),
                "1",
                "2",
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
        VehDemandFlowService vehDemandFlowContext = new VehDemandFlowService(VehDemandFlowTypes.PERIOD);
        vehDemandFlowContext.createVehDemandFlowXMLFile(filePath.toString(), vehFlows);
    }

    @Test
    void createVehDemandProbFlowXMLFile() {
        Path filePath = Paths.get("src", "test", "resources", "VehDemandProbFlow.rou.xml");
        VehDemandFlowService vehDemandFlowContext = new VehDemandFlowService(VehDemandFlowTypes.PROBABILITY);
        vehDemandFlowContext.createVehDemandFlowXMLFile(filePath.toString(), vehFlows);
    }

    @Test
    void createVehDemandNumFlowXMLFile() {
        Path filePath = Paths.get("src", "test", "resources", "VehDemandNumFlow.rou.xml");
        VehDemandFlowService vehDemandFlowContext = new VehDemandFlowService(VehDemandFlowTypes.PERIOD);
        vehDemandFlowContext.createVehDemandFlowXMLFile(filePath.toString(), vehFlows);
    }
}
package services.networkservice;

import models.enums.VehicleClassEnum;
import models.networks.VehType;
import models.vehdemands.VehFlow;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AdditionalXMLServiceTest {
    private static List<VehType> vehTypes = new ArrayList<>();;

    @BeforeAll
    static void beforeAll() {
        VehType vehType1 = new VehType(
                VehicleClassEnum.PASSENGER.getName(),
                2.6,
                4.5,
                0.5,
                5.0,
                2.5,
                13.8,
                VehicleClassEnum.PASSENGER,
                "Krauss"
        );
        VehType vehType2 = new VehType(
                VehicleClassEnum.PASSENGER.getName(),
                2.6,
                4.5,
                0.5,
                5.0,
                2.5,
                13.8,
                VehicleClassEnum.PASSENGER,
                "Krauss"
        );
        vehTypes.add(vehType1);
        vehTypes.add(vehType2);
    }
    @Test
    void createAdditionalXML() {
        Path filePath = Paths.get("src", "test", "resources", "TwoNodes.add.xml");
        AdditionalXMLService.createAdditionalXML(filePath.toString(), vehTypes);
    }
}
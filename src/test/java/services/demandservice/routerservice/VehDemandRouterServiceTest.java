package services.demandservice.routerservice;

import models.commandmodels.JTRRouterInputs;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class VehDemandRouterServiceTest {

    @Test
    void createRouterXMLbyFlowXML() {
        JTRRouterInputs jtrRouterInputs = new JTRRouterInputs();
        Path outputFilePath = Paths.get("src", "test", "resources", "TwoNodes.rou.xml");
        Path netFilePath = Paths.get("src", "test", "resources", "TwoNodes.net.xml");
        Path additionalFilePath = Paths.get("src", "test", "resources", "TwoNodes.add.xml");
        Path routeFilePath = Paths.get("src", "test", "resources", "VehDemandNumFlow.rou.xml");

        jtrRouterInputs.setOutputFilePath(outputFilePath.toAbsolutePath().toString());
        jtrRouterInputs.setNetFilePath(netFilePath.toAbsolutePath().toString());
        jtrRouterInputs.setAdditionalFilePath(additionalFilePath.toAbsolutePath().toString());
        jtrRouterInputs.setRouteFilePath(routeFilePath.toAbsolutePath().toString());
        jtrRouterInputs.setVtypeOutputFilePath(additionalFilePath.toAbsolutePath().toString());

        boolean exitSuccessfully = VehDemandRouterService.createRouterXML(jtrRouterInputs);
        assertTrue(exitSuccessfully);
    }
}
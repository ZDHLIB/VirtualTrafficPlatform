package services.networkservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.networks.Net;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

class NetworkXMLParserServiceTest {

    @Test
    void parseNetworkXML() {
        Path filePath = Paths.get("src", "test", "resources", "TwoNodes.net.xml");
        Net net = NetworkXMLParserService.ParseNetworkXML(filePath);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(net);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
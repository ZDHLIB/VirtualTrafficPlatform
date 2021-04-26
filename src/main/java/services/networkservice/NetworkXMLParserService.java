package services.networkservice;

import models.networks.*;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class NetworkXMLParserService {

    public static Net ParseNetworkXML(Path filePath) {
        SAXReader reader = new SAXReader();
        Document document = null;
        Net net = new Net();
        String fileName = filePath.getFileName().toString();
        try {
            document = reader.read(filePath.toString());
            net.setId(fileName);
            net.setJunctionHashMap(ParseNetworkJunctions(document));
            net.setEdgeHashMap(ParseNetworkEdges(document));
            net.setConnectionHashMap(ParseNetworkJConnection(document));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return net;
    }

    private static HashMap<String, Junction> ParseNetworkJunctions(Document document) {
        HashMap<String, Junction> junctionHashMap = new HashMap<>();
        List<Node> nodeList = document.selectNodes("/net/junction");
        nodeList.forEach(node -> {
            String id = node.valueOf("@id");
            Junction junction = new Junction();
            junction.setId(id);
            junction.setType(node.valueOf("@type"));
            junctionHashMap.put(id, junction);
        });
        return junctionHashMap;
    }

    private static HashMap<String, Edge> ParseNetworkEdges(Document document) {
        HashMap<String, Edge> edgeHashMap = new HashMap<>();
        List<Node> nodeList = document.selectNodes("/net/edge");
        nodeList.forEach(node -> {
            String id = node.valueOf("@id");
            String from = node.valueOf("@from");
            String to = node.valueOf("@to");
            Integer priority = Integer.valueOf(node.valueOf("@priority"));

            HashMap<String, Lane> laneHashMap = new HashMap<>();
            List<Node> laneNodes = node.selectNodes("*");
            laneNodes.forEach(laneNode -> {
                String laneId = laneNode.valueOf("@id");
                String laneIndex = laneNode.valueOf("@index");
                Double laneLength = Double.valueOf(laneNode.valueOf("@length"));
                Double laneSpeed = Double.valueOf(laneNode.valueOf("@speed"));
                laneHashMap.put(laneId, new Lane(laneId, laneIndex, laneSpeed, laneLength));
            });

            edgeHashMap.put(id, new Edge(id, from, to, priority, laneHashMap));
        });
        return edgeHashMap;
    }


    private static HashMap<String, Connection> ParseNetworkJConnection(Document document) {
        HashMap<String, Connection> connectionHashMap = new HashMap<>();
        List<Node> nodeList = document.selectNodes("/net/connection");
        nodeList.forEach(node -> {
            Connection connection = new Connection();
            String from = node.valueOf("@from");
            String to = node.valueOf("@to");
            connection.setFrom(from);
            connection.setTo(to);
            connection.setFromLane(node.valueOf("@fromLane"));
            connection.setToLane(node.valueOf("@toLane"));
            connectionHashMap.put(from+"_"+to, connection);
        });
        return connectionHashMap;
    }
}

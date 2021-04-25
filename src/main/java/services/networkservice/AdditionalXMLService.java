package services.networkservice;

import models.networks.VehType;
import org.dom4j.Document;
import utils.XMLUtils;

import java.util.List;

public class AdditionalXMLService {

    public static void createAdditionalXML(String filePath, List<VehType> vehTypes) {
        Document document = new AdditionalXMLDOMBuilder().addVehTypes(vehTypes).build();
        XMLUtils.WriteXML(filePath, document);
    }
}

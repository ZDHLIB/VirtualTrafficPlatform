package services.networkservice;

import models.networks.VehType;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdditionalXMLDOMBuilder {
    private Document document;
    private Element root;
    private Set<String> vehTypeIds = new HashSet<>();

    public AdditionalXMLDOMBuilder() {
        document = DocumentHelper.createDocument();
        root = document.addElement("additional");
    }

    public AdditionalXMLDOMBuilder addVehTypes(List<VehType> vehTypes) {
        vehTypes.forEach(vehType -> {
            if(!vehTypeIds.contains(vehType.getId())){
                vehTypeIds.add(vehType.getId());
                root.addElement("vType")
                    .addAttribute("id", vehType.getId())
                    .addAttribute("accel", String.valueOf(vehType.getAccel()))
                    .addAttribute("decel", String.valueOf(vehType.getDecel()))
                    .addAttribute("sigma", String.valueOf(vehType.getSigma()))
                    .addAttribute("length", String.valueOf(vehType.getLength()))
                    .addAttribute("minGap", String.valueOf(vehType.getMinGap()))
                    .addAttribute("maxSpeed", String.valueOf(vehType.getMaxSpeed()))
                    .addAttribute("vClass", vehType.getVehicleClass().getName())
                    .addAttribute("carFollowModel", vehType.getCarFollowModel());
            }
        });
        return this;
    }

    public Document build() {
        return document;
    }
}

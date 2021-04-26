package services.demandservice.flowservice;

import models.vehdemands.VehFlow;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;

public class VehDemandFlowNumStrategy implements IVehDemandFlowStrategy {
    @Override
    public Document createVehDemandDocument(List<VehFlow> vehFlows) {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("routes")
                               .addAttribute("xmlns:xsi", xmlSchema)
                               .addAttribute("xsi:noNamespaceSchemaLocation", xmlSchemaNoTargetNamespace);

        vehFlows.forEach(vehFlow -> {
            if(vehFlow.getVehsPerHour() >= 0) {
                String to = vehFlow.getTo();
                Element flowElement = root.addElement("flow");
                flowElement.addElement("flow")
                           .addAttribute("id", vehFlow.getId())
                           .addAttribute("type", vehFlow.getVehTypeId())
                           .addAttribute("from", vehFlow.getFrom())
                           .addAttribute("begin", String.valueOf(vehFlow.getBegin()))
                           .addAttribute("end", String.valueOf(vehFlow.getEnd()))
                           .addAttribute("departSpeed", vehFlow.getDepartSpeed())
                           .addAttribute("departLane", vehFlow.getDepartLane())
                           .addAttribute("departPos",String.valueOf(vehFlow.getDepartPos()))
                           .addAttribute("vehsPerHour", String.valueOf(vehFlow.getVehsPerHour()));

                if(to != null && !to.isBlank()){
                    flowElement.addAttribute("to", to);
                }
            }

        });

        return document;
    }
}

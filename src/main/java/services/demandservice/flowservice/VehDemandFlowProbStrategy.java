package services.demandservice.flowservice;

import models.vehdemands.VehFlow;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;

public class VehDemandFlowProbStrategy implements IVehDemandFlowStrategy {
    @Override
    public Document createVehDemandDocument(List<VehFlow> vehFlows) {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("routes")
                               .addAttribute("xmlns:xsi", xmlSchema)
                               .addAttribute("xsi:noNamespaceSchemaLocation", xmlSchemaNoTargetNamespace);

        vehFlows.forEach(vehFlow -> {
            if(vehFlow.getProbability() >= 0 && vehFlow.getProbability() <= 1){
                root.addElement("flow")
                    .addAttribute("id", vehFlow.getId())
                    .addAttribute("type", vehFlow.getVehTypeId())
                    .addAttribute("from", vehFlow.getFrom())
                    .addAttribute("begin", String.valueOf(vehFlow.getBegin()))
                    .addAttribute("end", String.valueOf(vehFlow.getEnd()))
                    .addAttribute("departSpeed", vehFlow.getDepartSpeed())
                    .addAttribute("departLane", vehFlow.getDepartLane())
                    .addAttribute("departPos",String.valueOf(vehFlow.getDepartPos()))
                    .addAttribute("to", vehFlow.getTo())  // optional
                    .addAttribute("probability", String.valueOf(vehFlow.getProbability()));
            }
        });

        return document;
    }
}
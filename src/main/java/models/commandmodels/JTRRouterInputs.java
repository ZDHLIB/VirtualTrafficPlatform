package models.commandmodels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JTRRouterInputs implements ICommandInputs {
    private String outputFilePath;
    private String netFilePath;
    private String additionalFilePath;
    private String routeFilePath;
    private String vtypeOutputFilePath;
    private String turnRatioFilePath;
    private String acceptAllDestinations = "false";
    private String turnRatioDefaults = "30,50,20";

    @Override
    public String createCommandInputs() {
        StringBuilder sb = new StringBuilder();
        sb.append(" --output-file ").append(outputFilePath)
                .append(" --net-file ").append(netFilePath)
                .append(" --route-files ").append(routeFilePath)
                .append(" --vtype-output ").append(vtypeOutputFilePath)
                .append(" --additional-files ").append(additionalFilePath)
                .append(" --accept-all-destinations ").append(acceptAllDestinations);

        if(turnRatioFilePath != null && !turnRatioFilePath.isBlank()) {
            sb.append(" --turn-ratio-files ").append(turnRatioFilePath);
        } else {
            sb.append(" --turn-defaults ").append(turnRatioDefaults);
        }
        return sb.toString();
    }
}

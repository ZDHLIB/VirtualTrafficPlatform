package models.vehdemands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehFlow {
    private String id;
    private String vehTypeId;
    private String from;
    private String to;
    private String departSpeed;
    private String departLane;
    private Double departPos;
    private Double begin = 0.0;
    private Double end = 3600.0;
    private Integer vehsPerHour = 1;
    private Double period = 1.0;
    private Double probability = 0.1;
    private Integer number = 1;
}

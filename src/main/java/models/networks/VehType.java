package models.networks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.enums.VehicleClassEnum;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehType {
    private String id;
    private Double accel = 2.6;
    private Double decel = 4.5;
    private Double sigma = 0.5;
    private Double length = 5.0;
    private Double minGap = 2.5;
    private Double maxSpeed = 13.8;
    private VehicleClassEnum vehicleClass = VehicleClassEnum.PASSENGER;
    private String carFollowModel = "Krauss";
}

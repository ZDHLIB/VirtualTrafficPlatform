package models.networks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lane {
    private String id;
    private String index;
    private Double speed;
    private Double length;
}

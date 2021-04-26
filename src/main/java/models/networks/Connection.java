package models.networks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Connection {
    private String from;
    private String to;
    private String fromLane;
    private String toLane;
}

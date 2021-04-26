package models.networks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Edge {
    private String id;
    private String from;
    private String to;
    private Integer priority = -1;
    private HashMap<String, Lane> laneHashMap;
}

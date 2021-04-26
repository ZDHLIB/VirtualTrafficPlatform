package models.networks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Net {
    private String id;
    private HashMap<String, Edge> edgeHashMap;
    private HashMap<String, Junction> junctionHashMap;
    private HashMap<String, Connection> connectionHashMap;
}

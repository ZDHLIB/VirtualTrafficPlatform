package models.enums;

public enum VehDemandFlowEnum {
    PROBABILITY(0, "PROBABILITY"),
    VEHSPERHOUR(1, "VEHSPERHOUR"),
    PERIOD(2, "PERIOD");

    private final int index;
    private final String name;

    VehDemandFlowEnum(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VehicleDemandFlowTypes {").append("index:").append(this.index).append(",")
                .append("name:").append(this.name).append("}");
        return sb.toString();
    }

}

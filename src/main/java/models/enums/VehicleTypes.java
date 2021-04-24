package models.enums;

public enum VehicleTypes {
    CAR(0, "Car");

    private final int index;
    private final String name;

    VehicleTypes(Integer index, String name) {
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
        sb.append("VehicleTypes {").append("index:").append(this.index).append(",")
                .append("name:").append(this.name).append("}");
        return sb.toString();
    }

}

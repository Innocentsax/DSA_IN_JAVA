package dev.Innocent.Section7.OOPPart1;

public class Animals {
    private String type;
    private String size;
    private double weight;

    public Animals(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public Animals() {
    }

    @Override
    public String toString() {
        return "Animals{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                '}';
    }
}

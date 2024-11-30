package dev.Innocent.Section7.ArrayAndArrayList;

enum UtilityType{ELECTRICAL, FIBER_OPTIC, GAS, WATER}

public class UtilityLine implements Mappable{
    private String name;
    private UtilityType utilityType;

    public UtilityLine(String name, UtilityType utilityType) {
        this.name = name;
        this.utilityType = utilityType;
    }

    @Override
    public String getLabel() {
        return name + " (" + utilityType + ")";
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
    }

    @Override
    public String getMarker() {
        return switch (utilityType){
            case ELECTRICAL -> Color.RED + " " + LineMaker.DASHED;
            case FIBER_OPTIC -> Color.GREEN + " " + LineMaker.DOTTED;
            case GAS-> Color.ORANGE + " " + LineMaker.SOLID;
            case WATER -> Color.BLUE + " " + LineMaker.SOLID;
            default -> Color.BLACK + " " + LineMaker.SOLID;
        };
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                , "name": "%s", "Utility": "%s" """.formatted(name, utilityType);
    }
}

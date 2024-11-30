package dev.Innocent.Section7.ArrayAndArrayList;

import java.util.ArrayList;
import java.util.List;

enum UsageType{ENTERTAINMENT, GOVERNMENT, RESIDENTIAL, SPORT}

public class Building implements Mappable{
    private String name;
    private UsageType usage;

    public Building(String name, UsageType usage) {
        this.name = name;
        this.usage = usage;
    }

    @Override
    public String getLabel() {
        return name + " (" + usage + ")";
    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }

    @Override
    public String getMarker() {
        return switch (usage){
            case ENTERTAINMENT -> Color.GREEN + " " + PointerMarker.TRIANGLE;
            case GOVERNMENT -> Color.RED + " " + PointerMarker.STAR;
            case RESIDENTIAL -> Color.BLUE + " " + PointerMarker.SQUARE;
            case SPORT -> Color.ORANGE + " " + PointerMarker.PUSH_PIN;
            default -> Color.BLACK + " " + PointerMarker.CIRCLE;
        };
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                , "name": "%s", "usage": "%s" """.formatted(name, usage);
    }

    public static void main(String[] args) {
        List<Mappable> mappable = new ArrayList<>();
        mappable.add(new Building("M Vertica", UsageType.ENTERTAINMENT));
        mappable.add(new Building("AirBnb", UsageType.RESIDENTIAL));


        mappable.add(new UtilityLine("Internet", UtilityType.FIBER_OPTIC));
        mappable.add(new UtilityLine("House rent", UtilityType.ELECTRICAL));
        for(var m : mappable){
            Mappable.mapIt(m);
        }
    }
}

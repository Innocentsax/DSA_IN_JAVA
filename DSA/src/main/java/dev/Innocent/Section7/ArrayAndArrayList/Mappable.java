package dev.Innocent.Section7.ArrayAndArrayList;

enum Geometry{LINE, POINT, POLYGON}
enum Color{BLACK, BLUE, GREEN, ORANGE, RED}
enum PointerMarker{CIRCLE, PUSH_PIN, STAR, SQUARE, TRIANGLE}
enum LineMaker{DASHED, DOTTED, SOLID}

public interface Mappable {
    String JSON_PROPERTY = """
            "property": {%s}""";

    String getLabel();
    Geometry getShape();
    String getMarker();

    default String toJSON(){
        return """
                "type": "%s", "label" : "%s" : "maker" : "%s" """
                .formatted(getShape(), getLabel(), getMarker());
    }

    static void mapIt(Mappable mappable){
        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }
}

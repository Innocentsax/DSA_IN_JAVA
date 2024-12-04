package dev.Innocent.Section7.Generics;

import java.util.Arrays;

public interface Mappable {
    void render();


    static double[] stringToLatLon(String location){
        var splits = location.split(",");
        double lat = Double.valueOf(splits[0]);
        double lng = Double.valueOf(splits[1]);
        return new double[]{lat, lng};
    }

}

abstract class Point implements Mappable{
    private double[] location = new double[2];

    public Point(String location){
        this.location = Mappable.stringToLatLon(location);
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as POINT (" + location() + ")");
    }

    private String location() {
        return Arrays.toString(location);
    }
}

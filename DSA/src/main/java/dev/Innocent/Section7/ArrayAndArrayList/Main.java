package dev.Innocent.Section7.ArrayAndArrayList;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Bird bird = new Bird();
        Animals animals = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

        animals.move();
        inFlight(flier);
        inFlight(new Jet());

        Trackable truck = new Truck();
        truck.track();

        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * FlightEnabled.KM_TO_MILE;
        System.out.printf("The truck traveled %.2f km or %.2f miles%n", kmsTraveled, milesTraveled);

        List<FlightEnabled> flies = new ArrayList<>();
        flies.add(bird);

        triggerFlier(flies);
        flyFlier(flies);
        landFlier(flies);
    }

    private static void inFlight(FlightEnabled flies){
        flies.takeOff();
        flies.fly();
        if(flies instanceof Trackable tracked){
            tracked.track();
        }
        flies.land();
    }

    private static void triggerFlier(List<FlightEnabled> fliers){
        for(var m : fliers){
            m.takeOff();
        }
    }

    private static void flyFlier(List<FlightEnabled> fliers){
        for(var m : fliers){
            m.fly();
        }
    }

    private static void landFlier(List<FlightEnabled> fliers){
        for(var m : fliers){
            m.land();
        }
    }
}

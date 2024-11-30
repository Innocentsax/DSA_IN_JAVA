package dev.Innocent.Section7.ArrayAndArrayList;

public class Test {
    public static void main(String[] args) {

        Orbit(new Satellite());
    }

    private static void inFlight(FlightEnabled flies){
        flies.takeOff();
        flies.fly();
        flies.transition(FlightStage.LAUNCH);
        if(flies instanceof Trackable tracked){
            tracked.track();
        }
        flies.land();
    }

    private static void Orbit(OrbitEarth flies){
        flies.takeOff();
        flies.fly();
        flies.land();
    }
}

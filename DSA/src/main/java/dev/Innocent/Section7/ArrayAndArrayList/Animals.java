package dev.Innocent.Section7.ArrayAndArrayList;


import java.util.Date;

enum FlightStage implements Trackable{
    GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {
        if(this == GROUNDED){
            System.out.println("Monitoring " + this);
        }
    }

    public FlightStage getNextStage(){
        FlightStage[] allStages = values();
        return allStages[(ordinal() + 1) % allStages.length];
    }
}

record DragonFly() implements FlightEnabled{

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}


class Satellite implements OrbitEarth{

    FlightStage stage = FlightStage.GROUNDED;

    @Override
    public void achieveOrbit() {
        transition("Orbit achieved");
    }

    @Override
    public void takeOff() {
        transition("taking off");
    }

    @Override
    public void land() {
        transition("Landing");
    }

    @Override
    public void fly() {
        achieveOrbit();
        transition("Data collection with Orbiting");
    }

    public void transition(String description){
        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }
}

interface OrbitEarth extends FlightEnabled{
    void achieveOrbit();

    static void log(String description){
        var today = new Date();
        System.out.println(today + ": " + description);
    }

    private void logStage(FlightStage stage, String description){
        description = stage + ": " + description;
        log(description);
    }

    @Override
    default FlightStage transition(FlightStage stage) {
        FlightStage nextStage = FlightEnabled.super.transition(stage);
        logStage(stage, "Beginning transition to " + nextStage);
        return nextStage;
    }
}

interface FlightEnabled{

    double MILE_TO_KM = 1.60934;
    double KM_TO_MILE = 0.621371;
    void takeOff();
    void land();
    void fly();

    default FlightStage transition(FlightStage stage){
        FlightStage nextStage = stage.getNextStage();
        System.out.println("Transitioning " + stage + " to " + nextStage);
        return nextStage;
    }
}

interface Trackable{
    void track();
}

public abstract class Animals {
    public abstract void move();
}



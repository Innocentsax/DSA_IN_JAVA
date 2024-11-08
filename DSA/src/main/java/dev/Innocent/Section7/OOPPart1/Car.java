package dev.Innocent.Section7.OOPPart1;

public class Car {
    private boolean engine = true;
    private int cylinders;
    private String name;
    private int wheel = 4;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
    }

    public void startEngine(){
        System.out.println("The car's engine is starting " + name);
    }

    public void accelerate(){
        System.out.println("Car is accelerating " + name);
    }

    public void brake(){
        System.out.println("Car is braking " + name);
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
}
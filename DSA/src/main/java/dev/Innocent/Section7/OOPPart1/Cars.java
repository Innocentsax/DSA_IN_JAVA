package dev.Innocent.Section7.OOPPart1;

public class Cars {
    private String description;

    public Cars(String description) {
        this.description = description;
    }

    public void startEngine(){
        System.out.println("Car -> startEngine");
    }

    public void drive(){
        System.out.println("Car -> driving, type is " + getClass().getSimpleName());
        runEngine();
    }

    protected void runEngine(){
        System.out.println("Car -> runEngine");
    }
}

class GasPoweredCars extends Cars {
    private double avgKmPerLiter;
    private int cylinder;

    public GasPoweredCars(String description) {
        super(description);
    }

    public GasPoweredCars(String description, double avgKmPerLiter, int cylinder) {
        super(description);
        this.avgKmPerLiter = avgKmPerLiter;
        this.cylinder = cylinder;
    }

    @Override
    public void startEngine() {
        System.out.printf("Gas -> All %d cylinder are fired up, Ready!%n", cylinder);
    }

    @Override
    protected void runEngine() {
        System.out.printf("Gas -> All %d cylinder are fired up, Ready!%n", avgKmPerLiter);
    }
}

class ElectricCar{
    private double avgKmPerCharge;
    private int batterySize;
}

class HybridCar{
    private double avgKmPerLiter;
    private int batterySize;
    private int cylinder;
}

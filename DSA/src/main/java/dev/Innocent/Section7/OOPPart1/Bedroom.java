package dev.Innocent.Section7.OOPPart1;

public class Bedroom {
    private String name;
    private Walls wall1, wall2, wall3, wall4;
    private Ceiling ceiling;
    private Bed bed;
    private Lamp lamp;

    public Bedroom(String name, Walls wall1, Walls wall2, Walls wall3, Walls wall4,
                   Ceiling ceiling, Bed bed, Lamp lamp) {
        this.name = name;
        this.wall1 = wall1;
        this.wall2 = wall2;
        this.wall3 = wall3;
        this.wall4 = wall4;
        this.ceiling = ceiling;
        this.bed = bed;
        this.lamp = lamp;
    }

    public Lamp getLamp() {
        return lamp;
    }

    public void makeBed(){
        System.out.print("Bedroom -> Making bed | ");
        bed.make();
    }
}
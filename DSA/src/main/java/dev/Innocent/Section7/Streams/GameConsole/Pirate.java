package dev.Innocent.Section7.Streams.GameConsole;

import java.util.*;

public class Pirate implements Player{

    private final String name;
    private final Map<String, Integer> gameData;
    private final List<String> townsVisited = new LinkedList<>();
    private Weapon currentWeapon;

    public Pirate(String name) {
        this.name = name;
    }

    //-----------------------------------------------------------
    {
        gameData = new HashMap<>(Map.of(
                "health", 100,
                "score", 0,
                "level", 0,
                "townIndex", 0
        ));
        visitTown();
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    int value(String name){
        return gameData.get(name);
    }

    private void setValue(String name, int value){
        gameData.put(name, value);
    }

    private void adjustValue(String name, int adj){
        gameData.compute(name, (k, v) -> v += adj);
    }

    private void adjustHealth(int adj){
        int health = value("health");
        health += adj;
        health = (health < 0) ? 0 : ((health > 100) ? 100 : health);
        setValue("health", health);
    }

    boolean useWeapon(){
        System.out.println("Used the " + currentWeapon);
        return false;
    }

    boolean visitTown(){
        String town = "My Town, somewhere";
        if(town != null){
            townsVisited.add(town);
            return false;
        }
        return true;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String toString() {
        var current = ((LinkedList<String>) townsVisited).getLast();
        String[] simpleNames = new String[townsVisited.size()];
        Arrays.setAll(simpleNames, i -> townsVisited.get(i).split(",")[0]);
        return "----> " + current + "\nPirate " + name + " " + gameData + "\n\ttownsVisited="
                + Arrays.toString(simpleNames);
    }
}

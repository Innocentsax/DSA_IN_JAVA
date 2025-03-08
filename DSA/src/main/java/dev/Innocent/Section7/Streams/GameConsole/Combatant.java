package dev.Innocent.Section7.Streams.GameConsole;

import java.util.*;

public sealed abstract class Combatant implements Player permits Pirate {

    private final String name;
    private final Map<String, Integer> gameData;
    private Weapon currentWeapon;

    public Combatant(String name) {
        this.name = name;
    }

    public Combatant(String name, Map<String, Integer> gameData) {
        this.name = name;
        if(gameData != null){
            this.gameData.putAll(gameData);
        }
    }

    //-----------------------------------------------------------
    {
        gameData = new HashMap<>(Map.of(
                "health", 100,
                "score", 0
        ));
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

    protected void setValue(String name, int value){
        gameData.put(name, value);
    }

    protected void adjustValue(String name, int adj){
        gameData.compute(name, (k, v) -> v += adj);
    }

    private void adjustHealth(int adj){
        int health = value("health");
        health += adj;
        health = (health < 0) ? 0 : ((health > 100) ? 100 : health);
        setValue("health", health);
    }

    boolean useWeapon(Combatant opponent){
        System.out.println(name + " used the " + currentWeapon);
        if(new Random().nextBoolean()){
            System.out.println(" and HIT ***" + opponent.name + "! ***");
            opponent.adjustHealth(-currentWeapon.getHitPoints());
            System.out.printf("%s's health=%d, %s's health=%d%n",
                    name, value("health"),
                    opponent.name(), opponent.value("health"));
            adjustValue("score", 50);
        }else{
            System.out.println(" and missed!");
        }
        return (opponent.value("health") <= 0);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String information(){
        return name + " " + gameData;
    }
}

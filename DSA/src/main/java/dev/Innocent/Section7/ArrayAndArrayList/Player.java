package dev.Innocent.Section7.ArrayAndArrayList;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable{
    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public List<String> write() {
        List<String> note = new ArrayList<>();
        note.add(this.name);
        note.add(String.valueOf(this.strength));
        note.add(String.valueOf(this.hitPoints));
        note.add(this.weapon);
        return note;
    }

    @Override
    public void read(List<String> contain) {
        if(contain != null && contain.size() > 0){
            this.name = contain.get(0);
            this.hitPoints = Integer.parseInt(contain.get(1));
            this.strength = Integer.parseInt(contain.get(2));
            this.weapon = contain.get(3);
        }
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', hitPoints=" + hitPoints + ", strength=" + strength + ", weapon='" + weapon + "'}";
    }
}
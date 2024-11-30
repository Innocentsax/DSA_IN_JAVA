package dev.Innocent.Section7.ArrayAndArrayList;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable{
    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public List<String> write() {
        List<String> contains = new ArrayList<>();
        contains.add(this.name);
        contains.add(String.valueOf(this.hitPoints));
        contains.add(String.valueOf(this.strength));
        return contains;
    }

    @Override
    public void read(List<String> contain) {
        if(contain != null && contain.size() > 0){
            this.name = contain.get(0);
            this.hitPoints = Integer.parseInt(contain.get(1));
            this.strength = Integer.parseInt(contain.get(2));
        }
    }

    @Override
    public String toString() {
        return "Monster{name='" + name + "', hitPoints=" + hitPoints + ", strength=" + strength + "}";
    }

    public static void main(String[] args) {
        Player player = new Player("Tim", 10, 15);
        System.out.println(player);

        List<String> playerData = player.write();
        System.out.println("Player data saved: " + playerData);

        Player loadedPlayer = new Player("Default", 0, 0);
        loadedPlayer.read(playerData);
        System.out.println("Loaded player: " + loadedPlayer);

        Monster monster = new Monster("Werewolf", 20, 40);
        System.out.println(monster);

        List<String> monsterData = monster.write();
        System.out.println("Monster data saved: " + monsterData);

        Monster loadedMonster = new Monster("Default", 0, 0);
        loadedMonster.read(monsterData);
        System.out.println("Loaded monster: " + loadedMonster);
    }
}
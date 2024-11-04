package dev.Innocent.Section7.OOPPart1;

public class EnhancedPlayer {
    private String name;
    private int health;
    private String weapon;

    public EnhancedPlayer(String name) {
        this.name = name;
    }

    public EnhancedPlayer(String name, int health, String weapon) {
        this.name = name;
        if(health <= 0){
            this.health = 1;
        }else if(health > 100){
            this.health = 100;
        }else{
            this.health = health;
        }
        this.weapon = weapon;
    }
}

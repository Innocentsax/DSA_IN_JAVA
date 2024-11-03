package dev.Innocent.Section7.OOPPart1;

public class Player {
    private String name;
    private int health;
    private String weapon;

    private void loseHealth(int damage){
        health = health - damage;
        if(health < 0){
            System.out.println("Player knocked out of the game");
        }
    }

    public int healthRemaining(){
        return health;
    }

    public void restoreHealth(int extraHealth){
        health = health + extraHealth;
        if(health > 100){
            System.out.println("Player restored to 100%");
            health = 100;
        }
    }
}

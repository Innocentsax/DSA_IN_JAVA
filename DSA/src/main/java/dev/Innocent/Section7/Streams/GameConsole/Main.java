package dev.Innocent.Section7.Streams.GameConsole;

public class Main {
    public static void main(String[] args) {
//        var console = new GameConsole<>(new ShooterGame("The Shootout Game"));
//
//        int playerIndex = console.addPlayer();
//        console.playGame(playerIndex);

        Weapon weapon = Weapon.getWeaponByChar('P');
        System.out.println("weapon = " + weapon + ", hitPoints" +
                weapon.getHitPoints() + ", minLevel = " + weapon.getMinLevel());

        var list = Weapon.getWeaponsByLevel(1);
        list.forEach(System.out::println);

        Pirate Inno = new Pirate("Innocent");
        System.out.println(Inno);

        PirateGame.getTowns(0).forEach(System.out::println);
        System.out.println("-----------------------------------------");
        PirateGame.getTowns(1).forEach(System.out::println);
    }
}

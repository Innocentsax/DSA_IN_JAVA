package dev.Innocent.Section7.Streams.GameConsole;

public class Main {
    public static void main(String[] args) {
        var console = new GameConsole<>(new ShooterGame("The Shootout Game"));

        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);
    }
}

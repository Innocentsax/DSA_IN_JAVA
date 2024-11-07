package dev.Innocent.Section7.OOPPart1;

public class Main {
    public static void main(String[] args) {
//        BankAccount bank = new BankAccount(2120100314, 4000,
//                "Innocent Udo", "innocentcharlesudo@gmail.com", "+60-179549917");
//
//        BankAccount newBank = new BankAccount(1234566, 6000, "Innocent", "08167876543",
//                "oiuytgfrds0987654");
//
//        bank.depositFunds(2000);
//        bank.withdrawFunds(100.00);
//        bank.withdrawFunds(200.00);
//
//        for (int i = 1; i <= 5; i++) {
//            LPStudent newStudent = new LPStudent("123er" + i,
//                    switch (i) {
//                        case 1 -> "Mary";
//                        case 2 -> "Henry";
//                        case 3 -> "Bit";
//                        case 4 -> "Epin";
//                        case 5 -> "King";
//                        default -> "Unknown";
//                    },
//                    "1996","I.T hard");
//
//            System.out.println(newStudent);
//        }
//        Wall newWall = new Wall(5, 4);
//        System.out.println("Area " + newWall.getArea());

        Cars car = new Cars("Killer car");
        runRace(car);
    }

    public static void runRace(Cars car){
        car.startEngine();
        car.drive();
    }
}

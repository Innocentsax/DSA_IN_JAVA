package dev.Innocent.Section7.Streams;

import java.util.Random;

public class Child extends Parent {

    private final int birthOrder = getBirthOrder();
    private final String birthOrderString;

    {
        if(siblings == 0){
            birthOrderString = "Only";
        } else if (birthOrder == 1) {
            birthOrderString = "Last";
        } else if (birthOrder == (siblings + 1)) {
            birthOrderString = "Last";
        }else {
            birthOrderString = "Middle";
        }
    }

    private final int getBirthOrder(){
        if(siblings == 0) return 1;
        return new Random().nextInt(1, siblings + 2);
    }
}

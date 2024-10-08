package dev.Innocent.Section5.KeywordsAndExpression;

public class FlourPacker {
    public static void main(String[] args) {
        System.out.println(canPack(0,5,4));
    }
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }
        int bigKilo = bigCount * 5;
        int totalKilo = bigKilo + smallCount;

        if(totalKilo < goal){
            return false;
        }

        if(goal % 5 <= smallCount && goal <= totalKilo){
            return true;
        }
        return false;
    }
}
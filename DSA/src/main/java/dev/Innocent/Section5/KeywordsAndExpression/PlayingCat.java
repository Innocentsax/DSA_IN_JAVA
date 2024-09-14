package dev.Innocent.Section5.KeywordsAndExpression;

public class PlayingCat {
    public static boolean isCatPlaying(boolean summer, int temperature){
        if(!summer && temperature >= 25 && temperature <= 35){
            return true;
        }else if(summer && (temperature > 24 && temperature < 46)){
            return true;
        }
        return false;
    }
}
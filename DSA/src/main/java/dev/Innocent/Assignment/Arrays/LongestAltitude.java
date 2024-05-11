package dev.Innocent.Assignment.Arrays;

class LongestAltitude {
    public static void main(String[] args) {
        int[] gain = {-5,1,5,0,-7};
        System.out.println(largestAltitude1(gain));
    }
    public static int largestAltitude(int[] gain) {
        int altitude = gain[0];
        for (int i = 0; i < gain.length; i++) {
            if(gain[i] > altitude){
                altitude = gain[i];
            }
        }
        return altitude;
    }
    public static int largestAltitude1(int[] gain) {
        int altitude = 0;
        int currentPosition = 0; // Index position
        for (int i = 0; i < gain.length; i++) {
            currentPosition = currentPosition + gain[i]; // index 0 + the first number in the array
            altitude = Math.max(currentPosition, altitude);
//            altitude = maxilla(currentPosition, altitude);
        }
        return altitude;
    }

    // Not correct
    public static int maxilla(int currentPosition, int altitude){
        if(currentPosition > altitude){
            return altitude;
        }
        return currentPosition;
    }
}
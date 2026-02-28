package dev.Innocent.LeetCode.Arrays;

public class Encrypter {

    public static void main(String[] args) {
        String name = "ate Winslet";
//        System.out.println(getEncryptedName(name));
        System.out.println(rev2(name));
    }

    public static boolean validate(String name){
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);

            if(ch != ' ' && !(Character.isLowerCase(ch)) || (Character.isUpperCase(ch))){
                return false;
            }
        }
        return true;
    }

    public static String getEncryptedName(String name){
        if(validate(name)){
            StringBuilder bul = new StringBuilder(name).reverse();
            return bul.toString().toLowerCase();
        }else {
            throw new IllegalArgumentException("Try again");
        }
    }

    // Reverse an array of Character
    public static String rev(String name){
        StringBuilder rep = new StringBuilder();
        for (int i = name.length() - 1; i >= 0 ; i--) {
            rep.append(name.charAt(i));
        }
        return rep.toString();
    }

    public static String rev2(String name){
        int start = 0;
        int end = name.length() -1;
        char[] conv = name.toCharArray();
        while (start < end){
            char temp = conv[start];
            conv[start] = conv[end];
            conv[end] = temp;
            start++;
            end--;
        }
        return new String(conv);
    }
}

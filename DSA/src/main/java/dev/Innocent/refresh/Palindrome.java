package dev.Innocent.refresh;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(pal1("aba"));
    }

    private static boolean palindrome(String value){
        char[] a = value.toCharArray();
        int start = 0;
        int end = value.length() - 1;

        while (start < end){
            if(a[start] != a[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean pal(String a){
        char[] keep = a.toCharArray();
        int b = 0;
        int c = a.length() - 1;

        while (b < c){
            if(keep[b] != keep[c]){
                return false;
            }
            b++;
            c--;
        }
        return true;
    }

    public static boolean pal1(String s){
        int a = 0;
        int b = s.length() - 1;

        while (a < b){
            if(s.charAt(a) != s.charAt(b)){
                return false;
            }
            a++;
            b--;
        }
        return true;
    }
}

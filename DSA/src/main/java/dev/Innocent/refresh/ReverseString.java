package dev.Innocent.refresh;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse("Tina"));
    }

    public static String reverse(String s) {
        if (s == null) return null;
        char[] a = s.toCharArray();
        int i = 0, j = a.length - 1;
        while (i < j) {
            char tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++; j--;
        }
        return new String(a);
    }
}

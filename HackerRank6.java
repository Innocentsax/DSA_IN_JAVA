import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner sc =new Scanner(System.in);
    int T = sc.nextInt();
    for(int i=0;i<T;i++)
    {
        String S = sc.next();
        for(int j=0;j<S.length();j++)
        {
            if(j%2==0)
            System.out.print(S.charAt(j));
        }
        System.out.print(" ");
        for(int j=0;j<S.length();j++)
        {
            if(j%2!=0)
            System.out.print(S.charAt(j));
        }
        System.out.println();
           }
           sc.close();
    }

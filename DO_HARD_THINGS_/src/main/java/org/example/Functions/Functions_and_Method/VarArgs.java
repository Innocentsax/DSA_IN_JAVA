package org.example.Functions.Functions_and_Method;

import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
        fun();

        multiple(12, 45, "Innocent", "Charles", "Udo");
    }

    static void fun(int ...innocent){
        System.out.println(Arrays.toString(innocent));
    }

    static  void multiple(int a, int b, String ...v){

    }
}

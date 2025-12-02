package dev.Innocent.refresh;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("() [] {}"));
    }

    public static boolean isValid(String s){
        if(s == null) return false;

        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            } else if (pairs.containsKey(ch)) {
                if(stack.isEmpty() || stack.pop() != pairs.get(ch)){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}

package dev.Innocent.refresh;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("() [] {}"));
        System.out.println(isValid("(}"));
        System.out.println(isValid("{}"));
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

    public static boolean isValid1(String s) {
        Map<Character, Character> map = Map.of(')', '(', '}', '{', ']', '[');
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsValue(c)) st.push(c);
            else if (map.containsKey(c)) {
                if (st.isEmpty() || st.pop() != map.get(c)) return false;
            }
        }
        return st.isEmpty();
    }
}

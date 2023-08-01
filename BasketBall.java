/*
Baseball Game

You are keeping score for a baseball game with strange rules. The game consists of several rounds, where

the scores of past rounds may affect future rounds' scores.

At the beginning of the game, you start with an empty record. You are given a list of strings ops

where ops[i] is the ith operation you must apply to the record and is one of the following.

0. An integer x -Record a new score of x

0. "4"-Record a new score that is the sum of the previous two scores. It is guaranteed there will

always be two previous scores.

0. "p" -Record a new score that is double the previous score. It is guaranteed there will always be a

previous score.

0. "c" - Invalidate the previous score, removing it from the record. It is guaranteed there will always be

a previous score.

Return the sum of all the scores on the record. */

import java.util.Stack;

public class BaseballGame {
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for (String op : ops) {
            if (op.equals("C")) {
                // Remove the last score from the record (invalidating the previous score)
                stack.pop();
            } else if (op.equals("D")) {
                // Double the last score and add it to the record
                int lastScore = stack.peek();
                stack.push(lastScore * 2);
            } else if (op.equals("+")) {
                // Add the sum of the last two scores to the record
                int lastScore = stack.pop();
                int secondLastScore = stack.peek();
                stack.push(lastScore);
                stack.push(lastScore + secondLastScore);
            } else {
                // Record a new score (integer value) to the record
                int score = Integer.parseInt(op);
                stack.push(score);
            }
        }

        // Calculate the sum of all the scores in the record
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    public static void main(String[] args) {
        String[] ops1 = {"5", "2", "C", "D", "+"};
        System.out.println(calPoints(ops1)); // Output: 30

        String[] ops2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(calPoints(ops2)); // Output: 27
    }
}

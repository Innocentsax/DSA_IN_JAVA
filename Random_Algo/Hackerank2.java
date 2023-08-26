import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function accepts following parameters:
     *  1. DOUBLE meal_cost
     *  2. INTEGER tip_percent
     *  3. INTEGER tax_percent
     */

    //public static void solve(double meal_cost, int tip_percent, int tax_percent) {
    // Write your code here
    public static void solve(double meal_cost, int tip_percent, int tax_percent) {
       double tip, tax, total_cost;
        tip = meal_cost * tip_percent/100;
        tax = tax_percent * meal_cost/100 ;
        total_cost = meal_cost + tip + tax;
        int round = (int) Math.round(total_cost);
        System.out.println(round);
        
    }


}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        double meal_cost = Double.parseDouble(bufferedReader.readLine().trim());

        int tip_percent = Integer.parseInt(bufferedReader.readLine().trim());

        int tax_percent = Integer.parseInt(bufferedReader.readLine().trim());

        Result.solve(meal_cost, tip_percent, tax_percent);.

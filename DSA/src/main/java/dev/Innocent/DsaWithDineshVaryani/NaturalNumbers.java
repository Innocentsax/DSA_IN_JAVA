package dev.Innocent.DsaWithDineshVaryani;

// Find the Sum of the first n natural number
public class NaturalNumbers {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        NaturalNumbers checkTimeComplexity = new NaturalNumbers();
        System.out.println(checkTimeComplexity.findSum(99999));

        System.out.println("Time taken ==> " + (System.currentTimeMillis() - now) + " milliseconds");
    }

    // Solution 1
    public int findSum(int n){
        return n * (n + 1)/2;
    }

    // Solution 2
    public int findSum1(int n){
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum +=i;
        }
        return sum;
    }
}

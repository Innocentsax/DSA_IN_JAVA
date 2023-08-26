import java.util.ArrayList;

/*
Write a function that counts how many different ways you can make change for an amount of money given an array of coin denominations. For example, there are 3 ways to give change for 4 if you have coins with denomination 1 and 2:

1+1+1+1, 1+1+2, 2+2.
The order of coins does not matter:

1+1+2 == 2+1+1
Also, assume that you have an infinite amount of coins.

Your function should take an amount to change and an array of unique denominations for the coins.*/
public class DSAweek5 {

   // public class Challenge {
        public static int countChange(int money, ArrayList<Integer> coins) {
            ArrayList<Integer> dp = new ArrayList<>(money + 1);
            dp.add(1);

            for (int i = 1; i <= money; i++) {
                dp.add(0);
            }

            for (int coin : coins) {
                for (int i = coin; i <= money; i++) {
                    dp.set(i, dp.get(i) + dp.get(i - coin));
                }
            }

            return dp.get(money);
        }


}

/*
Background
Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and carries the "instructions" for the development and functioning of living organisms.

If you want to know more http://en.wikipedia.org/wiki/DNA

DNA is created by two strands of nucleotides that are bonded together in complementary pairs. For each base on one side, there is an opposite base on the other side. There are 4 symbols used to represent the bases, A, T, C, and G.

Symbols A and T are complements of each other, as are C and G.

Task
You have function with one side of the DNA, you need to get the other complementary side. The DNA strand may be empty if there is no DNA at all. In this case, you can simple return the empty string.

Specification
Challenge.dnaComplement(dna)
Parameters
dna: String - DNA strand

Return Value
String - A new string generated by returning the complement of the input strand.

Constraints
It will always be a string, but it might be empty.

It will never be null/nil or undefined.*/

class Challenge {
    public static String dnaComplement(String dna) {
        StringBuilder cp = new StringBuilder();

        for (char match : dna.toCharArray()) {
            char complementBase = getComplement(match);
            cp.append(complementBase);
        }
        return cp.toString();
    }
    private static char getComplement(char match) {
        switch (match) {
            case 'A':
                return 'T';
            case 'T':
                return 'A';
            case 'C':
                return 'G';
            case 'G':
                return 'C';
            default:
                return match;
        }
    }
}
import java.util.ArrayList;

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

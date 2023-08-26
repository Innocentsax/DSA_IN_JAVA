import java.util.Arrays;
/**
Task:
Given an array of integers , Find the minimum sum which is obtained from summing each Two integers product .
*/

public class Solution
{
    public static int minSum(int[] passed) {
        Arrays.sort(passed);
        int sum = 0;
        for (int i = 0; i < passed.length / 2; i++) {
            sum += passed[i] * passed[passed.length - i - 1];
        }
        return sum;
    }
}

// TEST
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
import java.util.*;

public class MinimumSum {
    @Test
    public void basicTests()
    {
        assertEquals( 22, Solution.minSum(new int[]{5,4,2,3}));
        assertEquals(342, Solution.minSum(new int[]{12,6,10,26,3,24}));
        assertEquals( 74, Solution.minSum(new int[]{9,2,8,7,5,4,0,6}));
    }
}

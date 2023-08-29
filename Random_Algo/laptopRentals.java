/*
You're given a list of time intervals during which students at a school need a laptop. 
These time intervals are represented by pairs of integers [start, end], where 0 <= start < end. 
However, start and end don't represent real times; therefore, they may be greater than 24.

No two students can use a laptop at the same time, but immediately after a student is done using 
a laptop, another student can use that same laptop. For example, if one student rents a laptop 
during the time interval [0, 2], another student can rent the same laptop during any time interval starting with 2.

Write a function that returns the minimum number of laptops that the school needs to rent 
such that all students will always have access to a laptop when they need one.

Challenge.laptopRentals(times)
Parameters
times: List<Integer[]> - A 2D array containing the times the student would require a laptop.

Return Value
Integer - Minimum number of laptops the school needs to rent.

Examples
times	Return Value
[[0,2],[1,4],[4,6],[0,4],[7,8],[9,11],[3,10]]	3
[[0,4],[2,3],[2,3],[2,3]]	4
[[1,5],[5,6],[6,7],[7,9]]	1
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Challenge {
    public static Integer laptopRentals(List<List<Integer>> times) {
        if (times.isEmpty()) {
            return 0;
        }

        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();

        for (List<Integer> interval : times) {
            startTimes.add(interval.get(0));
            endTimes.add(interval.get(1));
        }

        startTimes.sort(null);
        endTimes.sort(null);

        int laptopsInUse = 0;
        int maxLaptops = 0;
        int startPtr = 0;
        int endPtr = 0;

        while (startPtr < startTimes.size()) {
            if (startTimes.get(startPtr) < endTimes.get(endPtr)) {
                laptopsInUse++;
                maxLaptops = Math.max(maxLaptops, laptopsInUse);
                startPtr++;
            } else {
                laptopsInUse--;
                endPtr++;
            }
        }

        return maxLaptops;
    }
}

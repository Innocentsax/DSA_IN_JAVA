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

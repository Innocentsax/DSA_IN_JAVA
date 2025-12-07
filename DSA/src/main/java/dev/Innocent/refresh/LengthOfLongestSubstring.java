package dev.Innocent.refresh;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, maxLen = 0;
        Set<Character> set = new HashSet<>();

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);

            // If duplicate, shrink window from the left
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

}

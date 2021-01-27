package String;

import java.util.Arrays;

public class Solution_395 {
    public int longestSubstring(String s, int k) {
        return longestSubstring(s, k, 0, s.length());
    }

    private int longestSubstring(String s, int k, int start, int end) {
        int[] countMap = new int[26];
        int maxLength = 0;
        for (int i = start; i < end; i++) {
            countMap[s.charAt(i) - 'a']++;
        }

        for (int i = start; i < end; i++) {
            if (countMap[s.charAt(i) - 'a'] >= k) continue;
            int iNext = i + 1;
            while (iNext < end && countMap[s.charAt(iNext) - 'a'] < k) iNext++;
            return Math.max(
                    longestSubstring(s, k, start, i),
                    longestSubstring(s, k, iNext, end)
            );
        }
        return end - start;
    }

    public int longestSubstringWithWindowSliding(String s, int k) {
        char[] str = s.toCharArray();
        int[] countMap = new int[26];
        int maxUnique = getMaxUniqueLetters(s);
        int result = 0;
        for (int currUnique = 1; currUnique <= maxUnique; currUnique++) {
            // reset countMap
            Arrays.fill(countMap, 0);
            int windowStart = 0, windowEnd = 0, idx = 0, unique = 0, countAtLeastK = 0;
            while (windowEnd < str.length) {
                // expand the sliding window
                if (unique <= currUnique) {
                    idx = str[windowEnd] - 'a';
                    if (countMap[idx] == 0) unique++;
                    countMap[idx]++;
                    if (countMap[idx] == k) countAtLeastK++;
                    windowEnd++;
                }
                // shrink the sliding window
                else {
                    idx = str[windowStart] - 'a';
                    if (countMap[idx] == k) countAtLeastK--;
                    countMap[idx]--;
                    if (countMap[idx] == 0) unique--;
                    windowStart++;
                }
                if (unique == currUnique && unique == countAtLeastK)
                    result = Math.max(windowEnd - windowStart, result);
            }
        }

        return result;
    }

    // get the maximum number of unique letters in the string s
    int getMaxUniqueLetters(String s) {
        boolean map[] = new boolean[26];
        int maxUnique = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map[s.charAt(i) - 'a']) {
                maxUnique++;
                map[s.charAt(i) - 'a'] = true;
            }
        }
        return maxUnique;
    }
}

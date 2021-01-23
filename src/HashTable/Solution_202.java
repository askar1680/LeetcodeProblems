package HashTable;

import java.util.HashSet;
import java.util.Set;

public class Solution_202 {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1) {
            int current = n;
            int sum = 0;
            while (current > 0) {
                sum += (current % 10) * (current % 10);
                current /= 10;
            }

            if (seen.contains(sum)) return false;
            seen.add(sum);
            n = sum;
        }

        return true;
    }
}

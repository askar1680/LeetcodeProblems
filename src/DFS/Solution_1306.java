package DFS;

import java.util.Arrays;

public class Solution_1306 {

    private int[] indexes;

    public boolean canReach(int[] arr, int index) {
        if (arr.length == 1) return arr[0] == 0;
        indexes = new int[arr.length];
        Arrays.fill(indexes, -1);
        return reachZero(arr, index);
    }

    public boolean reachZero(int[] arr, int index) {
        if (index < 0 || index >= arr.length) return false;
        if (arr[index] == 0) return true;
        if (indexes[index] != -1) return false;
        indexes[index] = index;
        return reachZero(arr, index + arr[index]) || reachZero(arr, index - arr[index]);
    }
}

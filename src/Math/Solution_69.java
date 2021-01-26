package Math;

public class Solution_69 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int left = 1;
        int right = x;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid*mid == x) return mid;
            if (mid >= x/mid) {
                right = mid - 1;
            }
            if (mid <= x/mid) {
                ans = mid;
                left = mid + 1;
            }
        }

        return ans;
    }
}

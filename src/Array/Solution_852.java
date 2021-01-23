package Array;

public class Solution_852 {

    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return i - 1;
        }
        return -1;
    }

    // Using binary search
    public int peakIndexInMountainArrayBS(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] < arr[middle + 1]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}

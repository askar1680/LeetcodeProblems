package Array;

public class Solution_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--; n--;
        int index = nums1.length - 1;
        while (index >= 0) {
            if (n < 0) {
                nums1[index] = nums1[m--];
            } else if (m < 0) {
                nums1[index] = nums2[n--];
            } else {
                if (nums1[m] < nums2[n]) {
                    nums1[index] = nums2[n--];
                } else {
                    nums1[index] = nums1[m--];
                }
            }
            index--;
        }
    }
}

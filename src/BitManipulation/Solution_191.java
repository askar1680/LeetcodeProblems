package BitManipulation;

public class Solution_191 {
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) count++;
            mask <<= 1;
        }
        return count;
    }
}

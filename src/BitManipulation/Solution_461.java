package BitManipulation;

public class Solution_461 {
    public int hammingDistance(int x, int y) {
        int distance = 0;

        for (int i = 0; i < 31; i++)
            if (getBit(x, i) != getBit(y, i))
                distance++;

        return distance;
    }

    private int getBit(int n, int index) {
        return (n & (1 << index)) > 0 ? 1 : 0;
    }
}

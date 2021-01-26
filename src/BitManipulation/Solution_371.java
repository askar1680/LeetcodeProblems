package BitManipulation;

public class Solution_371 {
    public int getSum(int a, int b) {
        while ((a & b) != 0) {
            int carry = a & b;
            int sum = a ^ b;
            a = carry << 1;
            b = sum;
        }
        return a | b;
    }
}

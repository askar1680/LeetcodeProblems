package Math;

public class Solution_1281 {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int pN = n;

        while (pN != 0) {
            product *= pN % 10;
            pN /= 10;
        }

        int sum = 0;
        int sN = n;
        while (sN != 0) {
            sum += sN % 10;
            sN /= 10;
        }

        return product - sum;
    }
}

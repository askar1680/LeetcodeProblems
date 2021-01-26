package String;

public class Solution_8 {
    public int myAtoi(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i >= s.length()) return 0;
        int sign = 1;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = s.charAt(i++) == '-' ? -1 : 1;
        }
        if (i >= s.length()) return 0;
        long result = 0;
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            result = result * 10 + (s.charAt(i++) - '0');
            if (result * sign > Integer.MAX_VALUE || result * sign < Integer.MIN_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return (int) (result * sign);
    }
}

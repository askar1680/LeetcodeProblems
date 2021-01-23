package String;

public class Solution_125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }

            if (s.charAt(left) == s.charAt(right)) {
                left++; right--;
                continue;
            } else if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}

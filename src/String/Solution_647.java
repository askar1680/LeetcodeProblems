package String;

public class Solution_647 {

    int count = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            findAllPalindromes(s, i, true);
            findAllPalindromes(s, i, false);
        }
        return count;
    }

    private void findAllPalindromes(String s, int position, boolean isEven) {
        int left = position;
        int right = isEven ? position + 1 : position;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) count++;
            if (s.charAt(left) != s.charAt(right)) return;
            left--;
            right++;
        }
    }
}

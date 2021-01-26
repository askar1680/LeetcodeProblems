package DFS;

import java.util.ArrayList;
import java.util.List;

public class Solution_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        dfs(0, s, new ArrayList<>(), list);
        return list;
    }

    private void dfs(int start, String s, List<String> current, List<List<String>> list) {
        if (start >= s.length()) list.add(new ArrayList<>(current));
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                current.add(s.substring(start, i + 1));
                dfs(i + 1, s, current, list);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}

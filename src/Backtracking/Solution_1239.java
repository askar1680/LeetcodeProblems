package Backtracking;

import java.util.HashSet;
import java.util.List;

public class Solution_1239 {

    int maxLen = 0;

    public int maxLength(List<String> arr) {
        backtracking(arr, 0, new StringBuilder(), new HashSet<Character>());
        return maxLen;
    }

    private void backtracking(List<String> arr, int start, StringBuilder sb, HashSet<Character> set) {
        if (sb.length() > maxLen) maxLen = sb.length();

        for (int i = start; i < arr.size(); i++) {
            HashSet<Character> tempSet = new HashSet<>();
            String word = arr.get(i);
            boolean add = true;
            for (int j = 0; j < word.length();  j++) {
                if (tempSet.contains(word.charAt(j)) || set.contains(word.charAt(j))) {
                    add = false;
                    break;
                }
                tempSet.add(word.charAt(j));
            }
            if (add) {
                set.addAll(tempSet);
                sb.append(word);
                backtracking(arr, i + 1, new StringBuilder(sb), set);
                set.removeAll(tempSet);
                sb.setLength(sb.length() - arr.get(i).length());
            }
        }
    }
}

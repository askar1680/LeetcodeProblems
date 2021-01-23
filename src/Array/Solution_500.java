package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution_500 {
    public String[] findWords(String[] words) {
        String[] keyboardRowStrings = {
                "qwertyuiop",
                "asdfghjkl",
                "zxcvbnm"
        };
        List<HashSet<Character>> keywordRows = new ArrayList<>();
        for (String row: keyboardRowStrings) {
            HashSet<Character> chars = new HashSet<>();
            for (char ch: row.toCharArray()) {
                chars.add(ch);
            }
            keywordRows.add(chars);
        }
        List<String> list = new ArrayList<>();

        for (String word: words) {
            for (HashSet<Character> chars: keywordRows) {
                boolean containsAll = true;
                String lowercase = word.toLowerCase();
                for (char ch: lowercase.toCharArray()) {
                    if (!chars.contains(ch)) {
                        containsAll = false;
                        break;
                    }
                }
                if (containsAll) {
                    list.add(word);
                    break;
                }
            }
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}

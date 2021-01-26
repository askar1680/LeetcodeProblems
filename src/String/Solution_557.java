package String;

import java.util.ArrayList;
import java.util.List;

public class Solution_557 {
    public String reverseWords(String s) {
        String words[] = split(s);
        StringBuilder result = new StringBuilder();
        for (String word: words)
            result.append(reverse(word) + " ");

        int index = result.length() - 1;
        while (index >= 0 && result.charAt(index) == ' ') {
            result.setLength(result.length() - 1);
            index--;
        }
        return result.toString().trim();
    }

    private String[] split(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                words.add(word.toString());
                word = new StringBuilder();
            } else {
                word.append(ch);
            }
        }
        if (word.length() != 0) {
            words.add(word.toString());
        }
        return words.toArray(new String[words.size()]);
    }

    private String reverse(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}

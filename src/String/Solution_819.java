package String;

import java.util.HashMap;
import java.util.HashSet;

public class Solution_819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedWords = new HashSet<>();
        for (String word: banned) {
            bannedWords.add(word);
        }

        HashMap<String, Integer> countMap = new HashMap<>();
        String[] words = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ");
        for (String word: words) {
            if (bannedWords.contains(word)) continue;
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        String result = "";
        for (String word: countMap.keySet()) {
            if (result.equals("") || countMap.get(result) < countMap.get(word)) {
                result = word;
            }
        }
        return result;
    }
}

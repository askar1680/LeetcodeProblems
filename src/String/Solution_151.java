package String;

public class Solution_151 {
    public String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder builder = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() == 0)
                continue;
            if (builder.length() > 0)
                builder.append(' ');
            builder.append(words[i]);
        }

        return builder.toString();
    }
}

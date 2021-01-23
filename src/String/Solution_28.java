package String;

public class Solution_28 {

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
            if (j == needle.length()) return i;
        }

        return -1;
    }

    // using kmp
    public int strStrKMP(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;
        int[] table = createKMPTable(needle);
        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
            }
            if (j == needle.length()) {
                return i - j;
            } else if (i < haystack.length() && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    j = table[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    private int[] createKMPTable(String pattern) {
        char[] chars = pattern.toCharArray();
        int[] table = new int[pattern.length()];
        table[0] = 0;
        int i = 0;
        int j = 1;

        while (j < pattern.length()) {
            if (chars[i] == chars[j]) {
                i++;
                table[j] = i;
                j++;
            } else {
                if (i != 0) {
                    i = table[i - 1];
                } else {
                    table[j] = i;
                    j++;
                }
            }
        }

        return table;
    }
}

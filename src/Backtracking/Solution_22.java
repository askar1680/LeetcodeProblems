package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution_22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(n, 0, 0, "", list);
        return list;
    }

    private void generate(int n, int open, int close, String s, List<String> list) {
        if (s.length() == n * 2) {
            list.add(s);
        }

        if (open < n) {
            generate(n, open + 1, close, s + "(", list);
        }
        if (close < open) {
            generate(n, open, close + 1, s + ")", list);
        }
    }
}

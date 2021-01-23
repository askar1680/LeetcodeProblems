package Array;

import java.util.ArrayList;
import java.util.List;

public class Solution_118 {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return list;
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        list.add(firstRow);
        if (numRows == 1) return list;

        for (int i = 1; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            List<Integer> topRow = list.get(i - 1);
            for (int j = 0; j < topRow.size() - 1; j++) {
                currentRow.add(topRow.get(j) + topRow.get(j + 1));
            }
            currentRow.add(1);
            list.add(currentRow);
        }

        return list;
    }
}

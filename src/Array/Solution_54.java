package Array;

import java.util.ArrayList;
import java.util.List;

public class Solution_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length;

        int left = 0;
        int right = matrix[0].length;

        List<Integer> orderedList = new ArrayList<>();
        int count = 0;
        int numberOfElements = matrix.length * matrix[0].length;

        while (count < numberOfElements) {
            for (int i = left; i < right; i++) {
                orderedList.add(matrix[top][i]);
                count++;
            }
            top++;
            if (count == numberOfElements) break;

            for (int i = top; i < bottom; i++) {
                orderedList.add(matrix[i][right - 1]);
                count++;
            }
            right--;
            if (count == numberOfElements) break;

            for (int i = right - 1; i >= left; i--) {
                orderedList.add(matrix[bottom - 1][i]);
                count++;
            }
            bottom--;
            if (count == numberOfElements) break;

            for (int i = bottom - 1; i >= top; i--) {
                orderedList.add(matrix[i][left]);
                count++;
            }
            left++;
        }

        return orderedList;
    }
}

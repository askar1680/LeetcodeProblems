package CrackingTheCodingInterview;

public class ArraysAndStrings {

    public static void main(String[] args) {
        int[][] array  = new int[][] {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        rotate(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 1.3. Replace all spaces in a string with '%20: You may assume that
    // the string has sufficient space at the end to hold the additional
    // characters, and that you are given the "true" length of the string.
    private static String replaceAllSpaces(char[] chars, int trueLength) {
        int index = chars.length - 1;
        for (int i = trueLength - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[index] = '0';
                chars[index - 1] = '2';
                chars[index - 2] = '%';
                index -= 3;
            } else {
                chars[index--] = chars[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch: chars) {
            sb.append(ch);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // 1.4. Palindrome Permutation: Given a string, write a function to
    // check if it is a permutation of a palindrome.
    // A palindrome is a word or phrase that is the same forwards and backwards.
    private static boolean isPermutationOfPalindrome(String s) {
        int[] counter = getStringCounterArray(s);
        boolean foundOdd = false;
        for (int i: counter) {
            if (i % 2 == 1 && foundOdd) return false;
            if (i % 2 == 1) foundOdd = true;
        }
        return true;
    }

    // 1.5 There are three types of edits that can be performed on strings:
    // insert a character, remove a character, or replace a character.
    private static boolean isOnlyOneDifference(String s1, String s2) {
        int[] counter1 = getStringCounterArray(s1);
        int[] counter2 = getStringCounterArray(s2);
        boolean foundDifference = false;
        for (int i = 0; i < counter1.length; i++) {
            if (counter1[i] != counter2[i] && foundDifference) return false;
            if (counter1[i] != counter2[i]) foundDifference = true;
        }
        return true;
    }

    // 1.6. Implement a method to perform basic string compression using the counts
    // of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3.
    private static String compressString(String s) {
        // aabcccccaaad
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            counter++;
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(s.charAt(i) + "" + counter);
                counter = 0;
            }
        }
        return sb.length() >= s.length() ? s : sb.toString();
    }

    // 1.7. Rotate an array into 90 degrees
    private static boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix.length != matrix[0].length) return false;
        int size = matrix.length;
        for (int layer = 0; layer < size/2; layer++) {
            int first = layer;
            int last = size - layer - 1;
            for (int i = first; i < last; i++) {
                int offset = i - first;

                int top = matrix[first][i];
                // left -> top
                matrix[first][i] = matrix[last-offset][first];
                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];
                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];
                // top -> right
                matrix[i][last] = top;
            }
        }
        return true;
    }

    private static int[] getStringCounterArray(String s) {
        String lowercased = s.toLowerCase();
        int[] counter = new int[256];
        for (char ch: lowercased.toCharArray()) {
            if (ch >= 'a' && ch <= 'z')
                counter[ch]++;
        }
        return counter;
    }
}

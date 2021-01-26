package String;

public class Solution_58 {

    public int lengthOfLastWord(String s) {
        String[] array = s.split(" ");
        if (array.length == 0) return 0;
        return array[array.length - 1].length();
    }
}

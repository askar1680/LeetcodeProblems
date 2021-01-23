package String;

public class Solution_657 {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char ch: moves.toCharArray()) {
            switch (ch) {
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'R':
                    x++;
                    break;
                case 'L':
                    x--;
                    break;
            }
        }
        return x == 0 && y == 0;
    }
}

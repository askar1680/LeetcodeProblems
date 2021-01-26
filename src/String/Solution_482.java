package String;

public class Solution_482 {
    public String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '-') continue;
            if (sb.length() % (K + 1) == K)
                sb.append('-');
            sb.append(Character.toUpperCase(S.charAt(i)));
        }
        return sb.reverse().toString();
    }
}

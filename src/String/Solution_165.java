package String;

public class Solution_165 {
    public int compareVersion(String version1, String version2) {
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");
        int i1 = 0, i2 = 0;
        while (i1 < versions1.length || i2 < versions2.length) {
            int v1 = i1 < versions1.length ? Integer.valueOf(versions1[i1]) : 0;
            int v2 = i2 < versions2.length ? Integer.valueOf(versions2[i2]) : 0;

            if (v1 > v2) {
                return 1;
            } else if ( v2 > v1) {
                return -1;
            }

            i1++; i2++;
        }
        return 0;
    }
}

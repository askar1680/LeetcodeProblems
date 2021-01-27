package DFS;

public class Solution_547 {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];

        int counter = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                counter++;
            }
        }
        return counter;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int position) {
        visited[position] = true;
        for (int i = 0; i < isConnected[position].length; i++) {
            if (!visited[i] && isConnected[position][i] == 1) {
                dfs(isConnected, visited, i);
            }
        }
    }
}

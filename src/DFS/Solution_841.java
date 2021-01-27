package DFS;

import java.util.List;

public class Solution_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);
        for (boolean isVisited: visited) {
            if (!isVisited) return false;
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int position) {
        if (visited[position]) return;
        visited[position] = true;
        List<Integer> keys = rooms.get(position);
        for (int key: keys) {
            dfs(rooms, visited, key);
        }
    }
}

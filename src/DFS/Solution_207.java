package DFS;

import java.util.ArrayList;
import java.util.List;

public class Solution_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0)
            return true;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for (int[] requirement : prerequisites)
            graph.get(requirement[0]).add(requirement[1]);

        int[] visited = new int[numCourses];
        for (int i = 0; i < graph.size(); i++) {
            if (dfs(graph, i, visited)) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int position, int[] visited) {
        visited[position] = 1;
        boolean hasCycle = false;

        for (int node: graph.get(position)) {
            if (visited[node] == 1)
                return true;
            if (visited[node] == 0) {
                hasCycle = hasCycle | dfs(graph, node, visited);
            }
        }

        visited[position] = 2;
        return hasCycle;
    }
}

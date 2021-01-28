package DFS;

import java.util.ArrayList;
import java.util.List;

public class Solution_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] lessons: prerequisites) {
            int a = lessons[1];
            int b = lessons[0];
            graph.get(b).add(a);
        }

        int[] visitedForCycle = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visitedForCycle[i] != 2 && graphHasCycle(graph, visitedForCycle, i)) return new int[0];
        }

        List<Integer> resultList = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i, resultList);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    private void dfs(List<List<Integer>> graph, boolean[] visited, int position, List<Integer> list) {
        visited[position] = true;
        for (int lesson: graph.get(position)) {
            if (!visited[lesson]) {
                dfs(graph, visited, lesson, list);
            }
        }
        list.add(position);
    }

    // 0 - not visited
    // 1 - visiting
    // 2 - visited
    private boolean graphHasCycle(List<List<Integer>> graph, int[] visited, int position) {
        visited[position] = 1;
        boolean hasCycle = false;
        for (int lesson: graph.get(position)) {
            if (visited[lesson] == 1) {
                hasCycle = true;
            } else {
                hasCycle = hasCycle || graphHasCycle(graph, visited, lesson);
            }
        }

        visited[position] = 2;
        return hasCycle;
    }
}

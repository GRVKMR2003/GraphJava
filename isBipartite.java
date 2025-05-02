class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length; 
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, graph, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int node, int col, int[][] graph, int[] color) {
        color[node] = col;

        for (int adj : graph[node]) {
            if (color[adj] == -1) {
                if (!dfs(adj, 1 - col, graph, color)) return false;
            } else if (color[adj] == col) {
                return false;
            }
        }

        return true;
    }
}

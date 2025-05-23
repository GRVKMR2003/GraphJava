class Solution {
    public int removeStones(int[][] stones) {
         int n = stones.length;
        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(stones, visited, i);
            }
        }

        return n - components;
    }
    private void dfs(int[][] stones, boolean[] visited, int index) {
        visited[index] = true;
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i] &&
                (stones[i][0] == stones[index][0] || stones[i][1] == stones[index][1])) {
                dfs(stones, visited, i);
            }
        }
    }
}
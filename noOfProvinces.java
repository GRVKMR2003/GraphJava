class Solution {
    public int findCircleNum(int[][] g) {
        int vis[]= new int[g.length];
        int c =0;
        for(int i=0;i<g.length;i++){
            if(vis[i]==0){
                dfs(g,i, vis);
                c++;
                            }
        }

        return c;
    }

    public void  dfs(int [][]g , int i, int [] vis){
        vis[i]=1;

        for(int j=0;j<g.length;j++){
            if(vis[j]==0&& g[i][j]==1){
                dfs(g , j ,vis);
            }
        }



    }
}
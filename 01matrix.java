class Solution {

    class node{
        int f;
        int s;
        int t;

        node(int f , int s , int t){
            this.f = f;
            this.s =s;
            this.t =t;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int vis[][] = new int[mat.length][mat[0].length];
        Queue<node> q = new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                   q.add(new node(i,j,0));
                   vis[i][j]=1;
                }else{
                    vis[i][j]=0;
                }
            }
        }

        int dir[][]={
            {1,0},{0,1},{-1,0},{0,-1}
        };

        while(!q.isEmpty()){
            node n = q.peek();
            int x=n.f;
            int y = n.s;
            int steps = n.t;
               mat[x][y]=steps;
            q.remove();

            for(int [] i:dir){
                int nr = i[0]+x;
                int nc = i[1]+y;
                if(nr>=0 && nc>=0 && nr<mat.length && nc<mat[0].length && vis[nr][nc]==0){
                     vis[nr][nc]=1;
                     q.add(new node(nr,nc,steps+1));
                }


            }


        }

        return mat;




    }
}
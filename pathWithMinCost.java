class Solution {

    class Pair{
        int d ;int f; int s;
        Pair(int d  , int f , int s){
        this.d = d;
        this.f=f;
        this.s=s;
        }

    }
    public int minimumEffortPath(int[][] h) {
        int n = h.length;
        int m = h[0].length;
        int mp[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mp[i][j]=Integer.MAX_VALUE;
            }
        }


        PriorityQueue<Pair>  pq = new PriorityQueue<>((a,b)->a.d-b.d);

        pq.add(new Pair(0,0,0));
         mp[0][0]=0;
        int dist[][]= {
            {1,0},{0,1},{0,-1},{-1,0}
        };

        while(!pq.isEmpty()){
           Pair p =  pq.poll();
           int dis = p.d;
           int x = p.f;
           int y=p.s;
            if(x==h.length-1 && y==h[0].length-1){
                return dis;
            }
           for(int i[]:dist){
            int nx = x +i[0];
            int ny = y+i[1];
            

            if(nx>=0 && ny>=0 && nx<h.length && ny<h[0].length ){
                int nd = Math.max(Math.abs(h[nx][ny]-h[x][y]),dis);

                if(nd<mp[nx][ny]){
                    mp[nx][ny]=nd;
                    pq.add(new Pair(nd,nx,ny));
                }
            }
           }
        }

        return 0;

    }
}
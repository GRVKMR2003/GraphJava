import java.util.*;
class Solution {
    public int orangesRotting(int[][] g) {
        int n = g.length;
        int f =0;
        int c=0;

        Queue<int []> q = new LinkedList<>();
        for(int i=0;i<n ; i++){
            for(int j=0;j<g[0].length;j++){
                if(g[i][j]==2){
                    q.add(new int[]{i,j});
                }else if(g[i][j]==1){
                    f++;
                }
            }
        }

        if(f==0)return 0;
           

           int dir[][]= {
            {1,0},{0,1},{0,-1},{-1,0}
           };

        while(!q.isEmpty()){
            
        boolean rot = false;
        int s = q.size();
            for(int i=0;i<s ;i++){
                int m[] =q.poll();
                int x = m[0];
                int y =m[1];

                for(int [] d:dir){
                    int dx = d[0]+x;
                    int dy =d[1]+y;

                    if(dx>=0 && dy>=0 && dx<n && dy<g[0].length && g[dx][dy]==1){
                        g[dx][dy]=2;
                        q.add(new int[]{dx,dy});
                        f--;
                        rot=true;
                    }
                }
            }
            if(rot)c++;
        }
          return f == 0 ? c : -1;
    }
}
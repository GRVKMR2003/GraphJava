import java.util.*;

class Solution {
    public int[][] floodFill(int[][] img, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        int pcolor = img[sr][sc];
        
        
        if (pcolor == color) return img;

        q.add(new int[]{sr, sc});
        img[sr][sc] = color; 

        int[][] dir = {
            {1,0}, {0,1}, {-1,0}, {0,-1}
        };

        while (!q.isEmpty()) {
            int[] m = q.poll();
            int x = m[0];
            int y = m[1];

            for (int[] d : dir) {
                int dx = x + d[0];
                int dy = y + d[1];

                if (dx >= 0 && dy >= 0 && dx < img.length && dy < img[0].length && img[dx][dy] == pcolor) {
                    img[dx][dy] = color;
                    q.add(new int[]{dx, dy}); 
                }
            }
        }

        return img;
    }
}

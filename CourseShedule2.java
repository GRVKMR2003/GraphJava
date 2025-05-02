class Solution {
    public boolean canFinish(int n, int[][] pre) {
        int ind[]= new int[n];
        for(int i[]:pre){
           ind[i[0]]++;

        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<ind.length;i++){
            if(ind[i]==0)q.add(i);
        }

   int cnt=0;
        while(!q.isEmpty()){
            cnt++;
            int c = q.poll();
            for(int p[]:pre){
                if(p[1]==c){
                    ind[p[0]]--;
                    if(ind[p[0]]==0){
                        q.add(p[0]);
                    }
                }
            }
        }


        return cnt==n;
    }
}
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        
        int ind[]= new int[graph.length];
        Arrays.fill(ind,0);

        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<graph.length;i++){
            for(int j:graph[i]){
                adj.get(j).add(i);
                ind[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();


        for(int i=0;i<ind.length;i++){
          if(ind[i]==0)q.add(i);
        }

        while(!q.isEmpty()){
            int x = q.poll();
            arr.add(x);

            for(int i:adj.get(x)){
                ind[i]--;
                if(ind[i]==0)q.add(i);
            }

        }
        Collections.sort(arr);

        return arr;
    }
}
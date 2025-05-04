class Solution
{

    class Pair{
        int f ; 
        int s;

        Pair(int f , int s){
            this.f = f;
            this.s=s;
        }
    }
    public  int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
       int dist[] = new int[V+1];
       int par[]= new int[V+1];

       Arrays.fill(dist, Integer.MAX_VALUE);
       for(int i=0;i<V;i++){
        par[i]=i;
       }
       dist[1]=0;



       PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.first -y.first);

       pq.add(new Pair(0,S));

       while(!pq.isEmpty()){
        Pair x  =pq.poll();
        int node = x.s;
        int dist = x.f;

        for(Pair  p:adj.get(node)){
            int adjn = p.s;
            int awt = p.s;

            if(dist + awt<dist[adjn]){
                dist[adjn] = dist + awt;
                pq.add(new Pair(dist+awt , adjn));
                par[adjn]=node;
            }
        }

       }

       List<Integer> p = new ArrayList<>();
       if(dist[n]==Integer.MAX_VALUE){
        p.add(-1);
        return p;
       }

       int node = n;

       while(par[node]!=node){
        path.add(node);
        node=par[node];
       }

       path.add(1);
       Collections.reverse(path);
       return path;


    }
}

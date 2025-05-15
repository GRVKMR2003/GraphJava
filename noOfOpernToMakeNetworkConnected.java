import java.util.ArrayList;

class DisjointSet {
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulpu = findUPar(u);
        int ulpv = findUPar(v);
        if (ulpu == ulpv) return;

        if (rank.get(ulpu) < rank.get(ulpv)) {
            parent.set(ulpu, ulpv);
        } else if (rank.get(ulpu) > rank.get(ulpv)) {
            parent.set(ulpv, ulpu);
        } else {
            parent.set(ulpv, ulpu);
            rank.set(ulpu, rank.get(ulpu) + 1);
        }
    }
}

class noOfOpernToMakeNetworkConnected {
    public int makeConnected(int n, int[][] edges) {
        if (edges.length < n - 1) return -1;  

        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (ds.findUPar(u) == ds.findUPar(v)) {
                extraEdges++;
            } else {
                ds.unionByRank(u, v);
            }
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findUPar(i) == i) components++;
        }

        int operationsNeeded = components - 1;
        return extraEdges >= operationsNeeded ? operationsNeeded : -1;
    }
}

import java.util.*;

class Solution {

    class Pair {
        int f, s;
        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }

    class nPair {
        int stops, node, cost;
        nPair(int stops, int node, int cost) {
            this.stops = stops;
            this.node = node;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        int[] costToNode = new int[n];
        Arrays.fill(costToNode, Integer.MAX_VALUE);
        costToNode[src] = 0;

        Queue<nPair> pq = new LinkedList<>();
        pq.add(new nPair(0, src, 0));

        while (!pq.isEmpty()) {
            nPair curr = pq.poll();
            int stops = curr.stops;
            int node = curr.node;
            int cost = curr.cost;

            if (stops > k) continue;

            for (Pair neighbor : adj.get(node)) {
                int nextCost = cost + neighbor.s;
                if (nextCost < costToNode[neighbor.f]) {
                    costToNode[neighbor.f] = nextCost;
                    pq.add(new nPair(stops + 1, neighbor.f, nextCost));
                }
            }
        }

        return costToNode[dst] == Integer.MAX_VALUE ? -1 : costToNode[dst];
    }
}

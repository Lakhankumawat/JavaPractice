package MST;

import java.util.*;

class Kruskal {

    static class Edge {
        int source;
        int dest;
        int weight;

        Edge(int s, int d, int w) {
            this.source = s;
            this.dest = d;
            this.weight = w;
        }
    }

    static class subset {
        int parent;
        int rank;

        subset(int p, int r) {
            parent = p;
            rank = r;
        }
    }

    // Function to unite two disjoint sets
    private static void union(subset[] subsets, int x,
            int y) {
        int rootX = findroot(subsets, x);
        int rootY = findroot(subsets, y);

        if (subsets[rootY].rank < subsets[rootX].rank) {
            subsets[rootY].parent = rootX;
        } else if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    private static int findroot(subset sets[], int i) {
        if (sets[i].parent == i)
            return i;

        return sets[i].parent = findroot(sets, sets[i].parent);
    }

    static int spanningTree(int V, int E, int e[][]) {

        List<Edge> edges = new ArrayList<Edge>();

        // add the edges to priority queue
        for (int i = 0; i < e.length; i++) {
            edges.add(new Edge(e[i][0], e[i][1], e[i][2]));
        }

        edges.sort(new Comparator<>() {
            @Override
            public int compare(Edge a, Edge b) {
                return a.weight - b.weight;
            }
        });

        // Create a set
        subset[] sets = new subset[V];

        // create a result vetor
        // in mst V-1 edges
        Edge[] result = new Edge[V];

        // Create V subsets with single elements
        for (int i = 0; i < V; i++) {
            sets[i] = new subset(i, 0);
        }

        // look carefully , j is the pq pointer lowest weight
        int j = 0;
        // total edges pointer
        int totalEdges = 0;
        int ans = 0;

        while (totalEdges < V - 1) {

            Edge curr = edges.get(j);

            int x = findroot(sets, curr.source);
            int y = findroot(sets, curr.dest);

            if (x != y) {
                result[totalEdges] = curr;
                union(sets, x, y);
                totalEdges++;
                ans += curr.weight;

            }
            j++;

        }

        return ans;
    }
}
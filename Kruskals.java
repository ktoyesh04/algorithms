import java.util.*;

class Edge{
    int src, dest, weight;
    public Edge(int src, int dest, int weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph{
    int V, E;
    List<Edge> edges;

    public Graph(int V, int E){
        this.V = V;
        this.E = E;
        edges = new ArrayList<>();
    }

    public void addEdge(int weight, int src, int dest){
        Edge new_edge = new Edge(src, dest, weight);
        edges.add(new_edge);
    }

    private int find(int[] parent, int i){
        if(parent[i] < 0) return i;
        else return find(parent, parent[i]);
    }

    private void union(int parent[], int x, int y){
        int xset = find(parent, x);
        int yset = find(parent, y);
        if(xset < yset){
            parent[xset] += parent[yset];
            parent[yset] = xset; 
        }
        else{
            parent[yset] += parent[xset];
            parent[xset] = yset;
        }
    }

    public void kruskal(){
        List<Edge> result = new ArrayList<>();
        Collections.sort(edges, Comparator.comparingInt(e->e.weight));

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        for(int i=0, edgeCount=0; edgeCount<V-1 && i<E; i++){
            Edge edge = edges.get(i);
            int x = find(parent, edge.src);
            int y = find(parent, edge.dest);
            if(x != y){
                result.add(edge);
                union(parent, x, y);
                edgeCount ++;
            }
        }

        int cost = 0;
        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : result){ 
            System.out.println(edge.src + " -- " + edge.dest + " : " + edge.weight);
            cost += edge.weight;
        }
        System.out.println("Cost of the spanning tree: "+cost);
    }
}

public class Kruskals{
    public static void main(String[] args) {
        int V = 9, E = 14;
        Graph graph = new Graph(V, E);

        graph.addEdge(1, 7, 6);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 6, 5);
        graph.addEdge(4, 0, 1);
        graph.addEdge(4, 2, 5);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 2, 3);
        graph.addEdge(7, 7, 8);
        graph.addEdge(8, 0, 7);
        graph.addEdge(8, 1, 2);
        graph.addEdge(9, 3, 4);
        graph.addEdge(10, 5, 4);
        graph.addEdge(11, 1, 7);
        graph.addEdge(14, 3, 5);

        graph.kruskal();
    }
}
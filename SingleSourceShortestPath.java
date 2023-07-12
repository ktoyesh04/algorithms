import java.util.Arrays;

public class SingleSourceShortestPath {
    private static final int Infinity = Integer.MAX_VALUE;

    private static void dijkstra(int[][] graph, int source) {
        int vertices = graph.length;
        boolean[] visited = new boolean[vertices];
        int[] distance = new int[vertices];
        Arrays.fill(distance, Infinity);
        distance[source] = 0;
        for (int i = 0; i < vertices - 1; i++) {
            int min_vertex = find_min_vertex(distance, visited);
            visited[min_vertex] = true;
            for (int j = 0; j < vertices; j++) {
         if (!visited[j] && graph[min_vertex][j] != 0 &&
                        distance[min_vertex] != Infinity && distance[min_vertex] + graph[min_vertex][j] < distance[j])
distance[j] = distance[min_vertex]+graph[min_vertex][j];
            }
        }
        print_shortest_paths(distance, source);
    }

    private static int find_min_vertex(int[] distance, boolean[] visited){
        int min_vertex = -1;
        for(int i=0;i<distance.length;i++){
            if(!visited[i]&&(min_vertex==-1 || distance[i]<distance[min_vertex])){
                min_vertex = i;}}
        return min_vertex;
    }

    public static void print_shortest_paths(int[] distance, int source) {
        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < distance.length; i++) {
            System.out.println(i + "\t\t" + distance[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                    {0, 2, 6, 0, 0, 0, 0},
                    {2, 0, 0, 5, 0, 0, 0},
                    {6, 0, 0, 8, 0, 0, 0},
                    {0, 5, 8, 0, 10, 15, 0},
                    {0, 0, 0, 10, 0, 6, 2},
                    {0, 0, 0, 15, 6, 0, 6},
                    {0, 0, 0, 0, 2, 6, 0}};
        int source = 0;
        dijkstra(graph, source);
    }
}

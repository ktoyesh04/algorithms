import java.util.Arrays;

public class Prims {
    private static final int Infinity = Integer.MAX_VALUE;

    private static void mincost_span_tree(int[][] graph){
        int vertices = graph.length;
        int[] parent = new int[vertices];
        int[] weight = new int[vertices];
        boolean visited[] = new boolean[vertices];
        Arrays.fill(weight, Infinity);
        Arrays.fill(visited, false);
        weight[0] = 0;
        parent[0] = -1;
        for(int i=0;i<vertices-1;i++){
            int min_weight_index = get_min_weight_index(weight, visited);
            visited[min_weight_index] = true;
            for(int j=0;j<vertices;j++){
                if(graph[min_weight_index][j]!=0 && !visited[j] && graph[min_weight_index][j]<weight[j]){
                    parent[j] = min_weight_index;
                    weight[j] = graph[min_weight_index][j];
                }
            }
        }
        mincost_span_tree(parent, graph);
        System.out.println("Min cost of spanning tree: "+ Arrays.stream(weight).sum());}
    private static void mincost_span_tree(int parent[], int graph[][]){
        System.out.println("Edge \t Weight");
        for(int i=1;i<graph.length;i++) 
        System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    private static int get_min_weight_index(int weight[], boolean[] visited){
        int min_weight = Infinity;
        int min_weight_index = -1;
        for(int i=0;i<weight.length;i++){
            if(!visited[i] && weight[i]<min_weight){
                min_weight = weight[i];
                min_weight_index = i;
            }}
        return min_weight_index;
    }

    public static void main(String[] args) {
        int[][] graph = {{0, 6, 3, 0, 7, 0},    
                         {6, 0, 4, 2, 0, 5},    
                         {3, 4, 0, 3, 8, 0},    
                         {0, 2, 3, 0, 0, 2},    
                         {7, 0, 8, 0, 0, 0},
                         {0, 5, 0, 2, 0, 0}};   
        mincost_span_tree(graph);
    }
}
import java.util.*;

class Graph {
    // Mapa que almacena el grafo como lista de adyacencia
    private Map<Integer, List<Integer>> graph;
    
    // Constructor que inicializa el grafo vacío
    public Graph() {
        graph = new HashMap<>();
    }
    
    // Método para agregar una arista del vértice u al vértice v
    public void addEdge(int u, int v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.get(u).add(v);
    }
    
    // Método público para iniciar el recorrido DFS (Búsqueda en Profundidad)
    public void dfs(int startVertex) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(startVertex, visited);
    }
    
    // Método recursivo privado para DFS
    private void dfsRecursive(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");
        
        List<Integer> neighbors = graph.getOrDefault(vertex, new ArrayList<>());
        for (int neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }
    
    // Método para realizar BFS (Búsqueda en Anchura)
    public void bfs(int startVertex) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        visited.add(startVertex);
        queue.add(startVertex);
        
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            
            List<Integer> neighbors = graph.getOrDefault(vertex, new ArrayList<>());
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Graph g = new Graph();
        
        // Agregando aristas para el grafo de prueba
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 6);
        g.addEdge(3, 7);
        
        System.out.println("DFS comenzando desde el vértice 1:");
        g.dfs(1);
        System.out.println("\n\nBFS comenzando desde el vértice 1:");
        g.bfs(1);
    }
}
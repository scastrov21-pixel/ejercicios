public class GrafoMatriz {
    private String[] vertices;
    private int[][] matriz;
    private int numVertices;
    private static final int MAX_VERTICES = 10;

    public GrafoMatriz() {
        vertices = new String[MAX_VERTICES];
        matriz = new int[MAX_VERTICES][MAX_VERTICES];
        numVertices = 0;
    }

    public void agregarVertice(String vertice) {
        if (numVertices < MAX_VERTICES) {
            vertices[numVertices] = vertice;
            for (int i = 0; i <= numVertices; i++) {
                matriz[i][numVertices] = 0;
                matriz[numVertices][i] = 0;
            }
            numVertices++;
        }
    }

    public void agregarArista(String inicio, String fin) {
        int i = buscarIndice(inicio);
        int j = buscarIndice(fin);
        if (i != -1 && j != -1) {
            matriz[i][j] = 1;
            matriz[j][i] = 1; // Para grafo no dirigido
        }
    }

    private int buscarIndice(String vertice) {
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].equals(vertice)) {
                return i;
            }
        }
        return -1;
    }

    public void mostrarMatriz() {
        System.out.print("  ");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(vertices[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < numVertices; i++) {
            System.out.print(vertices[i] + " ");
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GrafoMatriz grafo = new GrafoMatriz();

        // Agregar vértices
        String[] vertices = {"A", "B", "C", "D"};
        for (String v : vertices) {
            grafo.agregarVertice(v);
        }

        // Agregar aristas
        grafo.agregarArista("A", "B");
        grafo.agregarArista("B", "C");
        grafo.agregarArista("C", "D");
        grafo.agregarArista("D", "A");

        // Mostrar la matriz de adyacencia
        System.out.println("Matriz de Adyacencia:");
        grafo.mostrarMatriz();
    }
}
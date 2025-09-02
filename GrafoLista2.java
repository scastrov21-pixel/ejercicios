import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GrafoLista {
    private HashMap<String, List<String>> grafo;

    public GrafoLista() {
        grafo = new HashMap<>();
    }

    public void agregarVertice(String vertice) {
        if (!grafo.containsKey(vertice)) {
            grafo.put(vertice, new ArrayList<>());
        }
    }

    public void agregarArista(String origen, String destino) {
        // Asegurarse de que ambos vértices existan
        agregarVertice(origen);
        agregarVertice(destino);
        
        // Agregar la arista
        if (!grafo.get(origen).contains(destino)) {
            grafo.get(origen).add(destino);
        }
    }

    public void mostrarGrafo() {
        for (String vertice : grafo.keySet()) {
            System.out.print("Vértice " + vertice + " -> ");
            List<String> adyacentes = grafo.get(vertice);
            System.out.println(adyacentes);
        }
    }

    public static void main(String[] args) {
        GrafoLista grafo = new GrafoLista();
        
        // Agregar las aristas del ejemplo
        grafo.agregarArista("A", "B");
        grafo.agregarArista("A", "C");
        grafo.agregarArista("B", "D");
        
        // Mostrar el grafo
        grafo.mostrarGrafo();
    }
}
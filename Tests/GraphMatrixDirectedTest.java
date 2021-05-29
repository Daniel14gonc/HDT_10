import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GraphMatrixDirectedTest {

    @org.junit.Test
    public void add() {

        GraphMatrixDirected<String, Integer> graph = new GraphMatrixDirected<String, Integer>(4);
        graph.add("Antigua");
        graph.addEdge("Antigua", "Antigua", 0);
        graph.add("Guatemala");
        graph.addEdge("Guatemala", "Guatemala", 0);
        graph.addEdge("Antigua", "Guatemala", 10);

        String regreso = graph.get("Antigua");

        assertEquals("No se añade correctamente al grafo", regreso, "Antigua");


    }

    @Test
    public void addEdge() {
        GraphMatrixDirected<String, Integer> graph = new GraphMatrixDirected<String, Integer>(4);
        graph.add("Antigua");
        graph.addEdge("Antigua", "Antigua", 0);
        graph.add("Guatemala");
        graph.addEdge("Guatemala", "Guatemala", 0);
        graph.addEdge("Antigua", "Guatemala", 10);

        Edge<String, Integer> e = graph.getEdge("Antigua", "Guatemala");

        String origin = e.here();
        String llegada = e.there();

        assertEquals("No se añade edge correctamente al grafo", origin, "Antigua");
        assertEquals("No se añade edge correctamente al grafo", llegada, "Guatemala");

    }

    @Test
    public void removeEdge() {

        GraphMatrixDirected<String, Integer> graph = new GraphMatrixDirected<String, Integer>(4);
        graph.add("Antigua");
        graph.addEdge("Antigua", "Antigua", 0);
        graph.add("Guatemala");
        graph.addEdge("Guatemala", "Guatemala", 0);
        graph.addEdge("Antigua", "Guatemala", 10);
        graph.removeEdge("Antigua", "Guatemala");

        Edge<String, Integer> e = graph.getEdge("Antigua", "Guatemala");

        assertEquals("No se añade edge correctamente al grafo", e, null);

    }
}
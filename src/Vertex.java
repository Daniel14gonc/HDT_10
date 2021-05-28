public class Vertex <V>{
    protected int index;
    protected V label;
    protected boolean visited;

    public Vertex(V label, int index) {
        this.label = label;
        visited = false;
        this.index = index;
    }


    public V label() {
        return label;
    }

    public void visit() {
        visited = true;
    }

    public boolean isVisited() {
        return visited;
    }

    public void reset() {
        visited = true;
    }

    public boolean equals(Object o) {
        Vertex<V> vertex = (Vertex<V>) o;
        return label.equals(vertex.label());
    }

    public int index(){
        return index;
    }

    public int hashCode(){
        return label.hashCode();
    }

}

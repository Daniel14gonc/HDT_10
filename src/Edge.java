public class Edge<V, E> {

    protected V here;
    protected V there;
    protected E label;
    protected boolean visited;

    public Edge(V vtx1, V vtx2, E label) {
        here = vtx1;
        there = vtx2;
        this.label = label;
        visited = false;
    }

    public V here() {
        return here;
    }

    public V there() {
        return there;
    }

    public void setLabel(E label) {
        this.label = label;
    }

    public E label() {
        return label;
    }

    public void visit() {
        visited = true;
    }

    public boolean isVisited() {
        return visited;
    }

    public void reset() {
        visited = false;
    }

    public boolean equals(Object o) {
        Edge<?,?> e = (Edge<?,?>)o;
        return ((here().equals(e.here()) &&
                there().equals(e.there())));
    }
}

/*
 * Nombre: Daniel Gonzalez Carrillo
 * Carne: 20293
 * Modificacion: 28/05/2021
 * Clase: Edge
 * Descripcion: Clase que permite la implementacion de una arista para el grafo con direccion.
 */

public class Edge<V, E> {

    protected V here;
    protected V there;
    protected E label;

    //Constructor
    public Edge(V vtx1, V vtx2, E label) {
        here = vtx1;
        there = vtx2;
        this.label = label;
    }

    public V here() {
        //Post: Retorna el vertice del origen de la arista.
        return here;
    }

    public V there() {
        //Post: Retorna el vertice de llegada del grafo.
        return there;
    }

    public void setLabel(E label) {
        //Post: Determina la etiqueta de la arista.
        this.label = label;
    }

    public E label() {
        //Post: Retorna la etiqueta de la arista.
        return label;
    }


    public boolean equals(Object o) {
        //Post: Determina si la arista es igual a otra o no.
        Edge<?,?> e = (Edge<?,?>)o;
        return ((here().equals(e.here()) &&
                there().equals(e.there())));
    }
}

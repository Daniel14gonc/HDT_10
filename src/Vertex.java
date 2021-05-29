/*
 * Nombre: Daniel Gonzalez Carrillo
 * Carne: 20293
 * Modificacion: 28/05/2021
 * Clase: Vertex
 * Descripcion: Clase que permite la implementacion de un vertice para un grafo.
 */

public class Vertex <V>{
    protected int index;
    protected V label;

    //Constructor
    public Vertex(V label, int index) {
        this.label = label;
        this.index = index;
    }


    public V label() {
        //Post: Retorna la etiqueta del grafo.
        return label;
    }


    public boolean equals(Object o) {
        //Post: Determina si el vertice es igual a otro.
        Vertex<V> vertex = (Vertex<V>) o;
        return label.equals(vertex.label());
    }

    public int index(){
        //Post: Retorna el indice del vertice en la matriz de adyacencia.
        return index;
    }

}

/*
 * Nombre: Daniel Gonzalez Carrillo
 * Carne: 20293
 * Modificacion: 28/05/2021
 * Clase: GraphMatrixDirected
 * Descripcion: Clase que permite la implementacion de un grafo dirigido por medio
 *              de una matriz de adyacencia.
 */


import java.util.*;

public class GraphMatrixDirected <V, E> {

    protected int size;
    protected Object data[][];
    protected Map<V, Vertex<V>> dict;
    protected List<Integer> freeList;
    protected boolean directed;

    //Constructor
    public GraphMatrixDirected(int size){
        this.size = size;
        data = new Object[size][size];
        dict = new HashMap<V, Vertex<V>>();
        freeList = new LinkedList<Integer>();

        //Se determinan los indices libres de la matriz.
        for(int i = size-1; i>= 0; i--){
            freeList.add(i);
        }
    }


    public Map getMap(){
        //Post: Devuelve todos los vertices del grafo.
        return dict;
    }

    public void add(V label){
        //Pre: Determina si ya existe el vertice en el grafo. Si existe no lo añade.
        //Post: Se añade el vertice al grafo.

        if(dict.containsKey(label)) return;
        int row = freeList.remove(0);
        dict.put(label, new Vertex<V>(label, row));
    }

    public void addEdge(V v1, V v2, E label){
        //Post: Se agrega una nueva arista entre dos grafos.
        Vertex<V> vtx1, vtx2;
        vtx1 = dict.get(v1);
        vtx2 =  dict.get(v2);

        Edge<V, E> e = new Edge<V, E>(vtx1.label(), vtx2.label(), label);
        data[vtx1.index()][vtx2.index()] = e;
    }

    public void removeEdge(V v1, V v2){
        //Post: Se elimina una arista entre dos grafos.
        Vertex<V> vtx1, vtx2;
        vtx1 = dict.get(v1);
        vtx2 = dict.get(v2);

        data[vtx1.index()][vtx2.index()] = null;
    }

    public V get(V label){
        //Post: Se retorna la etiqueta de un vertice.
        return dict.get(label).label();
    }

    public int getIndex(V label){
        //Post: Se retorna el indice de la matriz de un vertice.
        return dict.get(label).index();
    }

    public Edge<V, E> getEdge(V label1, V label2){
        //Se devuelve una arista del grafo, dependiendo de dos nodos.
        int row = dict.get(label1).index();
        int column = dict.get(label2).index();
        return (Edge<V, E>) data[row][column];
    }

    public void clear(){
        //Post: Se hace un reset al grafo.
        dict.clear();
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                data[i][j] = null;
            }
        }

        freeList = new LinkedList<Integer>();
        for(int i = size-1; i>=0; i--)
            freeList.add(i);
    }

    public boolean isEmpty(){
        //Post: Se determina si el grafo esta vacio.
        return dict.isEmpty();
    }


    public boolean contains(V label){
        //Post: Se determina si el grafo contiene un vertice con determinada etiqueta.
        return dict.containsKey(label);
    }

    public Object[][] getData(){
        //Post: Se retorna la matriz que almacena las aristas.
        return data;
    }

    public V getByIndex(int index){
        //Post: Se retorna un vertice dado su indice.
        for(V keys: dict.keySet()){
            if(dict.get(keys).index() == index)
                return dict.get(keys).label();
        }
        return null;
    }

}
/*
 * Nombre: Daniel Gonzalez Carrillo
 * Carne: 20293
 * Modificacion: 28/05/2021
 * Clase: FloydAlgo
 * Descripcion: Clase que permite la implementacion del algoritmos de Floyd.
 */


import java.util.ArrayList;

public class FloydAlgo<V> {
    private Object[][] matriz;
    private Integer[][] P;
    private GraphMatrixDirected<V, Integer> tempGraph;

    //Constructor
    public FloydAlgo() {
        this.matriz = null;
        P = null;
        tempGraph = null;
    }

    public void getShortestPath(V salida,V llegada, GraphMatrixDirected graph){
        //Post: Se encuentran los caminos mas cortos entre grafos.

        //Se obtiene la matriz de adyacencia del grafo y se guarda una referencia al grafo.
        Object[][] temp = graph.getData();
        tempGraph = graph;

        //Se crea una copia de la matriz.
        fillMatrix(temp);

        P = new Integer[temp.length][temp.length];
        for(int k = 0; k<matriz.length; k++){
            for(int i = 0; i<matriz.length;i++){
                for(int j = 0; j<matriz.length;j++){
                    if(i!=j){
                        Object a1 = matriz[i][j];
                        Edge<V, Integer> a =(a1!= null)? (Edge<V, Integer>) matriz[i][j] : null;
                        Object b1 = matriz[i][k];
                        Edge<V, Integer> b = (b1!= null)? (Edge<V, Integer>) matriz[i][k]: null;
                        Object c1 = matriz[k][j];
                        Edge<V, Integer> c = (c1!= null)? (Edge<V, Integer>) matriz[k][j] : null;

                        //Se determina la ruta mas corta entre dos grafos.

                        int posibleNuevo = -1;
                        if(b != null && c != null) {
                            posibleNuevo = b.label() + c.label();
                            if (a != null){
                                if (a.label() > posibleNuevo){
                                    a.setLabel(posibleNuevo);
                                    P[i][j] = k;
                                }
                            }
                            else if(a== null && posibleNuevo!= -1){
                                V here = (V) graph.getByIndex(i);
                                V there = (V) graph.getByIndex(j);
                                //graph.addEdge(here, there, posibleNuevo);
                                Edge<V, Integer> result = new Edge<V, Integer>(here, there, posibleNuevo);
                                matriz[i][j] = result;
                                P[i][j] = k;
                            }
                        }
                    }
                }
            }
        }



    }

    public void fillMatrix(Object[][] temp){
        //Post: Se copia una matriz en otra matriz atributo de clase.
        matriz = new Object[temp.length][temp.length];
        for(int i = 0; i<temp.length;i++){
            for(int j = 0; j<temp.length;j++){
                Object a = temp[i][j];
                matriz[i][j] = a;
            }
        }
    }


    public void path(Integer q, Integer r){
        //Post: Se encuentra recursivamente el camino por el que se reocrre un grafo en su ruta mas corta.
        if(P[q][r] != null){
            path(q, P[q][r]);
            System.out.println("Se pasa por: " + tempGraph.getByIndex(P[q][r]) + "\n");
            path(P[q][r], r);
        }
        return;
    }


    public void center(){
        //Post: Se encuentra el centro del grafo.

        //Se encuentra la ruta mas grande para un grafo.
        ArrayList<Integer> ecc = new ArrayList<Integer>();
        for(int i = 0; i<matriz.length; i++){
            ecc.add(null);
            int mayor = -1;
            for(int j = 0; j<matriz.length; j++){
                Edge<V, Integer> edge = (Edge<V, Integer>) matriz[i][j];
                if(edge!= null){
                    int weight = edge.label();
                    mayor = (weight>mayor) ? weight: mayor;
                }
            }
            if(mayor != -1){
                ecc.set(i, mayor);
            }
        }

        //Se determina el grafo con la ruta mas corta de las mas grandes (eccentricidades del grafo)
        int menor = 0;
        Integer m = ecc.get(0);
        for(int i = 1; i<ecc.size(); i++){
            Integer a = ecc.get(i);
            if(a!=null){
                if(m == null){
                    m = a;
                    menor = i;
                }
                else if(a<m){
                    m = a;
                    menor = i;
                }
            }
        }

        V label = tempGraph.getByIndex(menor);
        System.out.println("\nEl centro del grafo es: " + label+ "\n");

    }

    public void shortestPath(V salida, V llegada){

        //Post: Se imprime la distancia de un grafo a otro y se imprimen las ciudades por las que pasa.
        if(salida.equals(llegada)){
            System.out.println("La ciudad"+salida+" es la misma. La distancia es de 0 km.");
        }
        else{

            int a = tempGraph.getIndex(salida);
            int b = tempGraph.getIndex(llegada);

            Edge<V,Integer> edge = (Edge<V,Integer>) matriz[a][b];
            if(edge != null){
                Integer shortest = edge.label();
                System.out.println("Camino mas corto de " + salida + " a " + llegada + ": " + shortest + " km\n");

                path(a,b);
            }
            else {
                System.out.println("No existe una forma de llegar de " + salida + " a "+ llegada+"\n");
            }

        }

    }
}

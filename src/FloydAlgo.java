public class FloydAlgo<V> {
    private Object[][] matriz;
    private Integer[][] P;
    private GraphMatrixDirected<V, Integer> tempGraph;

    public FloydAlgo() {
        this.matriz = null;
        P = null;
        tempGraph = null;
    }

    public void getShortestPath(V salida,V llegada, GraphMatrixDirected graph){
        Object[][] temp = graph.getData();
        tempGraph = graph;
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
                                graph.addEdge(here, there, posibleNuevo);
                                Edge<V, Integer> result = graph.getEdge(here, there);
                                matriz[i][j] = result;
                                P[i][j] = k;
                            }
                        }
                    }
                }
            }
        }
        int a = graph.getIndex(salida);
        int b = graph.getIndex(llegada);

        int shortest = ((Edge<V,Integer>) matriz[a][b]).label();
        System.out.println("Camino mas corto de " + salida + " a " + llegada + ": " + shortest);

        path(a,b);
    }

    public void fillMatrix(Object[][] temp){
        matriz = new Object[temp.length][temp.length];
        for(int i = 0; i<temp.length;i++){
            for(int j = 0; j<temp.length;j++){
                Object a = temp[i][j];
                matriz[i][j] = a;
            }
        }
    }

    public void stringMatrix(){
        String res = "";
        for(int i = 0; i<matriz.length;i++){
            for(int j = 0; j<matriz.length;j++){
                Edge<V, Integer> a = (Edge<V, Integer>) matriz[i][j];
                if(a != null)
                    res += a.label() + " ";
                else
                    res+= "null ";
            }
            res+= "\n";
        }

        System.out.println(res);
    }

    public void printS(){
        String res = "";
        for(int i = 0; i<P.length;i++) {
            for (int j = 0; j < P.length; j++) {
                res += P[i][j] + " ";
            }
            res+= "\n";
        }
        System.out.println(res);
    }

    public void path(Integer q, Integer r){
        if(P[q][r] != null){
            path(q, P[q][r]);
            System.out.println("Se paso por: " + tempGraph.getByIndex(P[q][r]));
            path(P[q][r], r);
        }
        return;
    }
}

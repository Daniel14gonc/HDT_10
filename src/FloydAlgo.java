public class FloydAlgo<V> {
    private Object[][] matriz;
    private Integer[][] P;


    public void getShortestPath(String label, GraphMatrixDirected graph){
        Object[][] temp = graph.getData();
        fillMatrix(temp);
        P = new Integer[temp.length][temp.length];
        for(int k = 0; k<matriz.length; k++){
            for(int i = 0; i<matriz.length;i++){
                for(int j = 0; j<matriz.length;j++){
                    if(i!=j && i != k){
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
                                    temp[i][j] = k;
                                }
                            }
                            else if(a== null && posibleNuevo!= -1){
                                V here = (V) graph.getByIndex(i);
                                V there = (V) graph.getByIndex(j);
                                graph.addEdge(here, there, posibleNuevo);
                                Edge<V, Integer> result = graph.getEdge(here, there);
                                matriz[i][j] = result;
                                temp[i][j] = k;
                            }

                        }
                    }
                }
            }
        }
        stringMatrix();
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

    public void path(Integer q, Integer r){

    }

}

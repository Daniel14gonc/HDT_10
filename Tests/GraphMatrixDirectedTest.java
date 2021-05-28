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

        FloydAlgo<String> floyd = new FloydAlgo<String>();
        floyd.getShortestPath("Antigua","Guatemala", graph);

        /*[][] temp = graph.getData();
        for (int i = 0; i<temp[0].length; i++)
            for(int j = 0; j<temp[1].length; j++)
                System.out.println(temp[i][j]);

                if(temp[i][j] != null){
                    System.out.println(((Edge<String,Integer>)temp[i][j]).here());
                    System.out.println(((Edge<String,Integer>)temp[i][j]).there());
                    System.out.println(((Edge<String,Integer>)temp[i][j]).label());
                }*/


    }
}
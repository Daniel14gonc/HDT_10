import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import static org.junit.Assert.*;

public class FloydAlgoTest {

    @Test
    public void getShortestPath() {

        try {
            File myObj = new File("guategrafo.txt");
            Scanner myReader = new Scanner(myObj);
            Scanner tempScan = new Scanner(myObj);
            int size = Unique.getUniqueCount(tempScan);
            GraphMatrixDirected<String, Integer> graph = new GraphMatrixDirected<String, Integer>(size);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] temp = data.split(" ");
                graph.add(temp[0]);
                if (!graph.contains(temp[0]))
                    graph.addEdge(temp[0], temp[0], 0);
                graph.add(temp[1]);
                if (!graph.contains(temp[1]))
                    graph.addEdge(temp[1], temp[1], 0);
                graph.addEdge(temp[0], temp[1], Integer.parseInt(temp[2]));
            }
            myReader.close();

            FloydAlgo<String> floyd = new FloydAlgo<String>();
            int ruta = floyd.getShortestPath("Mixco", "Antigua", graph);
            assertEquals("No funciona floyd", ruta, 30);

        }
        catch (Exception e) {
            System.out.println("Ingrese un dato correcto.");
        }

    }
}
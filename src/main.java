import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

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
                if(!graph.contains(temp[0]))
                    graph.addEdge(temp[0], temp[0], 0);
                graph.add(temp[1]);
                if(!graph.contains(temp[1]))
                    graph.addEdge(temp[1], temp[1], 0);
                graph.addEdge(temp[0], temp[1], Integer.parseInt(temp[2]));
            }
            myReader.close();

            FloydAlgo<String> floyd = new FloydAlgo<String>();
            floyd.getShortestPath("Mixco","SantaLucia", graph);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}

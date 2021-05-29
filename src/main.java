import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
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
            floyd.getShortestPath(graph.getByIndex(0),graph.getByIndex(1), graph);

            int op = 0;
            Scanner scan = new Scanner(System.in);

            System.out.println("Bienvenido al menu de centros de vacunacion.\n");
            while (op != 5) {
                try {
                    System.out.println("Por favor eliga una opcion.");
                    System.out.println("1. Encontrar la distancia mas corta entre dos centros de vacunacion");
                    System.out.println("2. Notificacion de interrupcion por trafico entre dos ciudades. (como waze pero chafa)");
                    System.out.println("3. Nueva conexion entre dos ciudades/centros de vacunacion.");
                    System.out.println("4. Encontrar la ciudad central.");
                    System.out.println("5. Salir.");
                    op = scan.nextInt();
                    if (op > 0 && op <= 5) {

                        switch (op) {
                            case 1: {
                                Map<String, Integer> map = graph.getMap();
                                System.out.println("Ingrese el nombre de la ciudad de origen.");
                                int cont = 1;
                                ArrayList<String> tempArray = new ArrayList<String>();
                                for (String key : map.keySet()) {
                                    tempArray.add(key);
                                    System.out.println(cont + " " + key);
                                    cont++;
                                }
                                int eleccion1 = scan.nextInt();

                                System.out.println("Ingrese el nombre de la ciudad de destino.");
                                cont = 1;
                                ArrayList<String> tempArray2 = new ArrayList<String>();
                                for (String key : map.keySet()) {
                                    tempArray2.add(key);
                                    System.out.println(cont + ". " + key);
                                    cont++;
                                }
                                int eleccion2 = scan.nextInt();

                                if (eleccion1 <= tempArray.size() && eleccion2 <= tempArray2.size()) {
                                    String a = tempArray.get(eleccion1 - 1);
                                    String b = tempArray2.get(eleccion2 - 1);

                                    floyd.getShortestPath(a, b, graph);
                                    floyd.shortestPath(a, b);
                                }

                            }
                            break;
                            case 2: {
                                Map<String, Integer> map = graph.getMap();
                                System.out.println("Ingrese el nombre de la ciudad de origen.");
                                int cont = 1;
                                ArrayList<String> tempArray = new ArrayList<String>();
                                for (String key : map.keySet()) {
                                    tempArray.add(key);
                                    System.out.println(cont + " " + key);
                                    cont++;
                                }
                                int eleccion1 = scan.nextInt();

                                System.out.println("Ingrese el nombre de la ciudad de destino.");
                                cont = 1;
                                ArrayList<String> tempArray2 = new ArrayList<String>();
                                for (String key : map.keySet()) {
                                    tempArray2.add(key);
                                    System.out.println(cont + ". " + key);
                                    cont++;
                                }
                                int eleccion2 = scan.nextInt();

                                if (eleccion1 <= tempArray.size() && eleccion2 <= tempArray2.size()) {
                                    String a = tempArray.get(eleccion1 - 1);
                                    String b = tempArray2.get(eleccion2 - 1);

                                    graph.removeEdge(a, b);
                                }
                            }
                            break;
                            case 3: {
                                Map<String, Integer> map = graph.getMap();
                                System.out.println("Ingrese el nombre de la ciudad de origen.");
                                int cont = 1;
                                ArrayList<String> tempArray = new ArrayList<String>();
                                for (String key : map.keySet()) {
                                    tempArray.add(key);
                                    System.out.println(cont + " " + key);
                                    cont++;
                                }
                                int eleccion1 = scan.nextInt();

                                System.out.println("Ingrese el nombre de la ciudad de destino.");
                                cont = 1;
                                ArrayList<String> tempArray2 = new ArrayList<String>();
                                for (String key : map.keySet()) {
                                    tempArray2.add(key);
                                    System.out.println(cont + ". " + key);
                                    cont++;
                                }
                                int eleccion2 = scan.nextInt();

                                if (eleccion1 <= tempArray.size() && eleccion2 <= tempArray2.size()) {
                                    System.out.println("Ingrese la distancia en km entre las ciudades.");
                                    int distancia = scan.nextInt();

                                    String a = tempArray.get(eleccion1 - 1);
                                    String b = tempArray2.get(eleccion2 - 1);

                                    graph.addEdge(a, b, distancia);
                                    floyd.getShortestPath(a,b,graph);
                                }
                            }
                            break;
                            case 4: {
                                floyd.center();
                            }
                            break;
                        }

                    } else {
                        System.out.println("Ingrese una opcion correcta.");
                    }
                }
                catch (Exception e){
                    System.out.println("Ingrese un dato correcto.");
                }

            }


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}

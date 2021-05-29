/*
 * Nombre: Daniel Gonzalez Carrillo
 * Carne: 20293
 * Modificacion: 28/05/2021
 * Clase: Unique
 * Descripcion: Clase que permite encontrar la cantidad de valores unicos de un arreglo.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Unique {

    public static int getUniqueCount(Scanner scan){
        //Post: Se encuentra la cantidad de valores unicos de un arreglo.
        ArrayList<String> temp = new ArrayList<String>();
        int cont = 0;
        while (scan.hasNextLine()) {
            String data = scan.nextLine();
            String[] t = data.split(" ");
            if(!temp.contains(t))
                cont++;
        }

        return cont;
    }
}

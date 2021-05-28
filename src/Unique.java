import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Unique {

    public static int getUniqueCount(Scanner scan){
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

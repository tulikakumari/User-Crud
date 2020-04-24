import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        String data = "0,tulika,20,F,800001,Bihar,Gardanibagh";

        data = data + "\n" +"1,tua,90,F,800001,Bihar,Gardanibagh" ;

        FileWriter fw= null;


        try {
            fw = new FileWriter("/Users/tulika/Desktop/Assignment/data.csv");
            fw.write(data);
            fw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File("/Users/tulika/Desktop/Assignment/data.csv");

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name())) {
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] words = line.split(",");

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}

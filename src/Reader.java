import user.Gender;
import user.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class Reader {

    public static String location = "/Users/tulika/Desktop/assignments/User-Crud/data.csv";


    public User[] readUsers() {


        File file = new File(location);
        User[] users = new User[100];
        int count = 0;

        Scanner sc = null;
        try {
            sc = new Scanner(file, StandardCharsets.UTF_8.name());
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] words = line.split(",");
                if (words.length == 7) {
                    int id = Integer.parseInt(words[0]);
                    String name = words[1];
                    int age = Integer.parseInt(words[2]);
                    Gender gender = Gender.valueOf(words[3]);
                    String pin = words[4];
                    String state = words[5];
                    String address = words[6];

                    User user = new User(count, name, age, gender, pin, state, address);
                    users[count] = user;
                    count++;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

        return users;

    }

}

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


    public User[] readUsers(){


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

//    System.out.println("Imported " + count + "users");


//    Random random = new Random();
//    int randomIndex = random.nextInt(99);
//    users[randomIndex] = new User(randomIndex, "Anurag", 24, Gender.M, "800020", "Bihar", "kankarbagh");
//
    StringBuilder usersDataInCSV = new StringBuilder();

    for (User user : users) {
        if (user != null) {
            String userDataCommaSeparated = user.getId() + "," + user.getName() + ","
                    + user.getAge() + "," + user.getGender() + "," + user.getPinCode() + ","
                    + user.getState() + "," + user.getAddress();
            usersDataInCSV.append(userDataCommaSeparated).append("\n");
        }
    }

    System.out.println(usersDataInCSV);

    try {
        FileWriter fw = new FileWriter(location);
        fw.write(usersDataInCSV.toString());
        fw.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
        return users;

}

}

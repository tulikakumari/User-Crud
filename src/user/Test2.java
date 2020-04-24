package user;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        User[] users = new User[10];
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        User user = new User(0, "name", 20, Gender.M, "1", "Bi", "Gardanibagh");
        user.getId();
        users[0] = user;

        User user1 = new User(1, "name1", 20, Gender.M, "10", "Bi", "Gardanibagh");

        users[6] = user1;
        users[1] = user;
        for (int i = 0; i < users.length; i++) {
            User user2 = users[i];

//            System.out.println(user2);

            if (user2 == null) {
//                System.out.println("User not found");
                continue;
            }

            if (user2.getId() == input) {
                user2 = null;
//                System.out.println(user2.getAddress());
//                user2.setAddress();
            }
        }
    }
}


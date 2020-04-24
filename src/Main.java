import user.Service;

import java.util.Scanner;

public class Main {

    private static final String MAIN_OPTIONS =
        "##########################################\n" +
            "# 1 Add user\t\t\t\t\t\t\t#\n" +
            "# 2 Delete User\t\t\t\t\t\t\t#\n" +
            "# 3 Search User\t\t\t\t\t\t\t#\n" +
            "# 4 Modify User\t\t\t\t\t\t\t#\n" +
            "# 0 Exit\t\t\t\t\t\t\t\t#\n" +
            "##########################################\n";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Service service = new Service();


        while (true) {

            String input = scanAndCheckLine(MAIN_OPTIONS, scan);
            final int option = Integer.parseInt(input);

            switch (option) {
                case 0:
                    System.out.println("I am very bad programmer Tulika I cant save to file sorry.");
                    System.out.println("Exiting.");
                    return;
                case 1:
                    service.addUser();
                    break;
                case 2:
                    service.deleteUser();
                    break;
                case 3:
                    service.searchUser();
                    break;
                case 4:
                    service.modifyUser();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }


    }

    private static String scanAndCheckLine(String message, Scanner scanner) {
        do {
            System.out.println(message);
            String line = scanner.nextLine();
            if (line.length() == 0) {
                System.out.println("Invalid input please try again");
            } else {
                return line;
            }
        } while (true);
    }
}





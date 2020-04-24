package user;

import java.util.Scanner;

public class Service {

    Scanner scan = new Scanner(System.in);
    User[] users = new User[10];
    int count = 0;

    private static final String MODIFY_OPTIONS = "##########################################\n" +
        "# 1 name\t\t\t\t\t\t#\n" +
        "# 2 age\t\t\t\t\t\t#\n" +
        "# 3 gender\t\t\t\t\t\t#\n" +
        "# 4 address\t\t\t\t\t\t#\n" +
        "# 5 pin code\t\t\t\t\t\t#\n" +
        "# 6 state\t\t\t\t\t\t#\n" +
        "# 0 return\t\t\t\t\t\t#\n" +
        "##########################################\n";

    public void addUser() {

        System.out.println("Enter Details of user Separated by comma");
        String input = scanAndCheckLine(
            "Input details: name(String), age(int), GENDER(M/F), address(String), pincode(String), state(String)  separated by comma");

        String[] split = input.split(",");

        if (split.length <= 6) {
            System.out.println("String has less number of fields then required. Required 6, found " + split.length);
        } else {
            String name = split[0];
            int age = Integer.parseInt(split[1]);
            Gender gender = Gender.valueOf(split[2].toUpperCase());
            String address = split[3];
            String pinCode = split[4];
            String state = split[5];

            User user = new User(count, name, age, gender, pinCode, state, address);
            users[count] = user;

            System.out.println("Saved " + user.getName() + " with " + user.getId() + " id ");
            count++;
        }
    }

    public void deleteUser() {
        String idStr = scanAndCheckLine("Enter id of user you want to delete");
        final int id = Integer.parseInt(idStr);

        User currentIndexUser = users[id];

        if (currentIndexUser != null) {
            if (id == currentIndexUser.getId()) {
                System.out.print("Deleted " + currentIndexUser.getName() + " with " + currentIndexUser.getId() + " id ");
                users[id] = null;
            }
        } else {
            System.out.println("No user found for id " + id);
        }


    }

    public void searchUser() {

        System.out.println("Enter the name you want to search");
        String name = scan.next();
        boolean found = false;

        for (User user3 : users) {
            if (user3 != null) {
                if (name.equalsIgnoreCase(user3.getName())) {
                    found = true;
                    System.out.println("Searched" + user3.getName() + " with " + user3.getId() + " id ");
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("No user with name " + name + "found");
        }
    }

    public void modifyUser() {

        String input = scanAndCheckLine("Enter id of user you want to modify");
        final int id = Integer.parseInt(input);

        User userInArrayAtIndexId = users[id];

        if (userInArrayAtIndexId == null) {
            System.out.println("No user present at id " + id);
        } else {
            System.out.println(MODIFY_OPTIONS);
            String operationStr = scanAndCheckLine("Input the field you want to modify");

            int operation = Integer.parseInt(operationStr);

            if (operation == 1) {
                String name = scanAndCheckLine("Enter new name");
                userInArrayAtIndexId.setName(name);

            } else if (operation == 2) {
                int age = Integer.parseInt(scanAndCheckLine("Enter new age"));
                userInArrayAtIndexId.setAge(age);

            } else if (operation == 3) {
                userInArrayAtIndexId.setGender(userInArrayAtIndexId.getGender() == Gender.M ? Gender.F : Gender.M);

            } else if (operation == 4) {
                String address = scanAndCheckLine("Enter new address");
                userInArrayAtIndexId.setAddress(address);

            } else if (operation == 5) {
                String pin = scanAndCheckLine("Enter new pinCode");
                userInArrayAtIndexId.setPinCode(pin);

            } else if (operation == 6) {
                String state = scanAndCheckLine("Enter new state");
                userInArrayAtIndexId.setState(state);

            } else {
                System.out.println("Invalid operation");
            }

            System.out.println("Updated the user with id " + userInArrayAtIndexId.getId() + " " + userInArrayAtIndexId);
        }
    }

    private String scanAndCheckLine(String message) {
        do {
            System.out.println(message);
            String line = scan.nextLine();
            if (line.length() == 0) {
                System.out.println("Invalid input please try again");
            } else {
                return line;
            }
        } while (true);
    }
}

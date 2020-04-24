package user;

import java.util.Scanner;

public class Service {
    Scanner scan = new Scanner(System.in);
    User[] users = new User[10];
    int count = 0;

    public void addUser() {


        System.out.println("enter Details of user Separated by comma");
        String input = scan.nextLine();
        System.out.println(input);

        String[] split = input.split(",");

        String name = split[0];
        int age = Integer.parseInt(split[1]);
        Gender gender = Gender.valueOf(split[2].toUpperCase());
        String address = split[3];
        String pinCode = split[4];
        String state = split[5];

        System.out.println(name);
        System.out.println(age);
        System.out.println(gender);
        System.out.println(address);
        System.out.println(pinCode);
        System.out.println(state);


        User user = new User(count, name, age, gender, pinCode, state, address);
        users[count] = user;

      count++;
    }

    public void deleteUser() {

        int id = scan.nextInt();
        if (id == user.ge()) {

        }

    }
//        public void searchUser(){
//
//        }
//        public void modifyUser(){
//
//        }
//        public void Exit(){

    //    }
}

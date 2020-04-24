import user.Gender;
import user.Service;
import user.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String mainOption =
                "##########################################\n" +
                        "# 1 Add user\t\t\t\t\t\t\t#\n" +
                        "# 2 Delete User\t\t\t\t\t\t\t#\n" +
                        "# 3 Search User\t\t\t\t\t\t\t#\n" +
                        "# 4 Modify User\t\t\t\t\t\t\t#\n" +
                        "# 0 Exit\t\t\t\t\t\t\t\t#\n" +
                        "##########################################\n";
//        System.out.println(mainOption);
        Service service = new Service();



        while (true) {

            System.out.println(mainOption);
            int number = scan.nextInt();


            if (number == 0) {
                return;
            } else if (number == 1) {
                service.addUser();
            }
           else if (number == 2) {
                service.deleteUser();
            }
        else if(number==3){
            service.searchUser();
        }
        else if(number==4){
            service.modifyUser();
        }
            else {
                System.out.println("Inavalid option");
            }
        }


    }
}





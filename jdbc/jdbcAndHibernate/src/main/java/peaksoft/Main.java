package peaksoft;

import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.util.Scanner;

public class Main {
    static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        Util.getSession();
        while (true) {
            System.out.println("1 Created table");
            System.out.println("2 Deleted table");
            System.out.println("3 Save user");
            System.out.println("4 Delete by id");
            System.out.println("5 get all");
            System.out.println("6 clear table");

            int i = new Scanner(System.in).nextInt();
            switch (i) {
                case 1 -> userService.createUsersTable();
                case 2 -> userService.dropUsersTable();
                case 3 -> {
                    System.out.println("Enter first name: ");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println("Enter last name: ");
                    String last_name = new Scanner(System.in).nextLine();
                    System.out.println("Enter age: ");
                    byte age = new Scanner(System.in).nextByte();
                    userService.saveUser(name, last_name, age);
                }
                case 4->{
                    System.out.println("Enter id: ");
                    Long id = new Scanner(System.in).nextLong();
                    userService.removeUserById(id);
                }
                case 5-> System.out.println(userService.getAllUsers());
                case 6->userService.cleanUsersTable();
            }


        }
    }
}

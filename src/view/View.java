package view;

import java.util.Scanner;

public class View {
    public static String inputChoice() {
        System.out.print("> Insert option: ");
        String choice = new Scanner(System.in).nextLine();
        System.out.println(".".repeat(50));
        return choice;
    }
    public static void menu(){
        System.out.println("=".repeat(50));
        System.out.println("1.ADD NEW COURSE\n2.LIST COURSES\n3.FIND COURSES BY ID\n4.FIND COURSES BY TITLE\n5.REMOVE COURSES BY ID\n0,99.EXIT");
        System.out.println("=".repeat(50));
    }
}

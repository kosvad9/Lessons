package shop;

import java.util.Scanner;

public class Application {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.printMenu();
    }
}

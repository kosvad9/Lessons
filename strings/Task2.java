package strings;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите исх. сообщение: ");
        String inputStr = scanner.nextLine();

        System.out.print("Введите шифр: ");
        int cipher = scanner.nextInt();

        char[] symbols = inputStr.toCharArray();
        for(int i = 0; i < symbols.length; i++)
            symbols[i] += cipher;
        String outputStr = new String(symbols);
        System.out.printf("Исходное сообщение: %s, зашифрованное сообщение: %s, шифр: %d",inputStr,outputStr,cipher);
        scanner.close();
    }
}

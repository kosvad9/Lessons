package strings;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        for(int i = 0; i < numbers.length; i++)
            numbers[i] = scanner.nextInt();
        for (int elem: numbers)
            if (elem % 2 == 0)
                System.out.printf("Число %d - четное\n",elem);
            else
                System.out.printf("Число %d - нечетное\n",elem);
        scanner.close();
    }
}

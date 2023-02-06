package adventureGame;

import java.util.Scanner;

public class Game {
    static boolean isGameFinished = false;
    Bathroom bathroom = new Bathroom("Ванная комната", "Обычный совмещенный санузел");
    Bedroom bedroom = new Bedroom("Спальня", "Просторная спальня с двуспальной кроватью");
    Kitchen kitchen = new Kitchen("Кухня", "Большая кухня с совмещенной столовой");
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("Добро пожаловать в игру Дом, твоя цель - найти выход из дома");
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя игрока: ");
        Player player = new Player(sc.nextLine());
        sc.close();
        System.out.printf("Привет, %s\n", player.getName());
        System.out.printf("Доступны следующие комнаты: %s, %s, %s", game.bedroom.getName(), game.bathroom.getName(), game.kitchen.getName());

    }
}

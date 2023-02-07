package adventureGame;

import java.util.Scanner;

public class Game {
    static boolean isGameFinished = false;
    Bathroom bathroom = new Bathroom("Ванная комната", "Обычный совмещенный санузел");
    Bedroom bedroom = new Bedroom("Спальня", "Просторная спальня с двуспальной кроватью");
    Kitchen kitchen = new Kitchen("Кухня", "Большая кухня с совмещенной столовой");

    Room[] rooms = new Room[]{bathroom,bedroom,kitchen};
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("Добро пожаловать в игру Дом, твоя цель - найти выход из дома");
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя игрока: ");
        Player player = new Player(sc.nextLine());
        System.out.printf("Привет, %s\n", player.getName());
        System.out.printf("Доступны следующие комнаты: %s, %s, %s\n", game.bedroom.getName(), game.bathroom.getName(), game.kitchen.getName());
        while(true){
            if (isGameFinished){
                System.out.println("Поздравляем, вы победили!");
                return;
            }
            switch(game.showMenu(sc)){
                case 0: return;
                case 1: {
                    player.setCurrentRoom(game.rooms[game.showRooms(sc)]);
                    break;
                }
                case 2: {
                    player.showItems();
                    break;
                }
            }
        }
    }

    public int showMenu(Scanner sc){
        System.out.println("Выберите действие:");
        System.out.println("1. Перейти в другую комнату");
        System.out.println("2. Показать инвентарь");
        System.out.println("0. Выход");
        sc.reset();
        int choice = sc.nextInt();
        while(choice < 0 || choice > 2){
            System.out.print("Неверный ввод. Повторите попытку: ");
            choice = sc.nextInt();
        }
        return choice;
    }
    public int showRooms(Scanner sc){
        System.out.println("Выберите комнату:");
        for (int i = 0; i < rooms.length; i++)
            System.out.printf("%d. %s\n",    i,  rooms[i].name);
        int choice = sc.nextInt();
        while(choice < 0 || choice >= rooms.length){
            System.out.print("Неверный ввод. Повторите попытку: ");
            choice = sc.nextInt();
        }
        return choice;
    }
}

package adventureGame;

import adventureGame.rooms.*;

import java.util.Scanner;

public class Game {
    public static boolean isGameFinished = false;
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
                case 3: {
                    player.interact(sc);
                    break;
                }
            }
        }
    }

    public static int input(Scanner sc, int min, int max){
        int choice = sc.nextInt();
        while(choice < min || choice >= max){
            System.out.print("Неверный ввод. Повторите попытку: ");
            choice = sc.nextInt();
        }
        return choice;
    }
    public int showMenu(Scanner sc){
        System.out.println("Выберите действие:");
        System.out.println("1. Перейти в другую комнату");
        System.out.println("2. Показать инвентарь");
        System.out.println("3. Показать предметы в комнате");
        System.out.println("0. Выход");
        return input(sc,0,4);
    }
    public int showRooms(Scanner sc){
        System.out.println("Выберите комнату:");
        for (int i = 0; i < rooms.length; i++)
            System.out.printf("%d. %s\n",    i,  rooms[i].getName());
        return input(sc,0,rooms.length);
    }
}

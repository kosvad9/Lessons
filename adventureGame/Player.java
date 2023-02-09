package adventureGame;

import adventureGame.items.Drawer;
import adventureGame.items.Item;
import adventureGame.rooms.Room;

import java.util.Scanner;

public class Player {
    private String name;
    private Item[] inventory = new Item[10];
    private int inventoryFree = 10;
    private Room currentRoom;
    public  Player(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setCurrentRoom(Room room){
        if (room != null)
            if (currentRoom != room){
                currentRoom = room;
                System.out.printf("Вы перешли в комнату %s.\n", currentRoom.getName());
            }
            else System.out.println("Вы уже находитесь в выбранной комнате");
    }

    public void showItems(){
        System.out.println("В инвентаре: ");
        for (Item item:inventory)
            if (item != null)
                System.out.printf("%s, ", item.getName());
    }

    public void interact(Scanner sc){
        if (currentRoom == null){
            System.out.println("Нужно перейти в какую-нибудь комнату.");
            return;
        }
        Item[] currRoomItems = currentRoom.getItems();
        System.out.println("В текущей комнате: ");
        for (int i = 0; i < currRoomItems.length; i++)
            System.out.printf("%d. %s\n",    i,  currRoomItems[i].getName());
        int choice = Game.input(sc, 0, currRoomItems.length);
        if (currRoomItems[choice] instanceof InsideItem){
            InsideItem ii = (InsideItem) currRoomItems[choice];
            ii.use();
            System.out.println("Желаете заглянуть внутрь?\n1. Да\n2. Нет");
            choice = Game.input(sc, 1, 3);
            if (choice == 2) return;
            Item inItem = ii.getItem();
            if (inItem == null) System.out.println("Пусто");
            else{
                System.out.printf("Есть предмет \"%s\". Что сделать с предметом?\n1. В инвентарь\n2. Использовать\n3. Ничего",inItem.getName());
                choice = Game.input(sc,1,4);
                if (choice == 1) addItem(inItem);
                if (choice == 2) {
                    Useful useItem = (Useful)inItem;
                    useItem.use();
                }
            }
        } else if (currRoomItems[choice] instanceof Collectible) {
            System.out.print("Что сделать с предметом?\n1. В инвентарь\n2. Использовать\n3. Ничего");
            choice = Game.input(sc,1,4);
            if (choice == 1) addItem(currRoomItems[choice]);
            if (choice == 2) {
                Useful useItem = (Useful)currRoomItems[choice];
                useItem.use();
        }
    }
        else {
            Useful useItem = (Useful)currRoomItems[choice];
            useItem.use();
        }
    }
    private void addItem(Item item){
        if (inventoryFree > 0)
            inventory[inventory.length-inventoryFree] = item;
    }

}

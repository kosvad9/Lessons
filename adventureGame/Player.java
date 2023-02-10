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

    public void showItems(Scanner sc){
        System.out.println("Предметы инвентаре (выберите для взаимодействия): ");
        for (int i = 0; i < inventory.length; i++)
            if (inventory[i] != null)
                System.out.printf("%d. %s\n",    i,  inventory[i].getName());
        System.out.printf("%d. Отмена\n",    inventory.length);
        int choice = Game.input(sc, 0, inventory.length);
        if (choice == inventory.length) return;
        if (inventory[choice] instanceof Useful)
            ((Useful) inventory[choice]).use();
    }

    public void interact(Scanner sc){
        if (currentRoom == null){
            System.out.println("Нужно перейти в какую-нибудь комнату.");
            return;
        }
        Item currRoomItem = currentRoom.printItems(sc);
        if (currRoomItem == null) return;
        int choice;
        //случай если предмет содержит в себе еще один предмет
        if (currRoomItem instanceof InsideItem){
            InsideItem ii = (InsideItem) currRoomItem;
            ii.use();
            System.out.println("Желаете заглянуть внутрь?\n1. Да\n2. Нет\n");
            choice = Game.input(sc, 1, 3);
            if (choice == 2) return;
            //получим ссылку на предмет внутри
            Item inItem = ii.getItem();
            if (inItem == null) System.out.println("Пусто");
            else{
                System.out.printf("Есть предмет \"%s\". Что сделать с предметом?\n1. В инвентарь\n2. Использовать\n3. Ничего\n",inItem.getName());
                choice = Game.input(sc,1,4);
                if (choice == 1) {
                    addItem(inItem);
                    //после того как забрали удалим предмет из помещения
                    ii.clearItemLink();
                }
                if (choice == 2) {
                    Useful useItem = (Useful)inItem;
                    useItem.use();
                }
            }
        } else if (currRoomItem instanceof Collectible) {
            System.out.print("Что сделать с предметом?\n1. В инвентарь\n2. Использовать\n3. Ничего\n");
            choice = Game.input(sc,1,4);
            if (choice == 1) {
                addItem(currRoomItem);
                //после того как забрали удалим предмет из помещения
                currentRoom.deleteItem(currentRoom.getItemIndex(currRoomItem));
            }
            if (choice == 2) {
                Useful useItem = (Useful)currRoomItem;
                useItem.use();
        }
    }
        else {
            Useful useItem = (Useful)currRoomItem;
            useItem.use();
        }
    }
    private void addItem(Item item){
        if (inventoryFree > 0)
            inventory[inventory.length-inventoryFree--] = item;
    }



}

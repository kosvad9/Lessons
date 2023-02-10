package adventureGame.rooms;

import adventureGame.Game;
import adventureGame.items.Drawer;
import adventureGame.items.Furniture;
import adventureGame.items.Item;
import adventureGame.items.Key;

import java.util.Scanner;

public class Kitchen extends Room {
    public Kitchen(String name, String description){
        this.name = name;
        this.description = description;
        this.items = new Item[] {new Drawer("Выдвижной ящик","Верхний ящик под столешницей",
                                                    new Key("Старинный ключ","Ключ победителя"))};
    }
    public Kitchen(String name){
        this(name,"");
    }
    @Override
    public Item printItems(Scanner sc){
        System.out.println("В текущей комнате (выберите предмет): ");
        for (int i = 0; i < items.length; i++)
            if (items[i] != null)
                System.out.printf("%d. %s\n",    i,  items[i].getName());
        System.out.printf("%d. Отмена\n",    items.length);
        int choice = Game.input(sc, 0, items.length+1);
        if (choice == items.length) return null;
        return items[choice];
    }

    @Override
    public int getItemIndex(Item item) {
        for (int i = 0; i < items.length; i++)
            if (items[i] == item) return i;
        return -1;
    }

    @Override
    public void deleteItem(int index){
        items[index] = null;
    }
}

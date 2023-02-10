package adventureGame.rooms;

import adventureGame.Game;
import adventureGame.items.*;

import java.util.Scanner;

public class Bathroom extends Room {
    public Bathroom(String name, String description){
        this.name = name;
        this.description = description;
        this.items = new Item[] { new Furniture("Зеркало","Круглое зеркало над раковиной"),
                                new Furniture("Раковина","Белая керамическая раковина"),
                                new Note("Блокнот","Блокнот с заметками","Подсказка: ключ находится на кухне")
                                };
    }
    public Bathroom(String name){
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

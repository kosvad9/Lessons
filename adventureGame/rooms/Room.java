package adventureGame.rooms;

import adventureGame.items.Item;

import java.util.Scanner;

public abstract class Room {
    protected String name;
    protected String description;
    protected Item[] items;

    public abstract Item printItems(Scanner sc);

    public String getName(){
        return name;
    }

    //для получения индекса предмета в комнате по его ссылке
    public abstract int getItemIndex(Item item);

    //для удаления предмета в комнате по его индексу
    public abstract void deleteItem(int index);
}

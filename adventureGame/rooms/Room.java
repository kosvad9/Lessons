package adventureGame.rooms;

import adventureGame.items.Item;

public abstract class Room {
    protected String name;
    protected String description;
    protected Item[] items;

    public abstract void printItems();

    public String getName(){
        return name;
    }

    public Item[] getItems(){
        return items;
    }
}

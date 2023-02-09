package adventureGame.rooms;

import adventureGame.items.Drawer;
import adventureGame.items.Furniture;
import adventureGame.items.Item;
import adventureGame.items.Key;

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
    public void printItems(){
        System.out.printf("Предметы в комнате %s:",name);
        for(Item i:items)
            System.out.printf("%s, ", i.getName());
    }
}

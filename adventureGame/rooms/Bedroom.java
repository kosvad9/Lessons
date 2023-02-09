package adventureGame.rooms;

import adventureGame.items.Furniture;
import adventureGame.items.Item;
import adventureGame.items.Window;

public class Bedroom extends Room {
    public Bedroom(String name, String description){
        this.name = name;
        this.description = description;
        this.items = new Item[] { new Window("Окно","Окно с ручкой в дальней стене", true),
                                new Furniture("Тумбочка","Деревянная тумбочка у кровати"),
                                new Furniture("Кровать","Незаправленная кровать из Икеи")
                                };
    }
    public Bedroom(String name){
        this(name,"");
    }
    @Override
    public void printItems(){
        System.out.printf("Предметы в комнате %s:",name);
        for(Item i:items)
            System.out.printf("%s, ", i.getName());
    }
}

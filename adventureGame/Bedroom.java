package adventureGame;

public class Bedroom extends Room {
    public Bedroom(String name, String description){
        this.name = name;
        this.description = description;
        this.items = new Item[] { new Item("Окно","Окно с ручкой в дальней стене"),
                                new Item("Тумбочка","Деревянная тумбочка у кровати"),
                                new Item("Кровать","Незаправленная кровать из Икеи")
                                };
    }
    public Bedroom(String name){
        this(name,"");
    }
    public String getName(){
        return name;
    }
    @Override
    public void printItems(){
        System.out.printf("Предметы в комнате %s:",name);
        for(Item i:items)
            System.out.printf("%s, ", i.getName());
    }
}

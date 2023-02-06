package adventureGame;

public class Bedroom {
    private String name;
    private String description;
    private Item[] items = new Item[] { new Item("Окно","Окно с ручкой в дальней стене"),
                                        new Item("Тумбочка","Деревянная тумбочка у кровати"),
                                        new Item("Кровать","Незаправленная кровать из Икеи")
                                        };
    public Bedroom(String name, String description){
        this.name = name;
        this.description = description;
    }
    public Bedroom(String name){
        this(name,"");
    }
    public String getName(){
        return name;
    }
}

package adventureGame;

public class Kitchen {
    private String name;
    private String description;
    private Item[] items = new Item[] {new Item("Выдвижной ящик","Верхний ящик под столешницей")};
    public Kitchen(String name, String description){
        this.name = name;
        this.description = description;
    }
    public Kitchen(String name){
        this(name,"");
    }
}

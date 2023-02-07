package adventureGame;

public class Kitchen extends Room {
    public Kitchen(String name, String description){
        this.name = name;
        this.description = description;
        this.items = new Item[] {new Item("Выдвижной ящик","Верхний ящик под столешницей")};
    }
    public Kitchen(String name){
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

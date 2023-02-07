package adventureGame;

 public class Bathroom extends Room {
    public Bathroom(String name, String description){
        this.name = name;
        this.description = description;
        this.items = new Item[] { new Item("Зеркало","Круглое зеркало над раковиной"),
                                new Item("Раковина","Белая керамическая раковина")
                                };
    }
    public Bathroom(String name){
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

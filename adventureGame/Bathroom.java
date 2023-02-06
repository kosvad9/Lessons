package adventureGame;

public class Bathroom {
    private String name;
    private String description;
    private Item[] items = new Item[] { new Item("Зеркало","Круглое зеркало над раковиной"),
                                        new Item("Раковина","Белая керамическая раковина")
                                        };
    public Bathroom(String name, String description){
        this.name = name;
        this.description = description;
    }
    public Bathroom(String name){
        this(name,"");
    }
}

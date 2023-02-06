package adventureGame;

public class Player {
    private String name;
    private Item[] inventory = new Item[10];
    public  Player(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}

package adventureGame;

public class Room {
    protected String name;
    protected String description;
    protected Item[] items;

    public void printItems(){
        System.out.println("В этой комнате нет доступных предметов");
    }
}

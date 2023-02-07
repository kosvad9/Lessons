package adventureGame;

public class Player {
    private String name;
    private Item[] inventory = new Item[10];
    private Room currentRoom;
    public  Player(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setCurrentRoom(Room room){
        if (room != null)
            if (currentRoom != room){
                currentRoom = room;
                System.out.printf("Вы перешли в комнату %s.\n", currentRoom.name);
            }
            else System.out.println("Вы уже находитесь в выбранной комнате");
    }

    public void showItems(){
        System.out.println("В инвентаре: ");
        for (Item item:inventory)
            if (item != null)
                System.out.printf("%s, ", item.getName());
    }
}

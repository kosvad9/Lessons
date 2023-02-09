package adventureGame.items;

import adventureGame.Useful;

public class Window extends Item implements Useful {
    boolean isOpen;

    public Window(String name, String description, boolean isOpen){
        super(name,description);
        this.isOpen = isOpen;
    }

    @Override
    public void use() {
        isOpen = isOpen ? false : true;
        if (isOpen)
            System.out.println("Окно открыто!");
        else System.out.println("Окно закрыто!");
    }
}

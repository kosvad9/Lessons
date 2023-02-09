package adventureGame.items;

import adventureGame.Useful;

public class Furniture extends Item implements Useful {

    public Furniture(String name, String description){
        super(name,description);
    }

    @Override
    public void use() {
        System.out.printf("Просто %s", description.toLowerCase());
    }
}

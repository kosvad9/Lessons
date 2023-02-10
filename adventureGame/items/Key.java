package adventureGame.items;

import adventureGame.*;

public class Key extends Item implements Collectible, Useful {
    public Key(String name, String description){
        super(name,description);
    }

    @Override
    public void use() {
        if (name.compareToIgnoreCase("старинный ключ") == 0) Game.isGameFinished = true;
    }
}

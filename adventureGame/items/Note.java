package adventureGame.items;

import adventureGame.Collectible;
import adventureGame.Useful;

public class Note extends Item implements Collectible, Useful {
    private String text;

    public Note(String name, String description, String text){
        super(name,description);
        this.text = text;
    }

    public String getText(){
        return text;
    }

    @Override
    public void use() {
        System.out.printf("Текст из записки: \"%s\".\n", text);
    }
}

package adventureGame.items;

import adventureGame.Collectible;
import adventureGame.InsideItem;

public class Drawer extends Furniture implements InsideItem {
    Collectible item;
    public Drawer(String name, String description, Collectible item){
        super(name,description);
        this.item = item;
    }
    @Override
    public void use() {
        System.out.printf("%s. %s. Можно заглянуть внутрь)\n", name, description);
    }

    @Override
    public Item getItem(){
        return (Item)item;
    }
}

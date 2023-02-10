package adventureGame;

import adventureGame.items.Item;

public interface InsideItem extends Useful{
    Item getItem();

    void clearItemLink();
    //метод для удаления ссылки на предмет, если его забрали
}

package shop;

public enum Category {
    ELECTRONICS("Электроника"), FURNITURE("Мебель"), ACCESSORIES("Аксессуары"), UNDEFINED("Неопределено");

    private String nameRus;

    Category(String nameRus){
        this.nameRus = nameRus;
    }

    @Override
    public String toString(){
        return nameRus;
    }

    public static Category defineCategory(String str){
        for(Category category : Category.values()){
            if (category.nameRus.compareToIgnoreCase(str) == 0)
                return category;
        }
        return UNDEFINED;
    }
}

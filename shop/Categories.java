package shop;

public enum Categories {
    ELECTRONICS("Электроника"), FURNITURE("Мебель"), ACCESSORIES("Аксессуары");

    private String nameRus;

    Categories(String nameRus){
        this.nameRus = nameRus;
    }

    @Override
    public String toString(){
        return nameRus;
    }
}

package shop;

public enum MenuItem {
    SHOWPRODUCTS("Показать все товары"), CREATEPRODUCT("Создать товар"), BUYPRODUCT("Купить товар"),
    SHOWLOGS("Показать логи"), EXIT("Выход");

    private String descriprion;
    MenuItem(String description){
        this.descriprion = description;
    }
    public String getDescriprion(){
        return descriprion;
    }
}

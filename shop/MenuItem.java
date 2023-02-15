package shop;

public enum MenuItem {
    SHOWPRODUCTS("Показать все товары"), CREATEPRODUCT("Создать товар"), EXIT("Выход");

    private String descriprion;
    MenuItem(String description){
        this.descriprion = description;
    }
    public String getDescriprion(){
        return descriprion;
    }
}

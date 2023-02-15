package shop;

public enum MenuItems {
    SHOWPRODUCTS("Показать все товары"), CREATEPRODUCT("Создать товар"), EXIT("Выход");

    private String descriprion;
    MenuItems(String description){
        this.descriprion = description;
    }
    public String getDescriprion(){
        return descriprion;
    }
}

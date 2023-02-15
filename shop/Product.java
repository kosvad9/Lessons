package shop;

public class Product {
    private String name;
    private String description;
    private double price;
    private Categories category;

    public Product(String name, String description, double price, Categories category){
        this.name = name;
        this.description = description;
        this.price  = price >= 0 ? price : 0;
        this.category = category;
    }

}

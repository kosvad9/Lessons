package shop;

public class Product {
    private String name;
    private String description;
    private double price;
    private Category category;

    public Product(String name, String description, double price, Category category){
        this.name = name;
        this.description = description;
        this.price  = price >= 0 ? price : 0;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}

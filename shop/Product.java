package shop;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Product {
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private LocalDateTime dateAdd;

    public Product(String name, String description, BigDecimal price, Category category, LocalDateTime dateAdd){
        this.name = name;
        this.description = description;
        this.price  = price.abs().setScale(2);
        this.category = category;
        this.dateAdd = dateAdd;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDateTime getDateAdd(){
        return dateAdd;
    }
}

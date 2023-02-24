package shop;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LogEntry {
    private String nameProduct;
    private Category categoryProduct;
    private BigDecimal price;
    private LocalDateTime dateOfSale;

    public LogEntry(String nameProduct, Category categoryProduct, BigDecimal price, LocalDateTime dateOfSale){
        this.nameProduct = nameProduct;
        this.categoryProduct = categoryProduct;
        this.price = price;
        this.dateOfSale = dateOfSale;
    }
}

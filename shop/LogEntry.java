package shop;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LogEntry {
    public final String nameProduct;
    public final Category categoryProduct;
    public final BigDecimal price;
    public final LocalDateTime dateOfSale;

    public LogEntry(String nameProduct, Category categoryProduct, BigDecimal price, LocalDateTime dateOfSale){
        this.nameProduct = nameProduct;
        this.categoryProduct = categoryProduct;
        this.price = price;
        this.dateOfSale = dateOfSale;
    }
}

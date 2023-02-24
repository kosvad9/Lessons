package shop;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.stream.Stream;

public class FileUtil {
    private final static String filePathProducts = "./shop/products.csv";

    private final static String filePathLogs = "./shop/logs.csv";
    private final static String separator = ";";
    private static Product[] defaultProducts = new Product[]{new Product("Смартфон","Apple Iphone 14 128GB",new BigDecimal("899.99"),Category.ELECTRONICS, LocalDateTime.now()),
            new Product("Телевизор","Samsung",new BigDecimal("754.99"),Category.ELECTRONICS, LocalDateTime.now()),
            new Product("Чехол","Чехол для смартфона Apple Iphone 14",new BigDecimal("3.00"),Category.ACCESSORIES, LocalDateTime.now()),
            new Product("Кровать","Двухместная кровать",new BigDecimal("120.40"),Category.FURNITURE, LocalDateTime.now()), null};

    public static Product[] readProducts(){
        Path path = Paths.get(filePathProducts);
        if (!Files.exists(path)) {
            System.out.println("Файл с данными не найден! Загружены данные по-умолчанию");
            return defaultProducts;
        }
        try {
            Object[] stringsProduct = Files.lines(path).toArray();
            Product[] products = new Product[stringsProduct.length+1];
            for (int i = 0; i < stringsProduct.length; i++)
                products[i] = parseProductFromCSV((String) stringsProduct[i]);
            return products;
        }catch (IOException e){
            System.out.println("При извлечении данных произошла ошибка "+e);
        }
        return defaultProducts;
    }

    private static Product parseProductFromCSV(String str){
        try {
            String[] params = str.split(separator);
            String name = params[0];
            String description = params[1];
            BigDecimal price = new BigDecimal(params[2]);
            Category category = Category.defineCategory(params[3]);
            LocalDateTime dateAdd = LocalDateTime.parse(params[4]);
            return new Product(name,description,price,category,dateAdd);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Произошла ошибка парсинга строки "+e);
        }catch (Exception e){
            System.out.println("Произошла непредвиденная ошибка "+e);
        }
        return null;
    }

    public static void saveProducts(Product[] products) {
        try (Writer writer = new FileWriter(filePathProducts);
                BufferedWriter bufWriter = new BufferedWriter(writer)){
            for(Product product : products){
                if (product == null) continue;
                bufWriter.write(String.format("%s%s%s%s%s\n",product.getName()+separator,product.getDescription()+separator,
                                                              product.getPrice()+separator,product.getCategory()+separator,
                                                                product.getDateAdd()+separator));
            }
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден "+e);
        }catch (Exception e){
            System.out.println("Не удалось сохранить данные в файл "+e);
        }
    }

    public static LogEntry[] readLogs(){
        Path path = Paths.get(filePathLogs);
        if (!Files.exists(path)){
            System.out.println("Файл с данными не найден!");
            return new LogEntry[0];
        }
        try{
            Object[] stringsLogs = Files.lines(path).toArray();
            LogEntry[] logs = new LogEntry[stringsLogs.length+1];
            for (int i = 0; i < stringsLogs.length; i++)
                logs[i] = parseLogEntryFromCSV((String) stringsLogs[i]);
            return logs;
        }catch (IOException e){
            System.out.println("При извлечении данных произошла ошибка "+e);
        }
        return new LogEntry[0];
    }

    private static LogEntry parseLogEntryFromCSV(String str){
        try {
            String[] params = str.split(separator);
            String name = params[0];
            Category category = Category.defineCategory(params[1]);
            BigDecimal price = new BigDecimal(params[2]);
            LocalDateTime dateOfSale = LocalDateTime.parse(params[3]);
            return new LogEntry(name,category,price,dateOfSale);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Произошла ошибка парсинга строки "+e);
        }catch (Exception e){
            System.out.println("Произошла непредвиденная ошибка "+e);
        }
        return null;
    }

    public static void saveLogs(LogEntry[] logs){
        try(Writer writer = new FileWriter(filePathLogs);
            BufferedWriter bufferedWriter = new BufferedWriter(writer)){
            for (LogEntry log:logs){
                if (log == null) continue;
                bufferedWriter.write(String.format("%s%s%s%s\n",log.nameProduct+separator,log.categoryProduct+separator,
                        log.price+separator,log.dateOfSale+separator));
            }
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден "+e);
        }catch (Exception e){
            System.out.println("Не удалось сохранить данные в файл "+e);
        }
    }
}

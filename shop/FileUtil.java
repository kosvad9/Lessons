package shop;

import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class FileUtil {
    private static String filePath = "./shop/products.csv";
    private static String separator = ";";
    private static Product[] defaultProducts = new Product[]{new Product("Смартфон","Apple Iphone 14 128GB",899.99,Category.ELECTRONICS),
            new Product("Телевизор","Samsung",754.99,Category.ELECTRONICS),
            new Product("Чехол","Чехол для смартфона Apple Iphone 14",3.00,Category.ACCESSORIES),
            new Product("Кровать","Двухместная кровать",120.40,Category.FURNITURE),
            null, null, null, null, null, null};
    public static Product[] readProducts(){
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) return defaultProducts;
        try {
            Stream<String> lines = Files.lines(path);
            Object[] stringsProduct = lines.toArray();
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
            Double price = Double.parseDouble(params[2]);
            Category category = Category.defineCategory(params[3]);
            return new Product(name,description,price,category);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Произошла ошибка парсинга строки "+e);
        }catch (Exception e){
            System.out.println("Произошла непредвиденная ошибка "+e);
        }
        return null;
    }

    public static void saveProducts(Product[] products) {
        try (OutputStream outputStream = new FileOutputStream(filePath);
                Writer writer = new OutputStreamWriter(outputStream);
                BufferedWriter bufWriter = new BufferedWriter(writer)){
            for(Product product : products){
                if (product == null) continue;
                bufWriter.write(String.format("%s%s%s%s\n",product.getName()+separator,product.getDescription()+separator,
                                                              product.getPrice()+separator,product.getCategory()+separator));
            }
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден "+e);
        }catch (Exception e){
            System.out.println("Не удалось сохранить данные в файл "+e);
        }
    }
}

package shop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static Scanner sc = new Scanner(System.in);

    private Product[] products;

    private LogEntry[] logs;

    public static void main(String[] args) {
        Application app = new Application();
        app.products = FileUtil.readProducts();
        app.logs = FileUtil.readLogs();
        //FileUtil.saveProducts(FileUtil.defaultProducts);
        Menu menu = new Menu();
        while (true){
            //try{
                switch (menu.printMenu()){
                    case SHOWPRODUCTS -> app.showProducts();
                    case CREATEPRODUCT -> {
                            app.addProduct(menu.createProduct());
                            app.products = FileUtil.readProducts();
                    }
                    case BUYPRODUCT -> {
                        app.buyProduct();
                        app.products = FileUtil.readProducts();
                        app.logs = FileUtil.readLogs();
                    }
                    case SHOWLOGS -> app.showLogs();
                    case EXIT -> {return;}
                }
            //}
        }
    }

    private void showProducts(){
        System.out.println("В наличии следующие товары:");
        for (int i = 0; i < products.length; i++){
            if (products[i] == null) continue;
            System.out.printf("\n%d. %s\n",i,products[i].getName());
            System.out.printf("\tКатегория: %s\n",products[i].getCategory());
            System.out.printf("\tОписание: %s\n",products[i].getDescription());
            System.out.printf("\tЦена: $ %.2f\n",products[i].getPrice());
            System.out.printf("\tДата добавления: %s\n",products[i].getDateAdd().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
        }
        System.out.println();
    }

    private void addProduct(Product product){
        try{
            products[products.length-1] = product;
            FileUtil.saveProducts(products);
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Закончилось место для товара.");
        }catch (Exception e){
            System.out.println("Возникла ошибка "+e);
        }
    }

    private void buyProduct(){
        showProducts();
        System.out.printf("%d. %s\n",products.length-1,"Отмена");
        System.out.print("Выберите товар для покупки: ");
        try {
            int i = sc.nextInt();
            while (i < 0 || i >= products.length){
                System.out.print("Повторите попытку: ");
                i = sc.nextInt();
            }
            if (i == products.length-1) return;
            logs[logs.length-1] = new LogEntry(products[i].getName(),products[i].getCategory(),products[i].getPrice(), LocalDateTime.now());
            products[i] = null;
            FileUtil.saveLogs(logs);
            FileUtil.saveProducts(products);
        }catch (InputMismatchException e){
            System.out.println("Введены некорректные данные!");
        }catch (NullPointerException e){
            System.out.println("Ошибка чтения данных из массива о товаре!");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Выход за пределы массива!");
        }
    }

    private void showLogs(){
        System.out.println("История продаж:");
        for (int i = 0; i < logs.length; i++){
            if (logs[i] == null) continue;
            System.out.printf("\n%d. %s\n",i,logs[i].nameProduct);
            System.out.printf("\tКатегория: %s\n",logs[i].categoryProduct);
            System.out.printf("\tЦена продажи: $ %.2f\n",logs[i].price);
            System.out.printf("\tДата продажи: %s\n",logs[i].dateOfSale.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
        }
        System.out.println();
    }
}

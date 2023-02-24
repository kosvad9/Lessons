package shop;

import java.util.Scanner;

public class Application {
    public static Scanner sc = new Scanner(System.in);

    private Product[] products;

    private LogEntry[] logs;

    public static void main(String[] args) {
        Application app = new Application();
        app.products = FileUtil.readProducts();
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
}

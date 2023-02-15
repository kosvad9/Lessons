package shop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static Scanner sc = new Scanner(System.in);

    private Product[] products = new Product[]{new Product("Смартфон","Apple Iphone 14 128GB",899.99,Categories.ELECTRONICS),
            new Product("Телевизор","Samsung",754.99,Categories.ELECTRONICS),
            new Product("Чехол","Чехол для смартфона Apple Iphone 14",3.00,Categories.ACCESSORIES),
            new Product("Кровать","Двухместная кровать",120.40,Categories.FURNITURE)};
    public static void main(String[] args) {
        Application app = new Application();
        Menu menu = new Menu();
        while (true){
            //try{
                switch (menu.printMenu()){
                    case SHOWPRODUCTS -> {
                        break;
                    }
                    case EXIT -> {return;}
                }
            //}
        }
    }

    private void showProducts(){
        System.out.println("В наличии следующие товары:");
        for (int i = 0; i < products.length; i++){
            System.out.printf("\n%d. %s\n",i,products[i].getName());
            System.out.printf("\tКатегория: \n",i,products[i].getCategory());
            System.out.printf("\tОписание: \n",i,products[i].getDescription());
            System.out.printf("\tЦена: \n",i,products[i].getPrice());
        }
    }
}

package shop;

import java.util.InputMismatchException;

public class Menu {
    public MenuItems printMenu(){
        MenuItems[] mi = MenuItems.values();
        System.out.println("Выберите действие:");
        for (int i = 0; i < mi.length; i++){
            System.out.printf("\t%d. %s;\n",i,mi[i].getDescriprion());
        }
        return choiceMenu();
    }

    private MenuItems choiceMenu(){
        while(true){
            try{
                MenuItems choiceItem = MenuItems.values()[Application.sc.nextInt()];
                return choiceItem;
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Выбран несуществующий пункт меню! Повторите попытку.");
            }catch (InputMismatchException e){
                System.out.println("Введены некорректные данные! Повторите попытку.");
                Application.sc.nextLine();
            }catch (Exception e){
                System.out.println("Возникла ошибка "+e);
            }
        }
    }

    public Product createProduct(){
        try{
            Application.sc.nextLine();
            System.out.print("Введите название: ");
            String name = Application.sc.nextLine();
            System.out.print("Введите описание: ");
            String description = Application.sc.nextLine();
            System.out.print("Укажите цену: ");
            double price = Application.sc.nextDouble();
            Category choiceCategory= printCategories();
            return new Product(name,description,price,choiceCategory);
        }catch (InputMismatchException e){
            System.out.println("Введены некорректные данные!");
            Application.sc.nextLine();
            return null;
        }catch (Exception e){
            System.out.println("Возникла ошибка "+e);
            return null;
        }
    }

    public Category printCategories(){
        Category[] categories = Category.values();
        System.out.println("Выберите категорию:");
        for (int i = 0; i < categories.length; i++){
            System.out.printf("\t%d. %s;\n",i,categories[i]);
        }
        return selectCategory();
    }

    private Category selectCategory(){
        while(true){
            try{
                Category choiceCategory = Category.values()[Application.sc.nextInt()];
                return choiceCategory;
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Выбрана несуществующая категория! Повторите попытку.");
            }catch (InputMismatchException e){
                System.out.println("Введены некорректные данные! Повторите попытку.");
                Application.sc.nextLine();
            }catch (Exception e){
                System.out.println("Возникла ошибка "+e);
                return null;
            }
        }
    }
}

package shop;

import java.util.InputMismatchException;

public class Menu {
    public MenuItems printMenu(){
        MenuItems[] mi = MenuItems.values();
        System.out.println("Выберите действие:");
        for (int i = 0; i < mi.length; i++){
            System.out.printf("%d. %s;\n",i,mi[i].getDescriprion());
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
            }
        }
    }
}

package shop;

public class Menu {
    public void printMenu(){
        MenuItems[] mi = MenuItems.values();
        System.out.println("Выберите действие:");
        for (int i = 0; i < mi.length; i++){
            System.out.printf("%d. %s;\n",i,mi[i].getDescriprion());
        }
    }
}

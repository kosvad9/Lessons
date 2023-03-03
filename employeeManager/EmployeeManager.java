package employeeManager;

import employeeManager.positions.development.MiddleDeveloper;
import employeeManager.positions.development.TeamLead;
import employeeManager.positions.hr.Manager;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {

    List<Employee> staff;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        EmployeeManager em = new EmployeeManager();
        em.staff = new LinkedList<>();
        try {
            em.staff.add(new Employee("Вадим", "Космачёв", 1, new TeamLead(), new BigDecimal(7000)));
            em.staff.add(new Employee("Иван", "Сидоренко", 2, new MiddleDeveloper(), new BigDecimal(1600)));
            em.staff.add(new Employee("Екатерина", "Петрова", 3, new Manager(), new BigDecimal(790)));

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        while(true){
            switch(em.printMenu()){
                case PRINTSTAFF -> System.out.println(em.staff);
                case EXIT -> {
                    return;
                }
            }
        }
    }

    public MenuItem printMenu(){
        MenuItem[] mi = MenuItem.values();
        System.out.println("Выберите действие:");
        for (int i = 0; i < mi.length; i++){
            System.out.printf("\t%d. %s;\n",i,mi[i].toString());
        }
        return choiceMenu();
    }

    private MenuItem choiceMenu(){
        while(true){
            try{
                MenuItem choiceItem = MenuItem.values()[sc.nextInt()];
                return choiceItem;
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Выбран несуществующий пункт меню! Повторите попытку.");
            }catch (InputMismatchException e){
                System.out.println("Введены некорректные данные! Повторите попытку.");
                sc.nextLine();
            }catch (Exception e){
                System.out.println("Возникла ошибка "+e);
            }
        }
    }
}

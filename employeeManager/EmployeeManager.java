package employeeManager;

import employeeManager.positions.development.DevelopmentPositions;
import employeeManager.positions.hr.HrPositions;
import employeeManager.positions.marketing.MarketingPositions;

import java.math.BigDecimal;
import java.util.*;

public class EmployeeManager {


    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        FileManager.fillStaff();
        while(true){
            System.out.println("Выберите пункт меню:");
            switch((MenuItem)(EnumUtil.choiceEnum(MenuItem.values()))){
                case PRINT_STAFF -> printStaff();
                case CREATE_EMPLOYEE -> createEmployee();
                case REMOVE_EMPLOYEE -> removeEmployee();
                case CHANGE_DEPT -> {
                    Employee employee = choiceEmployee();
                    if (employee != null)
                        DepartmentManager.changeDepartment(employee);
                }
                case CHANGE_SALARY -> changeSalary();
                case RAISE_POS -> raiseEmployee();
                case LOWER_POS -> lowerEmployee();
                case EXIT -> {
                    return;
                }
            }
        }
    }

    public static void printStaff(){
        System.out.println("Список сотрудников.");
        for (int i = 0; i < FileManager.staff.size(); i++)
            System.out.printf("%d. %s\n",i,FileManager.staff.get(i));
        System.out.println();
    }

    public static Position definePositionFromDept(Department department){
        return switch (department){
            case MARKETING -> ((MarketingPositions) EnumUtil.choiceEnum(MarketingPositions.values())).getPosition() ;
            case HR -> ((HrPositions) EnumUtil.choiceEnum(HrPositions.values())).getPosition();
            case DEVELOPMENT -> ((DevelopmentPositions) EnumUtil.choiceEnum(DevelopmentPositions.values())).getPosition();
        };
    }
    private static void createEmployee(){
        try{
            sc.nextLine();
            System.out.print("Введите имя: ");
            String firstname = sc.nextLine();
            System.out.print("Введите фамилию: ");
            String lastname = sc.nextLine();
            System.out.println("Выберите отдел:");
            Department department = (Department) EnumUtil.choiceEnum(Department.values());
            Position position = definePositionFromDept(department);
            System.out.printf("Введите размер ЗП (мин = %s, макс = %s)\n",position.getMinSalary(),position.getMaxSalary());
            BigDecimal salary = sc.nextBigDecimal();
            FileManager.addEmployee(new Employee(firstname,lastname,FileManager.getNextStaffID(),position,salary));
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Выбран неверный индекс! Повторите попытку.");
        }catch (InputMismatchException e){
            System.out.println("Введены некорректные данные! Повторите попытку.");
            sc.nextLine();
        }catch (Exception e){
            System.out.println("Возникла ошибка "+e);
        }
    }

    public static void changeSalary(){
        sc.nextLine();
        printStaff();
        System.out.print("Выберите сотрудника, которому требуется изменить ЗП:");
        Employee emp = choiceEmployee();
        if (emp == null) return;
        System.out.print("Введите размер новой ЗП: ");
        try{
            Accounting.changeSalary(emp,sc.nextBigDecimal());
        }catch (IndexOutOfBoundsException e){
            System.out.println("Выбран неверный индекс! Повторите попытку.");
        }catch (InputMismatchException e){
            System.out.println("Введены некорректные данные! Повторите попытку.");
            sc.nextLine();
        }catch (Exception e){
            System.out.println("Возникла ошибка "+e);
        }
    }

    private static void removeEmployee(){
        sc.nextLine();
        printStaff();
        System.out.print("Выберите сотрудника, которого надо уволить: ");
        Employee emp = choiceEmployee();
        if (emp == null) return;
        FileManager.removeEmployee(emp);
    }

    private static void raiseEmployee(){
        sc.nextLine();
        printStaff();
        System.out.print("Выберите сотрудника, которого надо повысить: ");
        Employee emp = choiceEmployee();
        if (emp == null) return;
        DepartmentManager.raisePosition(emp);
    }

    private static void lowerEmployee(){
        sc.nextLine();
        printStaff();
        System.out.print("Выберите сотрудника, которого надо понизить: ");
        Employee emp = choiceEmployee();
        if (emp == null) return;
        DepartmentManager.lowerPosition(emp);
    }

    public static Employee choiceEmployee(){
        try{
            return FileManager.staff.get(sc.nextInt());
        }catch (IndexOutOfBoundsException e){
            System.out.println("Выбран неверный индекс! Повторите попытку.");
        }catch (InputMismatchException e){
            System.out.println("Введены некорректные данные! Повторите попытку.");
            sc.nextLine();
        }catch (Exception e){
            System.out.println("Возникла ошибка "+e);
        }
        return null;
    }
}

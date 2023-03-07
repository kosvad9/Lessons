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
            switch((MenuItem)(choiceEnum(MenuItem.values()))){
                case PRINT_STAFF -> printStaff();
                case CREATE_EMPLOYEE -> createEmployee();
                case REMOVE_EMPLOYEE -> removeEmployee();
                case CHANGE_DEPT -> {
                    Employee employee = choiceEmployee();
                    if (employee != null)
                        DepartmentManager.changeDepartment(employee);
                }
                case EXIT -> {
                    return;
                }
            }
        }
    }

    private static void printStaff(){
        System.out.println("Список сотрудников.");
        for (int i = 0; i < FileManager.staff.size(); i++)
            System.out.printf("%d. %s\n",i,FileManager.staff.get(i));
        System.out.println();
    }

    private static void printEnums(Enum<?>[] enums){
        for (int i = 0; i < enums.length; i++){
            System.out.printf("\t%d. %s;\n",i,enums[i].toString());
        }
    }

    public static Enum<?> choiceEnum(Enum<?>[] enums){
        printEnums(enums);
        while(true){
            try{
                return enums[sc.nextInt()];
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Выбран неверный индекс! Повторите попытку.");
            }catch (InputMismatchException e){
                System.out.println("Введены некорректные данные! Повторите попытку.");
                sc.nextLine();
            }catch (Exception e){
                System.out.println("Возникла ошибка "+e);
            }
        }
    }

    public static Position definePositionFromDept(Department department){
        return switch (department){
            case MARKETING -> ((MarketingPositions) choiceEnum(MarketingPositions.values())).getPosition() ;
            case HR -> ((HrPositions) choiceEnum(HrPositions.values())).getPosition();
            case DEVELOPMENT -> ((DevelopmentPositions) choiceEnum(DevelopmentPositions.values())).getPosition();
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
            Department department = (Department) choiceEnum(Department.values());
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

    private static void removeEmployee(){
        Employee emp = choiceEmployee();
        if (emp == null) return;
        System.out.print("Выберите сотрудника, которого надо уволить: ");
        FileManager.removeEmployee(emp);
    }
    public static Employee choiceEmployee(){
        try{
            sc.nextLine();
            printStaff();
            System.out.println();
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

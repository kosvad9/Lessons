package employeeManager;

import employeeManager.positions.development.DevelopmentPositions;
import employeeManager.positions.hr.HrPositions;
import employeeManager.positions.marketing.MarketingPositions;

import java.math.BigDecimal;
import java.util.*;

public class EmployeeManager {


    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        EmployeeManager em = new EmployeeManager();
        FileManager.fillStaff();
        while(true){
            System.out.println("Выберите пункт меню:");
            switch((MenuItem)(em.choiceEnum(MenuItem.values()))){
                case PRINTSTAFF -> System.out.println(FileManager.staff);
                case EXIT -> {
                    return;
                }
            }
        }
    }

    private void printEnums(Enum<?>[] enums){
        for (int i = 0; i < enums.length; i++){
            System.out.printf("\t%d. %s;\n",i,enums[i].toString());
        }
    }

    public Enum<?> choiceEnum(Enum<?>[] enums){
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

    private void createEmployee(){
        try{
            System.out.print("Введите имя: ");
            String firstname = sc.nextLine();
            System.out.print("Введите фамилию: ");
            String lastname = sc.nextLine();
            System.out.println("Выберите отдел:");
            Department department = (Department) choiceEnum(Department.values());
            Position position = switch (department){
                case MARKETING -> ((MarketingPositions) choiceEnum(MarketingPositions.values())).getPosition() ;
                case HR -> ((HrPositions) choiceEnum(HrPositions.values())).getPosition();
                case DEVELOPMENT -> ((DevelopmentPositions) choiceEnum(DevelopmentPositions.values())).getPosition();
            };
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
}

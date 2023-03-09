package employeeManager;

import employeeManager.positions.hr.HrPositions;

import java.util.InputMismatchException;

public class EnumUtil {
    private static void printEnums(Enum<?>[] enums){
        for (int i = 0; i < enums.length; i++){
            System.out.printf("\t%d. %s;\n",i,enums[i].toString());
        }
    }

    public static Enum<?> choiceEnum(Enum<?>[] enums){
        printEnums(enums);
        while(true){
            try{
                return enums[EmployeeManager.sc.nextInt()];
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Выбран неверный индекс! Повторите попытку.");
            }catch (InputMismatchException e){
                System.out.println("Введены некорректные данные! Повторите попытку.");
                EmployeeManager.sc.nextLine();
            }catch (Exception e){
                System.out.println("Возникла ошибка "+e);
            }
        }
    }
}

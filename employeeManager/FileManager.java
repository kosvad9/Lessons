package employeeManager;
import employeeManager.positions.development.DevelopmentPositions;
import employeeManager.positions.hr.HrPositions;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class FileManager {
    public static List<Employee> staff = new LinkedList<>();

    public static void addEmployee(Employee employee){
        staff.add(employee);
    }

    public static void removeEmployee(Employee employee){
        staff.remove(employee);
    }

    public static void fillStaff(){
        try {
            FileManager.staff.add(new Employee("Вадим", "Космачёв", 1, DevelopmentPositions.TEAMLEAD.getPosition(), new BigDecimal(7000)));
            FileManager.staff.add(new Employee("Иван", "Сидоренко", 2, DevelopmentPositions.MIDDLE.getPosition(), new BigDecimal(1600)));
            FileManager.staff.add(new Employee("Екатерина", "Петрова", 3, HrPositions.MANAGER.getPosition(), new BigDecimal(790)));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public static int getNextStaffID(){
        return staff.size()+1;
    }
}

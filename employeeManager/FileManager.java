package employeeManager;

import employeeManager.positions.development.MiddleDeveloper;
import employeeManager.positions.development.TeamLead;
import employeeManager.positions.hr.Manager;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class FileManager {
    public static List<Employee> staff = new LinkedList<>();

    public static void addEmployee(Employee employee){
        staff.add(employee);
    }

    public static void removeEmployee(Employee employee){

    }
    public static void fillStaff(){
        try {
            FileManager.staff.add(new Employee("Вадим", "Космачёв", 1, new TeamLead(), new BigDecimal(7000)));
            FileManager.staff.add(new Employee("Иван", "Сидоренко", 2, new MiddleDeveloper(), new BigDecimal(1600)));
            FileManager.staff.add(new Employee("Екатерина", "Петрова", 3, new Manager(), new BigDecimal(790)));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public static int getNextStaffID(){
        return staff.size()+1;
    }
}

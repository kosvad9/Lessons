package employeeManager;

import employeeManager.positions.development.MiddleDeveloper;
import employeeManager.positions.development.TeamLead;
import employeeManager.positions.hr.Manager;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class EmployeeManager {

    List<Employee> staff;
    public static void main(String[] args) {
        try {
            EmployeeManager em = new EmployeeManager();
            em.staff = new LinkedList<>();
            em.staff.add(new Employee("Вадим", "Космачёв", 1, new TeamLead(), new BigDecimal(7000)));
            em.staff.add(new Employee("Иван", "Сидоренко", 2, new MiddleDeveloper(), new BigDecimal(1500)));
            em.staff.add(new Employee("Екатерина", "Петрова", 3, new Manager(), new BigDecimal(801)));

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}

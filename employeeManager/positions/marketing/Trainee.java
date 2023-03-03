package employeeManager.positions.marketing;

import employeeManager.Department;
import employeeManager.positions.Position;

import java.math.BigDecimal;

public class Trainee extends Position {
    public Trainee(String name, BigDecimal minSalary, BigDecimal maxSalary) {
        super(name, Department.MARKETING, minSalary, maxSalary);
    }
}

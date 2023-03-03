package employeeManager.positions.hr;

import employeeManager.Department;
import employeeManager.positions.Position;

import java.math.BigDecimal;

public class Manager extends Position {
    public Manager(String name, BigDecimal minSalary, BigDecimal maxSalary) {
        super(name, Department.HR, minSalary, maxSalary);
    }
}

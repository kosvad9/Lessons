package employeeManager.positions.development;

import employeeManager.Department;
import employeeManager.positions.Position;

import java.math.BigDecimal;

public class MiddleDeveloper extends Position {
    public MiddleDeveloper(String name, BigDecimal minSalary, BigDecimal maxSalary) {
        super(name, Department.DEVELOPMENT, minSalary, maxSalary);
    }
}

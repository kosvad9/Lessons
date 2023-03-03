package employeeManager.positions.development;

import employeeManager.Department;
import employeeManager.positions.Position;

import java.math.BigDecimal;

public class JuniorDeveloper extends Position {
    public JuniorDeveloper(String name, BigDecimal minSalary, BigDecimal maxSalary) {
        super(name, Department.DEVELOPMENT, minSalary, maxSalary);
    }
}

package employeeManager.positions.development;

import employeeManager.Department;
import employeeManager.positions.Position;

import java.math.BigDecimal;

public class SeniorDeveloper extends Position {
    public SeniorDeveloper(String name, BigDecimal minSalary, BigDecimal maxSalary) {
        super(name, Department.DEVELOPMENT, minSalary, maxSalary);
    }
}

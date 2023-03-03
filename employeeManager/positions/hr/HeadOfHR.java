package employeeManager.positions.hr;

import employeeManager.Department;
import employeeManager.positions.Position;

import java.math.BigDecimal;

public class HeadOfHR extends Position {
    public HeadOfHR(String name, BigDecimal minSalary, BigDecimal maxSalary) {
        super(name, Department.HR, minSalary, maxSalary);
    }
}

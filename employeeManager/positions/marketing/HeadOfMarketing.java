package employeeManager.positions.marketing;

import employeeManager.Department;
import employeeManager.positions.Position;

import java.math.BigDecimal;

public class HeadOfMarketing extends Position {
    public HeadOfMarketing(String name, BigDecimal minSalary, BigDecimal maxSalary) {
        super(name, Department.MARKETING, minSalary, maxSalary);
    }
}

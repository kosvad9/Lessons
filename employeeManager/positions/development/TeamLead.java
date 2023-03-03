package employeeManager.positions.development;

import employeeManager.Department;
import employeeManager.positions.Position;

import java.math.BigDecimal;

public class TeamLead extends Position {
    public TeamLead(String name, BigDecimal minSalary, BigDecimal maxSalary) {
        super(name, Department.DEVELOPMENT, minSalary, maxSalary);
    }
}

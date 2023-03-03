package employeeManager.positions.marketing;

import employeeManager.Department;
import employeeManager.positions.Position;

import java.math.BigDecimal;

public class Specialist extends Position {
    public Specialist() {
        super("Специалист", Department.MARKETING, new BigDecimal(500), new BigDecimal(1200));
    }
}

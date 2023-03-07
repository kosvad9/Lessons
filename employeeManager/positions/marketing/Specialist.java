package employeeManager.positions.marketing;

import employeeManager.Department;
import employeeManager.positions.AbstractPosition;

import java.math.BigDecimal;

class Specialist extends AbstractPosition {
    public Specialist() {
        super("Специалист", Department.MARKETING, new BigDecimal(500), new BigDecimal(1200));
    }
}

package employeeManager.positions.hr;

import employeeManager.Department;
import employeeManager.positions.AbstractPosition;

import java.math.BigDecimal;

class Manager extends AbstractPosition {
    public Manager() {
        super("Менеджер", Department.HR, new BigDecimal(400), new BigDecimal(800));
    }
}

package employeeManager.positions.development;

import employeeManager.Department;
import employeeManager.positions.AbstractPosition;

import java.math.BigDecimal;

class MiddleDeveloper extends AbstractPosition {
    public MiddleDeveloper() {
        super("Middle разработчик", Department.DEVELOPMENT, new BigDecimal(800), new BigDecimal(2000));
    }
}

package employeeManager.positions.development;

import employeeManager.Department;
import employeeManager.positions.AbstractPosition;

import java.math.BigDecimal;

class SeniorDeveloper extends AbstractPosition {
    public SeniorDeveloper() {
        super("Senior разработчик", Department.DEVELOPMENT, new BigDecimal(1800), new BigDecimal(4000));
    }
}
